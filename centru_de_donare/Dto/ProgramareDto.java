package com.aplicatie_donare_de_sange.centru_de_donare.Dto;

public class ProgramareDto {

    private String  donatorId;

    private String locatieId;

    private String date;

    public ProgramareDto(String donatorId, String locatieId, String date) {
        this.donatorId = donatorId;
        this.locatieId = locatieId;
        this.date = date;
    }

    public ProgramareDto(){}


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDonatorId() {
        return donatorId;
    }

    public void setDonatorId(String donatorId) {
        this.donatorId = donatorId;
    }

    public String getLocatieId() {
        return locatieId;
    }

    public void setLocatieId(String locatieId) {
        this.locatieId = locatieId;
    }

    @Override
    public String toString() {
        return "ProgramareDto{" +
                "donatorId=" + donatorId +
                ", locatieId=" + locatieId +
                ", date='" + date + '\'' +
                '}';
    }
}
