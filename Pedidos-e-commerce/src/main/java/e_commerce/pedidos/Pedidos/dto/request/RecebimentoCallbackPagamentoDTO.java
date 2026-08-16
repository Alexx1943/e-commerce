package e_commerce.pedidos.Pedidos.dto.request;


public record RecebimentoCallbackPagamentoDTO(Long idPedido, String chavePagamento, boolean status, String observacoes) {
}
