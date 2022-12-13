package com.prueba.api;



import java.time.Duration;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.prueba.exceptions.PersonalizadaException;

import reactor.core.publisher.Mono;
/**
 * 
 * @author Jose Antonio de Benito Suárez
 *  Clase encargada de las llamadas a la api de servicio Mocks
 */
@Service
public class ApiWebClient {
	String url = "http://localhost:3001/product/";
 
	
	/**
	 * Metodo encargado de ejecutar las llamas a la api de servicios , a traves de 
	 * WebFlux con el cliente WebClient
	 * @param id identificador ha introducir
	 * @param similarids Variable booleana para formar la llamada en la url
	 * @return String si es encontrado y si por el contrario no lo encuentra se realiza la gestion de excepciones.
	 * 
	 */
	@SuppressWarnings("unlikely-arg-type")
	public Mono<String> ejecutar(String id, boolean similarids) {
		String uri = similarids ? id+"/similarids" : id;
		return  WebClient.builder()
			    
			  .baseUrl(url).
			  defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE) 
			  .build().get()
			  .uri(url + uri  )
			  .retrieve()
			  .onRawStatus( 
					    HttpStatus.INTERNAL_SERVER_ERROR::equals,
					    response -> response.bodyToMono(String.class).map(UnknownError::new)) 
					  .onRawStatus(
					    HttpStatus.BAD_REQUEST::equals,
					    response -> response.bodyToMono(String.class).map(UnknownError::new))
					   .onRawStatus(
							    HttpStatus.NOT_FOUND::equals,
							    response -> response.bodyToMono(String.class).map(PersonalizadaException::new))
			  .bodyToMono(String.class);
	

	
 }
}
