package com.colatina.app.service.entrypoint.api.handler;

import com.colatina.app.service.core.exception.BusinessException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Getter
@Setter
@NoArgsConstructor
class ErrorResponse {
    private HttpStatus status;
    private Integer code;
    private String message;
}

@RestControllerAdvice
public class ApiExceptionHandler {

    private ResponseEntity<Object> buildResponseEntity(ErrorResponse errorResponse) {
        return new ResponseEntity<>(errorResponse, errorResponse.getStatus());
    }

    @ExceptionHandler(value = BusinessException.class)
    protected ResponseEntity<Object> cardNotFoundExceptionHandler(final BusinessException exception) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(BAD_REQUEST);
        errorResponse.setCode(errorResponse.getStatus().value());
        errorResponse.setMessage(exception.getMessage());
        return buildResponseEntity(errorResponse);
    }

}
