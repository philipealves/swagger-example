package br.com.philipe.swaggerExample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.philipe.swaggerExample.controller.request.ProductCreationRequest;
import br.com.philipe.swaggerExample.controller.request.ProductRequest;
import br.com.philipe.swaggerExample.controller.response.ProductResponse;
import br.com.philipe.swaggerExample.controller.response.ProductsResponse;
import br.com.philipe.swaggerExample.model.Product;
import br.com.philipe.swaggerExample.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/products")
@Api(value = "Product Service API", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ProductController {

	@Autowired
	private ProductService productService;

	@ApiOperation(value = "Get Products", nickname = "getProducts", notes = "Returns a list of products.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Product.class),
			@ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 500, message = "Failure") })
	@RequestMapping(path = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<ProductsResponse> getProducts() {

		ProductsResponse products = new ProductsResponse();
		products.setProducts(this.productService.findAll());

		return new ResponseEntity<ProductsResponse>((ProductsResponse) products, HttpStatus.valueOf(200));

	}

	@ApiOperation(value = "Get Product", nickname = "getProduct", notes = "Returns a specific product.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Product.class),
			@ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 500, message = "Failure") })
	@RequestMapping(path = "/{uid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<ProductResponse> getProduct(@PathVariable("uid") Long productId) {

		ProductResponse response = new ProductResponse();
		response.setProduct(this.productService.getById(productId));

		return new ResponseEntity<ProductResponse>(response, HttpStatus.valueOf(200));

	}

	@ApiOperation(value = "Save Product", nickname = "saveProduct", notes = "Save a product.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Product.class),
			@ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 500, message = "Failure") })
	@RequestMapping(path = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<ProductResponse> save(@RequestBody ProductCreationRequest product) {

		ProductResponse response = new ProductResponse();
		response.setProduct(this.productService.save(product));

		return new ResponseEntity<ProductResponse>(response, HttpStatus.valueOf(200));

	}

	@ApiOperation(value = "Update Product", nickname = "updateProduct", notes = "Update a product.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Product.class),
			@ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 500, message = "Failure") })
	@RequestMapping(path = "/", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<ProductResponse> update(@RequestBody ProductRequest product) {

		ProductResponse response = new ProductResponse();
		response.setProduct(this.productService.update(product));

		return new ResponseEntity<ProductResponse>(response, HttpStatus.valueOf(200));

	}

	@ApiOperation(value = "Delete Product", nickname = "deleteProduct", notes = "Delete a product.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Product.class),
			@ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 500, message = "Failure") })
	@RequestMapping(path = "/", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<ProductResponse> delete(Long productId) {

		ProductResponse response = new ProductResponse();
		response.setProduct(this.productService.delete(productId));

		return new ResponseEntity<ProductResponse>(response, HttpStatus.valueOf(200));

	}
}
