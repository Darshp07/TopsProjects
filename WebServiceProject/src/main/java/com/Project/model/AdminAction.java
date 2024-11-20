package com.Project.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "admin_logs")
public class AdminAction {

	@Id
	private Long logId;
	@Enumerated(EnumType.STRING)
	private Action actionType;
	private String description;
	@CreationTimestamp
	@Column(name = "created_at", updatable = false)
	private LocalDateTime createdAt;
}

enum Action{
	INSERT, UPDATE, DELETE, READ
}
