package com.aplicatie_donare_de_sange.centru_de_donare.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("2")
public class Donator extends User {

    @Column
    private String nume;

    @Column
    private String prenume;

    @Column
    private String grupa;

    @Column
    private String judet;

    public Donator(String nume, String prenume, String grupa, String judet, String email, String password) {

        super(email, password, "ROLE_DONATOR");
        this.nume = nume;
        this.prenume = prenume;
        this.grupa = grupa;
        this.judet = judet;

    }

    public Donator() {
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getGrupa() {
        return grupa;
    }

    public void setGrupa(String grupa) {
        this.grupa = grupa;
    }

    public String getJudet() {
        return judet;
    }

    public void setJudet(String judet) {
        this.judet = judet;
    }


    @Override
    public String toString() {
        return "Donator{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", grupa='" + grupa + '\'' +
                ", judet='" + judet + '\'' +
                '}';
    }
}
