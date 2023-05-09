package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/servicio")

public class ServicioController {
	@Autowired
	ServicioOperaciones servicioOperaciones;

	public List<String> mostrar() {

		return  servicioOperaciones.lista();

	}

}
