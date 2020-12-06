package com.example.curse.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.example.curse.model.*;
import com.example.curse.queryresults.BestDoc;
import com.example.curse.queryresults.ClientsByDate;
import com.example.curse.queryresults.ShortTreatment;
import com.example.curse.queryresults.SpecificDate;
import com.example.curse.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class CurseController {


    private final RegistrationService registrationService;
    private final ClientService clientService;
    private final CategoryService categoryService;
    private final DiagnosisService diagnosisService;
    private final DoctorService doctorService;

    @Autowired
    public CurseController(RegistrationService registrationService, ClientService clientService, CategoryService categoryService, DiagnosisService diagnosisService, DoctorService doctorService) {
        this.registrationService = registrationService;
        this.clientService = clientService;
        this.categoryService = categoryService;
        this.diagnosisService = diagnosisService;
        this.doctorService = doctorService;
    }

    @GetMapping("/")
    public String Hub(){
        return "hub";
    }

    @GetMapping("/queries")
    public String Queries(){
        return "queries";
    }

    //Registration Controllers
    @GetMapping("/registrations")
    public String findAll(Model model){
        List<Registration> registrations = registrationService.findAll();
        model.addAttribute("registrations", registrations);
        return "registration-list";
    }

    @GetMapping("/registration-create")
    public String createRegistrationForm(@Valid Registration registration){
        return "registration-create";
    }

    @GetMapping("/expensivetreatment")
    public String MostExpensiveTreatment(Model model){
        List<Registration> registrations = registrationService.MostExpensiveTreatment();
        model.addAttribute("registrations", registrations);
        return "queryresults";
    }

    @GetMapping("/shorttreatment")
    public String ShortTreatment(Model model) throws ParseException {
        ArrayList<ShortTreatment> ShortTreatment = registrationService.ShortTreatment();
        model.addAttribute("ShortTreatment", ShortTreatment);
        return "queryresults";
    }

    @GetMapping("/sumdiag")
    public String SumDiag(Model model){
        List<String> SumDiag = registrationService.SumDiag();
        System.out.println(SumDiag);
        model.addAttribute("SumDiag", SumDiag);
        return "queryresults";
    }

    @GetMapping("/avgpayment")
    public String AvgPayment(Model model){
        List<String> AvgPayment = registrationService.AvgPayment();
        model.addAttribute("AvgPayment", AvgPayment);
        return "queryresults";
    }

    @GetMapping("/spec")
    public String SpecRegistrationForm(Model model){
        SpecificDate specificDate = new SpecificDate();
        model.addAttribute("SpecificDate", specificDate);
        return "specform";
    }

    @GetMapping("/undertreatment")
    public String UnderTreatment(Model model){
        List<String> UnderTreatment = registrationService.UnderTreatment();
        model.addAttribute("Data", UnderTreatment);
        return "queryresults";
    }

    @GetMapping("/sum")
    public String PaymentSum(Model model){
        SpecificDate PaymentSum = new SpecificDate();
        model.addAttribute("PaymentSum", PaymentSum);
        return "specform2";
    }

    @PostMapping("/summary")
    public String PaySum(@Valid SpecificDate specificDate, Model model){
        List<String> PaySum = registrationService.PaymentSum(specificDate);
        model.addAttribute("Data", PaySum);
        return "queryresults";
    }

    @PostMapping("/specific")
    public String SpecificRegistrations(SpecificDate specificDate, Model model) throws ParseException {
        ArrayList<ClientsByDate> clientsByDate = registrationService.SpecificRegistration(specificDate);
        model.addAttribute("Data", clientsByDate);
        System.out.println(clientsByDate);
        return "queryresults";
    }

    @GetMapping("/best-doc")
    public String BestDoc(Model model){
        List<BestDoc> bestDoc = registrationService.BestDoctor();
        System.out.println(bestDoc.get(0));
        model.addAttribute("BestDoc", bestDoc);
        return "queryresults";
    }

    @PostMapping("/registration-create")
    public String createRegistration(Registration registration){
        registrationService.saveRegistration(registration);
        return "redirect:/registrations";
    }

    @GetMapping("registration-delete/{id}")
    public String deleteRegistration(@PathVariable("id") Long id){
        registrationService.deleteById(id);
        return "redirect:/registrations";
    }

    @GetMapping("/registration-update/{id}")
    public String updateRegistrationForm(@PathVariable("id") Long id, Model model){
        Registration registration = registrationService.findById(id);
        model.addAttribute("registration", registration);
        return "registration-update";
    }

    @PostMapping("/registration-update")
    public String updateRegistration(@Valid Registration registration) {
        registrationService.saveRegistration(registration);
        return "redirect:/registrations";
    }


    //Client Controllers
    @GetMapping("/clients")
    public String findAllClients(Model model){
        List<Client> clients = clientService.findAll();
        model.addAttribute("clients", clients);
        return "client-list";
    }

    @GetMapping("/client-create")
    public String createClientForm(@Valid Client client){
        return "client-create";
    }

    @PostMapping("/client-create")
    public String createClient(@Valid Client client){
        clientService.saveClient(client);
        return "redirect:/clients";
    }

    @GetMapping("client-delete/{ClientID}")
    public String deleteClient(@PathVariable("ClientID") Long id){
        clientService.deleteById(id);
        return "redirect:/clients";
    }

    @GetMapping("/client-update/{ClientID}")
    public String updateClientForm(@PathVariable("ClientID") Long id, Model model){
        Client client = clientService.findById(id);
        model.addAttribute("client", client);
        return "client-update";
    }

    @PostMapping("/client-update")
    public String updateClient(Client client) {
        clientService.saveClient(client);
        return "redirect:/clients";
    }

    @GetMapping("/hospclient")
    public String getClientByID(Model model){
        Client client = new Client();
        model.addAttribute("client", client);
        return "hospsform";
    }

    @PostMapping("/hosps")
    public String Hosps (Client client, Model model){
        List<String> clienthosps = clientService.Hosps(client);
        model.addAttribute("clienthosps", clienthosps);
        return "queryresults";
    }

    //Category Controller

    @GetMapping("/categories")
    public String findAllCategories(Model model){
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "category-list";
    }

    @GetMapping("/category-create")
    public String createCategoryForm(Category category){
        return "category-create";
    }

    @PostMapping("/category-create")
    public String createCategory(Category category){
        categoryService.saveCategory(category);
        return "redirect:/categories";
    }

    @GetMapping("category-delete/{CategoryID}")
    public String deleteCategory(@PathVariable("CategoryID") Long id){
        categoryService.deleteById(id);
        return "redirect:/categories";
    }

    @GetMapping("/category-update/{CategoryID}")
    public String updateCategoryForm(@PathVariable("CategoryID") Long id, Model model){
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "category-update";
    }

    @PostMapping("/category-update")
    public String updateCategory(Category category) {
        categoryService.saveCategory(category);
        return "redirect:/categories";
    }

    //Diagnosis Controller

    @GetMapping("/diagnoses")
    public String findAllDiagnoses(Model model){
        List<Diagnosis> diagnoses = diagnosisService.findAll();
        model.addAttribute("diagnoses", diagnoses);
        return "diagnosis-list";
    }

    @GetMapping("/diagnosis-create")
    public String createDiagnosisForm(Diagnosis diagnosis){
        return "diagnosis-create";
    }

    @PostMapping("/diagnosis-create")
    public String createDiagnosis(Diagnosis diagnosis){
        diagnosisService.saveDiagnosis(diagnosis);
        return "redirect:/diagnoses";
    }

    @GetMapping("diagnosis-delete/{DiagnosisID}")
    public String deleteDiagnosis(@PathVariable("DiagnosisID") Long id){
        diagnosisService.deleteById(id);
        return "redirect:/diagnoses";
    }

    @GetMapping("/diagnosis-update/{DiagnosisID}")
    public String updateDiagnosisForm(@PathVariable("DiagnosisID") Long id, Model model){
        Diagnosis diagnosis = diagnosisService.findById(id);
        model.addAttribute("diagnosis", diagnosis);
        return "diagnosis-update";
    }

    @PostMapping("/diagnosis-update")
    public String updateDiagnosis(Diagnosis diagnosis) {
        diagnosisService.saveDiagnosis(diagnosis);
        return "redirect:/diagnoses";
    }

    //Doctor Controller

    @GetMapping("/doctors")
    public String findAllDoctors(Model model){
        List<Doctor> doctors = doctorService.findAll();
        model.addAttribute("doctors", doctors);
        return "doctor-list";
    }

    @GetMapping("/doctor-create")
    public String createDoctorForm(@Valid Doctor doctor){
        return "doctor-create";
    }

    @PostMapping("/doctor-create")
    public String createDoctor(@Valid Doctor doctor){
        doctorService.saveDoctor(doctor);
        return "redirect:/doctors";
    }

    @GetMapping("doctor-delete/{DoctorID}")
    public String deleteDoctor(@PathVariable("DoctorID") Long id){
        clientService.deleteById(id);
        return "redirect:/doctors";
    }

    @GetMapping("/doctor-update/{DoctorID}")
    public String updateDoctorForm(@PathVariable("DoctorID") Long id, Model model){
        Doctor doctor = doctorService.findById(id);
        model.addAttribute("doctor", doctor);
        return "doctor-update";
    }

    @PostMapping("/doctor-update")
    public String updateDoctor(Doctor doctor) {
        doctorService.saveDoctor(doctor);
        return "redirect:/doctors";
    }
    


}