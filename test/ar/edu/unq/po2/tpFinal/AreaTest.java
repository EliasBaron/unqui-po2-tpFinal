package ar.edu.unq.po2.tpFinal;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AreaTest {

	private Coordenada coordenada1;
	private Coordenada coordenada2;
	private Coordenada coordenada3;
	private Area area;

	@BeforeEach
	void setUp() throws Exception {
		coordenada1 = new Coordenada(5, 4);
		area = new Area(coordenada1, 5);
		//coordenada2 = mock(Coordenada.class);
		
	}

	@Test
	void testVerificarCoordenadaMismoXY() {
		assertTrue(area.verificarCoordenada(coordenada1));

	}
	
	@Test
	void testVerificarCoordenadaApenasAlejada() {
		coordenada2= new Coordenada(8,5);
		assertTrue(area.verificarCoordenada(coordenada2));
	}
	
	@Test
	void testVerificarCoordenadaAfuera() {
		coordenada2= new Coordenada(15,10.5);
		assertFalse(area.verificarCoordenada(coordenada2));
	}

}
