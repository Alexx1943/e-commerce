package e_commerce.pedidos.Pedidos.service;

import e_commerce.pedidos.Pedidos.client.ServicoBancarioCliente;
import e_commerce.pedidos.Pedidos.domain.Pedido;
import e_commerce.pedidos.Pedidos.domain.eunus.StatusPedido;
import e_commerce.pedidos.Pedidos.repository.ItemPedidoRepository;
import e_commerce.pedidos.Pedidos.repository.PedidoRepository;
import e_commerce.pedidos.Pedidos.validador.PedidoValidador;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PedidoService {

    private final PedidoRepository repository;
    private final ItemPedidoRepository itemPedidoRepository;
    private final PedidoValidador validador;
    private final ServicoBancarioCliente bancoClient;


    @Transactional
    public Pedido savePedido(Pedido pedido) {

        validador.validar(pedido);

        realizarPersistencia(pedido);

        solicitacaoPagamento(pedido);

        return pedido;
    }

    public List<Pedido> findAll() {

        return repository.findAll();
    }

    public Pedido findById(Long id) {

        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void deleteAll() {

        itemPedidoRepository.deleteAll();
        repository.deleteAll();
    }

    private void solicitacaoPagamento(Pedido pedido) {

        var chavePagamento = bancoClient.solicitarPagamento(pedido);
        pedido.setChavePagamento(chavePagamento);
    }

    private void realizarPersistencia(Pedido pedido) {

        repository.save(pedido);
        itemPedidoRepository.saveAll(pedido.getItensPedido());
    }

    public void statusPagamento(Long idPedido, String chavePagamento, boolean status, String obsrvacoes) {

        var pedidoEncontrado = repository.findByIdPedidoAndChavePagamento(idPedido, chavePagamento);

        if (pedidoEncontrado.isEmpty()) {
            var mensagem = String.format("Pedido não encontrado, código: %d echave de pagamentos &s", idPedido, chavePagamento);
            log.error(mensagem);
        }
        Pedido pedido = pedidoEncontrado.get();

        if (status){
            pedido.setStatus(StatusPedido.PAGO);
        }else {
            pedido.setStatus(StatusPedido.ERRO_PAGAMENTO);
            pedido.setObservacoes(obsrvacoes);
        }
        repository.save(pedido);
    }


}
