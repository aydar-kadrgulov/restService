package com.rest.controllers;

import com.rest.entities.Patient;
import com.rest.entities.Vaccination;
import com.rest.services.PatientService;
import com.rest.services.VaccinationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class VaccinationController {

    @Autowired
    VaccinationService vaccinationService;

    @Autowired
    PatientService patientService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/vaccination/{snils}", method = RequestMethod.POST)
    public ResponseEntity<Vaccination> addVaccination(@PathVariable String snils, @RequestBody Vaccination vaccination) {
        logger.info("add vaccinations for patient with snils : " + snils);
        Patient patient = patientService.getPatientBySnils(snils);
        vaccination.setPatientId(patient.getId());
        vaccination = vaccinationService.createVaccination(vaccination);
        return new ResponseEntity<>(vaccination, HttpStatus.OK);
    }

    @RequestMapping(value = "/vaccination/{snils}", method = RequestMethod.GET)
    public ResponseEntity<List<Vaccination>> getVaccinationsBySnils(@PathVariable String snils) {
        logger.info("get vaccinations by snils : " + snils);
        List<Vaccination> vaccinations = new ArrayList<>();
        vaccinations.add(new Vaccination());
        vaccinations.add(new Vaccination());
        vaccinations.add(new Vaccination());
        vaccinations.add(new Vaccination());
        return new ResponseEntity<>(vaccinations, HttpStatus.OK);
    }

    @RequestMapping(value = "/vaccination/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<String> deleteVaccination(@PathVariable long id) {
        logger.info("delete vaccination with id : " + id);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }

}
