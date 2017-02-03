package com.rest.services;

import com.rest.dao.PatientDao;
import com.rest.entities.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    private PatientDao patientDao;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public void createPatient(Patient patient) {
        patientDao.createPatient(patient);
    }
}
