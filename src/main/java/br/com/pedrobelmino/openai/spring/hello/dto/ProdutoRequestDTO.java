package br.com.pedrobelmino.openai.spring.hello.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequestDTO {
    private String nome;
    private BigDecimal preco;
    private Long categoriaId;
}