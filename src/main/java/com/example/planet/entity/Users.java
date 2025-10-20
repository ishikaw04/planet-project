package com.example.planet.entity;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer userId;  // 主キー ※暗黙的にNOT NULLになる
	
	@Column(name = "username", nullable = false, unique = true, length = 50)
	private String username;
	
	@Column(name = "password", nullable = false, length = 255)
	private String password;
	
	// -- 関連テーブル --
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Favorites> favorites; // お気に入り
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Inquiries> inquiries; // お問い合わせ
}