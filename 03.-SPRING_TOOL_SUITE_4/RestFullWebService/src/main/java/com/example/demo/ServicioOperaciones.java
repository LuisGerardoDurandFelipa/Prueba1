package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ServicioOperaciones {
	
	public List<String> lista (){
		
		List<String> nombres= new ArrayList<>();
		nombres.add("Joaquin");
		nombres.add("Indira");
		nombres.add("Raul");
		nombres.add("Juan Carlos");
		nombres.add("Eduardo");
		return nombres;
		
		
	}

}
