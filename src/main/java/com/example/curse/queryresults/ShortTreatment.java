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
public class ShortTreatment {

    private long client_id;

    private String first_name;

    private String last_name;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date Visit_Date;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date Discharge_Date;
}
