package ar.edu.unq.po2.tpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MuestraTest {
	
	Muestra muestra; //SUT
	private Date fechaMuestra; //DOC
	private Coordenada coordenadaMuestra; //DOC
	
	
	@BeforeEach
	void setUp() throws Exception {
		fechaMuestra = mock(Date.class);
		coordenadaMuestra = mock(Coordenada.class);
		
		muestra = new Muestra(fechaMuestra, coordenadaMuestra);
	
	}

	@Test
	void testGetFecha() {
		assertEquals(fechaMuestra, muestra.getFecha());
	}
	
	@Test
	void testGetCoordenada() {
		assertEquals(coordenadaMuestra, muestra.getCoordenada());
	}

}
