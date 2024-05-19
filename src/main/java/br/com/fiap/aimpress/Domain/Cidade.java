package br.com.fiap.aimpress.Domain;

import br.com.fiap.aimpress.dto.Cidade.AtualizarCidadeDTO;
import br.com.fiap.aimpress.dto.Cidade.CadastroCidadeDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name="JV_cidade")
@SequenceGenerator(name="seq_cidade", sequenceName="seq_JV_cidade", allocationSize=1)
public class Cidade {

    @Id
    @Column(name="id_cidade")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_cidade")
    private Long id;

    @Column(nullable=false, length = 100, name="nm_cidade")
    private String nome;

    @Column(length=2,nullable=false, name="ds_uf")
    private String uf;

    @Column(name="nr_ddd")
    private Integer ddd;

    public Cidade(CadastroCidadeDTO dto) {
        nome = dto.nome();
        uf = dto.uf();
        ddd = dto.ddd();
    }

    public void Atualizar(AtualizarCidadeDTO dto) {
        if (dto.nome() != null)
            nome = dto.nome();
        if (dto.ddd() != null)
            ddd = dto.ddd();
        if (dto.uf() != null)
            uf = dto.uf();
    }

}
