package com.prueba.controller.vo;

import java.util.LinkedList;

import org.springframework.validation.annotation.Validated;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Schema(description = "Product detail")
@Validated

@AllArgsConstructor
@Builder
@Getter
@Setter
public class SimilarProducts extends LinkedList<ProductDetail> {


	/**
	 * 
	 */
	private static final long serialVersionUID = -6609554814397701519L;

}
