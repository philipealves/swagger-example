package br.com.philipe.swaggerExample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.philipe.swaggerExample.controller.request.ProductCreationRequest;
import br.com.philipe.swaggerExample.controller.request.ProductRequest;
import br.com.philipe.swaggerExample.model.Product;
import br.com.philipe.swaggerExample.utils.Mock;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private Mock mock;

	@Override
	public Product getById(Long productId) {
		return this.mock.getById(productId);
	}

	@Override
	public List<Product> findAll() {
		return this.mock.findAll();
	}

	@Override
	public Product save(ProductCreationRequest product) {
		return this.mock.save(product);
	}

	@Override
	public Product update(ProductRequest product) {
		return this.mock.update(product);
	}

	@Override
	public Product delete(Long productId) {
		return this.mock.delete(productId);
	}

}
