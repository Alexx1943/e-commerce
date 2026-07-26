package e_commerce.pedidos.Pedidos.dto.request;

import e_commerce.pedidos.Pedidos.domain.ItemPedido;

import java.util.List;

public record PostPedido(Long idCliente,
                         List<ItemPedido> itemPedidos) {}
