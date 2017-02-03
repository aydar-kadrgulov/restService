package com.rest.dao;

import com.rest.entities.Patient;
import org.springframework.data.repository.CrudRepository;


public interface PatientDao extends CrudRepository<Patient, Long>{

}
