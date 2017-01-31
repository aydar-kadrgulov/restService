package com.rest.entity;

import java.util.Date;
import java.util.List;

/**
 * Created by home on 31.01.2017.
 */
public class Patient {
    public static final String FEMALE = "female";
    public static final String MALE = "male";
    private String firstName;
    private String name;
    private String lastName;
    private Date birthDate;
    private String sex;
    private String snils;
    private List<Vaccination> vaccinationList;

    public Patient(String firstName, String name, String lastName, Date birthDate, String sex, String snils) {
        this.firstName = firstName;
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.sex = sex;
        this.snils = snils;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSnils() {
        return snils;
    }

    public void setSnils(String snils) {
        this.snils = snils;
    }

    public List<Vaccination> getVaccinationList() {
        return vaccinationList;
    }

    public void setVaccinationList(List<Vaccination> vaccinationList) {
        this.vaccinationList = vaccinationList;
    }
}
