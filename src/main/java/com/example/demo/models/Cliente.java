package com.example.demo.models;

import java.sql.Date;
import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Cliente {
	
	@Id
	private String documento;
	
	private String nombre;
	
	private Date fecha_naciemiento;
	
	private String email;

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha_naciemiento() {
		return fecha_naciemiento;
	}

	public void setFecha_naciemiento(Date fecha_naciemiento) {
		this.fecha_naciemiento = fecha_naciemiento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<Venta> getVentas() {
		return ventas;
	}

	
	
}
