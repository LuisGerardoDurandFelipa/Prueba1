package com.idat.pe.pro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.pe.pro.model.DatosUsuario;
import com.idat.pe.pro.repository.DatosUsuarioRepository;

import jakarta.transaction.Transactional;

// 1. INDICAMOS QUE ESTA CLASE ES UN CLASE SERVICIOS
@Service
@Transactional

public class DatosUsuarioService {

	// 2.- HACE REFERENCIA QUE VA A REALIZA UNA INYECCION DE LOS DATOS DE LA CAPA REPOSITORI
	@Autowired 
	private DatosUsuarioRepository datosUsuarioRepository; //3.- CREAMOS UNA VARIABLE QUE CONTIENE LOS DATOS DEL REPOSITORY
	
	
	//4.- CREAMOS NUESTROS METODOS SEGUN EL PROYECTO
	
	//4.1.- FUNCION LISTAR TODOS LOS USUARIOS
	@Transactional
	public List<DatosUsuario> listarUsuarios (String documento){
		List<DatosUsuario> usuario = datosUsuarioRepository.listarUsuarios(documento);
		return usuario;
	}
	
	//4.2.- FUNCION CREAR DE USUARIO
	public DatosUsuario crearUsuario (DatosUsuario datosUsuario) {
		return datosUsuarioRepository.save(datosUsuario);
	}
	
}
