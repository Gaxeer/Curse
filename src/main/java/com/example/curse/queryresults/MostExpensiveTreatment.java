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
public class MostExpensiveTreatment {
        @DateTimeFormat(pattern = "yyyy-mm-dd")
        private Date StartDate;

        @DateTimeFormat(pattern = "yyyy-mm-dd")
        private Date EndDate;
    }

