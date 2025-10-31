package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.models.Venta;
import com.example.demo.services.VentaService;

public class VentaController {
	@Autowired
    private VentaService ventaService;

    @PostMapping
    public Venta registrar(@RequestBody Venta venta) {
        //return ventaService.registrarVenta(venta);
    	return null;
    }

    @GetMapping
    public List<Venta> listar() {
        //return ventaService.listar();
    	return null;
    }
}
