package e_commerce.pedidos.Pedidos.domain;


import e_commerce.pedidos.Pedidos.domain.eunus.StatusPedido;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedido;

    private Long idCliente;

    private LocalDateTime dataPedido;

    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itensPedido;

    private BigDecimal total;

    private String chavePagamento;

    private String observacoes;

    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    private String codigoRastreio;

    private String urlNotaFiscal;

    @Transient
    private DadosPagamento dadosPagamento;
}
