package e_commerce.pedidos.Pedidos.repository;

import e_commerce.pedidos.Pedidos.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
