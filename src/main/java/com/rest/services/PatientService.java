package com.rest.services;

import com.rest.dao.PatientDao;
import com.rest.entities.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ComponentScan("com.rest.dao")
public class PatientService {

    @Autowired
    private PatientDao patientDao;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public Patient createPatient(Patient patient) {
        return patientDao.createPatient(patient);
    }

    public List<Patient> getPatients() {
        return patientDao.getPatients();
    }

    public Patient getPatientBySnils(String snils) {
        return patientDao.getPatientBySnils(snils);
    }

    public Patient getPatientById(long id) {
        return patientDao.getPatientById(id);
    }

    public void updatePatient(Patient patient) {
        patientDao.updatePatient(patient);
    }

    public void deletePatientsBySnils(String snils) {
        patientDao.deletePatientBySnils(snils);
    }
}
