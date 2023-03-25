package com.Java.Relacionamentos.model;

import javax.persistence.*;

@Entity
@Table(name = "diciplinas")
public class Diciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    private Integer semestre;

    @ManyToOne
    @JoinColumn(name = "professor_id",nullable = true)
    private Profesor profesor;

    @Deprecated
    public Diciplina(){}

    public Diciplina(String name, Integer semestre, Profesor professor) {
        this.name = name;
        this.semestre = semestre;
        this.profesor = professor;
    }

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    @Override
    public String toString() {
        return "Diciplina{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", semestre='" + semestre + '\'' +
                ", profesor=" + profesor +
                '}';
    }

}
