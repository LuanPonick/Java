package com.projetoPrincipal.projetoHard.repository;

import static org.assertj.core.api.Assertions.*;
import com.projetoPrincipal.projetoHard.model.Cliente;
import jakarta.persistence.EntityManager;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2,replace= AutoConfigureTestDatabase.Replace.NONE)
public class TesteClienteRepository {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EntityManager entityManager;
    @Test
    public void tentarSalvar(){
        Cliente cli = new Cliente("jao","jao@gmail.com");
        Cliente cliSalvo = clienteRepository.save(cli);

        Assert.assertNotNull(cliSalvo.getId());
    }

    @Test
    public void testBuscarEmail(){
        Cliente cli = new Cliente("carlao","carlão@gmail.com");
        entityManager.persist(cli);

        Cliente clibuscado = clienteRepository.selecionarPorEmail("carlão@gmail.com");
        assertThat(clibuscado.getNome()).isEqualTo(cli.getNome());
        assertThat(clibuscado.getEmail()).isEqualTo(cli.getEmail());
    }

    @Test
    public void testBuscarTodos(){
        Cliente cli = new Cliente("carlao","carlão@gmail.com");
        entityManager.persist(cli);
        cli = new Cliente("carlao2","carlão2@gmail.com");
        entityManager.persist(cli);
        cli = new Cliente("carlao3","carlão3@gmail.com");
        entityManager.persist(cli);

        List<Cliente> clientesbuscados = clienteRepository.selecionarTodos();

        assertThat(clientesbuscados.get(2).getEmail()).isEqualTo(cli.getEmail());
    }

}
