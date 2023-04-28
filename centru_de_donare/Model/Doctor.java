package com.aplicatie_donare_de_sange.centru_de_donare.Model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("3")
public class Doctor extends User{

    @Column
    private String nume;

    @Column
    private String prenume;

    @Column
    private String specializare;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    private Locatie locatie;

    public Doctor(String username , String password , String nume , String prenume , String specializare , Locatie locatie){

        super(username,password,"ROLE_DOCTOR");
        this.nume = nume;
        this.prenume = prenume;
        this.specializare = specializare;
        this.locatie = locatie;
    }

    public Doctor(){}


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

    public String getSpecializare() {
        return specializare;
    }

    public void setSpecializare(String specializare) {
        this.specializare = specializare;
    }

    public Locatie getLocatie() {
        return locatie;
    }

    public void setLocatie(Locatie locatie) {
        this.locatie = locatie;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", specializare='" + specializare + '\'' +
                '}';
    }
}