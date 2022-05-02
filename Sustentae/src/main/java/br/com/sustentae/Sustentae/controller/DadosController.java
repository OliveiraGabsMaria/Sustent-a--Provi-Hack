package br.com.sustentae.Sustentae.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.com.sustentae.Sustentae.model.DadosModel;
import br.com.sustentae.Sustentae.repository.DadosRepository;

@RestController
@RequestMapping("/dados")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DadosController {
	
	@Autowired
	private DadosRepository dadosRepository;

	@GetMapping 
	public ResponseEntity<List<DadosModel>> getAll() {
		return ResponseEntity.ok(dadosRepository.findAll());

	}
	
	@GetMapping("/{id}") 
	public ResponseEntity<DadosModel> getById(@PathVariable long id) {
		return dadosRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());

	}

	@GetMapping("/mes/{mes}")
	public ResponseEntity<List<DadosModel>> getByMes(@PathVariable String mes) {
		return ResponseEntity.ok(dadosRepository.findAllByMesContainingIgnoreCase(mes));

	}

	@PostMapping
	public ResponseEntity<DadosModel> postDadosModel(@Valid @RequestBody DadosModel dados) {
		return ResponseEntity.status(HttpStatus.CREATED).body(dadosRepository.save(dados));
	}

	@PutMapping
	public ResponseEntity<DadosModel> putDadosModel(@Valid @RequestBody DadosModel dados) {
		return dadosRepository.findById(dados.getId()).map(resposta -> {
			return ResponseEntity.ok().body(dadosRepository.save(dados));
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}") 
	public ResponseEntity<?> deletePLDadosModel(@PathVariable long id) {

		return dadosRepository.findById(id).map(resposta -> {
			dadosRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

		}).orElse(ResponseEntity.notFound().build());
	}
}
