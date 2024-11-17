package br.com.pedrobelmino.openai.spring.hello.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoResponseDTO {
    private Long id;
    private String nome;
    private BigDecimal preco;
    private String categoriaNome;
}