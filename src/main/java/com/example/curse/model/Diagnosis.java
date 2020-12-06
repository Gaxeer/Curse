package com.example.curse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name="diagnoses")
public class Diagnosis {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Diagnosis_ID")
    private long DiagnosisID;


    @Column(name="Diagnosis_Name")
    private String DiagnosisName;

    @Column(name="Treatment_Duration")
    private float TreatmentDuration;

    @Min(value = 0, message= "Tariff can't be negative")
    @Column(name="Tariff")
    private float Tariff;
}
