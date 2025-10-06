package dev.java10x.CadastroDeNinjas.ninjas;

import dev.java10x.CadastroDeNinjas.missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "tb_ninjas")
public class NinjaModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String nome;
    private int idade;

    @Column(unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "missoes_id")
    private MissoesModel missoes;

}
