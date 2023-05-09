package com.idat.edu.pe.daa2.jpa.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.idat.edu.pe.daa2.jpa.modelo.Sede;

public interface SedeRepositorio extends CrudRepository<Sede, Integer> {
	
	@Query(value = "SELECT a FROM Sede a WHERE a.nombre=?1")
    public List<Sede> buscarSedesPorNombre(String nombre);

}
