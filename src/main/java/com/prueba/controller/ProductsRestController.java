package com.prueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.controller.vo.ProductDetail;
import com.prueba.controller.vo.SimilarProducts;
import com.prueba.services.IProductsService;
import com.prueba.utils.AppLogger;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("product")
public class ProductsRestController {
	@Autowired
	private IProductsService productsService;

	@Operation( operationId = "get-product" ,description = "Se obtiene una acción", summary = "Buscar por id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Petición completada con exito", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ProductDetail.class)) }),
			@ApiResponse(responseCode = "500", description = "Error en el servidor", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ProductDetail.class)) }),
			@ApiResponse(responseCode = "404", description = "No se encuentra la entidad", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ProductDetail.class)) }) })
	@GetMapping("/{productId}")
	public ResponseEntity<?> findById(
			@Parameter(description = "Identificador de la entidad buscada", name = "productId", required = true) @PathVariable Long productId )
			throws Exception {
		AppLogger.info("", "Se pasa un id ara buscar el producto :", productId , ProductsRestController.class);
		return ResponseEntity.ok(productsService.findOne(String.valueOf(productId)));

	}

	@Operation(operationId = "get-product-similar" , description = "Se obtiene todos los productos relaccionados con un id", summary = "Buscar")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Petición completada con exito", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = SimilarProducts.class)) }),
			@ApiResponse(responseCode = "500", description = "Error en el servidor", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = SimilarProducts.class)) }),
			@ApiResponse(responseCode = "404", description = "No se encuentra la entidad", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = SimilarProducts.class)) }) })
	@GetMapping("/{productId}/similar")
	public ResponseEntity<?> findRelactions(@Parameter(description = "Identificador de la entidad buscada", name = "productId", required = true) @PathVariable Long productId) throws Exception {
		AppLogger.info("", "Se buscan los productos relaccionados con" + productId , ProductsRestController.class);
		return ResponseEntity.ok(productsService.findRelactions(String.valueOf(productId)));

	}

}
