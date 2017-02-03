package com.rest.controllers;

import com.rest.entities.Vaccination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class VaccinationController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/vaccination/{snils}", method = RequestMethod.POST)
    public ResponseEntity<List<Vaccination>> addVaccinations(@PathVariable String snils, @RequestBody List<Vaccination> vaccinations) {
        logger.info("add vaccinations for patient with snils : " + snils);

        return new ResponseEntity<>(vaccinations, HttpStatus.OK);
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
