package com.Project.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "stock_history")
public class StockHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long stockHistoryId;
	private int quantity;
	private String description;
	@Enumerated(EnumType.STRING)
	private StockActionType actionType;
	@CreationTimestamp
	@Column(name = "created_at", updatable = false)
	private LocalDateTime createdAt;
	@UpdateTimestamp
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
	
}

enum StockActionType{
	RESTOCK, MANUAL_ADJUSTMENT
}
