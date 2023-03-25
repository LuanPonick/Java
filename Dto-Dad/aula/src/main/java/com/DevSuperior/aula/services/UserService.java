package com.DevSuperior.aula.services;

import com.DevSuperior.aula.dto.UserDTO;
import com.DevSuperior.aula.model.User;
import com.DevSuperior.aula.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO UserFindById(Long id){
        User entity = userRepository.findById(id).get();
        UserDTO dto = new UserDTO(entity);
        return dto;
    }
}
