package com.Escola.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Escola.entities.Turma;
import com.Escola.service.TurmaService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/turma")
public class TurmaController {
	
	private final TurmaService TurmaService;

	public TurmaController(TurmaService TurmaService) {
		this.TurmaService = TurmaService;
	}

	@GetMapping ("/{id}")

	public ResponseEntity<Turma> buscaTurmaIdControlId (@ PathVariable Long id) {
		Turma Turma = TurmaService.buscaTurmaId(id);
		if (Turma != null) {
			return ResponseEntity.ok(Turma);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Turma>> buscaTodosTurmaControl(){
		List<Turma> Turma = TurmaService.buscaTodosTurma();
		return ResponseEntity.ok(Turma);
	}
		
	@GetMapping("/nome/(nome)")
	public ResponseEntity<List<Turma>> buscarTurmaPorNome(@PathVariable String nome){
		List<Turma> Turma = TurmaService.buscarTurmaPorNome(nome);
		return ResponseEntity.ok(Turma);
		}
	
	@GetMapping("/descricao/(descricao)")
	public ResponseEntity<List<Turma>> buscarTurmaPorDescricao(@PathVariable String descricao){
		List<Turma> Turma = TurmaService.buscarTurmaPorDescricao(descricao);
		return ResponseEntity.ok(Turma);
		}
	
	@GetMapping("/nome,descricao/(nome,descricao)")
	public ResponseEntity<List<Turma>> buscarTurmaPorNomeAndDescricao(@PathVariable String nome, String descricao){
		List<Turma> Turma = TurmaService.buscarTurmaPorNomeAndDescricao(nome, descricao);
		return ResponseEntity.ok(Turma);
		}
		
	@PostMapping("/")
	public ResponseEntity<Turma> salvaTurmaControl(@RequestBody  Turma Turma){
		Turma salvaTurma= TurmaService.salvaTurma(Turma);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaTurma);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Turma> alterarTurmaControl(@PathVariable Long id, @RequestBody Turma Turma){
		Turma alterarTurma = TurmaService.alterarTurma(id, Turma);
		if(alterarTurma != null) {
			return ResponseEntity.ok(alterarTurma);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagaTurmaControl(@PathVariable Long id){
		boolean Turma = TurmaService.apagarTurma(id);
		if (Turma) {
			return ResponseEntity.ok().body("A Turma foi excluída com sucesso");
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

}
