package com.example.curse.repo;

import com.example.curse.model.Registration;
import com.example.curse.queryresults.BestDoc;
import com.example.curse.queryresults.ShortTreatment;
import com.example.curse.queryresults.SpecificDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class RegistrationService {

    private final RegistrationRepository registrationRepository;

    @Autowired
    public RegistrationService(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    public Registration findById(Long id){
        return registrationRepository.getOne(id);
    }

    public List<Registration> findAll(){
        return registrationRepository.findAll();
    }

    public Registration saveRegistration(Registration registration){
        return registrationRepository.save(registration);
    }

    public void deleteById(Long id){
        registrationRepository.deleteById(id);
    }

    public List<String> SpecificRegistration(SpecificDate specificDate){
        return registrationRepository.SpecificClients(specificDate.getStartDate(), specificDate.getEndDate());
    }

    public ArrayList<BestDoc> BestDoctor(){
        List<String> Docs = registrationRepository.BestDoctor();
        ArrayList<BestDoc> Doc = new ArrayList<>();
        List<String> DocElements;
        for (String doc : Docs) {
            DocElements = Arrays.asList(doc.split(","));
            BestDoc bestDoc = new BestDoc(DocElements.get(0), Integer.parseInt(DocElements.get(1)));
            Doc.add(bestDoc);
        }
        return Doc;
    }

    public List<Registration> MostExpensiveTreatment(){
        return registrationRepository.MostExpensiveTreatment();
    }

    public ArrayList<ShortTreatment> ShortTreatment() throws ParseException {
         List<String> RawPatients = registrationRepository.ShortTreatment();
         ArrayList<ShortTreatment> ParsedPatients = new ArrayList<>();
         List<String> BufferPatient;
         SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (String rawPatient : RawPatients) {
            BufferPatient = Arrays.asList((rawPatient.split(",")));
            ShortTreatment parsedPatient = new ShortTreatment(Long.parseLong(BufferPatient.get(0)),
                    BufferPatient.get(1),
                    BufferPatient.get(2),
                    simpleDateFormat.parse(BufferPatient.get(3)),
                    simpleDateFormat.parse(BufferPatient.get(4)));
            ParsedPatients.add(parsedPatient);
            System.out.println(parsedPatient);
        }
        return ParsedPatients;
    }

    public List<String> SumDiag(){
        return registrationRepository.SumDiag();
    }

    public List<String> AvgPayment(){
        return registrationRepository.AvgPayment();
    }

    public List<String> PaymentSum(SpecificDate specificDate){
        return registrationRepository.PaymentSum(specificDate.getStartDate(), specificDate.getEndDate());
    }

    public List<String> UnderTreatment(){
        return registrationRepository.UnderTreatment();
    }
}