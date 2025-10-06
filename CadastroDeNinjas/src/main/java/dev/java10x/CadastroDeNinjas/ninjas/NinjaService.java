package dev.java10x.CadastroDeNinjas.ninjas;

import dev.java10x.CadastroDeNinjas.missoes.MissoesMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    public NinjaDTO criarNinja(NinjaDTO ninjaDTO) {
        NinjaModel ninja = new NinjaMapper().map(ninjaDTO);
        ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
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
