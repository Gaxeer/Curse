package com.example.curse.repo;

import com.example.curse.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query(value="select clients.client_id, first_name, last_name, diagnosis_name, doctor_name, visit_date, discharge_date from clients join registrations r on clients.client_id = r.client join diagnoses d on r.diagnosis = d.diagnosis_id join doctors d2 on r.doctor = d2.doctor_id where clients.client_id = ?1", nativeQuery = true)
    List<String> Hosps(long ClientID);
}
