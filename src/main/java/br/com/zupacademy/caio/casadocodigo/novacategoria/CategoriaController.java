package br.com.zupacademy.caio.casadocodigo.novacategoria;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ImpedirDuplicarCategoriaValidator impedirDuplicarCategoriaValidator;
	
	@PostMapping
	public String criar(@RequestBody @Valid CategoriaForm form) {
		Categoria categoria = form.converter();
		
		categoriaRepository.save(categoria);
		
		return categoria.toString();
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.addValidators(impedirDuplicarCategoriaValidator);
	}
}
