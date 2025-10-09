package dev.java10x.CadastroDeNinjas.missoes;

import org.springframework.stereotype.Component;

@Component
public class MissoesMapper {
    public MissoesModel map(MissoesDTO missoesDTO){
        MissoesModel missoesModel = new MissoesModel();

        missoesModel.setId(missoesDTO.getId());
        missoesModel.setNome(missoesDTO.getNome());
        missoesModel.setDificuldade(missoesDTO.getDificuldade());
        missoesModel.setStartAt(missoesDTO.getStartAt());
        missoesModel.setNinja(missoesDTO.getNinja());

        return missoesModel;
    }

    public MissoesDTO map(MissoesModel missoesModel){
        MissoesDTO missoesDTO = new MissoesDTO();

        missoesDTO.setId(missoesModel.getId());
        missoesDTO.setNome(missoesDTO.getNome());
        missoesDTO.setDificuldade(missoesModel.getDificuldade());
        missoesDTO.setStartAt(missoesModel.getStartAt());
        missoesDTO.setNinja(missoesModel.getNinja());

        return missoesDTO;
    }


}
