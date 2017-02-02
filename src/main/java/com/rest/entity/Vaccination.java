package com.rest.entity;

import java.util.Date;

public class Vaccination {
    private long id;
    private String drugName;
    private Date date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Vaccination{" +
                "id=" + id +
                ", drugName='" + drugName + '\'' +
                ", date=" + date +
                '}';
    }
}
