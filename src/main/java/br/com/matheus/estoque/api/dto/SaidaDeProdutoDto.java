package br.com.matheus.estoque.api.dto;

import br.com.matheus.estoque.api.entity.Destino;
import br.com.matheus.estoque.api.entity.Estoque;
import br.com.matheus.estoque.api.entity.Fornecedor;
import br.com.matheus.estoque.api.entity.SaidaDeProduto;
import br.com.matheus.estoque.api.repository.DestinoRepository;
import br.com.matheus.estoque.api.repository.EstoqueRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SaidaDeProdutoDto {
    private Long id;
    private int data;
    private EstoqueDto estoque;

    @Autowired
    private static EstoqueRepository estoqueRepository;

    public SaidaDeProdutoDto(SaidaDeProduto saidaDeProduto) {

    }


    public static SaidaDeProduto fromEntitySaidaDeProduto(SaidaDeProdutoDto dto) {
        SaidaDeProduto saida = new SaidaDeProduto();
        saida.setId(dto.getId());
        saida.setData(dto.getData());

        Long estoqueId = dto.estoque.getId();
        Optional<Estoque> estoqueOptional = estoqueRepository.findById(estoqueId);

        if (estoqueOptional.isPresent()) {
            saida.setEstoque(estoqueOptional.get());
        } else {
            throw new RuntimeException("Destino não encontrado com o ID: " + estoqueId);
        }
        return saida;
    };
}
