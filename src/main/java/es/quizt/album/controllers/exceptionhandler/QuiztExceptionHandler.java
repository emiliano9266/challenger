package es.quizt.album.controllers.exceptionhandler;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class QuiztExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ResponseError> handleResourceNotFoundException(final ResourceNotFoundException ex, final HttpServletRequest request) {
        ex.printStackTrace();
        return new ResponseEntity<ResponseError>(new ResponseError(ex.getMessage()), HttpStatus.NOT_FOUND);
    }
}
