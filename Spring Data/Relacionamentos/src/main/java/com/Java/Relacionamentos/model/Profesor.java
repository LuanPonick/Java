package com.Java.Relacionamentos.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "professor")
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false,unique = true)
    private String prontuario;

    @OneToMany(mappedBy = "profesor",fetch = FetchType.EAGER)
    private List<Diciplina> diciplinas;

    @PreRemove
    private void DeletarProfessor(){
        for (Diciplina diciplina : this.getDiciplinas()){
            diciplina.setProfesor(null);
        }
    }

    @Deprecated
    public Profesor() {}

    public Profesor(String nome, String prontuario) {
        this.nome = nome;
        this.prontuario = prontuario;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProntuario() {
        return prontuario;
    }

    public void setProntuario(String prontuario) {
        this.prontuario = prontuario;
    }

    @Override
    public String toString() {
        String values = "";
        for (Diciplina diciplina : this.diciplinas){
            values += "{ ";
            values += "    Id :" + diciplina.getId() + ", ";
            values += "    Name :" + diciplina.getName()+ ", ";
            values += "    Semetre :" + diciplina.getSemestre()+ ", ";
            values += "} \n";
        }
        return "Profesor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", prontuario='" + prontuario + '\'' +
                "\n" + values +
                '}';
    }

    public List<Diciplina> getDiciplinas() {
        return diciplinas;
    }

    public void setDiciplinas(List<Diciplina> diciplinas) {
        this.diciplinas = diciplinas;
    }
}
