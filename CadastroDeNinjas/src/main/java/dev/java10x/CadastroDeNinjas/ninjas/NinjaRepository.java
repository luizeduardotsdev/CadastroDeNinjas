package dev.java10x.CadastroDeNinjas.ninjas;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface NinjaRepository extends JpaRepository<NinjaModel, UUID> {
   Optional<NinjaModel> findById(UUID id);
}
