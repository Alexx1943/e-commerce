package e_commerce.pedidos.Pedidos.mapper;


import e_commerce.pedidos.Pedidos.domain.Pedido;
import e_commerce.pedidos.Pedidos.dto.request.PostPedido;
import e_commerce.pedidos.Pedidos.dto.response.GetPedido;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PedidoMapper {


    Pedido pedidoGet(GetPedido getPedido);
    GetPedido getPedido(Pedido pedido);

    Pedido postToPedido(PostPedido postPedido);
}
