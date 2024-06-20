package br.com.matheus.estoque.api.exceptions;

import br.com.matheus.estoque.api.dto.ErrorDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlerException {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity thread400(Exception exception){
        ErrorDto error = new ErrorDto(exception.getMessage(), 400);
        return ResponseEntity.badRequest().body(error);
    }

}
