package com.idat.pe.pro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.idat.pe.pro.model.DatosUsuario;
import com.idat.pe.pro.service.DatosUsuarioService;

import jakarta.websocket.server.PathParam;

@RestController // 1.- IMPORTAMOS LA LIBRERIA RESTCONTROLLER
@RequestMapping(value = "/proyecto1") // 2.- INDICAMOS LA RUTA COMO NUESTRO API SERA IDENTIFICADO
public class DatosUsuarioController {

	// 3.- INYECTAMOS LOS SERVICOS EN LA CAPA ANTERIOR
	@Autowired
	private DatosUsuarioService datosUsuarioService;

	// 4.- CREAMOS UN CONTROLLER LISTAR
	/*
	 * @GetMapping//("/listarUsuarios") //4.1 IDENTIFICADOR PARA ESTE METODO public
	 * String fromlistarUsuarios (Model model ) {
	 * model.addAttribute("listarAlumnos",datosUsuarioService.listarUsuarios());
	 * return "Curso/fromlistarUsuarios"; }
	 */
	/*
	 * *******************************************************************************************
	 * 
	 * @RequestMapping(value = "/usuario/{documento}",method = RequestMethod.GET,
	 * headers = "Accept=application/json") public@ResponseBody
	 * List<DatosUsuario>fromlistar(@PathVariable("documento") String documento){
	 * List<DatosUsuario>listarUsuario =
	 * datosUsuarioService.listarUsuarios(documento); return listarUsuario; }
	 * 
	 */
	@RequestMapping(value = "/usuario", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody List<DatosUsuario> fromlistar(@PathParam("documento") String documento) {
		List<DatosUsuario> listarUsuario = datosUsuarioService.listarUsuarios(documento);
		return listarUsuario;
	}
	//****************************************************************************************
	/* 
	@GetMapping("/usuario1/{documento}")
	public ResponseEntity<?> searchlist(@PathVariable("documento") String documento) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(datosUsuarioService.listarUsuarios(documento));
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"}" + e.getMessage() + "\"}"));
		}
	} 
	*/
	@GetMapping("/usuario1")
	public ResponseEntity<?> searchlist(@PathParam("documento") String documento) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(datosUsuarioService.listarUsuarios(documento));
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"}" + e.getMessage() + "\"}"));
		}
	}

	//***************************************************************************
	// LLAMANDO A UN VENTANA HTML 
	@RequestMapping("/listarTodo")
	public @ResponseBody String listarCategorias(Model model,@PathParam("documento") String documento) {
		List<DatosUsuario> listaUsuario = datosUsuarioService.listarUsuarios(documento);
		System.out.println("LISTA DE CATEGORIAS : " + listaUsuario);
		model.addAttribute("listaUsuario", listaUsuario);
		return "/index.html";
	}
	

	
	
	
}
