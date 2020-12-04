package com.example.curse.repo;

import com.example.curse.model.Registration;
import com.example.curse.queryresults.BestDoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {



    @Query(value = "SELECT first_Name, last_Name, visit_date, discharge_date, doctor_name FROM registrations join clients c on c.client_id = registrations.client_id join doctors d on d.doctor_id = registrations.doctor WHERE visit_date > ?1 AND visit_date < ?2", nativeQuery = true)
    List<String> SpecificClients(@DateTimeFormat(pattern = "yyyy-mm-dd") Date StartDate, @DateTimeFormat(pattern = "yyyy-mm-dd") Date EndDate);

    @Query(value = "Select * from BestDoc()", nativeQuery = true)
    ArrayList<String> BestDoctor();

    @Query(value = "select * from registrations natural join (select diagnosis diag, max(payment) as max from registrations group by diagnosis) as sub1 where diagnosis=sub1.diag and payment=max order by id", nativeQuery = true)
    List<Registration> MostExpensiveTreatment();

    @Query(value = "select r.client_id, first_name, last_name, visit_date, discharge_date from clients join registrations r on clients.client_id = r.client_id where discharge_date-visit_date<='10'", nativeQuery = true)
    List<String> ShortTreatment();

    @Query(value = "select * from SumDiag()", nativeQuery = true)
    List<String> SumDiag();

    @Query(value = "select diagnosis_name, avg(payment) from registrations join diagnoses d on registrations.diagnosis = d.diagnosis_id group by diagnosis_name", nativeQuery = true)
    List<String> AvgPayment();

    @Query(value = "SELECT sum(payment) FROM registrations WHERE discharge_date > ?1 AND discharge_date < ?2", nativeQuery = true)
    List<String> PaymentSum(@DateTimeFormat(pattern = "yyyy-mm-dd") Date StartDate, @DateTimeFormat(pattern = "yyyy-mm-dd") Date EndDate);

    @Query(value = "select c.client_id, first_name, last_name, diagnosis_name from registrations join clients c on registrations.client_id = c.client_id join diagnoses d on d.diagnosis_id = registrations.diagnosis where discharge_date is null order by diagnosis_name", nativeQuery = true)
    List<String> UnderTreatment();

}
