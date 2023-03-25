package com.Java.Relacionamentos.service;

import com.Java.Relacionamentos.model.Diciplina;
import com.Java.Relacionamentos.model.Profesor;
import com.Java.Relacionamentos.repositories.DiciplinaRepository;
import com.Java.Relacionamentos.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class DiciplinaService {
    @Autowired
    DiciplinaRepository diciplinaRepository;
    @Autowired
    ProfessorRepository professorRepository;

    public void fazerCadastroDiciplina(){
        Scanner scanner = new Scanner(System.in);
        String nome;
        Integer semestre;
        Long idProf;

        System.out.println("passe o nome");
        nome = scanner.nextLine();
        System.out.println("semestre");
        semestre = Integer.parseInt(scanner.nextLine());
        System.out.println("id Prof");
        idProf = Long.parseLong(scanner.nextLine());

        Optional<Profesor> optional = professorRepository.findById(idProf);
        if(optional.isPresent()){
            Profesor profesor = optional.get();
            diciplinaRepository.save(new Diciplina(nome,semestre,profesor));
        }else{
            System.out.println("valor impossivel");
        }
    }
    public void atualizarById(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o id do professor");
        Long id = scanner.nextLong();

        Optional<Diciplina> optional = diciplinaRepository.findById(id);

        if(optional.isPresent()){

            String nome = "";
            Integer semestre = 0;
            Profesor profesor;
            Long idProf;
            Scanner ler = new Scanner(System.in);

            System.out.println("passe o nome");
            nome = ler.nextLine();
            System.out.println("passe o prontuario");
            semestre = Integer.parseInt(ler.nextLine());
            System.out.println("Id do professor");
            idProf = Long.parseLong(ler.nextLine());
            Optional<Profesor> optional1 = professorRepository.findById(idProf);
            if(optional1.isPresent()){
                profesor = optional1.get();

                Diciplina diciplina = optional.get();
                diciplina.setName(nome);
                diciplina.setSemestre(semestre);
                diciplina.setProfesor(profesor);
                diciplinaRepository.save(diciplina);
            }else{
                System.out.println("Professor nao existente");
            }

        }else {
            System.out.println("o espertao nao exite *****");
        }
    }
    public void visualizarTodos(){
        List<Diciplina> profesors = diciplinaRepository.findAll();
        for(Diciplina diciplina : profesors){
            System.out.println(diciplina);
        }
    }
    public void apagarById(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o id do professor");
        Long id = scanner.nextLong();

        try{
            diciplinaRepository.deleteById(id);
        }catch (Exception e){
            System.out.println("Valor nao existente");
        }

    }

}
