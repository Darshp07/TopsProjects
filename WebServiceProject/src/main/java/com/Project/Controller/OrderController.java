package com.Project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Project.Dio.Apiserviece;
import com.Project.Services.OrderServices;
import com.Project.model.Order;

@Controller
@RequestMapping("/Api/Webservice/order")
public class OrderController {
	@Autowired
	private OrderServices orderServices;

	@PostMapping("/create")
	public ResponseEntity<Apiserviece<Order>> create(@RequestParam Order order) {
		Order orders = orderServices.createOrder(order);

		Apiserviece<Order> apiserviece = new Apiserviece<Order>(true, "oreder is created ", orders);

		return new ResponseEntity<>(apiserviece, HttpStatus.OK);

	}
}
