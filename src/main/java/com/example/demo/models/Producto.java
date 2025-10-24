package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Producto {
	
	@Id
	private Integer id;
    
	private String nombre;
    
	private String descripcion;
    
	private Double precio;
    
	private Integer tipoId; // CATEGORIA
}
