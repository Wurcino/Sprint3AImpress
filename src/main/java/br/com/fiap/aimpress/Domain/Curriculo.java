package br.com.fiap.aimpress.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "JV_curriculo")
@SequenceGenerator(name ="seq_curriculo", sequenceName="seq_JV_curriculo", allocationSize=1)
public class Curriculo {

    @Id
    @GeneratedValue
    @Column(name = "id_curriculo")
    private Long id;

    @Column(name = "nm_nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "nr_telefone", length = 11, nullable = false)
    private String numeroTelefone;
    //Ex: 11936620738

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cd_detalhe_curriculo", nullable = false)
    private DetalheCurriculo detalheCurriculo;

}
