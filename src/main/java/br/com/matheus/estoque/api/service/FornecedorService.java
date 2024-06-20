package br.com.matheus.estoque.api.service;

import br.com.matheus.estoque.api.dto.FornecedorDto;
import br.com.matheus.estoque.api.entity.Fornecedor;
import br.com.matheus.estoque.api.repository.FornecedorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

//    @Autowired
//    private FornecedorRepository fornecedorRepository;
//
//    public List<FornecedorDto> listar() {
//        List<Fornecedor> listFornecedor = fornecedorRepository.findAll();
//        return listFornecedor.stream().map(FornecedorDto::new).toList();
//    }
//
//    public void incluirFornecedor(FornecedorDto dto) {
//        Fornecedor fornecedor = Fornecedor.builder().nome(dto.getNome()).build();
//        fornecedorRepository.save(fornecedor);
//    }
//
//    public FornecedorDto getFornecedor(Long id) {
//        Optional<Fornecedor> fornecedor = fornecedorRepository.findById(id);
//        if (!fornecedor.isPresent()) {
//            throw new RuntimeException("Fornecedor não encontrado com o ID: " + id);
//        }
//        return new FornecedorDto(fornecedor.get());
//    }
//
//    public Fornecedor getById(Long id){
//        return fornecedorRepository.findById(id).orElseThrow(
//                () -> new RuntimeException("Fornecedor não encontrado com o ID: " + id)
//        );
//    }
//
//    @Transactional
//    public void alterar(Long id, FornecedorDto dto){
//        Fornecedor fornecedor = getById(id);
//        fornecedor.setNome(dto.getNome());
//    }
//    @Transactional
//    public void delete(Long id){
//        Fornecedor fornecedor = getById(id);
//        fornecedorRepository.delete(fornecedor);
//    }
}
