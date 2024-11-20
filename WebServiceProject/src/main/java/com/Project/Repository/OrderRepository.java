package com.Project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Project.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
