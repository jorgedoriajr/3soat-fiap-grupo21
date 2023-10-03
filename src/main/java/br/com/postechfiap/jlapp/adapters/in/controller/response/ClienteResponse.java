package br.com.postechfiap.jlapp.adapters.in.controller.response;

import br.com.postechfiap.jlapp.application.core.domain.Cliente;
import lombok.Data;

@Data
public class ClienteResponse {

	private Long id;

	private String nome;

	private String cpf;

	private String email;

	public ClienteResponse toClienteResponse(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.cpf = cliente.getCpf();
		this.email = cliente.getEmail();
		return this;
	}

}
