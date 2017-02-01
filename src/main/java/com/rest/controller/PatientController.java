package com.rest.controller;

import com.rest.entity.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by home on 31.01.2017.
 */
@RestController
public class PatientController {

    Logger logger = LoggerFactory.getLogger(this.getClass());
//    @RequestMapping(value="/getPatient", method = RequestMethod.GET)
//    public String  getPatient(@PathVariable String name){
//        return "Getting " + name;
//    }

    // этот метод будет принимать время методом GET и на его основе
    // отвечать клиенту
    @RequestMapping(value= "/{snils}", method = RequestMethod.GET)
    @ResponseBody
    public Patient getMyData(@PathVariable String snils) {
        logger.info("get request");
        return new Patient("firstName", "name", "lastName", new Date(), Patient.FEMALE, snils);
    }

    // этот метод будет принимать Объект MyDataObject и отдавать его клиенту
    // обычно метод PUT используют для сохранения либо для обновления объекта
    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public Patient putMyData(@RequestBody Patient patient) {
        logger.info("put request");
        logger.info(patient.toString());
        return patient;
    }

    // этот метод будет методом POST отдавать объект MyDataObject
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Patient postMyData() {
        logger.info("post request");
        Patient patient = new Patient("firstName", "name", "lastName", new Date(), Patient.FEMALE, "snils");
        logger.info(patient.toString());
        return patient;
    }

    // этот метод будет принимать время методом DELETE
    // и на его основе можно удалит объект
    @RequestMapping(value= "/{snils}", method = RequestMethod.DELETE)
    @ResponseBody
    public Patient deleteMyData(@PathVariable String snils) {
        logger.info("delete request");
        Patient patient = new Patient("firstName", "name", "lastName", new Date(), Patient.FEMALE, snils);
        logger.info(patient.toString());
        return patient;
    }
}
