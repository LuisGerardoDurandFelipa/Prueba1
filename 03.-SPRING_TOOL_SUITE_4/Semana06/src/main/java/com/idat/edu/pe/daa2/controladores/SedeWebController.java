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


import com.idat.edu.pe.daa2.jpa.modelo.Sede;
import com.idat.edu.pe.daa2.servicios.SedesServicios;

@Controller
@RequestMapping("/sedes")

public class SedeWebController {
	
	 	@Autowired
	    private SedesServicios servicio;
	 
	// devuelve la lista de peliculas desde la capa de servicio 
	    
	    @RequestMapping("/listarTodo")
	    public String  listarSedes (Model model) {
	        List<Sede> listaSedes = servicio.buscarTodo();
	        System.out.println("Lista sedes : " + listaSedes);
	        model.addAttribute("listaSedes", listaSedes);
	        return "/moduloSede/listarTodo";
	    }
	   
	    @RequestMapping ("/nuevo")
	    public  String nuevaSede (Model model) {
	        Sede sede = new Sede();
	        model.addAttribute("sede", sede);
	        return "/moduloSede/nuevaSede";
	        
	    }
	    
	    
	    @RequestMapping (value="/guardar" , method = RequestMethod.POST)
	    public  String crearSede(@ModelAttribute("sede")Sede sede) {
	        servicio.crear(sede); // Guardar la Pelicula en base de datos
	        return	"redirect:/sedes/listarTodo"; // retorna la lista con la pelicula ingresada
	    }
	  
	    
		@RequestMapping(value = "/actualizar/{id}")
		public ModelAndView editarSede(@PathVariable(name = "id") int id) {
		    ModelAndView mav = new ModelAndView("/moduloSede/editarSede");
		    Sede sede = servicio.buscarPorId(id);
		    mav.addObject("sede", sede);
		    return mav;
		}
		
		
		@RequestMapping(value ="/eliminar/{id}")
		public String eliminarSede(@PathVariable(name = "id") int id) {
			  servicio.borrarPorId(id);
			 return "redirect:/sedes/listarTodo";
			
		}
	    

}
