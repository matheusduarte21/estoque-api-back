package br.com.matheus.estoque.api.repository;

import br.com.matheus.estoque.api.entity.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
    Optional<Estoque> findByNameEstoque(String nomeEstoque);
}
