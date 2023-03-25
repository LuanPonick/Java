package com.DevSuperior.aula.repositories;


import com.DevSuperior.aula.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
