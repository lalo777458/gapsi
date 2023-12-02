package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Proveedor;

public interface IProveedorDAO extends JpaRepository<Proveedor, Integer> {

	public List<Proveedor> findAllByOrderByIdProveedorDesc();

	public Proveedor findByNombre(String nombre);

}
