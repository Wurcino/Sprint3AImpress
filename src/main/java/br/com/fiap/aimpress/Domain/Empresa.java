package br.com.fiap.aimpress.Domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "JV_EMPRESA")
@SequenceGenerator(name="seq_empresa", sequenceName="seq_JV_empresa", allocationSize=1)
public class Empresa {

    @Id
    @GeneratedValue
    @Column(name = "id_empresa")
    private Long id;

    @Column(name = "nm_empresa", nullable = false, length = 50)
    private String nome;

    @Column(name = "dsc_empresa", nullable = false, length = 100)
    private String descricao;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="cd_endereco")
    private Endereco endereco;

}
