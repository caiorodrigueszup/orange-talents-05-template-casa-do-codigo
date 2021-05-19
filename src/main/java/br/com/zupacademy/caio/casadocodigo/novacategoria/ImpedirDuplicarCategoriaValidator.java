package br.com.zupacademy.caio.casadocodigo.novacategoria;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ImpedirDuplicarCategoriaValidator implements Validator {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return CategoriaForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}
		
		CategoriaForm form = (CategoriaForm) target;
		
		Optional<Categoria> categoria = categoriaRepository.findByNome(form.getNome());
		
		if (categoria.isPresent()) {
			errors.rejectValue("Nome", null, "Já existe essa categoria.");
		}
	}

}
