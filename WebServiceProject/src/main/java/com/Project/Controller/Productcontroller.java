package com.Project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Project.Dio.Apiserviece;
import com.Project.Dio.Pagenation;
import com.Project.Services.ProductService;
import com.Project.model.Product;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/Api/Webservice/product")
public class Productcontroller {
	@Autowired
	private ProductService productService;

	@PostMapping("/create/{categoryId}/{userId}")
	public ResponseEntity<Apiserviece<Product>> create(@Valid @RequestBody Product product,
			@PathVariable Long categoryId, @PathVariable Long userId) {

		Product product2 = productService.CreateProduct(product, categoryId, userId);
		Apiserviece<Product> apiserviece = new Apiserviece<Product>(true, "Product Added succesfully", product2);
		return new ResponseEntity<>(apiserviece, HttpStatus.OK);
	}

	@GetMapping("/getallproducts")
	public ResponseEntity<Apiserviece<Pagenation<Product>>> getallproducts(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int size) {
		Pagenation<Product> pagenation = productService.getallproducts(page, size);
		Apiserviece<Pagenation<Product>> apiserviece = new Apiserviece<Pagenation<Product>>(true,
				"All Products are retrive", pagenation);
		return new ResponseEntity<>(apiserviece, HttpStatus.OK);

	}

	@PutMapping("/update")
	public ResponseEntity<Apiserviece<Product>> updateproduct(@RequestBody Product product) {

		Product product2 = productService.updateprodcut(product);

		Apiserviece<Product> apiserviece = new Apiserviece<Product>(true, "Product is suceesfully update", product2);
		return new ResponseEntity<>(apiserviece, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{productId}")
	public ResponseEntity<Apiserviece<Void>> deleteproduct(@PathVariable long productId) {

		productService.deleteproducut(productId);
		Apiserviece<Void> apiserviece = new Apiserviece<Void>(true, "product is sueesfully delete", null);
		return new ResponseEntity<>(apiserviece, HttpStatus.OK);

	}
}
