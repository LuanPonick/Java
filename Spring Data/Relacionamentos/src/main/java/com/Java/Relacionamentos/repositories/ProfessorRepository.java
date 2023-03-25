package com.Java.Relacionamentos.repositories;

import com.Java.Relacionamentos.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Profesor,Long>
{

}
