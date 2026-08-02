package e_commerce.pedidos.Pedidos.mapper;


import e_commerce.pedidos.Pedidos.domain.ItemPedido;
import e_commerce.pedidos.Pedidos.dto.request.PostItemPedido;
import e_commerce.pedidos.Pedidos.dto.response.GetItemPedido;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ItemPedidoMapper {


    ItemPedido postToItemPedido(PostItemPedido postItemPedido);

    GetItemPedido getItemPedido(ItemPedido itemPedido);

    List<GetItemPedido> getItemPedidoList(List<ItemPedido> itens);
}
