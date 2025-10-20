package com.example.planet.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "distributed_varieties")
@Data
public class DistributedVarieties { // 流通品種
	@Id
	@Column(name = "application_no")
	private Integer applicationNo; // 主キー ※暗黙的にNOT NULLになる
	
	@Column(name = "product_name", length = 100)
	private String productName; 

	@Column(name = "product_name_kana", length = 100)
	private String productNameKana; 
	
	@Column(name = "common_name", length = 255)
	private String commonName; 
}