package com.idat.edu.pe.daa2.jpa.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.idat.edu.pe.daa2.jpa.modelo.Categoria;



public interface CategoriaRepositorio extends CrudRepository<Categoria, Integer>{
	
	@Query(value = "SELECT a FROM Categoria a WHERE a.codigo =?1")
	public List<Categoria> buscarCategoriaPorNombre(String codigo);
	
	
	
	@Query(value = "SELECT a FROM Categoria a WHERE a.codigo like CONCAT(?1, '%')")
	public List<Categoria> buscarCategoriaLikeNombre(String codigo);
	
	
	

}
