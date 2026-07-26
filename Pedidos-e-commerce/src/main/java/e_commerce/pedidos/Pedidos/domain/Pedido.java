package e_commerce.pedidos.Pedidos.domain;


import e_commerce.pedidos.Pedidos.domain.eunus.StatusPedido;
import e_commerce.pedidos.Pedidos.domain.eunus.TipoPagamento;
import e_commerce.pedidos.Pedidos.dto.DadosPagamentoDTO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;

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

    @Column
    private Long idCliente;

    @Column
    private LocalDateTime dataPedido;

    @OneToMany(mappedBy = "codigoPedido")
    private List<ItemPedido> itensPedidos;

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

    @Transient
    private DadosPagamentoDTO dadosPagamento;


    @OneToMany(mappedBy = "idPedido")
    private List<ItemPedido> itensPedido;
}
