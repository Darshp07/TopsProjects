package com.Project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Project.model.OrderItem;

public interface OrderitemRespository extends JpaRepository<OrderItem, Long> {

}
