package dev.java10x.CadastroDeNinjas.missoes;

import dev.java10x.CadastroDeNinjas.ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "tb_missoes")
public class MissoesModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String nome;
    private String dificuldade;
    private LocalDateTime startAt;
    private LocalDateTime endAt;

    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninja;

}
