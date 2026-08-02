package e_commerce.pedidos.Pedidos.mapper;


import e_commerce.pedidos.Pedidos.domain.ItemPedido;
import e_commerce.pedidos.Pedidos.domain.Pedido;
import e_commerce.pedidos.Pedidos.domain.eunus.StatusPedido;
import e_commerce.pedidos.Pedidos.dto.request.PostItemPedido;
import e_commerce.pedidos.Pedidos.dto.request.PostPedido;
import e_commerce.pedidos.Pedidos.dto.response.GetPedido;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PedidoMapper {

    ItemPedidoMapper ITEM_PEDIDO_MAPPER = Mappers.getMapper(ItemPedidoMapper.class);

    List<GetPedido> getPedidoList(List<Pedido> pedidos);
    GetPedido getPedido(Pedido pedido);

    @Mapping(source = "itensPedido", target = "itensPedido", qualifiedByName = "mapItens")
    Pedido postToPedido(PostPedido postPedido);

    @Named("mapItens")
    default List<ItemPedido> mapItens(List<PostItemPedido> dtos) {

        return dtos.stream()
                .map(ITEM_PEDIDO_MAPPER::postToItemPedido).toList();
    }

    @AfterMapping
    default void afterMapping(@MappingTarget Pedido pedido) {
        pedido.setStatus(StatusPedido.REALIZADO);
        pedido.setDataPedido(LocalDateTime.now());

        var total = calcularTotal(pedido);

        pedido.setTotal(total);

        pedido.getItensPedido().forEach(itens -> itens.setPedido(pedido));
    }

    private static BigDecimal calcularTotal(Pedido pedido) {

        return pedido.getItensPedido().stream()
                .map(itens ->
                        itens.getValorUnitario()
                                .multiply(BigDecimal.valueOf(itens.getQuantidade())))
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .abs();
    }
}
