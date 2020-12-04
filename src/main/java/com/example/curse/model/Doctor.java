package com.example.curse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name="doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Doctor_ID")
    private long DoctorID;

    @Column(name="Doctor_Name")
    private String DoctorName;

    @Column(name="Doctor_Tariff")
    private int DoctorTariff;
}
