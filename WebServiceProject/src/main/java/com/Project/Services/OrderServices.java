package com.Project.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Project.Repository.OrderRepository;
import com.Project.Repository.OrderitemRespository;
import com.Project.Repository.ProductRepository;
import com.Project.Repository.ShippingaddressRepository;
import com.Project.Repository.UserRepository;
import com.Project.model.Order;
import com.Project.model.OrderItem;
import com.Project.model.ShippingAddress;
import com.Project.model.User;

@Service
public class OrderServices {

	@Autowired
	private OrderRepository repository;

	@Autowired
	private OrderitemRespository orderitemRespository;

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ShippingaddressRepository shippingaddressRepository;

	@Transactional
	public Order createOrder(Order order) {

		/*
		 * User user = userRepository.findByUserid(userId).orElseThrow(() -> new
		 * RuntimeException("User not found"));
		 * 
		 * // Find shipping address by shippingId ShippingAddress shippingAddress =
		 * shippingaddressRepository.findById(shippingId) .orElseThrow(() -> new
		 * RuntimeException("Shipping address not found"));
		 * 
		 * // Create new order Order order = new Order(); order.setUser(user);
		 * order.setShippingAddress(shippingAddress); order.setTotalAmount(0);
		 * order.setStatus(null);
		 */

		return repository.save(order);
	}

	@Transactional
	public Order saveOrder(Order order) {
		order.recalculateTotalAmount(); // Ensure total amount is recalculated
		return repository.save(order);
	}

	@Transactional
	public Order updateOrderItemQuantity(OrderItem orderItem, int newQuantity) {
		orderItem.setQuantity(newQuantity);
		orderItem.calculateItemTotal(); // Updates itemTotal
		orderItem.getOrder().recalculateTotalAmount(); // Recalculates order total
		return repository.save(orderItem.getOrder());
	}

}
