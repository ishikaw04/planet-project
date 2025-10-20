package com.example.planet.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "favorites")
@Data
@IdClass(FavoritesId.class) // 補助クラス
public class Favorites {
	@Id
	@Column(name = "user_id")
	private Integer userId; // 複合キー
	
	@Id
	@Column(name = "application_no", length = 20)
	private Integer applicationNo; // 複合キー
	
	@Column(name = "registered_at")
	private LocalDateTime registeredAt;	
	
	// -- 外部キー関連 --
	@ManyToOne
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	private Users user;
	
	@ManyToOne
	@JoinColumn(name = "application_no", insertable = false, updatable = false)
	private RegisteredVarieties registeredVariety;
}