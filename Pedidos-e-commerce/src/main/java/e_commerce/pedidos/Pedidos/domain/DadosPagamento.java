package e_commerce.pedidos.Pedidos.domain;


import e_commerce.pedidos.Pedidos.domain.eunus.TipoPagamento;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DadosPagamento {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String dados;
    private TipoPagamento tipoPagamento;
}
