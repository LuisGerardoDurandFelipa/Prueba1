package com.idat.pe.pro.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity //3.-
@Table (name = "rolUsuario") // 4.- INDICAMOS EL NOMBRE DE LA TABLA EN LA BASE DE DATOS
public class RolUsuario implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Basic(optional = false) 
	@Column (name = "idRol")
	private Integer idRol ;
	
	@Column (name = "codigoRol" ) 
	private String codigoRol ;
	@Column (name = "descripcionRol" )
	private String descripcionRol ;
	/*
	@OneToMany(mappedBy = "rol",cascade = CascadeType.ALL)
	private Set<DatosUsuario>datosUsu = new HashSet<>();
	*/
	public Integer getIdRol() {
		return idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public String getCodigoRol() {
		return codigoRol;
	}

	public void setCodigoRol(String codigoRol) {
		this.codigoRol = codigoRol;
	}

	public String getDescripcionRol() {
		return descripcionRol;
	}

	public void setDescripcionRol(String descripcionRol) {
		this.descripcionRol = descripcionRol;
	}

	
	
	
	
	
	
	
}
