package com.prueba.services.converter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.prueba.controller.vo.ProductDetail;
import com.prueba.controller.vo.SimilarProducts;
import com.prueba.services.impl.ProductsServiceImpl;
import com.prueba.utils.AppLogger;
import com.prueba.utils.ListProductSimilairsUtils;

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

	@Autowired
	ListProductSimilairsUtils<Object> lista;
	
	public ProductDetail convertProducto(String id,Mono<String> producto) {
		ProductDetail product = gson.fromJson(producto.block(), ProductDetail.class);
		lista.add(id, product);
		return product ;
	}

	public List<String> convertLista(Mono<String> producto) {
		return Arrays.asList(gson.fromJson(producto.block(), String[].class));
	}

	public SimilarProducts convertListaSimilar(String id,List<ProductDetail> array) {
		Collections.sort(array, (o1, o2) -> o1.getId().compareTo(o2.getId()));
		SimilarProducts simi = SimilarProducts.builder().build();
		simi.addAll(array);
		lista.add(id+"s", simi);
		return simi;
	}

}
