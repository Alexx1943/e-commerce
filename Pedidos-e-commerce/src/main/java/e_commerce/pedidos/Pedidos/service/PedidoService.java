package e_commerce.pedidos.Pedidos.service;

import e_commerce.pedidos.Pedidos.domain.Pedido;
import e_commerce.pedidos.Pedidos.mapper.MapperPedido;
import e_commerce.pedidos.Pedidos.repository.ItemPedidoRepository;
import e_commerce.pedidos.Pedidos.repository.PedidoRepository;
import e_commerce.pedidos.Pedidos.validador.PedidoValidador;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository repository;
    private final ItemPedidoRepository itemPedidoRepository;
    private final PedidoValidador validador;



    public Pedido savePedido(Pedido pedido){


    }
}
