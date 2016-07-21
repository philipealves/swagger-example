package br.com.philipe.swaggerExample.controller.response;

import br.com.philipe.swaggerExample.model.Product;
import io.swagger.annotations.Api;

@Api(value = "Product Response")
public class ProductResponse {

	private Product product;

	public ProductResponse() {
		super();
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
