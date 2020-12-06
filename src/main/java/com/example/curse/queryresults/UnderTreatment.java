package com.example.curse.queryresults;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UnderTreatment {

    private long client_id;

    private String first_name;

    private String last_name;

    private String diagnosis_name;

    private String doctor_name;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date visit_date;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date discharge_date;

}
