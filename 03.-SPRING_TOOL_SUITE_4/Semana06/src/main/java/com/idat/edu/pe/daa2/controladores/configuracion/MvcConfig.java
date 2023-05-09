package com.idat.edu.pe.daa2.controladores.configuracion;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig  implements  WebMvcConfigurer{
	
	public void addViewControllers(ViewControllerRegistry registry) {
		
		registry.addViewController("/").setViewName("principal");  // configuramos apra el lado de la vista
		registry.addViewController("/principal").setViewName("principal");
		registry.addViewController("/home").setViewName("principal");
		registry.addViewController("/inicio").setViewName("principal");
		registry.addViewController("/logeo").setViewName("index");
		registry.addViewController("/login").setViewName("index");
		registry.addViewController("/claudia").setViewName("index");
		registry.addViewController("/bienvenida").setViewName("bienvenida");
		registry.addViewController("/prueba").setViewName("principal");
		
		registry.addViewController("/error").setViewName("error");
		
		
		
	}
	
	

}
