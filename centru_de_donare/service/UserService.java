package com.aplicatie_donare_de_sange.centru_de_donare.service;

import com.aplicatie_donare_de_sange.centru_de_donare.Dto.UserDtoCredentials;
import com.aplicatie_donare_de_sange.centru_de_donare.Model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public User findByUsername(String username);
    public User authenticateUser(UserDtoCredentials userDtoCredentials);

}
