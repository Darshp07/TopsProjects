package com.Project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Project.Dio.Apiserviece;
import com.Project.Services.Orderitemservices;
import com.Project.model.OrderItem;

@Controller
@RequestMapping("/Api/Webservice/itemorder")
public class ItemOrderController {
	@Autowired
	private Orderitemservices orderitemservices;

	@PostMapping("/create/{productId}")
	public ResponseEntity<Apiserviece<OrderItem>> Create(@RequestBody OrderItem orderItem,@PathVariable Long productId) {
		OrderItem orderItem2 = orderitemservices.createorderitem(orderItem, productId);

		Apiserviece<OrderItem> apiserviece = new Apiserviece<OrderItem>(true, "orderitem is succesfully added ",
				orderItem2);

		return new ResponseEntity<>(apiserviece, HttpStatus.OK);

	}

}
