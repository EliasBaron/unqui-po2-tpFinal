package ar.edu.unq.po2.tpFinal;

//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.verify;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AreaTest {

	private Coordenada coordenadaCentro;
	private Coordenada coordenadaPrueba;
	private Area area;

	@BeforeEach
	void setUp() throws Exception {
		coordenadaCentro = new Coordenada(5, 4);
		area = new Area(coordenadaCentro, 5);
		//coordenada2 = mock(Coordenada.class);
		
	}

	@Test
	void testVerificarCoordenadaMismoXY() {
		assertTrue(area.verificarCoordenada(coordenadaCentro));

	}
	
	@Test
	void testVerificarCoordenadaApenasAlejada() {
		coordenadaPrueba= new Coordenada(8,5);
		assertTrue(area.verificarCoordenada(coordenadaPrueba));
	}
	
	@Test
	void testVerificarCoordenadaAfuera() {
		coordenadaPrueba= new Coordenada(15,10.5);
		assertFalse(area.verificarCoordenada(coordenadaPrueba));
	}
	

}
