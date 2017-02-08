package com.rest.entities;

import java.util.Date;

public class Vaccination {
    private long id;
    private String drugName;
    private Date date;
    private long patientId;

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

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    @Override
    public String toString() {
        return "Vaccination{" +
                "id=" + id +
                ", drugName='" + drugName + '\'' +
                ", date=" + date +
                ", patientId=" + patientId +
                '}';
    }
}
