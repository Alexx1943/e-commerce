package e_commerce.pedidos.Pedidos.domain;


import e_commerce.pedidos.Pedidos.domain.eunus.StatusPedido;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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

    @Column
    private Long idCliente;

    @Column
    private LocalDateTime dataPedido;

    @Column
    private BigDecimal total;

    @Column
    private String chavePagamento;

    @Column
    private String observacoes;

    @Column
    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    @Column
    private String codigoRastreio;

    @Column
    private String urlNotaFiscal;
}
