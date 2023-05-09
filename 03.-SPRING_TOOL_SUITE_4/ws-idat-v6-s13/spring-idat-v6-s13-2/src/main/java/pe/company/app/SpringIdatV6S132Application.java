package pe.company.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//1.- HACEMOS UN SCAN A LOS PAQUETES CREADOS
@SpringBootApplication(scanBasePackages = {"pe.company.controller","pe.company.repository","pe.company.service","pe.company.model"}) 

//2.- PARA EXPONGA NUESTROS SERVICIOS DEBEMOS INDICARLE QUE HAGA UNA CONFIGURACION 
//LA CONFIGURACION ES PARA QUE LEA NUESTRO ARCHIVO DONDE ENCONTRARA LA CONFIGURACION 
//DE NUESTRA APLIACION 
@PropertySource("classpath:application.properties")//INDICA EL NOMBRE DEL PROYECTO PARA NUESTRA URL

//3.- IDICAMOS QUE LAS ENTIDADES DE LA BASE DE DATOS ESTAN EN EL PAQUETE MODEL
@EntityScan ("pe.company.model")

//4.-como estamos usando jql , INDICAMOS QUE HABILITE LOS REPOSITORIO PARA PODER 
// QUE ME CONECTAN A LA BASE DE DATOS PARA YO USAR EL JQL
@EnableJpaRepositories ("pe.company.repository")

public class SpringIdatV6S132Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringIdatV6S132Application.class, args);
	}

}
