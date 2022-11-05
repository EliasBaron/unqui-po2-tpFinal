package ar.edu.unq.po2.tpFinal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CategoriaTest {
	
	private String nombre;
	private Categoria categoria;
	

	@BeforeEach
	void setUp() throws Exception {
		nombre = "biología";
		categoria = new Categoria(nombre);
		
	}

	@Test
	void testgetNombre() {
		
		assertEquals(nombre,categoria.getNombre());
	}
	
	@Test
	void testSetNombre() {
		categoria.setNombre("astrología");
		assertEquals("astrología",categoria.getNombre());
	}

}
