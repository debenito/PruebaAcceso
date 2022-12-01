package com.prueba.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.prueba.api.ApiWebClient;
import com.prueba.controller.vo.ProductDetail;
import com.prueba.controller.vo.SimilarProducts;
import com.prueba.services.IProductsService;
import com.prueba.services.converter.ProductDetailConverter;
import com.prueba.utils.AppLogger;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductsServiceImpl implements IProductsService {
	@Autowired
    private  ApiWebClient api;

	@Autowired
    private  ProductDetailConverter converter;
	
	@Cacheable("productos")
    @Override
    public ProductDetail findOne(String id) throws Exception {
        AppLogger.info("", "Se recibe una id para buscar un producto:", id, ProductsServiceImpl.class);
        return converter.convertProducto(api.ejecutar(id,false));
    }

	@Cacheable("similarids")
	@Override
	public SimilarProducts findRelactions(String id) throws Exception {
		  AppLogger.info("", "Se recibe una id para buscar una lista de productos relacionados:", id, ProductsServiceImpl.class);
	        List<ProductDetail> array = new ArrayList<ProductDetail>();
	        converter.convertLista(
	        		api.ejecutar(id,true))
	        .parallelStream().forEach(
				producto -> {
					try {
						array.add(findOne(producto));
					} catch (Exception e) {
						return;
					}
				});
			return converter.convertListaSimilar(array);
	      
	}


}
