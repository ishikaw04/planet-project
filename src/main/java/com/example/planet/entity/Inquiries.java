package com.example.planet.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "inquiries")
@Data
public class Inquiries {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "inquiry_id")
	private Integer inquiryId; /* 主キー */
	
	@Column(name = "user_id", nullable = false)
	private Integer userId;
	
	@Column(name = "subject", nullable = false, length = 100)
	private String subject;
	
	@Column(name = "message", nullable = false, columnDefinition = "TEXT")
	private String message;
	
	@Column(name = "sent_at")
	private LocalDate sentAt;
	
	@Column(name = "status", nullable = false, length = 10)
	private InquiryStatus status;
	
	@Column(name = "responded_at")
	private LocalDate respondedAt;
	
	// -- 外部キー関連 --
	@ManyToOne
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	private Users user;
}