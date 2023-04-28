package com.aplicatie_donare_de_sange.centru_de_donare.service;


import com.aplicatie_donare_de_sange.centru_de_donare.Model.Locatie;
import com.aplicatie_donare_de_sange.centru_de_donare.Repository.LocatieRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocatieServiceImpl implements LocatieService{

    private LocatieRepository locatieRepository;


    public LocatieServiceImpl(LocatieRepository locatieRepository){

        this.locatieRepository = locatieRepository;

    }


    @Override
    public List<Locatie> getAllLocatii() {

        List<Locatie> locatii = locatieRepository.findAll();

        List<Locatie> locatieAux = new ArrayList<>();

        for(Locatie l:locatii){

           Locatie aux = new Locatie();
           BeanUtils.copyProperties(l, aux);

           locatieAux.add(aux);

        }

        return locatieAux;

    }

    @Override
    public Locatie getOne(Long id) {

        Locatie l = new Locatie();

        BeanUtils.copyProperties(locatieRepository.getOne(id),l);

        return l;
    }

    @Override
    public Locatie findByName(String nume) {
        return  locatieRepository.findByNume(nume);
    }


}