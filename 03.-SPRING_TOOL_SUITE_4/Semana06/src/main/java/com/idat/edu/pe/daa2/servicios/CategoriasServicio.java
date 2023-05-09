package com.idat.edu.pe.daa2.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.edu.pe.daa2.jpa.modelo.Categoria;

import com.idat.edu.pe.daa2.jpa.repositorios.CategoriaRepositorio;

@Service
@Transactional

public class CategoriasServicio {
	@Autowired
	private CategoriaRepositorio categoriaRepositorio;

	public CategoriasServicio() {

	}

	public List<Categoria> buscarTodo() {
		return (List<Categoria>) categoriaRepositorio.findAll();
	}

	public Categoria crear(Categoria categoria) {
		return categoriaRepositorio.save(categoria);
	}

	public Categoria actualizar(Categoria categoriaActualizar) {

		Categoria categorialaActual = categoriaRepositorio.findById(categoriaActualizar.getIdCategoria()).get();

		categorialaActual.setIdCategoria(categoriaActualizar.getIdCategoria());
		categorialaActual.setCodigo(categoriaActualizar.getCodigo());
		categorialaActual.setDescripcion(categoriaActualizar.getDescripcion());

		Categoria cetegoriaActualizado = categoriaRepositorio.save(categorialaActual);
		return cetegoriaActualizado;
	}

	public Categoria buscarPorId(Integer id) {

		return categoriaRepositorio.findById(id).get();

	}

	public void borrarPorId(Integer id) {
		categoriaRepositorio.deleteById(id);

	}

}
