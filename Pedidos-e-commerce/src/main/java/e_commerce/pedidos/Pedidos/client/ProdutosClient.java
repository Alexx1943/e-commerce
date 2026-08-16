package e_commerce.pedidos.Pedidos.client;

import e_commerce.pedidos.Pedidos.client.represention.ProdutoRepresention;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "produtos", url = "${ecommerce.pedidos.produtos.url}")
public interface ProdutosClient {

    @GetMapping("/findById/{id}")
    ResponseEntity<ProdutoRepresention> findbyId(@PathVariable("id") Long idProduto);
}
