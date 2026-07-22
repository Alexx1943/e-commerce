package e_commerce.pedidos.Pedidos.domain;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedido {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idItemPedido;

    @Column
    private Long idPedido;

    @Column
    private Long idProduto;

    @Column
    private Integer quantidade;

    @Column
    private BigDecimal valorUnitario;
}
