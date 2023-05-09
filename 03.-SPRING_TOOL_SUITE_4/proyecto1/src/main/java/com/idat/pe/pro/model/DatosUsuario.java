package com.idat.pe.pro.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity // 3.-
@Table(name = "datosUsuario") // 4.- INDICAMOS EL NOMBRE DE LA TABLA EN LA BASE DE DATOS

public class DatosUsuario implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 1.- CREAMOS LOS ATRIBUTOS DE LA CLASE
	@Id // 5.- INDICACION QUE ESTA VARIABLE ES EL ID (PERSISTEN)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false) // 5.2 INDICA QUE EL ID ES UN VALOR REQUERIDO
	@Column(name = "idUsuario")
	private Integer idUsuario;

	@Column(name = "codigo") // 6.- INDICAMOS QUE ESTA VARIABLE ES UNA COLUMNA DE LA BD
	private String codigo;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "apellido")
	private String apellido;
	@Column(name = "documento")
	private String documento;
	@Column(name = "fecha_nacimiento")
	private Date fechaNacimiento;
	@Column(name = "idDireccion")
	private Integer idDireccion;
	/*
	 * //8.- VARIABLE QUE SE RELACIONA CON OTRA TABLA O OTRA CLASE //8.1 RELACIONAS
	 * LA VARIABLE CON LA OTRA TABLA // (NOMBRE DE LA TABLA EN BD, VARIABLE EN LA BD
	 * CON LA QUE SE VA REALCIONAR)
	 * 
	 * @JoinColumn(name ="rolUsuario", referencedColumnName = "idRol")//
	 * 
	 * @ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "rol") // indica que es el propietario
	@JsonProperty(access = Access.WRITE_ONLY)
	 */
	@ManyToOne(optional = false)//indicamos que esta relacion no puede ser nula
	@JoinColumn(name = "rol") // indicamos el nombre de la columna en la relacion de las tablas (forykey)
								//indica que es el propietario
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private RolUsuario rol;

	// 2.- CREAMOS LOS CONSTRUCTORES Y LOS GET AND SET

	public DatosUsuario() {
	}


	public DatosUsuario(Integer idUsuario, String codigo, String nombre, String apellido, String documento,
			Date fechaNacimiento, Integer idDireccion, RolUsuario rol) {
		this.idUsuario = idUsuario;
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;
		this.fechaNacimiento = fechaNacimiento;
		this.idDireccion = idDireccion;
		this.rol = rol;
	}
	


	public DatosUsuario(Integer idUsuario, String codigo, String nombre, String apellido, String documento,
			Date fechaNacimiento, Integer idDireccion) {
		this.idUsuario = idUsuario;
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;
		this.fechaNacimiento = fechaNacimiento;
		this.idDireccion = idDireccion;
	}


	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Integer getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(Integer idDireccion) {
		this.idDireccion = idDireccion;
	}


	public RolUsuario getRol() {
		return rol;
	}


	public void setRol(RolUsuario rol) {
		this.rol = rol;
	}



}
