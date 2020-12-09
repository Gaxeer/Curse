package com.example.curse.repo;

import com.example.curse.model.Client;
import com.example.curse.queryresults.ClientHosps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client findById(Long id){
        return clientRepository.getOne(id);
    }

    public List<Client> findAll(){
        return clientRepository.findAll();
    }

    public Client saveClient(Client client){
        return clientRepository.save(client);
    }

    public void deleteById(Long id){
        clientRepository.deleteById(id);
    }
    public List<ClientHosps> Hosps(Client client) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<String> RawClientHosps = clientRepository.Hosps(client.getClientID());
        ArrayList<ClientHosps> ParsedClientHosps = new ArrayList<>();
        List<String> Buffer;
        for(String rawClientHosp: RawClientHosps){
            Buffer = Arrays.asList(rawClientHosp.split(","));
            ClientHosps ClientHosp = new ClientHosps(Long.parseLong(Buffer.get(0)), (Buffer.get(1)), Buffer.get(2),Buffer.get(3),Buffer.get(4), simpleDateFormat.parse(Buffer.get(5)), simpleDateFormat.parse(Buffer.get(6)));
            ParsedClientHosps.add(ClientHosp);
        };
        return ParsedClientHosps;
    }
}
