package e_commerce.pedidos.Pedidos.dto.request;

import e_commerce.pedidos.Pedidos.domain.eunus.TipoPagamento;

public record PostNovoPagamentoDTO(Long idPedido, String dadosCartao, TipoPagamento tipoPagamento) {
}
