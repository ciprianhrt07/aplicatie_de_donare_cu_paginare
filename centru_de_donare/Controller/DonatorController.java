package com.aplicatie_donare_de_sange.centru_de_donare.Controller;

import com.aplicatie_donare_de_sange.centru_de_donare.Dto.DonatorDto;
import com.aplicatie_donare_de_sange.centru_de_donare.Model.Donator;
import com.aplicatie_donare_de_sange.centru_de_donare.service.DonatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class DonatorController {

    DonatorService donatorService;

    public DonatorController(DonatorService donatorService) {

        this.donatorService = donatorService;

    }


    @PostMapping("/register-donator")
    public Donator saveDonator(@RequestBody DonatorDto donatorDto){

        System.out.println("***************************************");
        System.out.println("Am primit request sa salvez donatorul:");
        System.out.println(donatorDto);
        System.out.println("***************************************");
        return donatorService.saveDonator(donatorDto);

    }

    @PutMapping("/update-donator/{id}")
    public ResponseEntity<Donator> updateDonator(@PathVariable String id,
                                                 @RequestBody DonatorDto donatorDto
                                                 )
    {

        Long idDeCautare = Long.valueOf(id.substring(1));

        Donator donator = donatorService.updateDonator(idDeCautare,donatorDto);

        return ResponseEntity.ok(donator);


    }

    @GetMapping("/getOne-donator/{id}")
    public ResponseEntity<Donator> getDonatorById(@PathVariable String id) {
        Donator donator = null;

        Long idDeCautare = Long.valueOf(id.substring(1,id.length()));

        donator = donatorService.getDonatorById(idDeCautare);
       // System.out.println(donator);
        return ResponseEntity.ok(donator);
    }

    @GetMapping("/get-donator/{username}")
    public ResponseEntity<Donator> getDonatorByUsername(@PathVariable String username) {
        Donator donator = null;

        donator = donatorService.findByUsername(username);

        //System.out.println(donator);

        return ResponseEntity.ok(donator);
    }

}
