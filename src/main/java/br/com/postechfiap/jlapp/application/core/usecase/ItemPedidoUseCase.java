package br.com.postechfiap.jlapp.application.core.usecase;

import java.util.List;
import java.util.stream.Collectors;

import br.com.postechfiap.jlapp.application.core.domain.ItemPedido;
import br.com.postechfiap.jlapp.application.ports.in.ItemPedidoInputPort;
import br.com.postechfiap.jlapp.application.ports.out.ItemPedidoOutputPort;
import br.com.postechfiap.jlapp.interfaces.dto.ItemPedidoDTO;

public class ItemPedidoUseCase implements ItemPedidoInputPort {

	private final ItemPedidoOutputPort itemPedidoOutputPort;

	public ItemPedidoUseCase(ItemPedidoOutputPort itemPedidoOutputPort) {
		this.itemPedidoOutputPort = itemPedidoOutputPort;
	}

	@Override
	public List<ItemPedidoDTO> inserir(List<ItemPedidoDTO> dtos) {
		List<ItemPedido> itemPedidos = itemPedidoOutputPort
				.inserir(dtos.stream().map(it -> new ItemPedido().toItemPedido(it)).collect(Collectors.toList()));
		return itemPedidos.stream().map(it -> new ItemPedidoDTO().toItemPedidoDTO(it)).collect(Collectors.toList());
	}

	@Override
	public List<ItemPedidoDTO> buscarItemPedido(Long id_pedido) {
		List<ItemPedido> itemPedidos = itemPedidoOutputPort.buscarItemPedido(id_pedido);

		return itemPedidos.stream().map(it -> new ItemPedidoDTO().toItemPedidoDTO(it)).collect(Collectors.toList());

	}

}
