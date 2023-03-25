package com.Relacionamento.repository;


import com.Relacionamento.entities.Custumer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Custumer,Integer> {
}
