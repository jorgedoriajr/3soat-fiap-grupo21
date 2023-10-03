package br.com.postechfiap.jlapp.adapters.out.repository.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.postechfiap.jlapp.adapters.out.repository.entity.ItemPedidoEntity;
import br.com.postechfiap.jlapp.application.core.domain.ItemPedido;

@Mapper(componentModel = "spring", uses = { PedidoEntityMapper.class, ProdutoEntityMapper.class })
public interface ItemPedidoEntityMapper {

	@Mapping(source = "produto", target = "produtoEntity")
	@Mapping(source = "pedido", target = "pedidoEntity")
	ItemPedidoEntity toItemPedidoEntity(ItemPedido itemPedido);

	@Mapping(source = "produtoEntity", target = "produto")
	@Mapping(source = "pedidoEntity", target = "pedido")
	ItemPedido toItemPedido(ItemPedidoEntity itemPedidoEntity);
	
	@Mapping(source = "pedido", target = "pedidoEntity")
	List<ItemPedidoEntity> toListItensPedidoEntities(List<ItemPedido> itemPedidos);
}
