package com.prueba.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.prueba.controller.vo.MensajeVO;
import com.prueba.utils.AppLogger;
/**
 * 
 * @author Jose Antonio De Benito Suárez
 * Clase encargada del control de excepciones
 */
@SuppressWarnings({"unchecked","rawtypes"})
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler 
{

	
	MensajeVO mensaje = new MensajeVO();
	
    
    @ExceptionHandler(PersonalizadaException.class)
    public final ResponseEntity<Object> handlePersonalizadaException(PersonalizadaException ex, WebRequest request) {
    	mensaje.setMensaje(ex.getMessage());
    	AppLogger.error("", new PersonalizadaException(ex.getMessage()), CustomExceptionHandler.class);
        return new ResponseEntity(mensaje, HttpStatus.NOT_FOUND);
    }

    
    @ExceptionHandler(WebClientResponseException.class)
    public ResponseEntity<String> handleWebClientResponseException(WebClientResponseException ex) {
    	AppLogger.error("", new PersonalizadaException(ex.getMessage()), CustomExceptionHandler.class);
        mensaje.setMensaje(ex.getResponseBodyAsString());
        return ResponseEntity.status(ex.getRawStatusCode()).body(ex.getResponseBodyAsString());
    }
 



}
