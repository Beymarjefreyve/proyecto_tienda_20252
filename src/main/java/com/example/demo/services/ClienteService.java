package com.example.demo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Cliente;
import com.example.demo.repository.ClienteRepository;

@Repository
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	public Cliente getCliente(String documento) {
		return clienteRepository.findByDocumento(documento);
	}

	public boolean removeCliente(String documento) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<Cliente> listarClientes() {
		return (ArrayList<Cliente>) clienteRepository.findAll();
	}

	public Cliente saveCliente(Cliente clienteNew) {
		
        Cliente cliente = clienteRepository.findByDocumento(clienteNew.getDocumento());
        
        if (cliente != null) {
            cliente.setNombre(clienteNew.getNombre());
            cliente.setDocumento(clienteNew.getDocumento());
            cliente.setFecha_naciemiento(clienteNew.getFecha_naciemiento());
            cliente.setEmail(clienteNew.getEmail());
            return clienteRepository.save(cliente);
        }
        // Si no existe, lo crea
        return clienteRepository.save(cliente);
	}

	public Cliente updateCliente(String documento, Cliente cliente) {
		// TODO Auto-generated method stub
		return null;
	}
}
