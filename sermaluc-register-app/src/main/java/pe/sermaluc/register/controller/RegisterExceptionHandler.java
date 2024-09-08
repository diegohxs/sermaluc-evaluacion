package pe.sermaluc.register.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import pe.sermaluc.register.contract.response.ErrorDto;

import java.util.*;

@ControllerAdvice
@Slf4j
public class RegisterExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException e) {
        log.error(e.getMessage());
        List<String> errors = new ArrayList<>();
        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            errors.add(fieldError.getField().concat(" -> ").concat(Objects.requireNonNull(fieldError.getDefaultMessage())));
        }
        ErrorDto errorDto = ErrorDto.builder().message(errors).build();

        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }

}
