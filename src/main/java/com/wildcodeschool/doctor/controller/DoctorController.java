package com.wildcodeschool.doctor.controller;

import com.wildcodeschool.doctor.model.Doctor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

import javax.print.Doc;

@Controller
public class DoctorController {

    @GetMapping("/doctor/")
    @ResponseBody
    public Doctor doctor() {

        return null;
    }

    @GetMapping("/doctor/{number}")
    @ResponseBody
    public Doctor DoctorIndex(@PathVariable int number) {
        if (number == 13) {
            return new Doctor(number, "Jodie Whittaker");
        } else if (1<=number && number <=12 ){
            throw new ResponseStatusException(HttpStatus.SEE_OTHER, "Redirects don't link to the requested resource");
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Impossible de récupérer l'incarnation " + number);
        }
    }
}

