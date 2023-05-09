package pe.company.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//3.-LE INDICAMOS A SPRINF QUE ESTA CLASE Categoria ESUNA ENTIDAD DE BASE DE DATOS
@Entity
//4.-AHORA LE INDICAMOS QUE Categoria ES UNA TABLA Y TAMBIEN EL NOMBRE QUE TIENE
@Table(name = "categoria") // DICHO NOMBRE TIENE QUE SER IGUAL A LA BASE DE DATOS

public class Categoria {
	
	//1.- CREACION DE LOS ATRIBUTOS DE LA CLASE
	@Id //5.- INDICAMOS QUE EL ATRIBUTO id_categoria ES EL ID QUE SE REQUERIE LA CAPA DE PERSISTENCIA
		// O TAMBIEN LE ESTAMOS INDICANDO QUE ES SU PRIMARY KEY 	
	@GeneratedValue (strategy = GenerationType.IDENTITY) // INCAMOS QUE TIPO DE IDENTIFICADOR ES ? 
		//PARA ESTE CASO COMO ES UN AUTOINCRE , SE TIENE QUE USAR EL CODIGO DE ARRIBA UN IDENTITY
		//
	private Long id_categoria;
	private String descripcion;
	
	
	//2.-GENERAMOS LOS CONSTRUCTORES Y GET AND SET
	
	public Categoria() {
	}


	public Categoria(Long id_categoria, String descripcion) {
		this.id_categoria = id_categoria;
		this.descripcion = descripcion;
	}


	public Long getId_categoria() {
		return id_categoria;
	}


	public void setId_categoria(Long id_categoria) {
		this.id_categoria = id_categoria;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
