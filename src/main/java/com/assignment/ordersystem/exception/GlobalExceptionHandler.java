package com.assignment.ordersystem.exception;

import com.assignment.ordersystem.payload.ErrorResponse;
import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(ResourceNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ErrorResponse.builder()
                        .message(ex.getMessage())
                        .status(404)
                        .timestamp(LocalDateTime.now())
                        .build());
    }

    @ExceptionHandler(InsufficientInventoryException.class)
    public ResponseEntity<ErrorResponse> handleInventory(InsufficientInventoryException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ErrorResponse.builder()
                        .message(ex.getMessage())
                        .status(400)
                        .timestamp(LocalDateTime.now())
                        .build());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException ex){

        String msg = ex.getBindingResult().getFieldError().getDefaultMessage();

        return ResponseEntity.badRequest()
                .body(ErrorResponse.builder()
                        .message(msg)
                        .status(400)
                        .timestamp(LocalDateTime.now())
                        .build());
    }

    @ExceptionHandler(ProductDisabledException.class)
public ResponseEntity<ErrorResponse> handleDisabled(ProductDisabledException ex){

    return ResponseEntity.badRequest()
            .body(ErrorResponse.builder()
                    .message(ex.getMessage())
                    .status(400)
                    .timestamp(LocalDateTime.now())
                    .build());
}

}
