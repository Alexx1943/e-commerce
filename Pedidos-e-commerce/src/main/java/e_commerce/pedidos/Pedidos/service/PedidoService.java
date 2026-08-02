package e_commerce.pedidos.Pedidos.service;

import e_commerce.pedidos.Pedidos.client.ServicoBancarioCliente;
import e_commerce.pedidos.Pedidos.domain.Pedido;
import e_commerce.pedidos.Pedidos.repository.ItemPedidoRepository;
import e_commerce.pedidos.Pedidos.repository.PedidoRepository;
import e_commerce.pedidos.Pedidos.validador.PedidoValidador;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository repository;
    private final ItemPedidoRepository itemPedidoRepository;
    private final PedidoValidador validador;
    private final ServicoBancarioCliente bancoClient;


    @Transactional
    public Pedido savePedido(Pedido pedido) {

        validador.validar(pedido);

        repository.save(pedido);

        itemPedidoRepository.saveAll(pedido.getItensPedido());

        var chavePagamento = bancoClient.solicitarPagamento(pedido);

        pedido.setChavePagamento(chavePagamento);

        return pedido;
    }

    public List<Pedido> findAll() {

        return repository.findAll();
    }
}
