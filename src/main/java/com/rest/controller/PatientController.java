package com.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by home on 31.01.2017.
 */
@RestController
public class PatientController {
    @RequestMapping("/addPatient")
    public String  addPatient(@RequestParam(value="name", defaultValue="World") String name){
        return "Added";
    }
}
