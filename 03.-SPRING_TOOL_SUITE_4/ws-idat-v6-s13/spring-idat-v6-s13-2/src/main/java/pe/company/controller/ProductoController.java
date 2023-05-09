package pe.company.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pe.company.model.Categoria;
import pe.company.model.Producto;
import pe.company.service.CategoryService;

//3.PARA LA CONVERSION A UN SERVICIO SE NECESITA LAS SEGUIENTES ANOTACIONES FRAMEWORK SPRING
@RestController // LE INDICAMOS QUE SEA UN RESTFULL
@RequestMapping(value="v1") //LE INDICAMOS EL NOMBRE CON EL CUAL SERA LLAMADO DESDE LA URL

public class ProductoController {
	
	//3.- INSTANCIAMOS LA CAPA SERVICE
	@Autowired
	private CategoryService categoryService;
	
	//1.- DEFINIMOS CON EL FRAMEWORK NUESTROS METODOS QUE VAMOS A ENVIAR
	// O MENTODOS PARA USAR 
	
	//2.- METODO LISTAR TODOS LOS DATOS PRODUCTOS 
	//***3.1.-LE INDACAMOE LA ANOTACION SPRIGN***************
	//este servicio respondera al metodo GET con el nombre de /productos y tendra un contenido de tipo json
	//este ultimo atributo es para que convierta nuestro return en formato json
	@RequestMapping(value="/productos",method = RequestMethod.GET,headers = "Accept=application/json")
	//***************************************************
	//@ResponseBody INDICA QUE TRANSFORME EL RESULTADO DEL FINDALL Y LO ENVIE A LA PERSONA QUE INVOCADO 
	//NUESTRO SERVICIO 
	public @ResponseBody List<Producto>findAll(){
		//2.1 CREAMOS UN OBJETO DEL TIPO ARRAY LIST
		List<Producto> listaProducto = new ArrayList<>();
		
		//2.2 INGRESAMO DATOS INGRESADOS DIRRECTAMENTE
		Producto producto1=new Producto(1L,"Caramelos","Bolsa",5.00,100);
	    Producto producto2=new Producto(2L,"Chocolates","Caja",8.00,50);
	    Producto producto3=new Producto(3L,"Galletas","Bolsa",10.00,70);
	    
	    //2.3 AGREGAMOS LOS DATOS A LA LISTA listaProducto
	    listaProducto.add(producto1);
	    listaProducto.add(producto2);
	    listaProducto.add(producto3);
	    
	    //2.3 RETORNAMOS EL RESULTADO 
		return listaProducto;
	}
	
	//4.- CREAMOS UN METODO LISTAR CATEGORIA
	//@RequestMapping(value="/categorias",method = RequestMethod.GET,headers = "Accept=application/json")
	//4.1 LO UNICO QUE SE VA AÑADIR ES EL @RequestParam , PARA INGRESAR EL DATOS POR LA URL
	/**
	 * @RequestParam  || URL> v1/categorias?descripcion=
	 * @PathVariable  || URL> v1/categorias/Impresoras
	 * */
	/*
	public@ResponseBody List<Categoria>findCategoriesByDescription(@RequestParam() String descripcion){
		List<Categoria> listaCategoria = categoryService.findByDescription(descripcion) ;
		return listaCategoria;//o tambien || return categoryService.findByDescription(descripcion);
	}
	*/
	@RequestMapping(value="/categorias/{descripcion}",method = RequestMethod.GET,headers = "Accept=application/json")
	public@ResponseBody List<Categoria> findCategoriesByDescription (@PathVariable("descripcion") String descripcion){
		List<Categoria> listaCategoria = categoryService.findByDescription(descripcion) ;
		return listaCategoria;//o tambien || return categoryService.findByDescription(descripcion);
	}
	
	/**
	 *BUSCAR POR ID EN LA CLASE CATEGORIA 
	 * */
	@RequestMapping(value="/categorias/buscarporid/{id_categoria}",method = RequestMethod.GET,headers = "Accept=application/json")
	public @ResponseBody Categoria buscarPorId (@PathVariable("id_categoria")Long id_categoria) {
			Categoria buscarporid = categoryService.buscarPorId(id_categoria);
			return buscarporid;
	}
}
