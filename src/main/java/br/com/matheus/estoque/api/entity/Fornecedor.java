package br.com.matheus.estoque.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
//@Data
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
public class Fornecedor {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
   private Long id;
//    private String nome;
//
//    @OneToOne(mappedBy = "fornecedor")
//    private EntradaDeProduto entradasDeProduto;
}
