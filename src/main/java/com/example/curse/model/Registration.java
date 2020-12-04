package com.example.curse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name="registrations")
public class Registration {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name="id")
        private long id;

        @Column(name="Category")
        @JoinColumn(name = "Category", referencedColumnName = "Category_ID")
        private int Category;

        @Column(name="Client_ID")
        @JoinColumn(name = "Client_ID", referencedColumnName = "Client_ID")
        private int ClientID;

        @Column(name="Diagnosis")
        @JoinColumn(name = "Diagnosis", referencedColumnName = "Diagnosis_ID")
        private int Diagnosis;

        @Column(name="Doctor")
        @JoinColumn(name = "Doctor", referencedColumnName = "Doctor_ID")
        private int Doctor;

        @Column(name="Visit_Date")
        @DateTimeFormat(pattern = "yyyy-mm-dd")
        private Date VisitDate;

        @Column(name="Discharge_Date")
        @DateTimeFormat(pattern = "yyyy-mm-dd")
        private Date DischargeDate;

        @Column(name="Severity")
        private float Severity;

        @Column(name="Payment")
        private float Payment;
    }
