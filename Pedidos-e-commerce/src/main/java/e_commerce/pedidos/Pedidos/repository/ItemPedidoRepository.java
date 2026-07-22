package e_commerce.pedidos.Pedidos.repository;

import e_commerce.pedidos.Pedidos.domain.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
}
