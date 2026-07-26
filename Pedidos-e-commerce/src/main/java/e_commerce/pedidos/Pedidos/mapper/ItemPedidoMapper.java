package e_commerce.pedidos.Pedidos.mapper;


import e_commerce.pedidos.Pedidos.domain.ItemPedido;
import e_commerce.pedidos.Pedidos.dto.request.PostItemPedido;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ItemPedidoMapper {

    ItemPedido postToItemPedido(PostItemPedido postItemPedido);
}
