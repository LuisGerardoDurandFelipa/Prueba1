package com.idat.edu.pe.daa2.controladores.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.idat.edu.pe.daa2.jpa.modelo.Funciones;
import com.idat.edu.pe.daa2.servicios.FuncionesServicio;

import org.springframework.http.MediaType;

@RestController
@RequestMapping("/rest/funciones")
public class FuncionesRestController {

	@Autowired
	private FuncionesServicio servicio;
	
	@GetMapping 
	public  ResponseEntity<Object> buscarTodo(){
		List<Funciones> listaFunciones =  servicio.buscarTodo();
		
		System.out.println("LISTA DE FUNCIONES : " + listaFunciones);
		
		return new ResponseEntity<>(listaFunciones, HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Object> buscarPorId(@PathVariable("id") int id){
		
		Funciones funcion = servicio.buscarPorId(id);
		if(funcion == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Función no encontrada, id  proporcionado no es correcto");
			 return new ResponseEntity<Object>(funcion, HttpStatus.OK);

	}
	
	
	@PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Object> crear (@RequestBody Funciones funcion){
		   servicio.crear(funcion);
		   return new ResponseEntity<Object>("Funcion creada correctamente", HttpStatus.OK);
		
	}
	
	@PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Object> actualizar(@PathVariable("id") int id, @RequestBody Funciones funcion){
		servicio.actualizar(funcion);
		return new ResponseEntity<Object>("Funcion actualizada correctamente", HttpStatus.OK);
		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") int id){
		servicio.eliminarFunciones(id);
		return new ResponseEntity<Object>("Funcion eliminada correctamente", HttpStatus.OK);
		
	}
	
	
}
