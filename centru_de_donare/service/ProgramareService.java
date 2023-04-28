package com.aplicatie_donare_de_sange.centru_de_donare.service;

import com.aplicatie_donare_de_sange.centru_de_donare.Dto.ProgramareDto;
import com.aplicatie_donare_de_sange.centru_de_donare.Model.Donator;
import com.aplicatie_donare_de_sange.centru_de_donare.Model.Programare;

import java.util.List;

public interface ProgramareService {

    public Programare saveProgramare(ProgramareDto programareDto);
    List<Programare> getChechedProgramari(Long id);
    List<Programare> getUncheckedProgramari(Long id);

    List<Programare> getProgramariFromLocation(Long idLocatie);

    List<Programare> allProgramari();


    List<Programare> getProgramariDonator(Donator donator);

    void anuleaza(Long id);

    void finalizeaza(Long id);



    List<Programare> getProgramariFromLocationCurrentDay(Long idLocatie);

    void succesProgramare(Long id);
}
