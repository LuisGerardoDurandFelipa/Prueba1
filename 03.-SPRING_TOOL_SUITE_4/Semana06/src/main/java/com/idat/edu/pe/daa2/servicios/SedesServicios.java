package com.idat.edu.pe.daa2.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.edu.pe.daa2.jpa.modelo.Pelicula;
import com.idat.edu.pe.daa2.jpa.modelo.Sede;
import com.idat.edu.pe.daa2.jpa.repositorios.SedeRepositorio;

@Service
@Transactional
public class SedesServicios {
	
	@Autowired
    private SedeRepositorio repositorio;
	
	public SedesServicios() {
		
		
	}

	public List<Sede> buscarTodo(){
			return (List<Sede>) repositorio.findAll();
			}

	
	public Sede crear (Sede sede) {
			return repositorio.save(sede);
			}
	
	
	public Sede actualizar (Sede sedeActualizar) {
		
		
		Sede sedeActual= repositorio.findById(sedeActualizar.getIdSede()).get();
		
		sedeActual.setIdSede(sedeActualizar.getIdSede());
		sedeActual.setNombre(sedeActualizar.getNombre());
		sedeActual.setDireccion(sedeActualizar.getDireccion());
		
		
		Sede sedeActualizado = repositorio.save(sedeActual);
		return sedeActualizado;
	}
	
	public Sede buscarPorId(Integer id) {
		
		return repositorio.findById(id).get();
	}
	
	public void borrarPorId(Integer id) {
		repositorio.deleteById(id);
		
	}
	
}
