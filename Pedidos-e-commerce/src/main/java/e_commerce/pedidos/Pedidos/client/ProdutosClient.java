package e_commerce.pedidos.Pedidos.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "produtos", url = "${ecommerce.pedidos.produtos}")
public interface ProdutosClient {

    @GetMapping("/findById")
    ResponseEntity<ProdutosClient> findbyId(@PathVariable Long id);
}
