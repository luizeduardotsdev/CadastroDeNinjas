package dev.java10x.CadastroDeNinjas.missoes;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MissoesRepository extends JpaRepository<MissoesModel, UUID> {
}
