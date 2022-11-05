package ar.edu.unq.po2.tpFinal;

//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.verify;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AreaTest {
	
	private Area area; //SUT
	private Coordenada coordenadaCentro; //DOC
	private Coordenada coordenadaPrueba; //DOC
	

	@BeforeEach
	void setUp() throws Exception {
		coordenadaCentro = mock(Coordenada.class);
		coordenadaPrueba = mock(Coordenada.class);
		area = new Area(coordenadaCentro, 5);
		
		
		when(coordenadaCentro.getX()).thenReturn(5.0);
		when(coordenadaCentro.getY()).thenReturn(4.0);
		
		
	}

	@Test
	void testVerificarCoordenadaMismoXY() {
		coordenadaPrueba = coordenadaCentro;
		
		assertTrue(area.verificarCoordenada(coordenadaPrueba));

	}
	
	@Test
	void testVerificarCoordenadaApenasAlejada() {
		when(coordenadaPrueba.getX()).thenReturn(8.0);
		when(coordenadaPrueba.getY()).thenReturn(5.0);
		
		assertTrue(area.verificarCoordenada(coordenadaPrueba));
	}
	
	@Test
	void testVerificarCoordenadaAfuera() {
		when(coordenadaPrueba.getX()).thenReturn(15.0);
		when(coordenadaPrueba.getY()).thenReturn(10.0);
		
		assertFalse(area.verificarCoordenada(coordenadaPrueba));
	}
	

}
