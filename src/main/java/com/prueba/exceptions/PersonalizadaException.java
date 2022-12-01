package com.prueba.exceptions;

import org.springframework.http.HttpStatus;

/**
 * 
 * @author Jose Antonio De Benito Su&aacute;rez,
 *
 *Excepcion personalizada para mayor control de logs y excepciones
 */
public class PersonalizadaException extends RuntimeException {
	private static final long serialVersionUID = 1L;


	@Override
	public synchronized Throwable fillInStackTrace() {
		return this;
	}

	public PersonalizadaException() {
		super();
	}

	public PersonalizadaException(String message) {
		super(message);
		
	}
}
