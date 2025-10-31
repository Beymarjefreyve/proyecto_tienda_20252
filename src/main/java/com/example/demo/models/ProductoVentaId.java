package com.example.demo.models;

import java.io.Serializable;
import java.util.Objects;

public class ProductoVentaId implements Serializable {

    private Integer ventaId;
    private Integer productoId;

    public ProductoVentaId() {}

    public ProductoVentaId(Integer ventaId, Integer productoId) {
        this.ventaId = ventaId;
        this.productoId = productoId;
    }

    // Getters, setters y equals/hashCode

    public Integer getVentaId() {
        return ventaId;
    }

    public void setVentaId(Integer ventaId) {
        this.ventaId = ventaId;
    }

    public Integer getProductoId() {
        return productoId;
    }

    public void setProductoId(Integer productoId) {
        this.productoId = productoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductoVentaId)) return false;
        ProductoVentaId that = (ProductoVentaId) o;
        return Objects.equals(ventaId, that.ventaId) &&
               Objects.equals(productoId, that.productoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ventaId, productoId);
    }
}
