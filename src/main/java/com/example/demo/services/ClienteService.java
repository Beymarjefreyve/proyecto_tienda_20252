package com.example.demo.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.models.Cliente;
import com.example.demo.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> obtenerClientePorDocumento(String documento) {
        return clienteRepository.findById(documento);
    }

    
    public Cliente crearCliente(Cliente cliente) {
        // validar si existe el documento
        if (clienteRepository.existsById(cliente.getDocumento())) {
            throw new RuntimeException("Ya existe un cliente con documento: " + cliente.getDocumento());
        }
        
        return clienteRepository.save(cliente);
    }

    public Cliente actualizarCliente(String documento, Cliente datos) {
        return clienteRepository.findById(documento).map(c -> {
            c.setNombre(datos.getNombre());
            c.setFechaNacimiento(datos.getFechaNacimiento());
            c.setEmail(datos.getEmail());
            return clienteRepository.save(c);
        }).orElseThrow(() -> new RuntimeException("Cliente no encontrado: " + documento));
    }

    public boolean eliminarCliente(String documento) {
        try {
            clienteRepository.deleteById(documento);
            return true; 
        } catch (EmptyResultDataAccessException ex) {
            return false; 
        }
    }
}
