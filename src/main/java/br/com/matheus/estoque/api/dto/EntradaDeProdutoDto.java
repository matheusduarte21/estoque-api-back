package br.com.matheus.estoque.api.dto;

import br.com.matheus.estoque.api.entity.EntradaDeProduto;
import br.com.matheus.estoque.api.entity.Fornecedor;
import br.com.matheus.estoque.api.entity.Produto;
import br.com.matheus.estoque.api.repository.FornecedorRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//@AllArgsConstructor
//@NoArgsConstructor
//@Data
public class EntradaDeProdutoDto {

//    @Autowired
//    private static FornecedorRepository fornecedorService;
//
//    private Long id;
//    private int data;
//    private Produto produtosParaEntrada;
//    private FornecedorDto fornecedor;
//
//    public EntradaDeProdutoDto(EntradaDeProduto entradaDeProduto) {
//        this.id = entradaDeProduto.getId();
//        this.data = entradaDeProduto.getData();
//        this.produtosParaEntrada = entradaDeProduto.getProdutoParaEntrar();
//        this.fornecedor = new FornecedorDto(entradaDeProduto.getFornecedor());
//    }

}
