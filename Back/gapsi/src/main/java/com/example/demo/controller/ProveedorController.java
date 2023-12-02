package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ProveedorDTO;
import com.example.demo.service.IProveedorService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/proveedor/")
public class ProveedorController {
	
	@Autowired
	private IProveedorService iProveedorService;
	
	@GetMapping
	public List<ProveedorDTO> getProveedores(){
		return iProveedorService.getProveedores();
	}
	
	@PostMapping
	public ResponseEntity<?> saveUpdateProveedor(@RequestBody ProveedorDTO proveedor){
		return iProveedorService.saveProveedor(proveedor);
	}
	@DeleteMapping
	public ResponseEntity<?> deleteProveedor(@RequestParam(value = "idProveedor") Integer idProveedor){
		return iProveedorService.deleteProveedor(idProveedor);
	}
	
}
