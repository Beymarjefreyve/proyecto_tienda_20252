package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Cliente;
import com.example.demo.repository.ClienteRepository;

@Repository
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	public Cliente getCliente(String id) {
		return clienteRepository.findById(id).orElse(null);
	}
}
