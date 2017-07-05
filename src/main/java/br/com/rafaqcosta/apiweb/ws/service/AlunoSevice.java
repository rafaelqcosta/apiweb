package br.com.rafaqcosta.apiweb.ws.service;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rafaqcosta.apiweb.ws.model.Aluno;
import br.com.rafaqcosta.apiweb.ws.repository.AlunoPepository;

@Service
public class AlunoSevice {

	
	@Autowired
	AlunoPepository alunoRepository;

	// NEGOCIO
	// simulando banco??
	public Aluno cadastrar(Aluno aluno) {
		return alunoRepository.save(aluno);
	}

	// busca
	public Collection<Aluno> buscarTodos() {
		return alunoRepository.findAll();
	}
	
	public Aluno buscarPorId(Integer id) {
		return alunoRepository.getOne(id);
	}
	
	public Aluno alterar(Aluno aluno){
		//TODO mesmo quando não há um id ele cria um novo aluno
		return alunoRepository.save(aluno);
	}
	
	public Boolean excluir(Integer id){
		try {
			alunoRepository.delete(id);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	
}
