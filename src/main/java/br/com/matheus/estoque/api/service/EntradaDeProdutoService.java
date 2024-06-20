package br.com.matheus.estoque.api.service;

import br.com.matheus.estoque.api.dto.EntradaDeProdutoDto;
import br.com.matheus.estoque.api.dto.ProdutoDto;
import br.com.matheus.estoque.api.entity.EntradaDeProduto;
import br.com.matheus.estoque.api.entity.Estoque;
import br.com.matheus.estoque.api.entity.Fornecedor;
import br.com.matheus.estoque.api.entity.Produto;
import br.com.matheus.estoque.api.repository.EntradaDeEstoqueRepository;
import br.com.matheus.estoque.api.repository.EstoqueRepository;
import br.com.matheus.estoque.api.repository.FornecedorRepository;
import br.com.matheus.estoque.api.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntradaDeProdutoService {

    @Autowired
    private EstoqueRepository estoqueRepository;
    @Autowired
    private ControleDeEstoqueService serviceEstoque;
    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional
    public void incluirEntradaDeProduto (ProdutoDto dto, Long idEstoque){
        Estoque estoque = serviceEstoque.getById(idEstoque);
        Produto produtoConversao = ProdutoDto.fromEntity(dto);

        Optional<Produto> produtoOptional = produtoRepository.findByNome(dto.getNome());
        if(produtoOptional.isPresent()){
            Produto produtoExistente = produtoOptional.get();
            produtoExistente.setQuantidade(produtoExistente.getQuantidade() + produtoConversao.getQuantidade());
            produtoConversao = produtoExistente;
        }
        else{
            estoque.getProdutos().add(produtoConversao);
        }

        estoqueRepository.save(estoque);
    }
}
