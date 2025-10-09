package dev.java10x.CadastroDeNinjas.missoes;

import dev.java10x.CadastroDeNinjas.ninjas.NinjaModel;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class MissoesDTO {

    private Long id;
    private String nome;
    private String dificuldade;
    private LocalDateTime startAt;
    private List<NinjaModel> ninja;
}
