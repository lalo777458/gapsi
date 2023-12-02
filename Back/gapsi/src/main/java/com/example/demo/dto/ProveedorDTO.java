package com.example.demo.dto;

import java.io.Serializable;

import com.example.demo.entity.Proveedor;

public class ProveedorDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idProveedor;

	private String nombre;

	private String apellidos;

	private String razonSocial;

	private String direccion;

	private Double nomina;

	private Boolean estatus;

	public ProveedorDTO() {
		super();
	}

	public ProveedorDTO(Proveedor obj) {
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
