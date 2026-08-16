package e_commerce.pedidos.Pedidos.validador;

import e_commerce.pedidos.Pedidos.client.ClienteClient;
import e_commerce.pedidos.Pedidos.client.ProdutosClient;
import e_commerce.pedidos.Pedidos.client.represention.ClienteRepresention;
import e_commerce.pedidos.Pedidos.client.represention.ProdutoRepresention;
import e_commerce.pedidos.Pedidos.domain.ItemPedido;
import e_commerce.pedidos.Pedidos.domain.Pedido;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PedidoValidador {

    private final ProdutosClient produtosClient;
    private final ClienteClient clienteClient;

    public void validar(Pedido pedido) {

        log.info("========== VALIDADOR EXECUTADO ==========");

        Long idCliente = pedido.getIdCliente();
        validarCliente(idCliente);

        pedido.getItensPedido().forEach(this::validarItemPedido);
        log.info("Total: {}", pedido.getTotal());
        log.info("========== VALIDADOR EXECUTADO ==========");
    }

    private void validarCliente(Long idCliente) {

        try {

            var response = clienteClient.findbyId(idCliente);
            ClienteRepresention cliente = response.getBody();
            log.info("Cliente de código: {} encontrado: {}", cliente.id(), cliente.name());

        } catch (FeignException.NotFound e) {

        }
    }

    private void validarItemPedido(ItemPedido itemPedido) {

        try {

            var response = produtosClient.findbyId(itemPedido.getIdProduto());
            ProdutoRepresention produto = response.getBody();
            log.info("Produto de código: {}, encontrado: {}, valor unitário: {}", produto.idProduto(), produto.name(), produto.valorUnitario());

        } catch (FeignException.NotFound e) {

        }
    }


}
