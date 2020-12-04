package com.example.curse.repo;

import com.example.curse.model.Registration;
import com.example.curse.queryresults.SpecificDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public ArrayList<String> BestDoctor(){
        return registrationRepository.BestDoctor();
    }

    public List<Registration> MostExpensiveTreatment(){
        return registrationRepository.MostExpensiveTreatment();
    }

    public List<String> BarelyIll(){
        return registrationRepository.BarelyIll();
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