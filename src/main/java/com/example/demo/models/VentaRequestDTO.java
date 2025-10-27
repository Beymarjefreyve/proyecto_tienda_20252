package com.example.demo.models;

import java.util.List;

public class VentaRequestDTO {
	
	private String documento;
	
	private List<Producto_Venta> detalle;

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public List<Producto_Venta> getDetalle() {
		return detalle;
	}

	public void setDetalle(List<Producto_Venta> detalle) {
		this.detalle = detalle;
	}

	public String getDocumento() {
		return documento;
	}
	
	
}