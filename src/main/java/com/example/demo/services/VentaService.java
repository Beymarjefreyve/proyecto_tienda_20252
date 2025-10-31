package com.example.demo.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.models.Cliente;
import com.example.demo.models.Producto;
import com.example.demo.models.ProductoDetalleDTO;
import com.example.demo.models.ProductoVenta;
import com.example.demo.models.ProductoVentaId;
import com.example.demo.models.Venta;
import com.example.demo.models.VentaRequestDTO;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.ProductoRepository;
import com.example.demo.repository.ProductoVentaRepository;
import com.example.demo.repository.VentaRepository;

@Service
public class VentaService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ProductoVentaRepository productoVentaRepository;

    public boolean registrarVenta(VentaRequestDTO ventaDTO) {
        try {
            // 1. Buscar cliente
            String documento = ventaDTO.getDocumento();
            Cliente cliente = clienteRepository.findById(documento)
                    .orElseThrow(() -> new RuntimeException("Cliente no encontrado: " + documento));

            // 2. Crear la venta principal
            Venta venta = new Venta();
            venta.setClienteId(cliente.getDocumento());
            venta.setFecha(LocalDateTime.now());
            venta.setTotal(0D);

            venta = ventaRepository.save(venta);

            // 3. Procesar los productos del detalle
            double totalVenta = 0D;

            for (ProductoDetalleDTO detalleReq : ventaDTO.getDetalle()) {
                Producto producto = productoRepository.findById(detalleReq.getProductoId())
                        .orElseThrow(() -> new RuntimeException("Producto no encontrado: " + detalleReq.getProductoId()));

                // Validar stock
                if (producto.getStock() < detalleReq.getCantidad()) {
                    throw new RuntimeException("Stock insuficiente para producto: " + producto.getNombre());
                }

                // Calcular subtotal (precio × cantidad)
                double subtotal = producto.getPrecio() * detalleReq.getCantidad();
                totalVenta += subtotal;

                // Descontar stock
                producto.setStock(producto.getStock() - detalleReq.getCantidad());
                productoRepository.save(producto);

                // Crear detalle de la venta
                ProductoVenta detalle = new ProductoVenta();
                ProductoVentaId id = new ProductoVentaId(venta.getId(), producto.getId());
                detalle.setId(id);
                detalle.setVenta(venta);
                detalle.setProducto(producto);
                detalle.setCantidad(detalleReq.getCantidad());

                productoVentaRepository.save(detalle);
            }

            // 4. Actualizar total de la venta
            venta.setTotal(totalVenta);
            ventaRepository.save(venta);

            return true; // Venta registrada correctamente

        } catch (Exception e) {
            System.out.println("Error al registrar venta: " + e.getMessage());
            return false;
        }
    }
}
/*
 * public void registrarVenta(VentaRequestDTO venta) {
 * 
 * String documento = venta.getDocumento();
 * 
 * Cliente cliente = clienteRepository.findById(documento) .orElseThrow(() ->
 * new RuntimeException("Cliente no encontrado: " + documento));
 * 
 * Venta ventaNew = new Venta(); ventaNew.setClienteId(cliente.getDocumento());
 * ventaNew.setFecha(LocalDateTime.now());
 * 
 * //List<ProductoVentaId> detallesVenta = cliente.getVentas();
 * 
 * 
 * 
 * for (Producto_Venta detalles : detallesVenta) {
 * 
 * Producto producto = productoRepository.findById(detalleReq.getProductoId())
 * .orElseThrow(() -> new RuntimeException("Producto no encontrado: " +
 * detalleReq.getProductoId()));
 * 
 * // Validar stock disponible if (producto.getStock() <
 * detalleReq.getCantidad()) { throw new
 * RuntimeException("Stock insuficiente para producto: " +
 * producto.getNombre()); }
 * 
 * // Calcular subtotal del producto BigDecimal subtotal =
 * producto.getPrecio().multiply(BigDecimal.valueOf(detalleReq.getCantidad()));
 * totalVenta = totalVenta.add(subtotal);
 * 
 * // Descontar stock producto.setStock(producto.getStock() -
 * detalleReq.getCantidad()); productoRepository.save(producto);
 * 
 * // Crear detalle de venta Producto_Venta detalle = new Producto_Venta();
 * detalle.setVenta(venta); detalle.setProducto(producto);
 * detalle.setCantidad(detalleReq.getCantidad());
 * detalle.setPrecioUnitario(producto.getPrecio());
 * detalle.setSubtotal(subtotal);
 * 
 * detallesVenta.add(detalle); }
 * 
 * // 4. Guardar venta principal venta.setTotal(totalVenta);
 * ventaRepository.save(venta);
 * 
 * // 5. Guardar detalles for (Producto_Venta det : detallesVenta) {
 * productoVentaRepository.save(det); }
 * 
 */
