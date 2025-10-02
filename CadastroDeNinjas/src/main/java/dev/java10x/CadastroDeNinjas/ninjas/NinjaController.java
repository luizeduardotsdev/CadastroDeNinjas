package dev.java10x.CadastroDeNinjas.ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Minha primeira mensagem nessa rota!";
    }

    @PostMapping("/criar")
    public String criarNinja() {
        return "Ninja criado";
    }

    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas() {
        return ninjaService.listarNinjas();
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
