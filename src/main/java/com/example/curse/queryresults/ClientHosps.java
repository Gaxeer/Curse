package com.example.curse.queryresults;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;


@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ClientHosps {

    private long client_id;

    private String first_name;

    private String last_name;

    private String diagnosis_name;

    private String doctor_name;

    private Date visit_date;

    private Date discharge_date;
}
