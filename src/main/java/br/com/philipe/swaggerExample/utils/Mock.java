package br.com.philipe.swaggerExample.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import br.com.philipe.swaggerExample.controller.request.ProductCreationRequest;
import br.com.philipe.swaggerExample.controller.request.ProductRequest;
import br.com.philipe.swaggerExample.model.Product;
import br.com.philipe.swaggerExample.template.ProductTemplate;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

@Component
public class Mock {

	@PostConstruct
	public void initIt() {
		FixtureFactoryLoader.loadTemplates(ProductTemplate.class.getPackage().getName());
	}

	public Product getById(Long productId) {
		Product product = Fixture.from(Product.class).gimme(ProductTemplate.NEW);
		product.setUid(productId);
		return product;
	}

	public List<Product> findAll() {
		List<Product> list = new ArrayList<Product>();
		for (int i = 0; i < new Random().nextInt(20); i++) {
			Product product = Fixture.from(Product.class).gimme(ProductTemplate.NEW_WITH_ID);
			list.add(product);
		}

		return list;
	}

	public Product save(ProductCreationRequest product) {
		Product p = new Product(1L, product.getName(), product.getDescription(),
				product.getPrice());
		return p;
	}

	public Product update(ProductRequest product) {
		Product p = new Product(product.getUid(), product.getName(), product.getDescription(), product.getPrice());
		return p;
	}

	public Product delete(Long productId) {
		Product product = Fixture.from(Product.class).gimme(ProductTemplate.NEW);
		product.setUid(productId);
		return product;
	}
}
