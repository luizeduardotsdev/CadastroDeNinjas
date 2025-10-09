package dev.java10x.CadastroDeNinjas.ninjas;

import dev.java10x.CadastroDeNinjas.missoes.MissoesModel;
import lombok.Data;

import java.util.UUID;

@Data
public class NinjaDTO {

    private UUID id;
    private String nome;
    private int idade;
    private String email;
    private MissoesModel missoes;

}
