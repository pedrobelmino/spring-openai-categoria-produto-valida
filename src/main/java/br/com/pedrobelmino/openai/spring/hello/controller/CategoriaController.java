package br.com.pedrobelmino.openai.spring.hello.controller;

import br.com.pedrobelmino.openai.spring.hello.dto.CategoriaRequestDTO;
import br.com.pedrobelmino.openai.spring.hello.dto.CategoriaResponseDTO;
import br.com.pedrobelmino.openai.spring.hello.entity.Categoria;
import br.com.pedrobelmino.openai.spring.hello.mapper.CategoriaMapper;
import br.com.pedrobelmino.openai.spring.hello.service.CategoriaService;
import br.com.pedrobelmino.openai.spring.hello.service.OpenAIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private CategoriaMapper categoriaMapper;

    @GetMapping
    public List<CategoriaResponseDTO> findAll() {
        return categoriaService.findAll().stream()
                .map(categoriaMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Optional<CategoriaResponseDTO> findById(@PathVariable Long id) {
        return categoriaService.findById(id)
                .map(categoriaMapper::toResponseDTO);
    }

    @PostMapping
    public CategoriaResponseDTO save(@RequestBody CategoriaRequestDTO categoriaRequestDTO) {
        Categoria categoria = categoriaMapper.toEntity(categoriaRequestDTO);

        return categoriaMapper.toResponseDTO(categoriaService.save(categoria));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        categoriaService.deleteById(id);
    }

}