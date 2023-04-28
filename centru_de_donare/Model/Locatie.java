package com.aplicatie_donare_de_sange.centru_de_donare.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Locatie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(name = "nume_locatie")
    private String nume;

    @Column
    private String strada;

    @Column
    private String judet;

    @Column
    private String orar;

    @Column(name = "numar_maxim_programari")
    private int numarMaximProgramari;

    @Column(name = "numar_programari_ramase")
    private int numarProgramari;

    public Locatie(String nume, String strada, String judet, String orar, int numarMaximProgramari, int numarProgramari) {
        this.nume = nume;
        this.strada = strada;
        this.judet = judet;
        this.orar = orar;
        this.numarMaximProgramari = numarMaximProgramari;
        this.numarProgramari = numarProgramari;
    }


    public Locatie() {

    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getStrada() {
        return strada;
    }

    public void setStrada(String strada) {
        this.strada = strada;
    }

    public String getJudet() {
        return judet;
    }

    public void setJudet(String judet) {
        this.judet = judet;
    }

    public String getOrar() {
        return orar;
    }

    public void setOrar(String orar) {
        this.orar = orar;
    }

    public int getNumarMaximProgramari() {
        return numarMaximProgramari;
    }

    public void setNumarMaximProgramari(int numarMaximProgramari) {
        this.numarMaximProgramari = numarMaximProgramari;
    }

 /*   public List<Doctor> getDoctor() {
        return doctor;
    }

    public void setDoctor(List<Doctor> doctor) {
        this.doctor = doctor;
    }
*/
    @Override
    public String toString() {
        return "Centrul{" +
                "Id=" + Id +
                ", nume='" + nume + '\'' +
                ", strada='" + strada + '\'' +
                ", judet='" + judet + '\'' +
                " functioneaza intre orele: "+
                ", orar='" + orar + '\'' +
                " si poate accepta maxim :"+
                +numarMaximProgramari +
                " pe zi de L-V "+
                '}'
                ;
    }

    public int getNumarProgramari() {
        return numarProgramari;
    }

    public void setNumarProgramari(int numarProgramari) {
        this.numarProgramari = numarProgramari;
    }
}