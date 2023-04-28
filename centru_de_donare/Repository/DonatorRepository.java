package com.aplicatie_donare_de_sange.centru_de_donare.Repository;

import com.aplicatie_donare_de_sange.centru_de_donare.Model.Donator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonatorRepository extends JpaRepository<Donator,Long> {

    public Donator findByUsername(String username);

}
