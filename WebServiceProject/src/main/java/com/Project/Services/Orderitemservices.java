package com.Project.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.Repository.OrderitemRespository;
import com.Project.Repository.ProductRepository;
import com.Project.model.OrderItem;
import com.Project.model.Product;

@Service
public class Orderitemservices {

	@Autowired
	private OrderitemRespository orderitemRespository;
	@Autowired
	private ProductRepository productRepository;

	public OrderItem createorderitem(OrderItem orderItem, Long productId) {

		Product product = productRepository.findByproductId(productId);
		if (product == null) {
			throw new RuntimeException("Product with ID " + productId + " not found.");
		}

		orderItem.setProduct(product);
		orderItem.calculateItemTotal();
		return orderitemRespository.save(orderItem);
	}

}
