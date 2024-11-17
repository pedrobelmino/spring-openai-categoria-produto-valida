package br.com.pedrobelmino.openai.spring.hello.service;

import br.com.pedrobelmino.openai.spring.hello.entity.Categoria;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class OpenAIService {

    private final OpenAiChatModel chatModel;

    public boolean categoriaProdutoIsValida(Categoria categoria) {

        var prompt = String.format("Esse texto '%s' esse é uma categoria de produto de supermercado válida? As respostas possíveis são apenas s de sim ou n de não", categoria.getNome());

        ChatResponse response = chatModel.call(
                new Prompt(
                        prompt,
                        OpenAiChatOptions.builder()
                                .withTemperature(0.4)
                                .build()
                ));
        return ofNullable(response.getResult().getOutput().getContent())
                .map(content -> content.contains("s"))
                .orElse(false);
    }
}