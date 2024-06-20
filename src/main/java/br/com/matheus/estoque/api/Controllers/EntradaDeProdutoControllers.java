package br.com.matheus.estoque.api.Controllers;

import br.com.matheus.estoque.api.dto.EntradaDeProdutoDto;
import br.com.matheus.estoque.api.dto.ProdutoDto;
import br.com.matheus.estoque.api.entity.EntradaDeProduto;
import br.com.matheus.estoque.api.service.ControleDeEstoqueService;
import br.com.matheus.estoque.api.service.EntradaDeProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entrada")
@RequiredArgsConstructor
public class EntradaDeProdutoControllers {
    @Autowired
    private EntradaDeProdutoService entradaDeProdutoService;

    @PostMapping("/estoque/{idEstoque}/produtos")
    public ResponseEntity<?> incluirProdutoNoEstoque
            (
                    @RequestBody ProdutoDto produtoDto,
                    @PathVariable("idEstoque") Long idEstoque
            ) {

        entradaDeProdutoService.incluirEntradaDeProduto(produtoDto, idEstoque);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
