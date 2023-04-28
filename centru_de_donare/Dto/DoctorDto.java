package com.aplicatie_donare_de_sange.centru_de_donare.Dto;

public class DoctorDto {


    private String username;

    private String password;

    private String role;

    private String nume;

    private String prenume;

    private String specializare;

    private String locatie;

    public DoctorDto(String username, String password, String nume, String prenume, String specializare, String locatie) {

        this.nume = nume;
        this.prenume = prenume;
        this.specializare = specializare;
        this.username = username;
        this.password = password;
        this.locatie = locatie;
    }

    public DoctorDto(  String username, String password, String role, String nume, String prenume, String specializare, String locatie) {

        this.username = username;
        this.password = password;
        this.role = role;
        this.nume = nume;
        this.prenume = prenume;
        this.specializare = specializare;
        this.locatie = locatie;
    }

    public DoctorDto() {
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

    public String getSpecializare() {
        return specializare;
    }

    public void setSpecializare(String specializare) {
        this.specializare = specializare;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    @Override
    public String toString() {
        return "DoctorDto{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", specializare='" + specializare + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +

                ", locatie='" + locatie + '\'' +
                '}';
    }



    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}