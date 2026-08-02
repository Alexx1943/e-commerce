package e_commerce.pedidos.Pedidos.dto.request;


import java.math.BigDecimal;

public record  PostItemPedido(Long idProduto, Integer quantidade, BigDecimal valorUnitario) {


}
