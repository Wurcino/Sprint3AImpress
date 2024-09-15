package br.com.fiap.aimpress.model;

import br.com.fiap.aimpress.dto.Vaga.AtualizarVagaDTO;
import br.com.fiap.aimpress.dto.Vaga.CadastroVagaDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "JV_vagas")
@SequenceGenerator(name="seq_vagas", sequenceName="seq_JV_vagas", allocationSize=1)
public class Vaga {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_vagas")
    @Column(name = "id_vaga")
    private long id;

    @Column(name = "titulo_vagas", nullable = false, length = 50)
    private String titulo;

    @Column(name = "dsc_vagas", nullable = false, length = 300)
    private String descricao;

    @Column(name = "requisitos_vagas",nullable = false, length = 100)
    private String requisitos;

    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    public Vaga(CadastroVagaDTO dto) {
        titulo = dto.titulo();
        descricao = dto.descricao();
        requisitos = dto.requisitos();
    }

    public void atualizar(AtualizarVagaDTO dto) {
        if(dto.titulo() != null)
            titulo = dto.titulo();
        if(dto.descricao() != null)
            descricao = dto.descricao();
        if(dto.requisitos() != null)
            requisitos = dto.requisitos();
    }

}
