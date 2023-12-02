package com.example.demo.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

import com.example.demo.dto.ProveedorDTO;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "proveedor")
public class Proveedor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_proveedor")
	private Integer idProveedor;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellidos")
	private String apellidos;

	@Column(name = "razon_social")
	private String razonSocial;

	@Column(name = "direccion")
	private String direccion;

	@Column(name = "nomina")
	private Double nomina;

	@Column(name = "estatus")
	private Boolean estatus;

	public Proveedor() {
		super();
	}

	public Proveedor(ProveedorDTO obj) {
		super();
		this.idProveedor = obj.getIdProveedor();
		this.nombre = obj.getNombre();
		this.apellidos = obj.getApellidos();
		this.razonSocial = obj.getRazonSocial();
		this.direccion = obj.getDireccion();
		this.nomina = obj.getNomina();
		this.estatus = obj.getEstatus();
	}

	public Integer getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(Integer idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Double getNomina() {
		return nomina;
	}

	public void setNomina(Double nomina) {
		this.nomina = nomina;
	}

	public Boolean getEstatus() {
		return estatus;
	}

	public void setEstatus(Boolean estatus) {
		this.estatus = estatus;
	}

}
