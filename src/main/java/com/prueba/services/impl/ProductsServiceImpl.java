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
import com.prueba.utils.ListProductSimilairsUtils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductsServiceImpl implements IProductsService {
	@Autowired
    private  ApiWebClient api;

	@Autowired
    private  ProductDetailConverter converter;
	
	@Autowired
	ListProductSimilairsUtils<Object> lista;
	
	
	@Cacheable("productos")
    @Override
    public ProductDetail findOne(String id) throws Exception {
        return lista.contains(id)?(ProductDetail) lista.get(id):
        	 converter.convertProducto(id,api.ejecutar(id,false));
    }

	@Cacheable("similarids")
	@Override
	public SimilarProducts findRelactions(String id) throws Exception {
		
			return  lista.contains(id+"s")?(SimilarProducts) lista.get(id+"s"):ejecutarLista(id);
	      
	}

	// Metodo privado encargado de recoger la lista y convertirla al objeto SimilarProducts
	private SimilarProducts ejecutarLista(String id){
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
        return converter.convertListaSimilar(id,array);
	}
}
