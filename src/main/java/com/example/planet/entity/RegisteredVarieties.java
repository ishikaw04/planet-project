package com.example.planet.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "registered_varieties")
@Data
public class RegisteredVarieties {
	@Id
	@Column(name = "application_no")
	private Integer applicationNo; /*主キー ※暗黙的にNOT NULLになる*/
	
	@Column(name = "registration_no", length = 20)
	private String registrationNo; 

	@Column(name = "plant_type", length = 255)
	private String plantType;

	@Column(name = "variety_name", length = 100)
	private String varietyName;

	@Column(name = "variety_name_kana", length = 100)
	private String varietyNameKana;

	@Column(name = "publication_date")
	private LocalDate publicationDate;

	@Column(name = "applicant", length = 150)
	private String applicant;
	
	@Column(name = "registration_publication_date")
	private LocalDate registrationPublicationDate;
}