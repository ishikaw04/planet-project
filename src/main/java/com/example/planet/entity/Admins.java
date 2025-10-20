package com.example.planet.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "admins")
@Data
public class Admins {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "admin_id")
	private Integer adminId;  // 主キー ※暗黙的にNOT NULLになる
	
	@Column(name = "admin_name", nullable = false,  length = 100)
	private String adminName;
	
	@Column(name = "password", nullable = false, length = 255)
	private String password;	
}