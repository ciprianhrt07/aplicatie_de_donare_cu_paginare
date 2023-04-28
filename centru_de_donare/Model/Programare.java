package com.aplicatie_donare_de_sange.centru_de_donare.Model;

import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.print.Doc;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Programare{

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    private Locatie locatie;

    @ManyToOne(fetch = FetchType.LAZY)
    private Donator donator;

    @Column
    private boolean status;

    @Column
    private boolean anulata;


    public Programare(LocalDate date, Locatie locatie, Donator donator) {
        this.date = date;
        this.locatie = locatie;
        this.donator = donator;
        this.anulata = false;
        this.status = true;

    }

    public Programare() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Locatie getLocatie() {
        return locatie;
    }

    public void setLocatie(Locatie locatie) {
        this.locatie = locatie;
    }

    public Donator getDonator() {
        return donator;
    }

    public void setDonator(Donator donator) {
        this.donator = donator;
    }

    public boolean isAnulata() {
        return anulata;
    }

    public void setAnulata(boolean anulata) {
        this.anulata = anulata;
    }




    @Override
    public String toString() {
        return "Programare{" +
                "id=" + id +
                ", date=" + date +
                ", locatie=" + locatie +
                ", donator=" + donator +
                ", status=" + status +
                ", anulata=" + anulata +
                '}';
    }
}
