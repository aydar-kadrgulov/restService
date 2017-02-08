package com.rest.services;

import com.rest.dao.VaccinationDao;
import com.rest.entities.Vaccination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@ComponentScan("com.rest.dao")
@Service
public class VaccinationService {

    @Autowired
    VaccinationDao vaccinationDao;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public Vaccination createVaccination(Vaccination vaccination) {
        return vaccinationDao.createVaccination(vaccination);
    }
}
