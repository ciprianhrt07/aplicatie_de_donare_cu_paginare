package com.aplicatie_donare_de_sange.centru_de_donare.Repository;
import com.aplicatie_donare_de_sange.centru_de_donare.Model.Locatie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocatieRepository extends JpaRepository<Locatie, Long> {

        Locatie findByNume(String nume);
}