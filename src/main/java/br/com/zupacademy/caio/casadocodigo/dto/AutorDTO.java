package br.com.zupacademy.caio.casadocodigo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.zupacademy.caio.casadocodigo.entity.Autor;

public class AutorDTO {
	@NotNull @NotNull @NotBlank @Size(min = 3, max = 30)
	private String nome;
	
	@NotNull @NotEmpty @Email
	private String email;
	
	@NotNull @NotEmpty @Size(max = 400)
	private String descricao;
	
	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public Autor converter() {
		return new Autor(nome, email, descricao);
	}
}
