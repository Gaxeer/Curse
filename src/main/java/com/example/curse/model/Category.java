package com.example.curse.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name="categories")
public class Category {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Category_ID")
    private long CategoryID;

    @Min(value = 0, message= "Discount should not be less than 0")
    @Max(value = 1, message= "Discount should not be greater than 1")
    @Column(name="Discount")
    float Discount;
}
