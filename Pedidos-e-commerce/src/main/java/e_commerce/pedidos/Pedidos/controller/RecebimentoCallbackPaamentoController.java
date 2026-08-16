package e_commerce.pedidos.Pedidos.controller;


import e_commerce.pedidos.Pedidos.dto.request.RecebimentoCallbackPagamentoDTO;
import e_commerce.pedidos.Pedidos.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pedidos/pagamentos/callback-pagamentos")
@RequiredArgsConstructor
public class RecebimentoCallbackPaamentoController {

    private final PedidoService service;

    @PostMapping
    public ResponseEntity<Object> statusPagamento(
            @RequestBody RecebimentoCallbackPagamentoDTO body,
            @RequestHeader(required = true, name = "apikey") String apikey) {

        service.statusPagamento(body.idPedido(),
                body.chavePagamento(),
                body.status(),
                body.observacoes());

        return ResponseEntity.ok().build();
    }
}
