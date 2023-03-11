package com.projetoPrincipal.projetoHard.repository;

import com.projetoPrincipal.projetoHard.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {
    @Query("select c from Cliente c where c.email=:email")
    public Cliente selecionarPorEmail(@Param("email") String email);

    @Query("select c from Cliente c")
    public List<Cliente> selecionarTodos();
}
