package dev.java10x.CadastroDeNinjas.ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public NinjaModel criarNinja(NinjaModel ninjaModel) {
        return ninjaRepository.save(ninjaModel);
    }

    public List<NinjaModel> listarNinjas() {
        return ninjaRepository.findAll();
    }

    public NinjaModel ListarNinjaPorID(UUID id) {
        Optional<NinjaModel> ninja = ninjaRepository.findById(id);
        return ninja.orElse(null);
    }

    public NinjaModel atualizarNinja(UUID id, NinjaModel ninjaModel) {
        if (ninjaRepository.existsById(id)) {
            ninjaModel.setId(id);
            return ninjaRepository.save(ninjaModel);
        }
        return null;
    }

    public void deleteNinjaPorId(UUID id) {
        ninjaRepository.deleteById(id);
    }
}
