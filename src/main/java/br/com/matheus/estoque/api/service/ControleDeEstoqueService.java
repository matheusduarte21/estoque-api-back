package br.com.matheus.estoque.api.service;

import br.com.matheus.estoque.api.dto.EntradaDeProdutoDto;
import br.com.matheus.estoque.api.dto.EstoqueDto;
import br.com.matheus.estoque.api.dto.ProdutoDto;
import br.com.matheus.estoque.api.dto.SaidaDeProdutoDto;
import br.com.matheus.estoque.api.entity.EntradaDeProduto;
import br.com.matheus.estoque.api.entity.Estoque;
import br.com.matheus.estoque.api.entity.Produto;
import br.com.matheus.estoque.api.entity.SaidaDeProduto;
import br.com.matheus.estoque.api.repository.EntradaDeEstoqueRepository;
import br.com.matheus.estoque.api.repository.EstoqueRepository;
import br.com.matheus.estoque.api.repository.SaidaDeProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ControleDeEstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    public void incluirFornecedor(EstoqueDto estoqueDto) {

        Optional<Estoque> estoqueExistente = estoqueRepository.findByNameEstoque(estoqueDto.getNameEstoque());

        if(estoqueExistente.isPresent()) {
            throw new RuntimeException("O estoque já existe");
        }
        else {

            Estoque estoque = Estoque.builder()
                    .nameEstoque(estoqueDto.getNameEstoque())
                    .id(estoqueDto.getId())
                    .produtos(
                            estoqueDto.getProdutos().stream()
                                    .map(ProdutoDto::fromEntity)
                                    .collect(Collectors.toList())
                    )
                    .build();
            estoqueRepository.save(estoque);
        }

    }

    public List<EstoqueDto> buscarTodos (){
        List<Estoque> listEstoque = estoqueRepository.findAll();
        return listEstoque.stream().map(EstoqueDto::new).toList();
    }

    public EstoqueDto buscarPorId(Long id){
        Optional<Estoque> estoqueOptional = estoqueRepository.findById(id);
        if(estoqueOptional.isPresent()){
            return new EstoqueDto(estoqueOptional.get());
        }else{
            throw new RuntimeException("O estoque não foi encontrada" + estoqueOptional.get());
        }
    }

    public Estoque getById(Long id){
        return estoqueRepository.findById(id).orElseThrow(
                () -> new RuntimeException("O estoque não foi encontrada")
        );
    }

    @Transactional
    public void delete(Long id){
       Estoque estoque = estoqueRepository.getById(id);
       estoqueRepository.delete(estoque);
    }
    @Transactional
    public void atualizar(Long id, EstoqueDto estoqueDto){
        Estoque estoque = getById(id);
        estoque.setNameEstoque(estoqueDto.getNameEstoque());
        estoque.setProdutos(estoqueDto.getProdutos().stream().map(ProdutoDto::fromEntity).collect(Collectors.toList()));
        estoqueRepository.save(estoque);
    }

}
