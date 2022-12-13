package com.prueba.controller.vo;

import java.math.BigDecimal;

import org.springframework.validation.annotation.Validated;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Product detail
 */
@Schema(description = "Product detail")
@Validated

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class ProductDetail {
	private String id ;
	private String name;
	private BigDecimal price ;
	private boolean availability ;
	public Object compareTo(ProductDetail o2) {
		return o2.getId().compareTo(id);
	}

}
