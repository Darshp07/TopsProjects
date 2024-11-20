package com.Project.model;

import java.time.LocalDateTime;


import org.hibernate.annotations.CreationTimestamp;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//https://github.com/abinashpanigrahi/ECommerce-SpringBoot-Backend-Project/tree/main/E-Commerce-Backend

@Entity
@Table(name = "wishLists")
public class WishList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long wishListId;
	
	@CreationTimestamp
	@Column(name = "created_at", updatable = false)
	private LocalDateTime createdAt;

	
}
