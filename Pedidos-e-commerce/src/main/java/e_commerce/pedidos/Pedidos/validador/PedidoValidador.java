package e_commerce.pedidos.Pedidos.validador;

import e_commerce.pedidos.Pedidos.client.ProdutosClient;
import e_commerce.pedidos.Pedidos.domain.Pedido;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PedidoValidador {

    private final ProdutosClient produtosClient;

    public void validar(Pedido pedido) {

    }


}
