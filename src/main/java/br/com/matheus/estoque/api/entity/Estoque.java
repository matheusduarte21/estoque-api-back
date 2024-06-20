package br.com.matheus.estoque.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Estoque{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nameEstoque;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Produto> produtos;

    @OneToOne(mappedBy = "estoque", cascade = CascadeType.ALL)
    private SaidaDeProduto saida;

}
