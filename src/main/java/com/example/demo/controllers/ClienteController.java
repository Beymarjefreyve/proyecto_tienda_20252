package com.example.demo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
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
	ClienteService clienteService;
	
	@GetMapping("/{documento}")
	public Cliente getCliente(@PathVariable String documento) {
		return clienteService.getCliente(documento);
	}
	
	@DeleteMapping("/{documento}")
    public String eliminarCliente(@PathVariable String documento) {
        
		Cliente cliente = this.getCliente(documento);
		
		if(clienteService.removeCliente(documento)) {
        	return "Se eliminó corractamente al cliente" + cliente;
        }
		
		return "No se pudo eliminar al cliente: " + documento;
    }
	
    @GetMapping
    public ArrayList<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }


    // Registrar nuevo cliente
    @PostMapping
    public Cliente registrarCliente(@RequestBody Cliente cliente) {
        return clienteService.saveCliente(cliente);
    }

    // Actualizar cliente existente
    @PutMapping("/{id}")
    public Cliente actualizarCliente(@PathVariable String documento, @RequestBody Cliente cliente) {
        return clienteService.updateCliente(documento, cliente);
    }

}
