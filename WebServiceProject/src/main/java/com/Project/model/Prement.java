package com.Project.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "prements")
public class Prement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long prementId;
	private Double amount;
	@Enumerated(EnumType.STRING)
	private Method method;
	@Enumerated(EnumType.STRING)
	private Status status;

	@CreationTimestamp
	@Column(name = "created_at", updatable = false)
	private LocalDateTime createdAt;

}

enum Method {
	CRADIT_CARD, ONLINE, NET_BANKING, DABIT_CARD, CASH_ON_DELIVERY
}

enum Status {
	COMPLITED, FAILED
}