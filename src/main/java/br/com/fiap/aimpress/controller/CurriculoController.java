package br.com.fiap.aimpress.controller;

import br.com.fiap.aimpress.model.Curriculo;
import br.com.fiap.aimpress.dto.Curriculo.AtualizarCurriculoDTO;
import br.com.fiap.aimpress.dto.Curriculo.CadastroCurriculoDTO;
import br.com.fiap.aimpress.dto.Curriculo.DetalhesCurriculoDTO;
import br.com.fiap.aimpress.repository.CurriculoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/curriculos")
public class CurriculoController {

    private final CurriculoRepository curriculoRepository;

    public CurriculoController(CurriculoRepository curriculoRepository) {
        this.curriculoRepository = curriculoRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhesCurriculoDTO> buscarPorId(@PathVariable Long id) {
        Optional<Curriculo> curriculoOptional = curriculoRepository.findById(id);
        if (curriculoOptional.isPresent()) {
            DetalhesCurriculoDTO detalhesCurriculoDTO = new DetalhesCurriculoDTO(curriculoOptional.get());
            return ResponseEntity.ok(detalhesCurriculoDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<DetalhesCurriculoDTO>> listarCurriculos() {
        List<Curriculo> curriculos = curriculoRepository.findAll();
        List<DetalhesCurriculoDTO> detalhesCurriculoDTOList = curriculos.stream()
                .map(DetalhesCurriculoDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(detalhesCurriculoDTOList);
    }

    @PostMapping
    public ResponseEntity<DetalhesCurriculoDTO> cadastrarCurriculo(@RequestBody CadastroCurriculoDTO dto) {
        Curriculo curriculo = curriculoRepository.save(new Curriculo(dto));
        DetalhesCurriculoDTO detalhesCurriculoDTO = new DetalhesCurriculoDTO(curriculo);
        return ResponseEntity.status(HttpStatus.CREATED).body(detalhesCurriculoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalhesCurriculoDTO> atualizarCurriculo(@PathVariable Long id, @RequestBody AtualizarCurriculoDTO dto) {
        Optional<Curriculo> curriculoOptional = curriculoRepository.findById(id);
        if (curriculoOptional.isPresent()) {
            Curriculo curriculo = curriculoOptional.get();
            curriculo.atualizar(dto);
            curriculo = curriculoRepository.save(curriculo);
            DetalhesCurriculoDTO detalhesCurriculoDTO = new DetalhesCurriculoDTO(curriculo);
            return ResponseEntity.ok(detalhesCurriculoDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCurriculo(@PathVariable Long id) {
        if (curriculoRepository.existsById(id)) {
            curriculoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}