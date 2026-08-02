package e_commerce.pedidos.Pedidos.mapper;


import e_commerce.pedidos.Pedidos.domain.ItemPedido;
import e_commerce.pedidos.Pedidos.domain.Pedido;
import e_commerce.pedidos.Pedidos.dto.request.PostItemPedido;
import e_commerce.pedidos.Pedidos.dto.request.PostPedido;
import e_commerce.pedidos.Pedidos.dto.response.GetPedido;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PedidoMapper {

    ItemPedidoMapper ITEM_PEDIDO_MAPPER = Mappers.getMapper(ItemPedidoMapper.class);

    GetPedido getPedido(Pedido pedido);

    @Mapping(source = "itensPedido", target = "itensPedido", qualifiedByName = "mapItens")
    Pedido postToPedido(PostPedido postPedido);

    @Named("mapItens")
    default List<ItemPedido> mapItens(List<PostItemPedido> dtos) {

        return dtos.stream()
                .map(ITEM_PEDIDO_MAPPER::postToItemPedido).toList();
    }
}
