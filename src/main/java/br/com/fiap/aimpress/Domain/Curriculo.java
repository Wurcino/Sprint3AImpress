package br.com.fiap.aimpress.Domain;

import br.com.fiap.aimpress.Domain.enums.Carreira;
import br.com.fiap.aimpress.Domain.enums.NivelEscolaridade;
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

    @Column(name = "ds_resumo", nullable = false, length = 300)
    private String resumo;

    @Column(name = "ds_experiencia", nullable = false, length = 300)
    private String experiencia;

    @Column(name = "nvl_escolaridade", nullable = false)
    @Enumerated(EnumType.STRING)
    private NivelEscolaridade nivelEscolaridade;

    @Column(name = "ds_carreira", nullable = false)
    @Enumerated(EnumType.STRING)
    private Carreira carreira;

    @Column(name = "ds_cursos", nullable = false, length = 300)
    private String cursos;

    @Column(name = "ds_idiomas", nullable = false, length = 300)
    private String idiomas;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Curriculo (CadastroCurriculoDTO dto) {
        nome = dto.nome();
        numeroTelefone = dto.numeroTelefone();
        resumo = dto.resumo();
        experiencia = dto.experiencia();
        nivelEscolaridade = dto.nivelEscolaridade();
        carreira = dto.carreira();
        cursos = dto.cursos();
        idiomas = dto.idiomas();
    }

    public void atualizar(AtualizarCurriculoDTO dto) {
        if(dto.nome() != null)
            nome = dto.nome();
        if(dto.numeroTelefone() != null)
            numeroTelefone = dto.numeroTelefone();
        if(dto.resumo() != null)
            resumo = dto.resumo();
        if(dto.experiencia() != null)
            experiencia = dto.experiencia();
        if(dto.nivelEscolaridade() != null)
            nivelEscolaridade = dto.nivelEscolaridade();
        if(dto.carreira() != null)
            carreira = dto.carreira();
        if(dto.cursos() != null)
            cursos = dto.cursos();
        if(dto.idiomas() != null)
            idiomas = dto.idiomas();
    }
}
