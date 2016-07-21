package br.com.philipe.swaggerExample.model;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

public class Product extends AppEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1609851070752417299L;

	@NotNull
	@ApiModelProperty(dataType = "String", value = "Product name", required = true)
	private String name;

	@NotNull
	@ApiModelProperty(dataType = "String", value = "Product description", required = true)
	private String description;

	@NotNull
	@ApiModelProperty(dataType = "String", value = "Product price", required = true)
	private BigDecimal price;

	public Product() {
		super();
	}

	public Product(Long uid, String name, String description, BigDecimal price) {
		super(uid);
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public Product(String name, String description, BigDecimal price) {
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
