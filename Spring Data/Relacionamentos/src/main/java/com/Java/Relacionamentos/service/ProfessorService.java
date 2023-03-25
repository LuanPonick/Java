package com.Java.Relacionamentos.service;

import com.Java.Relacionamentos.model.Profesor;
import com.Java.Relacionamentos.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class ProfessorService {
    @Autowired
    ProfessorRepository professorRepository;
    public void fazerCadastroProfessor(){
        Scanner scanner = new Scanner(System.in);
        String[] infoObjeto = new String[2];

        System.out.println("passe o nome");
        infoObjeto[0] = scanner.nextLine();
        System.out.println("passe o prontuario");
        infoObjeto[1] = scanner.nextLine();

        professorRepository.save(new Profesor(infoObjeto[0],infoObjeto[1]));
    }
    public void atualizarById(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o id do professor");
        Long id = scanner.nextLong();

        Optional<Profesor> optional = professorRepository.findById(id);

        if(optional.isPresent()){

            String[] infoObjeto = new String[2];
            Scanner ler = new Scanner(System.in);

            System.out.println("passe o nome");
            infoObjeto[0] = ler.nextLine();
            System.out.println("passe o prontuario");
            infoObjeto[1] = ler.nextLine();

            Profesor professor = optional.get();
            professor.setNome(infoObjeto[0]);
            professor.setProntuario(infoObjeto[1]);

            professorRepository.save(professor);
        }else {
            System.out.println("o espertao nao exite *****");
        }
    }
    public void visualizarTodos(){
        Scanner scanner = new Scanner(System.in);
        Long valorDigitado = 0l;
        System.out.println("Digite 0 para mostrar todos ou digite um id");
        valorDigitado = Long.parseLong(scanner.nextLine());
        if(valorDigitado == 0){
            List<Profesor> profesors = professorRepository.findAll();
            for(Profesor profesor : profesors){
                System.out.println(profesor);
            }
        }else{
            Optional<Profesor> optional = professorRepository.findById(valorDigitado);
            if(optional.isPresent()){
                System.out.println(optional.get().toString());
            }else {
                System.out.println("nao existe");
            }
        }

    }
    public void apagarById(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o id do professor");
        Long id = scanner.nextLong();

        try{
            professorRepository.deleteById(id);
        }catch (Exception e){
            System.out.println("Valor nao existente");
        }

    }
}
