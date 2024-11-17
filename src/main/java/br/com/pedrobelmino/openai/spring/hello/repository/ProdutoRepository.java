package br.com.pedrobelmino.openai.spring.hello.repository;

import br.com.pedrobelmino.openai.spring.hello.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}