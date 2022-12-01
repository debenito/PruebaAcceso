package com.prueba.services.converter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.prueba.controller.vo.ProductDetail;
import com.prueba.controller.vo.SimilarProducts;
import com.prueba.services.impl.ProductsServiceImpl;
import com.prueba.utils.AppLogger;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

/**
 * 
 * @author Jose Antonio de Benito Suarez Clase encargada de la conversion o
 *         mapeo de los diversos objetos tanto en la salida como en la entrada
 *         de datos.
 */
@Component
@RequiredArgsConstructor
public class ProductDetailConverter {

	Gson gson = new Gson();

	public ProductDetail convertProducto(Mono<String> producto) {
	AppLogger.debug("", "Se realiza la conversion de json "+ producto +" a ProductoDetail:", ProductDetailConverter.class);
		return gson.fromJson(producto.block(), ProductDetail.class);
	}

	public List<String> convertLista(Mono<String> producto) {
		AppLogger.debug("", "Se realiza la conversion de json "+ producto +" a Lista de productos:", ProductDetailConverter.class);
		return Arrays.asList(gson.fromJson(producto.block(), String[].class));
	}

	public SimilarProducts convertListaSimilar(List<ProductDetail> array) {
		AppLogger.debug("", "Se realiza la conversion de Lista de productos "+ array.toString() +" a a Similairs", ProductDetailConverter.class);
		Collections.sort(array, (o1, o2) -> o1.getId().compareTo(o2.getId()));
		SimilarProducts simi = SimilarProducts.builder().build();
		simi.addAll(array);
		AppLogger.debug("", "Se devuelve el objeto Similairs ordenador "+ simi.toString(), ProductDetailConverter.class);
		return simi;
	}

}
