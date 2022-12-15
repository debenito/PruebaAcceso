package com.prueba.services.impl;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.prueba.api.ApiWebClient;
import com.prueba.controller.vo.ProductDetail;
import com.prueba.controller.vo.SimilarProducts;
import com.prueba.services.IProductsService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductsServiceImpl implements IProductsService {
	@Autowired
    private  ApiWebClient api;

	
	
	
	@Cacheable("productos")
    @Override
    public ProductDetail findOne(String id) throws Exception {
        return api.ejecutarProducto(id);
    }

	@Cacheable("similarids")
	@Override
	public SimilarProducts findRelactions(String id) throws Exception {
		SimilarProducts similar = SimilarProducts.builder().build();
			  api.ejecutar(id).parallelStream().forEach(p->{
				try {
					similar.add(api.ejecutarProducto(p));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					return;
				}
			});
				Collections.sort(similar, (o1, o2) -> o1.getId().compareTo(o2.getId()));
	      return similar;
	}

}
