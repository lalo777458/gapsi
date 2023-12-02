package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.dto.ProveedorDTO;

public interface IProveedorService {

	List<ProveedorDTO> getProveedores();
	
	ResponseEntity<?> saveProveedor(ProveedorDTO proveedor);
	
	ResponseEntity<?> deleteProveedor(Integer idProveedor);
}
