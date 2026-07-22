package e_commerce.pedidos.Pedidos.service;

import e_commerce.pedidos.Pedidos.repository.ItemPedidoRepository;
import e_commerce.pedidos.Pedidos.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PedidoServicee {

    private final PedidoRepository repository;
    private final ItemPedidoRepository itemPedidoRepository;
}
