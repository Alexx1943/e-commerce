package cliente.e_commerce.Cliente.e_commerce.domain;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String cpf;

    @Column
    private String logradouro;

    @Column
    private Long numero;

    @Column
    private String bairro;

    @Column
    private String email;

    @Column
    private String telefone;
}
