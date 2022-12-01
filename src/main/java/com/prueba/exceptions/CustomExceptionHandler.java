package com.prueba.exceptions;

import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.prueba.controller.vo.MensajeVO;
import com.prueba.services.converter.ProductDetailConverter;
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
	
	 @ExceptionHandler(UnknownError.class)
	  public final ResponseEntity<Object> handleUnknownErrorException(HttpClientErrorException ex, WebRequest request) {
	        mensaje.setMensaje(ex.getMessage());
	    	AppLogger.error("", new PersonalizadaException(ex.getMessage()), CustomExceptionHandler.class);

			return new ResponseEntity(mensaje, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	 
	
	
	 @ExceptionHandler(	HttpClientErrorException.class)
	  public final ResponseEntity<Object> handleHttpClientErrorException(HttpClientErrorException ex, WebRequest request) {
	        mensaje.setMensaje(ex.getMessage());
	    	AppLogger.error("", new PersonalizadaException(ex.getMessage()), CustomExceptionHandler.class);
	        return new ResponseEntity(mensaje, HttpStatus.NON_AUTHORITATIVE_INFORMATION);
	    }
	 
	 
  
 
    @ExceptionHandler(TimeoutException.class)
    public final ResponseEntity<Object> handleTimeoutException(TimeoutException ex, WebRequest request) {
        mensaje.setMensaje(ex.getMessage());
    	AppLogger.error("", new PersonalizadaException(ex.getMessage()), CustomExceptionHandler.class);
        return new ResponseEntity(mensaje, HttpStatus.GATEWAY_TIMEOUT);
    }
    
    @ExceptionHandler(ConnectException.class)
    public final ResponseEntity<Object> handleConnectException(ConnectException ex, WebRequest request) {
    	AppLogger.error("", new PersonalizadaException(ex.getMessage()), CustomExceptionHandler.class);
        mensaje.setMensaje(ex.getMessage());
        return new ResponseEntity(mensaje, HttpStatus.GATEWAY_TIMEOUT);
    }
    
    @ExceptionHandler(UnknownHostException.class)
    public final ResponseEntity<Object> handleUnknownHostException(UnknownHostException ex, WebRequest request) {
    	mensaje.setMensaje(ex.getMessage());
    	AppLogger.error("", new PersonalizadaException(ex.getMessage()), CustomExceptionHandler.class);
        return new ResponseEntity(mensaje, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(PersonalizadaException.class)
    public final ResponseEntity<Object> handlePersonalizadaException(PersonalizadaException ex, WebRequest request) {
    	AppLogger.error("", new PersonalizadaException(ex.getMessage()), CustomExceptionHandler.class);
        mensaje.setMensaje(ex.getMessage());
        return new ResponseEntity(mensaje, HttpStatus.NOT_ACCEPTABLE);
    }

    
    @ExceptionHandler(WebClientResponseException.class)
    public ResponseEntity<String> handleWebClientResponseException(WebClientResponseException ex) {
    	AppLogger.error("", new PersonalizadaException(ex.getMessage()), CustomExceptionHandler.class);
        mensaje.setMensaje(ex.getResponseBodyAsString());
        return ResponseEntity.status(ex.getRawStatusCode()).body(ex.getResponseBodyAsString());
    }
 



}
