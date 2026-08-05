package e_commerce.pedidos.Pedidos.client;


import e_commerce.pedidos.Pedidos.client.represention.ClienteRepresention;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "produtos", url = "${ecommerce.pedidos.clientes}")
public interface ClienteClient {

    @GetMapping("{id}")
    public ResponseEntity<ClienteRepresention> findbyId(@PathVariable Long id);
}
