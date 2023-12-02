package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IProveedorDAO;
import com.example.demo.dto.ProveedorDTO;
import com.example.demo.entity.Proveedor;
import com.example.demo.service.IProveedorService;

@Service
public class ProveedorServiceImpl implements IProveedorService {

	private static final Logger log = LoggerFactory.getLogger(ProveedorServiceImpl.class);

	@Autowired
	private IProveedorDAO proveedorDAO;

	@Override
	public List<ProveedorDTO> getProveedores() {
		return proveedorDAO.findAllByOrderByIdProveedorDesc().stream().map(ProveedorDTO::new)
				.collect(Collectors.toList());
	}

	@Override
	public ResponseEntity<?> saveProveedor(ProveedorDTO proveedor) {
		try {
			proveedorDAO.save(new Proveedor(proveedor));
			return new ResponseEntity<>(null, HttpStatus.OK);
		}catch (Exception e) {
			log.info("Error: ", e);
			return null;
		}
	}

	@Override
	public ResponseEntity<?> deleteProveedor(Integer idProveedor) {
		try {
			proveedorDAO.deleteById(idProveedor);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			log.info("Error: ", e);
			return null;
		}
	}

}
