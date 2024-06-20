package br.com.matheus.estoque.api.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Destino {

  @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
//
//    private String description;
//
//    @OneToOne
//    @JoinColumn(name = "saida_de_produto_id", unique = true)
//    @JsonBackReference
//    private SaidaDeProduto saidaDeProduto;

}
