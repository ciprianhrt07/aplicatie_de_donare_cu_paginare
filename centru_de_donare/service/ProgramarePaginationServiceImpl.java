package com.aplicatie_donare_de_sange.centru_de_donare.service;

import com.aplicatie_donare_de_sange.centru_de_donare.Model.Programare;
import com.aplicatie_donare_de_sange.centru_de_donare.Repository.ProgramarePaginationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProgramarePaginationServiceImpl implements ProgramarePaginationService{

    public ProgramarePaginationRepository programarePaginationRepository;

    public ProgramarePaginationServiceImpl(ProgramarePaginationRepository programarePaginationRepository){
        this.programarePaginationRepository = programarePaginationRepository;
    }

    @Override
    public Page<Programare> findAll(int idDonator , int page, int size) {
        PageRequest pageRequest = PageRequest.of(page,size);
        List<Programare> programari = programarePaginationRepository.findAll(pageRequest)
                .stream()
                .filter(programare -> programare.getDonator().getId() == idDonator)
                .collect(Collectors.toList());
        return new PageImpl<>(programari, pageRequest, programari.size());}
}
