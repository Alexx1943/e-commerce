package e_commerce.pedidos.Pedidos.client.represention;

import java.math.BigDecimal;

public record ProtudoRepresention(Long idProduto,
                                  String name,
                                  BigDecimal valorUnitario) {
}
