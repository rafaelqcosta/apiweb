package br.com.rafaqcosta.apiweb.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rafaqcosta.apiweb.ws.model.Aluno;


@Repository
public interface AlunoPepository extends JpaRepository<Aluno, Integer> {


	
}
