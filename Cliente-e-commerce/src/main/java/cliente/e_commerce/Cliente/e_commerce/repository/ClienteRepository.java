package cliente.e_commerce.Cliente.e_commerce.repository;

import cliente.e_commerce.Cliente.e_commerce.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByName(String name);
}
