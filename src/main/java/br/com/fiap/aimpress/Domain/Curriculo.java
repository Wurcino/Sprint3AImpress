package br.com.fiap.aimpress.Domain;

import br.com.fiap.aimpress.dto.Curriculo.AtualizarCurriculoDTO;
import br.com.fiap.aimpress.dto.Curriculo.CadastroCurriculoDTO;
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
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_curriculo")
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

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    public Curriculo (CadastroCurriculoDTO dto) {
        nome = dto.nome();
        numeroTelefone = dto.numeroTelefone();
    }

    public void atualizar(AtualizarCurriculoDTO dto) {
        if(dto.nome() != null)
            nome = dto.nome();
        if(dto.numeroTelefone() != null)
            numeroTelefone = dto.numeroTelefone();
    }
}
