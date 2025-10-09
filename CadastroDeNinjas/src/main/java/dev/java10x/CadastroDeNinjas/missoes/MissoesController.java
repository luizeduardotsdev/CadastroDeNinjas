package dev.java10x.CadastroDeNinjas.missoes;

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
    public MissoesDTO criarMissao(MissoesDTO missoesModel) {
        return missoesService.CriarMissao(missoesModel);
    }

    @GetMapping("/listar")
    public List<MissoesDTO> listarMissao() {
        return missoesService.listarMissoes();
    }

    @PutMapping("/alterar/{id}")
    public MissoesDTO alterarMissao(@PathVariable Long id, @RequestBody MissoesDTO missoesModel) {
        return missoesService.atualizarMissao(id, missoesModel);
    }


    @DeleteMapping("/deletar/{id}")
    public void deletarMissao(@PathVariable Long id) {
        missoesService.deletarMissoesPorId(id);
    }
}
