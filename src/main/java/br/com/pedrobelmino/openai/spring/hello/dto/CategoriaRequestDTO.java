package br.com.pedrobelmino.openai.spring.hello.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaRequestDTO {
    private String nome;
}