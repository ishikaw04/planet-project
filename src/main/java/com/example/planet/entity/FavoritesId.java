package com.example.planet.entity;
import java.io.Serializable;

import lombok.Data;

@Data
public class FavoritesId implements Serializable {
	private Integer userId;
	private String applicationNo;
}