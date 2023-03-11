package com.aula.restApi.restController;

import com.aula.restApi.model.Contato;
import com.aula.restApi.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contato")
public class ContatoRest {
    @Autowired
    private ContatoRepository contatoRepository;

    @GetMapping
    public List<Contato> todosContatos(){
        return contatoRepository.findAll();
    }

    @PostMapping
    public void criarContato(@RequestBody Contato cont){
        contatoRepository.save(cont);
    }

    @PutMapping
    public void alterarContato(@RequestBody Contato cont){
        if(cont.getId()>0) {
            contatoRepository.save(cont);
        }
    }
    @DeleteMapping
    public void apagarId(@RequestBody Contato cont){
        contatoRepository.delete(cont);
    }

}
