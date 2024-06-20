package br.com.matheus.estoque.api.Controllers;

import br.com.matheus.estoque.api.dto.ProdutoDto;
import br.com.matheus.estoque.api.dto.SaidaDeProdutoDto;
import br.com.matheus.estoque.api.entity.Produto;
import br.com.matheus.estoque.api.entity.SaidaDeProduto;
import br.com.matheus.estoque.api.service.ControleDeEstoqueService;
import br.com.matheus.estoque.api.service.SaidaDeProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/saida-de-produtos")
@RequiredArgsConstructor
public class SaidaDeProdutoControllers {

    private final SaidaDeProdutoService saidaDeProdutoService;


    @PatchMapping("/{idEstoque}/produtos/{idProduto}/saida")
    public ResponseEntity<?> atualizarSaidaDeProduto(
            @PathVariable("idEstoque") Long idEstoque,
            @PathVariable("idProduto") Long idProduto,
            @RequestBody int QuantidadeDaSaidaDoProduto
    ) {
        saidaDeProdutoService.deleteProdutoDoEstoque(idEstoque, idProduto, QuantidadeDaSaidaDoProduto);
        return ResponseEntity.ok("Produto excluido do estoque"+ idEstoque);
    }

//    @GetMapping()
//    public ResponseEntity<List<SaidaDeProdutoDto>> mostrarTodos(){
//        return new ResponseEntity<>(saidaDeProdutoService.buscarTodos(), HttpStatus.OK);
//    }
//    @GetMapping()
//    public ResponseEntity<List<ProdutoDto>>mostrarquaisSairam(){
//       return new ResponseEntity<>(saidaDeProdutoService.quaisProdutosSairam(),HttpStatus.OK);
//    }

}