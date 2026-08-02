package e_commerce.pedidos.Pedidos.dto.response;

import e_commerce.pedidos.Pedidos.domain.ItemPedido;
import e_commerce.pedidos.Pedidos.domain.eunus.StatusPedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record GetPedido(Long idPedido,
                        Long idCliente,
                        LocalDateTime dataPedido,
                        List<GetItemPedido> itensPedido,
                        BigDecimal total,
                        String chavePagamento,
                        StatusPedido status,
                        String codigoRastreio,
                        String urlNotaFiscal) {
}
