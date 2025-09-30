package dev.java10x.CadastroDeNinjas.missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    @GetMapping("/boasvindas")
    public String missoes() {
        return "aba de missoes";
    }

    @PostMapping("/criar")
    public String criarMissao() {
        return "missao criada";
    }

    @GetMapping("/listar")
    public String listarMissao() {
        return "lista de missoes";
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
