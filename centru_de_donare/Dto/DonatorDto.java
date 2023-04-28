package com.aplicatie_donare_de_sange.centru_de_donare.Dto;


public class DonatorDto{

    private String nume;
    private String username;
    private String password;
    private String role;
    private String prenume;
    private String grupa;
    private String judet;

    public DonatorDto(String username, String password, String nume, String prenume, String grupa, String judet) {

        this.username = username;
        this.password = password;
        this.role = "ROLE_DONATOR";
        this.nume = nume;
        this.prenume = prenume;
        this.grupa = grupa;
        this.judet = judet;
    }

    public DonatorDto() {

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



    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "DonatorDto{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", grupa='" + grupa + '\'' +
                ", judet='" + judet + '\'' +
                '}';
    }
}
