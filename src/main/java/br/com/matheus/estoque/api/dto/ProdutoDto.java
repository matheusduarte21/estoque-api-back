package br.com.matheus.estoque.api.dto;

import br.com.matheus.estoque.api.entity.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class ProdutoDto {

    private Long id;
    private String nome;
    private int quantidade;
   public static Produto fromEntity(ProdutoDto produtoDto) {
       Produto produto = new Produto();
       produto.setNome(produtoDto.getNome());
       produto.setId(produtoDto.getId());
       produto.setQuantidade(produtoDto.getQuantidade());
       return produto;
   }

   public ProdutoDto (Produto produto){
       this.id = produto.getId();
       this.nome = produto.getNome();
       this.quantidade = produto.getQuantidade();
   }
}
