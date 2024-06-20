package br.com.matheus.estoque.api.Controllers;

import br.com.matheus.estoque.api.dto.EstoqueDto;
import br.com.matheus.estoque.api.service.ControleDeEstoqueService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estoque-api/products")
@RequiredArgsConstructor
public class EstoqueControllers {

    @Autowired
    private ControleDeEstoqueService controleDeEstoqueService;
    

    @PostMapping()
    public ResponseEntity<?> salvar(@RequestBody EstoqueDto EstoqueDto) {
        controleDeEstoqueService.incluirFornecedor(EstoqueDto);
        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping()
    public ResponseEntity<List<EstoqueDto>> mostrarTodos(){
        return new ResponseEntity<>(controleDeEstoqueService.buscarTodos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstoqueDto> buscarPorId(@PathVariable("id") Long id) {
        return new ResponseEntity<>(controleDeEstoqueService.buscarPorId(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> atualizar (@PathVariable("id") Long id){
        controleDeEstoqueService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> Atualizar (@PathVariable("id") Long id, @RequestBody EstoqueDto estoqueDto){
        controleDeEstoqueService.atualizar(id, estoqueDto);
        return ResponseEntity.noContent().build();
    }

}

