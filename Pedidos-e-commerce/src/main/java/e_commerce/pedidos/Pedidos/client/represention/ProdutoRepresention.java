package e_commerce.pedidos.Pedidos.client.represention;

import java.math.BigDecimal;

public record ProdutoRepresention(Long idProduto,
                                  String name,
                                  BigDecimal valorUnitario) {
}
