package dev.java10x.CadastroDeNinjas.ninjas;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NinjaRepository extends JpaRepository<NinjaModel, UUID> {
}
