package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Venta {
    
	@Id
	private Integer id;
    
	private String fecha;
    
	private Integer clienteId;
    
	private Double total;
}
