package br.com.matheus.estoque.api.service;

import br.com.matheus.estoque.api.dto.ProdutoDto;
import br.com.matheus.estoque.api.dto.SaidaDeProdutoDto;
import br.com.matheus.estoque.api.entity.Estoque;
import br.com.matheus.estoque.api.entity.Produto;
import br.com.matheus.estoque.api.entity.SaidaDeProduto;
import br.com.matheus.estoque.api.repository.EstoqueRepository;
import br.com.matheus.estoque.api.repository.SaidaDeProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SaidaDeProdutoService {

    @Autowired
    private EstoqueRepository estoqueRepository;
    @Autowired
    private SaidaDeProdutoRepository saidaDeProdutoRepository;

    public Estoque getById(Long id){
        return estoqueRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Estoque não encontrado" )
        );
    }

    @Transactional
    public void deleteProdutoDoEstoque(Long idEstoque, Long idProduto, int quantidadeDaSaida){

        Estoque estoque = getById(idEstoque);

        Optional<Produto> ProdutoOptcional = estoque.getProdutos().stream()
                .filter(produto -> produto.getId().equals(idProduto))
                .findFirst();
        
        if (ProdutoOptcional.isEmpty()) {
            throw new RuntimeException("Produto não encontrado");
        }

        Produto produto = ProdutoOptcional.get();

        if (produto.getQuantidade() < quantidadeDaSaida) {
            throw new RuntimeException("Quantidade solicitada não disponível no estoque");
        } else if (produto.getQuantidade() == quantidadeDaSaida) {
            estoque.getProdutos().remove(produto);
        } else {
            produto.setQuantidade(produto.getQuantidade() - quantidadeDaSaida);
        }

        estoqueRepository.save(estoque);
    }


}
