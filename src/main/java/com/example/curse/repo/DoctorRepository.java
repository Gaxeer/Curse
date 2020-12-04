package com.example.curse.repo;

import com.example.curse.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    @Query(value = "Select doctor_id, doctor_name, doctor_tariff from doctors", nativeQuery = true)
    ArrayList<Doctor> BestDoctor();

}
