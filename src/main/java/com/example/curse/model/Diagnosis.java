package com.example.curse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name="diagnoses")
public class Diagnosis {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Diagnosis_ID")
    private long DiagnosisID;

    @Column(name="Diagnosis_Name")
    private String DiagnosisName;

    @Column(name="Treatment_Duration")
    private float TreatmentDuration;

    @Column(name="Tariff")
    private float Tariff;
}
