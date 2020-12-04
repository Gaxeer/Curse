package com.example.curse.repo;

import com.example.curse.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<String> Hosps(Client client){
        return clientRepository.Hosps(client.getClientID());
    }
}