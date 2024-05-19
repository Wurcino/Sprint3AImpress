package br.com.fiap.aimpress.Domain;

import br.com.fiap.aimpress.dto.Empresa.AtualizarEmpresaDTO;
import br.com.fiap.aimpress.dto.Empresa.CadastroEmpresaDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "JV_EMPRESA")
@SequenceGenerator(name="seq_empresa", sequenceName="seq_JV_empresa", allocationSize=1)
public class Empresa {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_empresa")
    @Column(name = "id_empresa")
    private Long id;

    @Column(name = "nm_empresa", nullable = false, length = 50)
    private String nome;

    @Column(name = "dsc_empresa", nullable = false, length = 100)
    private String descricao;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="id_endereco")
    private Endereco endereco;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
    private List<Vaga> vagas;

    public Empresa(CadastroEmpresaDTO  dto) {
        nome = dto.nome();
        descricao = dto.descricao();
    }

    public void atualizar(AtualizarEmpresaDTO dto) {
        if(dto.nome() != null)
            nome = dto.nome();
        if (dto.descricao() != null)
            descricao = dto.descricao();
    }



}
