package com.aplicatie_donare_de_sange.centru_de_donare.Controller;

import com.aplicatie_donare_de_sange.centru_de_donare.Dto.ProgramareDto;
import com.aplicatie_donare_de_sange.centru_de_donare.Model.Donator;
import com.aplicatie_donare_de_sange.centru_de_donare.Model.Programare;
import com.aplicatie_donare_de_sange.centru_de_donare.service.ProgramarePaginationService;
import com.aplicatie_donare_de_sange.centru_de_donare.service.ProgramarePaginationServiceImpl;
import com.aplicatie_donare_de_sange.centru_de_donare.service.ProgramareService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ProgramareController {

    private ProgramarePaginationService programarePaginationService;
    private ProgramareService programareService;

    public ProgramareController(ProgramareService programareService,ProgramarePaginationService programarePaginationService) {
        this.programareService = programareService;
        this.programarePaginationService = programarePaginationService;
    }

    @GetMapping("/get-all-page/{id}/{page}/{size}")
    public Page<Programare> findAllWithPagination(@PathVariable int id,@PathVariable int page, @PathVariable int size){
        System.out.println("I'm here find all with pagination****");
        return programarePaginationService.findAll(id, page , size);
    }

    @PostMapping("/save-programare")
    public Programare saveProgramare(@RequestBody ProgramareDto programareDto) {

        System.out.println("Am primit request sa salvez programarea: ");
        System.out.println(programareDto.toString());

        // programareService.saveProgramare(programareDto);

        // -problema e la service probabil trebuie copiate field-urile din
        return programareService.saveProgramare(programareDto);
        // return null;
    }

    @GetMapping("/get-true-status/{id}")
    public List<Programare> getAllTrueStatus(@PathVariable Long id) {

        List<Programare> aux = programareService.getChechedProgramari(id);

        /*System.out.println("----------------------");
        System.out.println(aux);*/
        return aux;
    }

    @GetMapping("/get-true-anulat/{id}")
    public List<Programare> getAllAnulat(@PathVariable Long id) {
        return programareService.getUncheckedProgramari(id);
    }

    @GetMapping("/get-from-location/{id}")
    public List<Programare> getAllProgramariFromLocation(@PathVariable String id) {
        //System.out.println("Am ajuns aici->>>>>>>>>>>>>>!");


        long idLocatie;


        idLocatie = Long.parseLong(id);

        return programareService.getProgramariFromLocation(idLocatie);
    }

    @GetMapping("/get-all-programari")
    public List<Programare> getAllPrgr() {
        System.out.println("Am ajuns aicisea!");


        return programareService.allProgramari();
    }

    @PostMapping("/getProgramariDonator")
    public List<Programare> getAllPrgrD(@RequestBody Donator donator) {

        System.out.println("Am primit " + donator);

        List<Programare> programari = programareService.getProgramariDonator(donator);

        System.out.println(programari);

        return programari;
    }

    @PostMapping("/anuleaza-programarea/{id}")
    public String anuleazaProgramarea(@PathVariable Long id) {

        System.out.println("Programare : Am ajuns aici!");

        System.out.println("Anulez Programarea:" + id);
        programareService.anuleaza(id);

        return null;
    }

    @PostMapping("/finalizeaza-programarea/{id}")
    public String finalizeazaProgramarea(@PathVariable Long id) {

        System.out.println("Programare : Am ajuns aici!");

        System.out.println("Finalizez Programarea:" + id);
        programareService.finalizeaza(id);

        return null;
    }


    @PostMapping("/succes-programarea/{id}")
    public String succesProgramare(@PathVariable Long id) {

        System.out.println("Programare : Am ajuns aici!");

        System.out.println("SuccesProgramare Programarea:" + id);
        programareService.succesProgramare(id);

        return null;
    }


    @GetMapping("/getProgramariFromTodayLocation/{id}")
    public List<Programare> getProgramariFromTodayLocation(@PathVariable String id) {

        System.out.println("*****************************************************");
        System.out.println("Am primit request: intoarce toate prorgamarile din ziua curenta: " + java.time.LocalDate.now());
        System.out.println("*****************************************************");
        long idLocatie;

        idLocatie = Long.parseLong(id);

        return programareService.getProgramariFromLocationCurrentDay(idLocatie);
    }

}
