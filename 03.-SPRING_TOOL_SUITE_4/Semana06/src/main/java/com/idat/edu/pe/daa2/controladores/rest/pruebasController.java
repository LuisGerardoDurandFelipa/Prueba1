package com.idat.edu.pe.daa2.controladores.rest;



import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/pruebas")

public class pruebasController {
	

	    public String  pruexxba (Model model) {
		 		return "principal";
	    }
}
