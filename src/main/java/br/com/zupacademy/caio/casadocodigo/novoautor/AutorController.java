package br.com.zupacademy.caio.casadocodigo.novoautor;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autor")
public class AutorController {

	
	@Autowired
	private AutorRepository autorRepository;
	
	@Autowired
	private EmailAutorDuplicadoValidator emailAutorDuplicadoValidator;
	
	@PostMapping
	public String criarAutor(@RequestBody @Valid AutorDTO autorDTO) {
		Autor autor = autorDTO.converter();
		autorRepository.save(autor);
		return autor.toString();
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.addValidators(emailAutorDuplicadoValidator);
	}
}
