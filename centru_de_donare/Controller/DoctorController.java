package com.aplicatie_donare_de_sange.centru_de_donare.Controller;

import com.aplicatie_donare_de_sange.centru_de_donare.Dto.DoctorDto;
import com.aplicatie_donare_de_sange.centru_de_donare.Dto.DonatorDto;
import com.aplicatie_donare_de_sange.centru_de_donare.Model.Doctor;
import com.aplicatie_donare_de_sange.centru_de_donare.Model.Donator;
import com.aplicatie_donare_de_sange.centru_de_donare.service.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class DoctorController {

    private DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;

    }

    @PostMapping("/doctor-save")
    public Doctor saveDoctor(@RequestBody DoctorDto doctorDto){

        System.out.println(doctorDto.toString());
        return doctorService.saveDoctor(doctorDto);
    }
    @GetMapping("/doctor-get-all")
    public List<Doctor> allDoctors(){
        return doctorService.getAll();
    }

    @PostMapping("/doctor/delete/{id}")
    public String deleteDoctor(@PathVariable Long id) {


        Doctor doctor = doctorService.getOne(id);

        System.out.println("Doctorul: "+doctor+" va fi sters!");

        System.out.println("**********************");
        doctorService.deleteDoctor(id);

        return "redirect:/admin/?succes";

    }

    @PutMapping("/doctor/update/{id}")
    public ResponseEntity<Doctor> updateDonator(@PathVariable String id,
                                                 @RequestBody DoctorDto doctorDto
    )
    {

        //System.out.println(id+"   "+doctorDto);

        Long idDeCautare = Long.valueOf(id.substring(1));

        Doctor doctor = doctorService.updateDoctor(idDeCautare,doctorDto);

        return ResponseEntity.ok(null);


    }


    @GetMapping("/doctor/get/{id}")
    public Doctor getDoctor(@PathVariable("id") String id){


        return doctorService.getOne(Long.valueOf(id.substring(1)));
    }

    @GetMapping("/doctor/getDoctor/{username}")
    public Doctor getDoctorByUSername(@PathVariable String username){
        return doctorService.findByUsername(username);
    }




}
