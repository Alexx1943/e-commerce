package e_commerce.pedidos.Pedidos.dto.request;

import e_commerce.pedidos.Pedidos.domain.ItemPedido;
import e_commerce.pedidos.Pedidos.dto.DadosPagamentoDTO;

import java.util.List;

public record PostPedido(Long idCliente,
                         DadosPagamentoDTO dadosPagamentoDTO,
                         List<ItemPedido> itemPedidos) {}
