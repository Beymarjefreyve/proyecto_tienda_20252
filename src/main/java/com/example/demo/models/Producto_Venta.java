package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Producto_Venta {
	
	@Id
	private Integer ventaId;
	
    private Integer productoId; // PRODUCTO
    
    private Integer cantidad;
    
    private Double precio;
}
