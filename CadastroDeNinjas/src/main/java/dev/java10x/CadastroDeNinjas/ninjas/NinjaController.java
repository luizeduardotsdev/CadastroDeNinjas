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
    public List<NinjaModel> listarNinjas() {
        return ninjaService.listarNinjas();
    }

    @GetMapping("/listar/{id}")
    public NinjaModel mostrarNinjaPorId(@PathVariable UUID id) {
        return ninjaService.ListarNinjaPorID(id);
    }

    @PutMapping("/alterar/{id}")
    public NinjaModel alterarNinjaPorId(@PathVariable UUID id, @RequestBody NinjaModel ninjaModel) {
        return ninjaService.atualizarNinja(id, ninjaModel);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarNinja(@PathVariable UUID id) {
        ninjaService.deleteNinjaPorId(id);
    }


}
