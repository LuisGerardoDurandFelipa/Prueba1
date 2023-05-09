package com.idat.edu.pe.daa2.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.idat.edu.pe.daa2.jpa.modelo.Categoria;

import com.idat.edu.pe.daa2.servicios.CategoriasServicio;


@Controller
@RequestMapping("/categorias")

public class CategoriaWebController {
	
	@Autowired
	private CategoriasServicio categoriasServicio;
	
	
	@RequestMapping("/listarTodo")
	public String listarCategorias(Model model) {
		List<Categoria> listaCategorias = categoriasServicio.buscarTodo();
		
		System.out.println("LISTA DE CATEGORIAS : " + listaCategorias);
		
		model.addAttribute("listaCategorias", listaCategorias);
		return "/moduloCategoria/listarTodo";
	}
	
	
	@RequestMapping("/nuevo")
	public String nuevaCategoria(Model model) {
		Categoria categoria = new Categoria();
		model.addAttribute("categoria", categoria);
		return "/moduloCategoria/nuevaCategoria";
		
	}
	
	@RequestMapping(value = "/guardar" , method = RequestMethod.POST)
	public String crearCategoria(@ModelAttribute("categoria") Categoria categoria) {
		categoriasServicio.crear(categoria);
		    return "redirect:/categorias/listarTodo";
	
	}
	
	
	@RequestMapping(value = "/actualizar/{id}")
	public ModelAndView editarCategoria(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("/moduloCategoria/editarCategoria");
	    Categoria categoria = categoriasServicio.buscarPorId(id);
	    mav.addObject("categoria", categoria);
	    return mav;
	}
	
	
	@RequestMapping(value ="/eliminar/{id}")
	public String eliminarCategoria(@PathVariable(name = "id") int id) {
		categoriasServicio.borrarPorId(id);
		 return "redirect:/categorias/listarTodo";
		
	}
	
	
	
	

}
