package br.com.fiap.aimpress.model.application;

//import br.com.fiap.aimpress.dto.Endereco.AtualizarEnderecoDTO;
//import br.com.fiap.aimpress.dto.Endereco.CadastroEnderecoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name="JV_endereco")
@SequenceGenerator(name="seq_endereco", sequenceName="seq_JV_endereco", allocationSize=1)
public class Endereco {

    @Id
    @Column(name="id_endereco")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_endereco")
    private Long id;

    @Column(name="ds_logradouro", length = 100, nullable=false)
    private String logradouro;

    @Column(name="nr_cep", nullable=false, length = 9)
    private String cep;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="id_cidade")
    private Cidade cidade;

//    public Endereco(CadastroEnderecoDTO dto) {
//        logradouro = dto.logradouro();
//        cep = dto.cep();
//
//    }
//
//    public void atualizar(AtualizarEnderecoDTO dto) {
//        if(dto.logradouro() != null)
//            logradouro = dto.logradouro();
//        if(dto.cep() != null)
//            cep = dto.cep();
//    }

}
