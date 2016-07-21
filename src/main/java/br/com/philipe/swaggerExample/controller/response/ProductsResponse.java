package br.com.philipe.swaggerExample.controller.response;

import java.util.List;

import br.com.philipe.swaggerExample.model.Product;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Products")
public class ProductsResponse {

	@ApiModelProperty(dataType = "List", value = "List of products", required = true)
	private List<Product> products;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
