package com.aplicatie_donare_de_sange.centru_de_donare.Dto;

public class UserDtoCredentials {

    public  String username;
    public String password;

    public UserDtoCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserDtoCredentials() {
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

    @Override
    public String toString() {
        return "UserDtoCredentials{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}


