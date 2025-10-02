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

    @GetMapping("/boasvindas")
    public String missoes() {
        return "aba de missoes";
    }

    @PostMapping("/criar")
    public String criarMissao() {
        return "missao criada";
    }

    @GetMapping("/listar")
    public List<MissoesModel> listarMissao() {
        return missoesService.listarMissoes();
    }

    @PutMapping("/alterar")
    public String alterarMissao() {
        return "missao alterada";
    }


    @DeleteMapping("/deletar")
    public String deletarMissao() {
        return "missao deletada";
    }
}
