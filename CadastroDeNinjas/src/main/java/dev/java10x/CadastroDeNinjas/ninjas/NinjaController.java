package dev.java10x.CadastroDeNinjas.ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninjaModel) {
        return ninjaService.criarNinja(ninjaModel);
    }

    @GetMapping("/listar")
    public List<NinjaDTO> listarNinjas() {
        return ninjaService.listarNinjas();
    }

    @GetMapping("/listar/{id}")
    public NinjaDTO mostrarNinjaPorId(@PathVariable UUID id) {
        return ninjaService.ListarNinjaPorID(id);
    }

    @PutMapping("/alterar/{id}")
    public NinjaDTO alterarNinjaPorId(@PathVariable UUID id, @RequestBody NinjaDTO ninjaModel) {
        return ninjaService.atualizarNinja(id, ninjaModel);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarNinja(@PathVariable UUID id) {
        ninjaService.deleteNinjaPorId(id);
    }


}
