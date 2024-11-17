package br.com.pedrobelmino.openai.spring.hello.controller;

import br.com.pedrobelmino.openai.spring.hello.dto.ProdutoRequestDTO;
import br.com.pedrobelmino.openai.spring.hello.dto.ProdutoResponseDTO;
import br.com.pedrobelmino.openai.spring.hello.entity.Categoria;
import br.com.pedrobelmino.openai.spring.hello.entity.Produto;
import br.com.pedrobelmino.openai.spring.hello.mapper.ProdutoMapper;
import br.com.pedrobelmino.openai.spring.hello.service.CategoriaService;
import br.com.pedrobelmino.openai.spring.hello.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private ProdutoMapper produtoMapper;

    @GetMapping
    public List<ProdutoResponseDTO> findAll() {
        return produtoService.findAll().stream()
                .map(produtoMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Optional<ProdutoResponseDTO> findById(@PathVariable Long id) {
        return produtoService.findById(id)
                .map(produtoMapper::toResponseDTO);
    }

    @PostMapping
    public ProdutoResponseDTO save(@RequestBody ProdutoRequestDTO produtoRequestDTO) {
        Categoria categoria = categoriaService.findById(produtoRequestDTO.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        Produto produto = produtoMapper.toEntity(produtoRequestDTO, categoria);
        return produtoMapper.toResponseDTO(produtoService.save(produto));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        produtoService.deleteById(id);
    }

}