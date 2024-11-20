package com.Project.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.Repository.ShippingaddressRepository;
import com.Project.Repository.UserRepository;
import com.Project.model.ShippingAddress;
import com.Project.model.User;

@Service
public class Shippingaddressservices {

	@Autowired
	private ShippingaddressRepository shippingaddressRepository;
	@Autowired
	private UserRepository userRepository;

	public ShippingAddress createaddresse(Long userid, ShippingAddress shippingAddress) {

		User user = userRepository.findByUserid(userid).orElseThrow(() -> new RuntimeException("User not found"));

		shippingAddress.setUser(user);

		return shippingaddressRepository.save(shippingAddress);
	}

	public ShippingAddress updateaddress(ShippingAddress shippingAddress) {
		Optional<ShippingAddress> optional = shippingaddressRepository.findById(shippingAddress.getAddressId());

		ShippingAddress address = optional.get();
		address.setAddressLine1(shippingAddress.getAddressLine1());
		address.setAddressLine2(shippingAddress.getAddressLine2());
		address.setCity(shippingAddress.getCity());
		address.setState(shippingAddress.getState());
		address.setCountry(shippingAddress.getCountry());
		address.setZipcode(shippingAddress.getZipcode());

		return shippingaddressRepository.save(address);
	}

	public void deleteAddress(long addressid) {

		shippingaddressRepository.deleteById(addressid);

	}
}
