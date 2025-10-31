package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Cliente;
import com.example.demo.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> listar() {
        return clienteService.listarClientes();
    }

    @GetMapping("/{documento}")
    public Cliente obtener(@PathVariable String documento) {
        return clienteService.obtenerClientePorDocumento(documento).orElse(null);
    }

    @PostMapping
    public Cliente crear(@RequestBody Cliente cliente) {
        return clienteService.crearCliente(cliente);
    }

    @PutMapping("/{documento}")
    public Cliente actualizar(@PathVariable String documento, @RequestBody Cliente cliente) {
        return clienteService.actualizarCliente(documento, cliente); 
    }

    @DeleteMapping("/{documento}")
    public String eliminar(@PathVariable String documento) {
        boolean eliminado = clienteService.eliminarCliente(documento);
        if (eliminado) {
            return "Cliente eliminado: " + documento;
        } else {
            return "No se encontró cliente con documento: " + documento;
        }
    }
}
