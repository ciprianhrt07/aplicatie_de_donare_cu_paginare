package com.aplicatie_donare_de_sange.centru_de_donare.service;

import com.aplicatie_donare_de_sange.centru_de_donare.Dto.DonatorDto;
import com.aplicatie_donare_de_sange.centru_de_donare.Model.Donator;

public interface DonatorService {

    public Donator saveDonator(DonatorDto donatorDto);


    Donator updateDonator(Long id, DonatorDto donatorDto);

    Donator getDonatorById(Long id);

    Donator findByUsername(String username);
}
