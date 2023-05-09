package com.idat.edu.pe.daa2.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.edu.pe.daa2.jpa.modelo.Funciones;
import com.idat.edu.pe.daa2.jpa.repositorios.FuncionesRepositorio;

@Service
@Transactional
public class FuncionesServicio {

	@Autowired
	public FuncionesRepositorio  funcionesRepositorio;
	
	public FuncionesServicio() {
		
	}
	
	public Funciones crear (Funciones funciones) {
		return funcionesRepositorio.save(funciones);
	}
	
	public List<Funciones> buscarTodo(){
		return (ArrayList<Funciones>) funcionesRepositorio.findAll();
	}
	
	public Funciones buscarPorId(Integer id) {
		return funcionesRepositorio.findById(id).get();
	}
	
	public Funciones actualizar(Funciones funcionesActualizar) {
		Funciones funcionesActual = funcionesRepositorio.findById(funcionesActualizar.getIdFunciones()).get();
		
		funcionesActual.setIdFunciones(funcionesActualizar.getIdFunciones());
		funcionesActual.setHoraInicio(funcionesActualizar.getHoraInicio());
		funcionesActual.setHoraFin(funcionesActualizar.getHoraFin());
		funcionesActual.setPrecio(funcionesActualizar.getPrecio());
		
		Funciones  funcionesActualizado = funcionesRepositorio.save(funcionesActual);
		return funcionesActualizado;
		
	}
	
	
	public void eliminarFunciones(Integer id) {
		funcionesRepositorio.deleteById(id);
	}
	
	
	public void actualizar(int id , Funciones funcion) {
		Funciones funcionesActual = funcionesRepositorio.findById(id).get();
		
	
		funcionesActual.setHoraInicio(funcion.getHoraInicio());
		funcionesActual.setHoraFin(funcion.getHoraFin());
		funcionesActual.setPelicula(funcion.getPelicula());
		funcionesActual.setPrecio(funcion.getPrecio());
	    funcionesActual.setSala(funcion.getSala());
		
		funcionesRepositorio.save(funcionesActual);
	
		
	}
	
	
	
	
}
