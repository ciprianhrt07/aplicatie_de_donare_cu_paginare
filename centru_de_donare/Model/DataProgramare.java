package com.aplicatie_donare_de_sange.centru_de_donare.Model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class DataProgramare {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    public DataProgramare(Date date) {
        this.date = date;
    }

    public DataProgramare() {

    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "DataProgramare{" +
                "date=" + date +
                '}';
    }
}
