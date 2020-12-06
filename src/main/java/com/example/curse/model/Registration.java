package com.example.curse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name="registrations")
public class Registration {

        @Id
        @NotNull
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name="id")
        private long id;

        @Column(name="Category")
        @Min(value = 1, message = "Category can't be less than 1" )
        @JoinColumn(name = "Category", referencedColumnName = "Category_ID")
        private int Category;

        @Column(name="Client_ID")
        @Min(value = 1, message = "ClientID can't be less than 1" )
        @JoinColumn(name = "Client_ID", referencedColumnName = "Client_ID")
        private int ClientID;

        @Column(name="Diagnosis")
        @Min(value = 1, message = "Diagnosis can't be less than 1" )
        @JoinColumn(name = "Diagnosis", referencedColumnName = "Diagnosis_ID")
        private int Diagnosis;

        @Column(name="Doctor")
        @Min(value = 1, message = "Doctor can't be less than 1" )
        @JoinColumn(name = "Doctor", referencedColumnName = "Doctor_ID")
        private int Doctor;

        @Column(name="Visit_Date")
        @DateTimeFormat(pattern = "yyyy-mm-dd")
        private Date VisitDate;

        @Column(name="Discharge_Date")
        @DateTimeFormat(pattern = "yyyy-mm-dd")
        private Date DischargeDate;

        @Column(name="Severity")
        @Min(value=1, message = "Value can't be less than 1")
        @Max(value=1, message = "Value can't be greater than 2")
        private float Severity;

        @Column(name="Payment")
        @Min(value=0, message = "Value can't be negative")
        private float Payment;
    }
