package com.aplicatie_donare_de_sange.centru_de_donare.Repository;

import com.aplicatie_donare_de_sange.centru_de_donare.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User findByUsername(String username);

}
