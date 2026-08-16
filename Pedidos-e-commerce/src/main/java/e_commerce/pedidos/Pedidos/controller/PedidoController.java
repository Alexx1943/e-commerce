package e_commerce.pedidos.Pedidos.controller;


import e_commerce.pedidos.Pedidos.domain.Pedido;
import e_commerce.pedidos.Pedidos.dto.request.PostPedido;
import e_commerce.pedidos.Pedidos.dto.response.GetPedido;
import e_commerce.pedidos.Pedidos.mapper.PedidoMapper;
import e_commerce.pedidos.Pedidos.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService service;
    private final PedidoMapper mapper;


    @PostMapping("/save")
    public ResponseEntity<GetPedido> save(@RequestBody PostPedido postPedido) {

        var postToPedido = mapper.postToPedido(postPedido);

        var pedido = service.savePedido(postToPedido);

        var response = mapper.getPedido(pedido);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<GetPedido>> findAll() {

        var all = service.findAll();

        var response = mapper.getPedidoList(all);

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<GetPedido> findById(@PathVariable Long id) {

        Pedido byId = service.findById(id);
        GetPedido respponse = mapper.getPedido(byId);

        return ResponseEntity.ok(respponse);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAll() {

        service.deleteAll();

        return ResponseEntity.noContent().build();
    }

}
