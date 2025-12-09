package dev.java10x.CadastroDeNinjas.missoes;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarMissao(MissoesDTO missoesModel) {
        MissoesDTO missao =  missoesService.CriarMissao(missoesModel);
        return ResponseEntity.status(HttpStatus.CREATED).body("Missao criada com sucesso: " +  missao);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<MissoesDTO>> listarMissao() {
        List<MissoesDTO> missoes = missoesService.listarMissoes();
        return ResponseEntity.ok(missoes);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<String> listarMissaoPorId(@PathVariable Long id) {
        MissoesDTO missao = missoesService.listarMissoesPorId(id);

        if (missao != null) {
            return ResponseEntity.ok("Missao encontrada com sucesso: " +  missao);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("missao nao encontrada");

    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<String> alterarMissao(@PathVariable Long id, @RequestBody MissoesDTO missoesModel) {

        if (missoesService.listarMissoesPorId(id) != null) {
            MissoesDTO missaoAlterada = missoesService.listarMissoesPorId(id);
            return ResponseEntity.status(HttpStatus.OK).body("Missao alterada com sucesso: " +   missaoAlterada);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("missao nao encontrada");

     }


    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissao(@PathVariable Long id) {

        if (missoesService.listarMissoesPorId(id) != null) {
            missoesService.deletarMissoesPorId(id);
            return ResponseEntity.ok("Missao deletada com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("missao nao encontrada");
    }
}
