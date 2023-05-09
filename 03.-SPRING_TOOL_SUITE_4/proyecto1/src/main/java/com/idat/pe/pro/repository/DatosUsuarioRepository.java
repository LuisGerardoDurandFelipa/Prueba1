package com.idat.pe.pro.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.idat.pe.pro.model.DatosUsuario;

//1.-DESPUES DE CREAR LA INTERFACE
//2.-INDICAMOS QUE ESTA INTERFACE ES UN REPOSITORY
@Repository
//3.-AGREGAMOS LA EXTENCION JpaRepository<Nombre de la Clase , Tipo de valor del primary key en la clase >
public interface DatosUsuarioRepository extends JpaRepository<DatosUsuario, Integer>{
	
	//5.-CREAMOS EL QUERY SJPA 
	@Query(value ="SELECT * FROM datosUsuario WHERE documento= :documento " ,nativeQuery = true)
	//4.- CREAMOS EL SERVICIO LISTAR
	 List<DatosUsuario> listarUsuarios(@Param("documento") String documento);

}
