package com.aplicatie_donare_de_sange.centru_de_donare.Controller;

import com.aplicatie_donare_de_sange.centru_de_donare.Dto.UserDtoCredentials;
import com.aplicatie_donare_de_sange.centru_de_donare.Model.User;
import com.aplicatie_donare_de_sange.centru_de_donare.service.UserService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/login")
    public String getUser(@RequestBody UserDtoCredentials userDtoCredentials){

        System.out.println("********************************");
        System.out.println("LoginBackend: I got the point "+userDtoCredentials);


        User user = userService.authenticateUser(userDtoCredentials);

        if (user== null){
            System.out.println("Fail to authenticate");
        }else
            System.out.println("Success to authenticate");

        System.out.println("********************************");

        if(user==null){
            return "0";
        }else
        if(user.getRole().equals("ROLE_ADMIN")){
            return "1";
        }else
        if(user.getRole().equals("ROLE_DONATOR")){
            return "2";
        }else
        return "3";


    }

}
