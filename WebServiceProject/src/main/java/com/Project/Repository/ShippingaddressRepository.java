package com.Project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Project.model.ShippingAddress;

public interface ShippingaddressRepository extends JpaRepository<ShippingAddress, Long>{

}
