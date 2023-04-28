package com.aplicatie_donare_de_sange.centru_de_donare.service;

import com.aplicatie_donare_de_sange.centru_de_donare.Dto.DoctorDto;
import com.aplicatie_donare_de_sange.centru_de_donare.Model.Doctor;
import com.aplicatie_donare_de_sange.centru_de_donare.Model.Locatie;
import com.aplicatie_donare_de_sange.centru_de_donare.Repository.DoctorRepository;
import com.aplicatie_donare_de_sange.centru_de_donare.Repository.LocatieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    private DoctorRepository doctorRepository;
    private LocatieRepository locatieRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository, LocatieRepository locatieRepository) {
        this.doctorRepository = doctorRepository;
        this.locatieRepository = locatieRepository;
    }

    @Override
    public Doctor saveDoctor(DoctorDto doctorDto) {

        Locatie locatie = locatieRepository.findByNume(doctorDto.getLocatie());

        Doctor doctor = new Doctor(doctorDto.getUsername(), doctorDto.getPassword(), doctorDto.getNume(), doctorDto.getPrenume(), doctorDto.getSpecializare(), locatie);

        return doctorRepository.save(doctor);

    }

    @Override
    public List<Doctor> getAll() {
        return doctorRepository.findAll();

    }
    @Override
    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }

    @Override
    public Doctor getOne(Long id) {
        return doctorRepository.getOne(id);
    }

    @Override
    public Doctor findByUsername(String username) {

        return doctorRepository.findByUsername(username);
    }

    @Override
    public void update(Doctor doctor) {

        doctorRepository.save(doctor);

    }

    @Override
    public Doctor updateDoctor(Long idDeCautare, DoctorDto doctorDto) {

        Doctor doctor;
        doctor = doctorRepository.findById(idDeCautare).get();

        doctor.setUsername(doctorDto.getUsername());
        doctor.setNume(doctorDto.getNume());

      //  System.out.println(doctorDto.getLocatie());

        Locatie locatie = locatieRepository.findByNume(doctorDto.getLocatie());

        doctor.setLocatie(locatie);

        doctor.setSpecializare(doctorDto.getSpecializare());
        doctor.setPassword(doctorDto.getPassword());

        doctorRepository.save(doctor);

        return doctor;

    }
}
