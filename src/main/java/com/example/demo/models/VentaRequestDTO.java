package com.example.demo.models;

import java.util.List;

public class VentaRequestDTO {
	
	private String documento; 
	
    private List<ProductoDetalleDTO> detalle;

    // Getters y setters

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public List<ProductoDetalleDTO> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<ProductoDetalleDTO> detalle) {
        this.detalle = detalle;
    }
}
