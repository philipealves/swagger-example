package br.com.philipe.swaggerExample.controller.request;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

public class ProductCreationRequest {

	@ApiModelProperty(dataType = "String", value = "Product name", required = true)
	@NotNull
	private String name;

	@ApiModelProperty(dataType = "String", value = "Product description", required = true)
	@NotNull
	private String description;

	@ApiModelProperty(dataType = "String", value = "Product price", required = true)
	@NotNull
	private BigDecimal price;

	public ProductCreationRequest() {
		super();
	}

	public ProductCreationRequest(String name, String description, BigDecimal price) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
