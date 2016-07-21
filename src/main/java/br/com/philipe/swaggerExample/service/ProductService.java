package br.com.philipe.swaggerExample.service;

import java.util.List;

import br.com.philipe.swaggerExample.controller.request.ProductCreationRequest;
import br.com.philipe.swaggerExample.controller.request.ProductRequest;
import br.com.philipe.swaggerExample.model.Product;

public interface ProductService {

	Product getById(Long productId);

	List<Product> findAll();

	Product save(ProductCreationRequest product);

	Product update(ProductRequest product);

	Product delete(Long productId);

}
