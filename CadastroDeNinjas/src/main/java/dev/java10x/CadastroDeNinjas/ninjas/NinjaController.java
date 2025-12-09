package dev.java10x.CadastroDeNinjas.ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninjaModel) {
        NinjaDTO novoNinja =  ninjaService.criarNinja(ninjaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ninja Criado com sucesso! " +  novoNinja.toString());
    }

    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<String> mostrarNinjaPorId(@PathVariable UUID id) {
        NinjaDTO ninjaPorId = ninjaService.ListarNinjaPorID(id);

        if (ninjaPorId != null) {
            return ResponseEntity.ok("Ninja encontrado: " + ninjaPorId);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com id: " +id+ " nao encontrado");
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<String> alterarNinjaPorId(@PathVariable UUID id, @RequestBody NinjaDTO ninjaModel) {

        if (ninjaService.ListarNinjaPorID(id) != null) {
            NinjaDTO ninjaAlterado = ninjaService.atualizarNinja(id, ninjaModel);
            return ResponseEntity.status(HttpStatus.OK).body("Ninja Alterado com sucesso! " + ninjaAlterado);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja nao encontrado!");
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinja(@PathVariable UUID id) {

        if (ninjaService.ListarNinjaPorID(id) != null) {
            ninjaService.deleteNinjaPorId(id);
            return ResponseEntity.ok("Ninja Deletado com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja nao existente!");
    }


}
