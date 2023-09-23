package br.com.postechfiap.jlapp.adapters.in.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.postechfiap.jlapp.adapters.in.controller.mapper.ProdutoMapper;
import br.com.postechfiap.jlapp.adapters.in.controller.request.ProdutoRequest;
import br.com.postechfiap.jlapp.adapters.in.controller.response.ProdutoResponse;
import br.com.postechfiap.jlapp.application.core.domain.Produto;
import br.com.postechfiap.jlapp.application.ports.in.ProdutoInputPort;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "/api/v1/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoInputPort produtoInputPort;

	@Autowired
	private ProdutoMapper produtoMapper;

	@PostMapping
	public ResponseEntity<Void> inserirProduto(@Valid @RequestBody ProdutoRequest produtoRequest) {
		Produto produto = produtoMapper.toProduto(produtoRequest);
		log.info("cadastrando produto {}", produto.toString());
		produtoInputPort.inserir(produto);
		return ResponseEntity.ok().build();
	}

	@GetMapping
	public ResponseEntity<List<ProdutoResponse>> buscarTodosProdutos() {
		List<ProdutoResponse> produtoResponse = produtoMapper
				.toListProdutoResponse(produtoInputPort.buscarTodosProdutos());
		return ResponseEntity.ok().body(produtoResponse);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProdutoResponse> atualizarProduto(@Valid @RequestBody ProdutoRequest produtoRequest,
			@PathVariable Long id) {
		Produto produto = produtoMapper.toProduto(produtoRequest);
		log.info("alterando produto {}", produto.toString());
		ProdutoResponse produtoResponse = produtoMapper.toProdutoResponse(produtoInputPort.atualizar(produto, id));
		return ResponseEntity.ok().body(produtoResponse);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
		produtoInputPort.deletar(id);
		return ResponseEntity.ok().build();
	}

}
