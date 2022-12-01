package com.prueba.services;

import com.prueba.controller.vo.ProductDetail;
import com.prueba.controller.vo.SimilarProducts;
/**
 * 
 * @author Jose Antonio de Benito Suarez
 *
 */
public interface IProductsService {

	/**
	 * Metodo encargado de llamar a la api de servicios Mocks y recuperar los datos
	 * de un producto si este existe.
	 * Finalmente devuevle un objeto ProductDetail si este es encontrado.
	 * @param id
	 * @return ProductDetail
	 * @throws Exception 
	 */
	ProductDetail findOne(String id) throws Exception;
	/**
	 * Metodo encargado de llamar a la api de servicios Mocks y recuperar los datos
	 * de los productos similares al enviado.
	 * Finalmente devuevle un objeto SimilarProducts si este es encontrado con la lista ordenada y el
	 * detalle de los productos.
	 * @param id
	 * @return ProductDetail
	 * @throws Exception 
	 */
	SimilarProducts findRelactions(String id) throws Exception;

}
