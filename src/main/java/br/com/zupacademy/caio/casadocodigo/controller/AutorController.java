package br.com.zupacademy.caio.casadocodigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.caio.casadocodigo.dto.AutorDTO;
import br.com.zupacademy.caio.casadocodigo.entity.Autor;
import br.com.zupacademy.caio.casadocodigo.repository.AutorRepository;

@RestController
@RequestMapping("/autor")
public class AutorController {
	
	@Autowired
	private AutorRepository autorRepository;
	
	@PostMapping
	public ResponseEntity<?> criarAutor(@Valid @RequestBody AutorDTO autorDTO) {
		Autor autor = autorDTO.converter();
		autorRepository.save(autor);
		return ResponseEntity.ok().build();
	}
}
