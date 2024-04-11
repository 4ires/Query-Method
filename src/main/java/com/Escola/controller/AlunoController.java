package com.Escola.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Escola.entities.Aluno;
import com.Escola.service.AlunoService;


@RestController
@RequestMapping("/aluno")
public class AlunoController {
	
	private final AlunoService AlunoService;

	
	public AlunoController(AlunoService AlunoService) {
		this.AlunoService = AlunoService;
	}

	@GetMapping ("/{id}")
	public ResponseEntity<Aluno> buscaAlunoIdControlId (@ PathVariable Long id) {
		Aluno Aluno = AlunoService.buscaAlunoId(id);
		if (Aluno != null) {
			return ResponseEntity.ok(Aluno);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/cidade/(cidade)")
	public ResponseEntity<List<Aluno>> buscarAlunoPorCidade(@PathVariable String cidade){
		List<Aluno> Aluno = AlunoService.buscarAlunosPorCidade(cidade);
		return ResponseEntity.ok(Aluno);
	}
		
	@GetMapping("/nome/(nome)")
	public ResponseEntity<List<Aluno>> buscarAlunoPorNome(@PathVariable String nome){
		List<Aluno> Aluno = AlunoService.buscarAlunosPorNome(nome);
		return ResponseEntity.ok(Aluno);
	}
	
	@GetMapping("/renda/(renda)")
	public ResponseEntity<List<Aluno>> buscarAlunoPorRenda(@PathVariable Double renda){
		List<Aluno> Aluno = AlunoService.buscarAlunosPorRenda(renda);
		return ResponseEntity.ok(Aluno);
	}
	
	@GetMapping("/ra/(ra)")
	public ResponseEntity<List<Aluno>> buscarAlunoPorRa(@PathVariable String ra){
		List<Aluno> Aluno = AlunoService.buscarAlunosPorRa(ra);
		return ResponseEntity.ok(Aluno);
	}
	
	@GetMapping("/cidade,renda/(cidade,renda)")
	public ResponseEntity<List<Aluno>> buscarAlunoPorCidadeAndRenda(@PathVariable String cidade, Double renda){
		List<Aluno> Aluno = AlunoService.buscarAlunosPorCidadeAndRenda(cidade, renda);
		return ResponseEntity.ok(Aluno);
	}
	
	
	@GetMapping("/")
	public ResponseEntity<List<Aluno>> buscaTodosAlunoControl(){
		List<Aluno> Aluno = AlunoService.buscaTodosAluno();
		return ResponseEntity.ok(Aluno);
	}
	@PostMapping("/")
	public ResponseEntity<Aluno> salvaAlunoControl(@RequestBody  Aluno Aluno){
		Aluno salvaAluno= AlunoService.salvaAluno(Aluno);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaAluno);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Aluno> alterarAlunoControl(@PathVariable Long id, @RequestBody Aluno Aluno){
		Aluno alterarAluno = AlunoService.alterarAluno(id, Aluno);
		if(alterarAluno != null) {
			return ResponseEntity.ok(alterarAluno);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagaAlunoControl(@PathVariable Long id){
		boolean Aluno = AlunoService.apagarAluno(id);
		if (Aluno) {
			return ResponseEntity.ok().body("O Aluno foi excluído com sucesso");
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

}
