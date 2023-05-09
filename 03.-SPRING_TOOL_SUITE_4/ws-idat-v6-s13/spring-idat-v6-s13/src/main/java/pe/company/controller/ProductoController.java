package pe.company.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pe.company.model.Categoria;
import pe.company.model.Producto;
import pe.company.service.CategoryService;

// ES AQUI DONDE IMPLEMENTAMOS LOS SERVICIOS 

@RestController
@RequestMapping(value = "v1")
public class ProductoController {
	
	@RequestMapping(value = "/productos",method = RequestMethod.GET,headers = "Accept=application/json")
	public @ResponseBody List<Producto> finAll (){
		List<Producto>lista = new ArrayList<>();
		
        Producto producto1=new Producto(1L,"Caramelos","Bolsa",5.00,100);
        Producto producto2=new Producto(2L,"Chocolates","Caja",8.00,50);
        Producto producto3=new Producto(3L,"Galletas","Bolsa",10.00,70);
        lista.add(producto1);
        lista.add(producto2);
        lista.add(producto3);
        return lista;
		
	}
	
	@Autowired
	private CategoryService categoryService;
	@RequestMapping(value = "/categorias",method = RequestMethod.GET,headers = "Accept=application/json")
	public @ResponseBody List<Categoria> finCategoriesByDescription(@RequestParam String descripcion){
		return categoryService.findByDescription(descripcion);
	}
	
	

}
