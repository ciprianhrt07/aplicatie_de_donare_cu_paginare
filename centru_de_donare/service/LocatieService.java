package com.aplicatie_donare_de_sange.centru_de_donare.service;

import com.aplicatie_donare_de_sange.centru_de_donare.Model.Locatie;

import java.util.List;

public interface LocatieService {

    public List<Locatie> getAllLocatii();

    Locatie getOne(Long id);

    Locatie findByName(String nume);


}
