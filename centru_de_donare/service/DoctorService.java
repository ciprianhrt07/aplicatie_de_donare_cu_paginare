package com.aplicatie_donare_de_sange.centru_de_donare.service;

import com.aplicatie_donare_de_sange.centru_de_donare.Dto.DoctorDto;
import com.aplicatie_donare_de_sange.centru_de_donare.Dto.DonatorDto;
import com.aplicatie_donare_de_sange.centru_de_donare.Model.Doctor;

import java.util.List;

public interface DoctorService {

    Doctor saveDoctor(DoctorDto doctorDto);

    List<Doctor> getAll();

    void deleteDoctor(Long id);

    Doctor getOne(Long id);

    Doctor findByUsername(String username);

    void update(Doctor doctor);



    Doctor updateDoctor(Long idDeCautare, DoctorDto doctorDto);
}
