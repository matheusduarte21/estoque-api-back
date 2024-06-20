package br.com.matheus.estoque.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaidaDeProduto {
  @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
  private int data;

  @OneToOne()
  @JoinColumn(name = "estoque_id")
  private Estoque estoque;

}
