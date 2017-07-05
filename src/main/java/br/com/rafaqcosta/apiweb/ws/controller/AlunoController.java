package br.com.rafaqcosta.apiweb.ws.controller;

import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.rafaqcosta.apiweb.ws.model.Aluno;
import br.com.rafaqcosta.apiweb.ws.service.AlunoSevice;

@RestController
public class AlunoController {

	@Autowired
	AlunoSevice alunoService;

	// end point
	@RequestMapping(method = RequestMethod.POST, value = "/alunos", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Aluno> cadastrarAluno(@RequestBody Aluno aluno) {
		aluno = alunoService.cadastrar(aluno);
		return new ResponseEntity<>(aluno, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/alunos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Aluno>> buscarTodosAlunos() {
		Collection<Aluno> allAlunos = alunoService.buscarTodos();
		return new ResponseEntity<>(allAlunos, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/alunos/{id}")
	public ResponseEntity<Collection<Aluno>> excluirAluno(@PathVariable Integer id) {
		
		if (!alunoService.excluir(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.OK);
		
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/alunos")
	public ResponseEntity<Aluno> alterarAlunos(@RequestBody Aluno aluno) {
		Aluno alunoAlterado = alunoService.alterar(aluno);
		if (alunoAlterado == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(alunoAlterado, HttpStatus.OK);
	}

	
}
