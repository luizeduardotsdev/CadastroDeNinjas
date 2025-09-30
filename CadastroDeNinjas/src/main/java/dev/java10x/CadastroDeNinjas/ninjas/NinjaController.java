package dev.java10x.CadastroDeNinjas.ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Minha primeira mensagem nessa rota!";
    }

    @PostMapping("/criar")
    public String criarNinja() {
        return "Ninja criado";
    }

    @GetMapping("/listar")
    public String mostrarNinja() {
        return "mostrar todos ninjas";
    }

    @GetMapping("/listarId")
    public String mostrarNinjaPorId() {
        return "mostrar ninja por id";
    }

    @PutMapping("/alterar")
    public String alterarNinjaPorId() {
        return "alterar ninja alterada";
    }

    @DeleteMapping("/deletar")
    public String deletarNinja() {
        return "Ninja deletado por id";
    }


}
