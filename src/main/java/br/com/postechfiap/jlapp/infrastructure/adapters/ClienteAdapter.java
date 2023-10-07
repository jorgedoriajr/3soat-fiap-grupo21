package br.com.postechfiap.jlapp.infrastructure.adapters;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.postechfiap.jlapp.application.core.domain.Cliente;
import br.com.postechfiap.jlapp.application.exception.UnprocessableEntityException;
import br.com.postechfiap.jlapp.application.ports.out.ClienteOutputPort;
import br.com.postechfiap.jlapp.infrastructure.adapters.repository.ClienteRepository;
import br.com.postechfiap.jlapp.infrastructure.adapters.repository.entity.ClienteEntity;
import br.com.postechfiap.jlapp.shared.logger.log.Logger;

@Component
public class ClienteAdapter implements ClienteOutputPort {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private Logger log;

	@Override
	public Cliente inserir(Cliente cliente) {
		
		log.info("Verificando se o cliente já existe na base!");
		
		Optional<Cliente> clienteExiste = this.buscarClientePorCpf(cliente.getCpf());
		if (!clienteExiste.isEmpty()) {
			log.info("Cliente já existe na base!");
			throw new UnprocessableEntityException("Cliente já cadastrado com esse CPF!");
		}
		log.info("Cadastrando novo cliente!");
		ClienteEntity clienteEntity = new ClienteEntity().toClienteEntity(cliente);
		return cliente.toCliente(clienteRepository.save(clienteEntity));
	}

	@Override
	public void atualizar(Cliente cliente) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletar(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Cliente> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Cliente> buscar(Long id) {
		Optional<ClienteEntity> customerEntity = clienteRepository.findById(id);
		return customerEntity.map(entity -> new Cliente().toCliente(entity));
	}

	@Override
	public Optional<Cliente> buscarClientePorCpf(String cpf) {
		Optional<ClienteEntity> customerEntity = clienteRepository.findByCpf(cpf);
		return customerEntity.map(entity -> new Cliente().toCliente(entity));
	}

}
