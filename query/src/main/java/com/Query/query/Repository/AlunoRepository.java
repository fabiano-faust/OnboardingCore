package com.Query.query.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Query.query.Model.Aluno;





public interface AlunoRepository extends JpaRepository<Aluno, Integer>{
	
	Aluno findByMatricula(Integer matricula);
	
}
