package br.com.matheus.estoque.api.repository;

import br.com.matheus.estoque.api.entity.SaidaDeProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaidaDeProdutoRepository extends JpaRepository<SaidaDeProduto, Long> {
}
