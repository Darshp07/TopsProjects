package com.Project.Services;

import java.util.Collections;

import java.util.List;

import com.Project.model.User;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.Project.Dio.Pagenation;
import com.Project.Repository.CategoryRepository;
import com.Project.Repository.ProductRepository;
import com.Project.Repository.UserRepository;
import com.Project.model.Category;
import com.Project.model.Product;

import jakarta.validation.Valid;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryrepository;

	@Autowired
	private UserRepository repository;

	public Product CreateProduct(@Valid Product product, Long categoryId, Long userId) {

		Category category = categoryrepository.findBycategoryId(categoryId)
				.orElseThrow(() -> new RuntimeException("Category not found with id " + categoryId));
		product.setCategory(category);

		User user = repository.findByUserid(userId)
				.orElseThrow(() -> new RuntimeException("User not found with id " + userId));
		product.getCreate_by().add(user);

		return productRepository.save(product);
	}

	public Pagenation<Product> getallproducts(int page, int size) {

		PageRequest pageRequest = PageRequest.of(page - 1, size);
		Page<Product> page2 = productRepository.findAll(pageRequest);
		List<Product> listProducts = page2.getContent();

		Pagenation<Product> pagenation = new Pagenation<>(page2.getNumber() + 1, page2.getTotalPages(),
				page2.getTotalElements(), page2.getSize(), listProducts);

		return pagenation;
	}

	public Product updateprodcut(Product product) {
		Optional<Product> optional = productRepository.findByProductId(product.getProductId());

		Product product2 = optional.get();
		product2.setName(product.getName());
		product2.setDescription(product.getDescription());
		product2.setPrice(product.getPrice());
		product2.setImageUrl(product.getImageUrl());
		product2.setStock(product.getStock());
		product2.setReorderThreshold(product.getReorderThreshold());
		product2.setCategory(product.getCategory());
		return product2;
	}

	public void deleteproducut(long productId) {

		productRepository.deleteByproductId(productId);

	}

}
