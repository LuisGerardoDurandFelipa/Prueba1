package com.idat.edu.pe.daa2.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.idat.edu.pe.daa2.jpa.modelo.Cine;

import com.idat.edu.pe.daa2.jpa.repositorios.CineRepositorio;


@Service
@Transactional

public class CinesServicios {
	
	
	@Autowired
	private CineRepositorio cineRepositorio;

	public CinesServicios() {

	}

	public List<Cine> buscarTodo() {
		return (List<Cine>) cineRepositorio.findAll();
	}

	public Cine crear(Cine cine) {
		return cineRepositorio.save(cine);
	}

	public Cine actualizar(Cine cineActualizar) {

		Cine cineActual = cineRepositorio.findById(cineActualizar.getIdCine()).get();

		cineActual.setRazonSocial(cineActualizar.getRazonSocial());
		cineActual.setNombre(cineActualizar.getNombre());
	

		Cine cineActualizado = cineRepositorio.save(cineActual);
		return cineActualizado;
	}

	public Cine buscarPorId(Integer id) {

		return cineRepositorio.findById(id).get();

	}

	public void borrarPorId(Integer id) {
		cineRepositorio.deleteById(id);

	}
	
	

}
