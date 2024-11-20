package com.Project.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Project.Dio.Apiserviece;
import com.Project.Services.Shippingaddressservices;
import com.Project.model.ShippingAddress;

@Controller
@RequestMapping("/Api/Webservice/shippingaddress")
public class ShippingController {

	@Autowired
	private Shippingaddressservices shippingaddressservices;

	@PostMapping("/create/{userId}")
	public ResponseEntity<Apiserviece<ShippingAddress>> create(@PathVariable Long userId,
			@RequestBody ShippingAddress shippingAddress) {

		ShippingAddress shippingAddress2 = shippingaddressservices.createaddresse(userId, shippingAddress);
		Apiserviece<ShippingAddress> apiserviece = new Apiserviece<ShippingAddress>(true,
				"Shipping Address is created successfully", shippingAddress2);
		return new ResponseEntity<>(apiserviece, HttpStatus.OK);

	}

	@PutMapping("/update")
	public ResponseEntity<Apiserviece<ShippingAddress>> updateaddress(@RequestBody ShippingAddress shippingAddress) {

		ShippingAddress address = shippingaddressservices.updateaddress(shippingAddress);
		Apiserviece<ShippingAddress> apiserviece = new Apiserviece<ShippingAddress>(true, "Address is updated ",
				address);
		return new ResponseEntity<>(apiserviece, HttpStatus.OK);

	}

	@DeleteMapping("/delete/{addressid}")
	public ResponseEntity<Apiserviece<Void>> deleteaddress(@PathVariable long addressid) {
		shippingaddressservices.deleteAddress(addressid);
		Apiserviece<Void> apiserviece = new Apiserviece<Void>(true, "address is deleted", null);
		return new ResponseEntity<>(apiserviece, HttpStatus.NO_CONTENT);

	}
}
