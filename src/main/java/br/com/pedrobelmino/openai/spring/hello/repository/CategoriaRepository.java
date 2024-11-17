package br.com.pedrobelmino.openai.spring.hello.repository;

import br.com.pedrobelmino.openai.spring.hello.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Optional<Categoria> findByNome(String nome);

    void deleteByNome(String nome);

    boolean existsByNome(String nome);
}