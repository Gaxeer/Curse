package com.example.curse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name="doctors")
public class Doctor {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Doctor_ID")
    private long DoctorID;

    @NotBlank
    @Column(name="Doctor_Name")
    @Size(min = 2, max = 60, message = "Name should be in range between 2 and 60")
    private String DoctorName;

    @Min(value = 0, message= "Tariff can't be negative")
    @Column(name="Doctor_Tariff")
    private int DoctorTariff;
}
