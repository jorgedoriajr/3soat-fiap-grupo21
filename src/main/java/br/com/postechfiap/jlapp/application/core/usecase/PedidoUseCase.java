package br.com.postechfiap.jlapp.application.core.usecase;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.postechfiap.jlapp.adapters.in.controller.dto.ItemPedidoDTO;
import br.com.postechfiap.jlapp.adapters.in.controller.dto.PedidoDTO;
import br.com.postechfiap.jlapp.adapters.in.controller.dto.ProdutoDTO;
import br.com.postechfiap.jlapp.application.core.domain.Pedido;
import br.com.postechfiap.jlapp.application.enums.Estado;
import br.com.postechfiap.jlapp.application.ports.in.ClienteInputPort;
import br.com.postechfiap.jlapp.application.ports.in.ItemPedidoInputPort;
import br.com.postechfiap.jlapp.application.ports.in.PedidoInputPort;
import br.com.postechfiap.jlapp.application.ports.in.ProdutoInputPort;
import br.com.postechfiap.jlapp.application.ports.out.PedidoOutputPort;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PedidoUseCase implements PedidoInputPort {

	private final PedidoOutputPort pedidoOutputPort;

	private final ClienteInputPort clienteInputPort;

	private final ProdutoInputPort produtoInputPort;

	private final ItemPedidoInputPort itemPedidoInputPort;

	public PedidoUseCase(PedidoOutputPort pedidoOutputPort, ClienteInputPort clienteInputPort,
			ProdutoInputPort produtoInputPort, ItemPedidoInputPort itemPedidoInputPort) {
		this.pedidoOutputPort = pedidoOutputPort;
		this.clienteInputPort = clienteInputPort;
		this.produtoInputPort = produtoInputPort;
		this.itemPedidoInputPort = itemPedidoInputPort;
	}

	@Override
	public PedidoDTO inserir(PedidoDTO pedidoDTO) {

		BigDecimal valorPedido = BigDecimal.ZERO;

		if (!pedidoDTO.getClienteDTO().getCpf().isBlank()) {
			pedidoDTO.setClienteDTO(clienteInputPort.buscarClientePorCpf(pedidoDTO.getClienteDTO().getCpf()));
		}

		pedidoDTO.setEstado(Estado.RECEBIDO);
		pedidoDTO.setValor_pedido(valorPedido);
		pedidoDTO.setData_pedido(LocalDateTime.now());
//		pedidoDTO.setValor_pedido(pedidoDTO.getItemPedidoDTOs().stream().map(ItemPedidoDTO::getProdutoDTO)
//				.map(ProdutoDTO::getPreco).reduce(BigDecimal::add).get());
		
		log.info(pedidoDTO.getItemPedidoDTOs().stream().map(ItemPedidoDTO::getProdutoDTO)
				.map(ProdutoDTO::getPreco).reduce(BigDecimal::add).get()+"");

		pedidoDTO.toPedidoDTO(pedidoOutputPort.inserir(new Pedido().toPedido(pedidoDTO)));

		// Ate Aqui esta certo!!!!!

		for (ItemPedidoDTO itemPedidoDTO : pedidoDTO.getItemPedidoDTOs()) {
			itemPedidoDTO.setProdutoDTO(produtoInputPort.buscarProdutoPorId(itemPedidoDTO.getProdutoDTO().getId()));
			valorPedido = valorPedido.add(itemPedidoDTO.getProdutoDTO().getPreco());
		}

		return pedidoDTO;

	}

//	@Override
//	public PedidoDTO inserir(PedidoDTO pedidoDTO) {
//
//		BigDecimal valorPedido = BigDecimal.ZERO;
//
//		if (!pedidoDTO.getClienteDTO().getCpf().isBlank()) {
//			pedidoDTO.setClienteDTO(clienteInputPort.buscarClientePorCpf(pedidoDTO.getClienteDTO().getCpf()));
//		}
//
//		for (ItemPedidoDTO itemPedidoDTO : pedidoDTO.getItemPedidoDTOs()) {
//			itemPedidoDTO.setProdutoDTO(produtoInputPort.buscarProdutoPorId(itemPedidoDTO.getProdutoDTO().getId()));
//			valorPedido = valorPedido.add(itemPedidoDTO.getProdutoDTO().getPreco());
//		}
//
//		log.info(pedidoDTO.getItemPedidoDTOs().get(0).getProdutoDTO().toString());
//
//		pedidoDTO.setEstado(Estado.RECEBIDO);
//		pedidoDTO.setValor_pedido(valorPedido);
//		pedidoDTO.setData_pedido(LocalDateTime.now());
//
//		log.info(pedidoDTO.toString());
//
//		pedidoDTO.toPedidoDTO(pedidoOutputPort.inserir(new Pedido().toPedido(pedidoDTO)));
//		
//		List<ItemPedidoDTO> itemPedidoDTOs = itemPedidoInputPort.inserir(pedidoDTO.getItemPedidoDTOs());
//		
//		pedidoDTO.setItemPedidoDTOs(itemPedidoDTOs);
//		
//		for (ItemPedidoDTO itemPedidoDTO : itemPedidoDTOs) {
//			itemPedidoDTOs.(itemPedidoDTO.setPedidoDTO(pedidoDTO));
//			itemPedidoInputPort.inserir(pedidoDTO.getItemPedidoDTOs());
//			
//		}
//		itemPedidoInputPort.inserir(pedidoDTO.getItemPedidoDTOs());
//		pedidoDTO.toPedidoDTO(pedidoOutputPort.inserir(new Pedido().toPedido(pedidoDTO)));
//
//		return pedidoDTO;
//
//	}
}
