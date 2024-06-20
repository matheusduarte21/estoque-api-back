package br.com.matheus.estoque.api.repository;

import br.com.matheus.estoque.api.entity.EntradaDeProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntradaDeEstoqueRepository extends JpaRepository<EntradaDeProduto, Long> {
}
