package com.rest.controllers;

import com.rest.entities.Patient;
import com.rest.services.PatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        logger.info("create new patient: " + patient.toString());
        patient = patientService.createPatient(patient);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    @RequestMapping(value = "/{snils}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Patient> getPatient(@PathVariable String snils) {
        logger.info("get patient by snils : " + snils);
        Patient patient = patientService.getPatientBySnils(snils);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Patient> update(@RequestBody Patient patient) {
        logger.info("update patient : " + patient.toString());
        Patient oldPatient = patientService.getPatientById(patient.getId());
        if (patient.getFirstName()!= null) oldPatient.setFirstName(patient.getFirstName());
        if (patient.getName()!= null) oldPatient.setName(patient.getName());
        if (patient.getLastName()!= null) oldPatient.setLastName(patient.getLastName());
        if (patient.getBirthDate() != null) oldPatient.setBirthDate(patient.getBirthDate());
        if (patient.getGender() != null) oldPatient.setGender(patient.getGender());
        if (patient.getSnils()!= null) oldPatient.setSnils(patient.getSnils());
        patientService.updatePatient(oldPatient);
        return new ResponseEntity<>(oldPatient, HttpStatus.OK);
    }

    @RequestMapping(value = "/{snils}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<String> deletePatient(@PathVariable String snils) {
        logger.info("delete patient by snils : " + snils);
        patientService.deletePatientsBySnils(snils);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Patient>> getPatients() {
        logger.info("get all patients");
        List<Patient> patiens = patientService.getPatients();
        return new ResponseEntity<>(patiens, HttpStatus.OK);
    }

}
