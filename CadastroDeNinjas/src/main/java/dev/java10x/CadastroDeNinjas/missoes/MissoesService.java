package dev.java10x.CadastroDeNinjas.missoes;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    public MissoesModel CriarMissao(MissoesModel missoesModel) {
        return missoesRepository.save(missoesModel);
    }

    public List<MissoesModel> listarMissoes() {
        return missoesRepository.findAll();
    }

    public MissoesModel atualizarMissao(Long id, MissoesModel missoesModel) {
        if (missoesRepository.existsById(id)){
            missoesModel.setId(id);
            return missoesRepository.save(missoesModel);
        }
        return null;
    }

    public void deletarMissoesPorId(Long id) {
        missoesRepository.deleteById(id);
    }
}
