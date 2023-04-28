package com.aplicatie_donare_de_sange.centru_de_donare.service;

import com.aplicatie_donare_de_sange.centru_de_donare.Dto.UserDtoCredentials;
import com.aplicatie_donare_de_sange.centru_de_donare.Model.User;
import com.aplicatie_donare_de_sange.centru_de_donare.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User authenticateUser(UserDtoCredentials userDtoCredentials) {

        String usernameAthentication = userDtoCredentials.getUsername();
        String passwordAuthetication = userDtoCredentials.getPassword();

        User user = findByUsername(usernameAthentication);

        if (user == null) {
            return null;
        } else {
            if (user.getPassword().equals(passwordAuthetication))
                return user;
            else
                return null;
        }

    }
}
