package com.aplicatie_donare_de_sange.centru_de_donare.service;

import com.aplicatie_donare_de_sange.centru_de_donare.Model.Programare;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


public interface ProgramarePaginationService {


    Page<Programare> findAll(int idDonator , int page , int size);

}
