package com.aplicatie_donare_de_sange.centru_de_donare.Model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class Admin extends User {

    public Admin(String username, String password) {

        super(username, password, "ROLE_ADMIN");

    }

    public Admin() {
    }

}