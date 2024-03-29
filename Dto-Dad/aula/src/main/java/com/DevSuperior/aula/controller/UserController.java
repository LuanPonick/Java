package com.DevSuperior.aula.controller;

import com.DevSuperior.aula.dto.UserDTO;
import com.DevSuperior.aula.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{id}")
    public UserDTO findById(@PathVariable Long id){
        return userService.UserFindById(id);
    }
}
