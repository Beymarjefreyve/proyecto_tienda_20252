package com.example.demo.models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Cliente {
	
	@Id
	private String documento;
	
	private String nombre;
	
	private Date fecha_naciemiento;
	
	private String email;
	
	
}
