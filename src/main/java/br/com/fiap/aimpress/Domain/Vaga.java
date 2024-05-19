package br.com.fiap.aimpress.Domain;

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
    @JoinColumn(name = "id_empresa", nullable = false)
    private Empresa empresa;

}
