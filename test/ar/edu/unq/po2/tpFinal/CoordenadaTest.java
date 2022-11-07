package ar.edu.unq.po2.tpFinal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CoordenadaTest {
	
	private Coordenada coordenada;

	@BeforeEach
	void setUp() throws Exception {
		coordenada = new Coordenada(5,4);
	}

	@Test
	void testGetX() {
		assertEquals(5, coordenada.getX());
	}
	
	@Test
	void testGetY() {
		assertEquals(4, coordenada.getY());
	}
	
	@Test
	void setX() {
		coordenada.setX(6);
		assertEquals(6, coordenada.getX());
	}
	
	@Test
	void setY() {
		coordenada.setY(7);
		assertEquals(7, coordenada.getY());
	}

}
