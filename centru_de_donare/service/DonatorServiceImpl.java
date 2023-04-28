package com.aplicatie_donare_de_sange.centru_de_donare.service;

import com.aplicatie_donare_de_sange.centru_de_donare.Dto.DonatorDto;
import com.aplicatie_donare_de_sange.centru_de_donare.Model.Donator;
import com.aplicatie_donare_de_sange.centru_de_donare.Repository.DonatorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class DonatorServiceImpl implements DonatorService {

    private DonatorRepository donatorRepository;

    public DonatorServiceImpl (DonatorRepository donatorRepository){
        this.donatorRepository  = donatorRepository;
    }

    @Override
    public Donator saveDonator(DonatorDto donatorDto) {
        Donator donator = new Donator(donatorDto.getNume() , donatorDto.getPrenume(), donatorDto.getGrupa() , donatorDto.getJudet() ,donatorDto.getUsername(), donatorDto.getPassword());
        return  donatorRepository.save(donator);
    }

    @Override
    public Donator updateDonator(Long id, DonatorDto donatorDto) {

        Donator donator = donatorRepository.findById(id).get();

        donator.setNume(donatorDto.getNume());
        donator.setPrenume(donatorDto.getPrenume());
        donator.setGrupa(donatorDto.getGrupa());
        donator.setJudet(donatorDto.getJudet());
        donator.setPassword(donatorDto.getPassword());
        donator.setUsername(donatorDto.getUsername());

        donatorRepository.save(donator);

        return donator;

    }

    @Override
    public Donator getDonatorById(Long id) {

        Donator donator = donatorRepository.findById(id).get();

        Donator donator1 = new Donator();

        BeanUtils.copyProperties(donator, donator1);

        return donator1;

    }

    @Override
    public Donator findByUsername(String username) {

        Donator donator = donatorRepository.findByUsername(username);

        Donator donator1 = new Donator();

        BeanUtils.copyProperties(donator, donator1);


        return donator1;
    }


}
