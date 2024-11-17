package br.com.pedrobelmino.openai.spring.hello.mapper;

import br.com.pedrobelmino.openai.spring.hello.dto.ProdutoRequestDTO;
import br.com.pedrobelmino.openai.spring.hello.dto.ProdutoResponseDTO;
import br.com.pedrobelmino.openai.spring.hello.entity.Categoria;
import br.com.pedrobelmino.openai.spring.hello.entity.Produto;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {

    public Produto toEntity(ProdutoRequestDTO dto, Categoria categoria) {
        Produto produto = Produto.builder()
                .nome(dto.getNome())
                .preco(dto.getPreco())
                .categoria(categoria)
                .build();
        return produto;
    }

    public ProdutoResponseDTO toResponseDTO(Produto produto) {
        return ProdutoResponseDTO.builder()
                .id(produto.getId())
                .nome(produto.getNome())
                .preco(produto.getPreco())
                .categoriaNome(produto.getCategoria().getNome())
                .build();
    }
}