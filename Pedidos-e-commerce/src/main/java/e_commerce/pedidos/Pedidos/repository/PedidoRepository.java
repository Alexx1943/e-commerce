package e_commerce.pedidos.Pedidos.repository;

import e_commerce.pedidos.Pedidos.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    Optional<Pedido> findByIdPedidoAndChavePagamento(Long idPedido, String chavePagamento);
}
