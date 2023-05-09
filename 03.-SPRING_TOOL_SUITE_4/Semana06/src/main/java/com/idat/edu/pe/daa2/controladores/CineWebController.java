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


import com.idat.edu.pe.daa2.jpa.modelo.Cine;

import com.idat.edu.pe.daa2.servicios.CinesServicios;

@Controller
@RequestMapping("/cines")

public class CineWebController {
	
	
	@Autowired
	private CinesServicios cinesServicios;
	
	// Metodo Listar
	
	@RequestMapping("/listarTodo")
	public String listarCines(Model model) {
		List<Cine> listaCategorias = cinesServicios.buscarTodo();
		
		System.out.println("LISTA DE CINES : " + listaCategorias);
		
		model.addAttribute("listaCines", listaCategorias);
		return "/moduloCine/listarTodo";
	}
	
	// Metodo Nuevo
	
	@RequestMapping("/nuevo")
	public String nuevaCine(Model model) {
		Cine cine = new Cine();
		model.addAttribute("cine", cine);
		return "/moduloCine/nuevaCine";
		
	}
	
	@RequestMapping(value = "/guardar" , method = RequestMethod.POST)
	public String crearCine(@ModelAttribute("categoria") Cine cine) {
		cinesServicios.crear(cine);
		    return "redirect:/cines/listarTodo";
	}
	
	@RequestMapping(value = "/actualizar/{id}")
	public ModelAndView editarCine(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("/moduloCine/editarCine");
	    Cine cine = cinesServicios.buscarPorId(id);
	    mav.addObject("cine", cine);
	    return mav;
	}
	
	
	@RequestMapping(value ="/eliminar/{id}")
	public String eliminarCine(@PathVariable(name = "id") int id) {
		cinesServicios.borrarPorId(id);
		 return "redirect:/cines/listarTodo";
		
	}
	
	
	

}
