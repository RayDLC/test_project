package org.recetas4you;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.recetas4you.model.Receta;
import org.recetas4you.service.RecetaServiceImplements;

class TestCrearReceta {
	
	RecetaServiceImplements rs = new RecetaServiceImplements();
	
	Receta r = new Receta();
	
	String prueba[] = {"99", "Pruaba test", "1", "2", "Ingredientes Junit5", "Preparacion Junit5"};

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	void pruebaCreate() {
		
	}

}
