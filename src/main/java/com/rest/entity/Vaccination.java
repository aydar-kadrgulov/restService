package com.rest.entity;

import java.util.Date;

/**
 * Created by home on 31.01.2017.
 */
public class Vaccination {
    private String drugName;
    private Date date;

    public Vaccination(String drugName, Date date) {
        this.drugName = drugName;
        this.date = date;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
