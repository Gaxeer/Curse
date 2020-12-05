package com.example.curse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name="clients")
public class Client {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Client_ID")
    private long ClientID;

    @Size(min = 2, max = 30, message = "First name must be between 2 and 30")
    @Column(name="First_Name")
    private String FirstName;

    @Size(min = 2, max = 30, message = "Last name must be between 2 and 30")
    @Column(name="Last_Name")
    private String LastName;
}
