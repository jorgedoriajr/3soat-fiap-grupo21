package br.com.postechfiap.jlapp.application.ports.in;

import java.util.List;

import br.com.postechfiap.jlapp.application.core.domain.Produto;

public interface ProdutoInputPort {

	public void inserir(Produto produto);

	public Produto atualizar(Produto produto, Long id);

	public void deletar(Long id);

	public List<Produto> buscarTodosProdutos();

	public Produto buscarProdutoPorId(Long id);

}
