package br.com.pedrobelmino.openai.spring.hello.service;

import br.com.pedrobelmino.openai.spring.hello.entity.Categoria;
import br.com.pedrobelmino.openai.spring.hello.repository.CategoriaRepository;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import static java.util.Optional.of;
import static java.util.Optional.ofNullable;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private OpenAIService openAIService;

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> findById(Long id) {
        return categoriaRepository.findById(id);
    }

    public Categoria save(Categoria categoria) {

        if (categoriaRepository.existsByNome(categoria.getNome())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Categoria já cadastrada");
        }

        of(categoria)
                .filter(openAIService::categoriaProdutoIsValida)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Categoria inválida"));

        return categoriaRepository.save(categoria);
    }


    public void deleteById(Long id) {
        categoriaRepository.deleteById(id);
    }

    public Optional<Categoria> findByNome(String nome) {
        return categoriaRepository.findByNome(nome);
    }


}