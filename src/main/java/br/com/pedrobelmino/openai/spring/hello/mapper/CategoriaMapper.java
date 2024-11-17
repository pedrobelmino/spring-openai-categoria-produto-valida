package br.com.pedrobelmino.openai.spring.hello.mapper;

import br.com.pedrobelmino.openai.spring.hello.dto.CategoriaRequestDTO;
import br.com.pedrobelmino.openai.spring.hello.dto.CategoriaResponseDTO;
import br.com.pedrobelmino.openai.spring.hello.entity.Categoria;
import org.springframework.stereotype.Component;

@Component
public class CategoriaMapper {

    public Categoria toEntity(CategoriaRequestDTO dto) {
        return Categoria.builder()
                .nome(dto.getNome())
                .build();
    }

    public CategoriaResponseDTO toResponseDTO(Categoria categoria) {
        return CategoriaResponseDTO.builder()
                .id(categoria.getId())
                .nome(categoria.getNome())
                .build();
    }
}