package com.example.demo.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Cliente;
import com.example.demo.models.Producto;
import com.example.demo.models.ProductoVentaId;
import com.example.demo.models.Producto_Venta;
import com.example.demo.models.Venta;
import com.example.demo.models.VentaRequestDTO;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.ProductoRepository;
import com.example.demo.repository.VentaRepository;

@Repository
public class VentaService {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	VentaRepository ventaRepository;
	

	@Autowired
	ProductoRepository productoRepository;
	
	public void registrarVenta(VentaRequestDTO venta) {
		
	    String documento = venta.getDocumento();

	    Cliente cliente = clienteRepository.findById(documento)
	            .orElseThrow(() -> new RuntimeException("Cliente no encontrado: " + documento));

	    Venta ventaNew = new Venta();
	    ventaNew.setClienteId(cliente.getDocumento());
	    ventaNew.setFecha(LocalDateTime.now());

	    //List<ProductoVentaId> detallesVenta = cliente.getVentas();
	
	    
	    /*
	    for (Producto_Venta detalles : detallesVenta) {

	        Producto producto = productoRepository.findById(detalleReq.getProductoId())
	                .orElseThrow(() -> new RuntimeException("Producto no encontrado: " + detalleReq.getProductoId()));

	        // Validar stock disponible
	        if (producto.getStock() < detalleReq.getCantidad()) {
	            throw new RuntimeException("Stock insuficiente para producto: " + producto.getNombre());
	        }

	        // Calcular subtotal del producto
	        BigDecimal subtotal = producto.getPrecio().multiply(BigDecimal.valueOf(detalleReq.getCantidad()));
	        totalVenta = totalVenta.add(subtotal);

	        // Descontar stock
	        producto.setStock(producto.getStock() - detalleReq.getCantidad());
	        productoRepository.save(producto);

	        // Crear detalle de venta
	        Producto_Venta detalle = new Producto_Venta();
	        detalle.setVenta(venta);
	        detalle.setProducto(producto);
	        detalle.setCantidad(detalleReq.getCantidad());
	        detalle.setPrecioUnitario(producto.getPrecio());
	        detalle.setSubtotal(subtotal);

	        detallesVenta.add(detalle);
	    }

	    // 4. Guardar venta principal
	    venta.setTotal(totalVenta);
	    ventaRepository.save(venta);

	    // 5. Guardar detalles
	    for (Producto_Venta det : detallesVenta) {
	        productoVentaRepository.save(det);
	    }

	  */
	}
	
	
}
