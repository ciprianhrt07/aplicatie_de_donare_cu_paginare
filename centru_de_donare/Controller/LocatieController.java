package com.aplicatie_donare_de_sange.centru_de_donare.Controller;

import com.aplicatie_donare_de_sange.centru_de_donare.Model.Locatie;
import com.aplicatie_donare_de_sange.centru_de_donare.service.LocatieService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class LocatieController {

    private LocatieService locatieService;

    public LocatieController(LocatieService locatieService){

        this.locatieService = locatieService;
    }


    @GetMapping("/locatii")
    public List<Locatie> getAllLocatii(){
        return locatieService.getAllLocatii();
    }

    @GetMapping("/get-locatie/{id}")
    public Locatie getLocatie(@PathVariable Long id){
        return locatieService.getOne(id);
    }

}
