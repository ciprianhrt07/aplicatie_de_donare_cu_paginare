package com.aplicatie_donare_de_sange.centru_de_donare.service;

import com.aplicatie_donare_de_sange.centru_de_donare.Dto.ProgramareDto;
import com.aplicatie_donare_de_sange.centru_de_donare.Model.Donator;
import com.aplicatie_donare_de_sange.centru_de_donare.Model.Locatie;
import com.aplicatie_donare_de_sange.centru_de_donare.Model.Programare;
import com.aplicatie_donare_de_sange.centru_de_donare.Repository.DonatorRepository;
import com.aplicatie_donare_de_sange.centru_de_donare.Repository.LocatieRepository;
import com.aplicatie_donare_de_sange.centru_de_donare.Repository.ProgramareRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProgramareServiceImpl implements ProgramareService {

    private ProgramareRepository programareRepository;
    private LocatieRepository locatieRepository;
    private DonatorRepository donatorRepository;

    public ProgramareServiceImpl(ProgramareRepository programareRepository, LocatieRepository locatieRepository, DonatorRepository donatorRepository) {

        this.programareRepository = programareRepository;
        this.locatieRepository = locatieRepository;
        this.donatorRepository = donatorRepository;

    }

    @Override
    public Programare saveProgramare(ProgramareDto programareDto) {

        Donator donator = donatorRepository.getOne(Long.parseLong(programareDto.getDonatorId()));
        Locatie locatie = locatieRepository.getOne(Long.parseLong(programareDto.getLocatieId()));
        LocalDate date = LocalDate.parse(programareDto.getDate());

        System.out.println("****************************************************");

        System.out.println(java.time.LocalDate.now());
        System.out.println(date);
        System.out.println(date.isAfter(java.time.LocalDate.now()));
        System.out.println("In locatia curenta au mai ramas: "+locatie.getNumarProgramari()+" locuri");

        System.out.println("****************************************************");
        Programare programare = new Programare(date, locatie, donator);

        if((date.isAfter(java.time.LocalDate.now()) || date.equals(java.time.LocalDate.now())) && locatie.getNumarProgramari()>=1) {

            int numarulDeProgramariRamase = locatie.getNumarProgramari();
            numarulDeProgramariRamase--;
            locatie.setNumarProgramari(numarulDeProgramariRamase);

            locatieRepository.save(locatie);

            return programareRepository.save(programare);
        }
        else
            return null;
    }

    @Override
    public List<Programare> getChechedProgramari(Long id) {

        return programareRepository.findAll().stream().filter(programare -> programare.getDonator().getId() == id && programare.isStatus() && !programare.isAnulata()).collect(Collectors.toList());
    }

    @Override
    public List<Programare> getUncheckedProgramari(Long id) {
        return programareRepository.findAll().stream().filter(programare -> !programare.isAnulata()).collect(Collectors.toList());

    }

    @Override
    public List<Programare> getProgramariFromLocation(Long idLocatie) {
        return programareRepository.findAll().stream().filter(programare -> programare.getLocatie().getId() == idLocatie).collect(Collectors.toList());
    }

    @Override
    public List<Programare> allProgramari() {
        return programareRepository.findAll().stream().filter(programare -> (!programare.isAnulata() && programare.isStatus())).collect(Collectors.toList());
    }

    @Override
    public List<Programare> getProgramariDonator(Donator donator) {
        return programareRepository.findAll().stream().filter(programare -> programare.getDonator().getId() == donator.getId()).collect(Collectors.toList());
    }

    @Override
    public void anuleaza(Long id) {

        Programare lastProgramare = programareRepository.getOne(id);
        lastProgramare.setAnulata(true);
      //  lastProgramare.setStatus(false);
        programareRepository.save(lastProgramare);

    }

    @Override
    public void finalizeaza(Long id) {
        Programare lastProgramare = programareRepository.getOne(id);
        lastProgramare.setAnulata(true);
        lastProgramare.setStatus(false);
        programareRepository.save(lastProgramare);
    }

    @Override
    public List<Programare> getProgramariFromLocationCurrentDay(Long idLocatie) {
        return programareRepository.findAll().stream().filter(programare -> programare.getLocatie().getId() == idLocatie && (!programare.isAnulata() && programare.isStatus()) && programare.getDate().equals(java.time.LocalDate.now())).collect(Collectors.toList());
    }

    @Override
    public void succesProgramare(Long id) {

        Programare lastProgramare = programareRepository.getOne(id);
        lastProgramare.setStatus(true);
        programareRepository.save(lastProgramare);

    }


}
