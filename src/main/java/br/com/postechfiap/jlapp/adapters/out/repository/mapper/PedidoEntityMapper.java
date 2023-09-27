package br.com.postechfiap.jlapp.adapters.out.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import br.com.postechfiap.jlapp.adapters.out.repository.entity.PedidoEntity;
import br.com.postechfiap.jlapp.application.core.domain.Pedido;

@Mapper(componentModel = "spring", uses = CategoriaEntityMapper.class, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PedidoEntityMapper {

	PedidoEntity toPedidoEntity(Pedido pedido);

	Pedido toPedido(PedidoEntity pedidoEntityø);

}