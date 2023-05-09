package com.idat.edu.pe.daa2.jpa.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.idat.edu.pe.daa2.jpa.modelo.Cine;

public interface CineRepositorio extends CrudRepository<Cine, Integer>{
	
	@Query(value = "SELECT a FROM Cine a WHERE a.razonSocial =?1")
	public List<Cine> buscarCinePorNombre(String razonSocial);
	
	
	
	
	@Query(value = "SELECT a FROM Cine a WHERE a.razonSocial like CONCAT(?1, '%')")
	public List<Cine> buscarCineLikeNombre(String razonSocial);
	
	
	
	
}