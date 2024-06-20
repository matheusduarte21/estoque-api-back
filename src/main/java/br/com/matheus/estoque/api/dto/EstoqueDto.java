package br.com.matheus.estoque.api.dto;

import br.com.matheus.estoque.api.entity.Estoque;
import br.com.matheus.estoque.api.entity.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstoqueDto {

    private Long id;
    private String nameEstoque;
    private List<ProdutoDto> produtos;


    public EstoqueDto(Estoque estoque) {
        this.id = estoque.getId();
        this.nameEstoque = estoque.getNameEstoque();
        this.produtos = estoque.getProdutos().stream().map(ProdutoDto::new).collect(Collectors.toList());
    }
}
