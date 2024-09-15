package br.com.fiap.aimpress.model.application;

import br.com.fiap.aimpress.dto.application.Empresa.AtualizarEmpresaDTO;
import br.com.fiap.aimpress.dto.application.Empresa.CadastroEmpresaDTO;
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
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_empresa")
    @Column(name = "id_empresa")
    private Long id;

    @Column(name = "nm_empresa", nullable = false, length = 50)
    private String nome;

    @Column(name = "dsc_empresa", nullable = false, length = 100)
    private String descricao;


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
