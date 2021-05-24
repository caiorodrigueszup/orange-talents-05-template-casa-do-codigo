package br.com.zupacademy.caio.casadocodigo.cadastrarcliente;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NovoClienteController {
	
	@Autowired
	private EntityManager manager;
	
	@Autowired
	private VerificaSeEstadoPertenceAoPais verificaSeEstadoPertenceAoPais; 
	
	@InitBinder
	@Transactional
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.addValidators(verificaSeEstadoPertenceAoPais);
	}
	
	@PostMapping(value = "/api/clientes")
	@Transactional
	public String cadastrar(@RequestBody @Valid NovoClienteRequest request) {
		Cliente cliente = request.toModel(manager);
		
		manager.persist(cliente);
		
		return cliente.toString();
	}
}
