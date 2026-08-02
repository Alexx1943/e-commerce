package e_commerce.pedidos.Pedidos.dto.response;

import java.math.BigDecimal;

public record GetItemPedido(Long idItemPedido,
                            Long idProduto,
                            Integer quantidade,
                            BigDecimal valorUnitario) {
}
