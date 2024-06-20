package br.com.matheus.estoque.api.Controllers;

import br.com.matheus.estoque.api.dto.FornecedorDto;
import br.com.matheus.estoque.api.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

//    @Autowired
//    private FornecedorService fornecedorService;
//
//    @GetMapping
//    public ResponseEntity<List<FornecedorDto>> listar() {
//        return new ResponseEntity<>(fornecedorService.listar(), HttpStatus.OK);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<FornecedorDto> buscarPorId(@PathVariable("id") Long id) {
//        return new ResponseEntity<>(fornecedorService.getFornecedor(id), HttpStatus.OK);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<?> atualizar(@PathVariable("id") Long id, @RequestBody FornecedorDto fornecedorDto) {
//        fornecedorService.alterar(id, fornecedorDto);
//        return ResponseEntity.noContent().build();
//    }
//
//    @PostMapping()
//    public ResponseEntity<?> salvar(@RequestBody FornecedorDto fornecedorDto) {
//        fornecedorService.incluirFornecedor(fornecedorDto);
//        return  ResponseEntity.status(HttpStatus.CREATED).build();
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> remover(@PathVariable("id") Long id) {
//        fornecedorService.delete(id);
//        return ResponseEntity.noContent().build();
//    }
}
