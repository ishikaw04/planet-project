package com.example.planet.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "update_history")
@Data
public class UpdateHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "history_id")
	private Integer historyId;  // 主キー ※暗黙的にNOT NULLになる
	
	@Column(name = "admin_id", nullable = false)
	private Integer adminId;
	
	@Column(name = "data_type", nullable = false, length = 20)
	@Enumerated(EnumType.STRING)
	private DataType dataType;
	
	@Column(name = "updated_at", nullable = false)
	private LocalDateTime updatedAt;
	
	// -- 外部キー関連 --
	@ManyToOne
	@JoinColumn(name = "admin_id", insertable = false, updatable = false)
	private Admins admin;
	
	// -- Enum クラス 内部のみで使用 --
	public enum DataType {
		登録品種,
		流通品種
	}
}