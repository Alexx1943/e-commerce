package e_commerce.pedidos.Pedidos.client;

import e_commerce.pedidos.Pedidos.domain.Pedido;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class ServicoBancarioCliente {

    public String solicitarPagamento(Pedido pedido) {

        log.info("Solicitando pagamento para o pedido de código: {}", pedido.getIdPedido());

        return UUID.randomUUID().toString();
    }
}
