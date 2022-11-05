package ar.edu.unq.po2.tpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DesafioTest {
	
	private Desafio desafio; //SUT
	private Area areaDesafio; //DOC
	private List<RestriccionTemporal> restriccionesTemporales;
	private RestriccionTemporal restriccion1; //DOC
	private RestriccionTemporal restriccion2; //DOC
	private Muestra muestra; //DOC
	
	@BeforeEach
	void setUp() throws Exception {
		areaDesafio = mock(Area.class);
		restriccion1 = mock(RestriccionTemporal.class);
		restriccion2 = mock(RestriccionTemporal.class);
		restriccionesTemporales = Arrays.asList(restriccion1, restriccion2);
		desafio = new Desafio(1, 2, 3, areaDesafio, restriccionesTemporales);
		
		muestra = mock(Muestra.class);
	}
	
	@Test
	void testGetCantidadMuestrasNecesarias() {
		assertEquals(1, desafio.getCantidadDeMuestrasNecesarias());
	}
	
	@Test
	void testGetDificultad() {
		assertEquals(2, desafio.getDificultad());
	}
	
	@Test
	void testGetRecompensa() {
		assertEquals(3, desafio.getRecompensa());
	}

	@Test
	void testPasaLasRestriccionesTemporales() {
		when(restriccion1.verificar(muestra.getFecha())).thenReturn(true);
		when(restriccion2.verificar(muestra.getFecha())).thenReturn(true);
		
		assertTrue(desafio.verificarRestriccionesTemporales(muestra));
	}
	
	@Test
	void testPasaUnaRestriccionTemporalPeroOtraNo() {
		when(restriccion1.verificar(muestra.getFecha())).thenReturn(true);
		when(restriccion2.verificar(muestra.getFecha())).thenReturn(false);
		
		assertFalse(desafio.verificarRestriccionesTemporales(muestra));
	}
	
	@Test
	void testNoPasaNingunaRestriccionTemporal() {
		when(restriccion1.verificar(muestra.getFecha())).thenReturn(false);
		when(restriccion2.verificar(muestra.getFecha())).thenReturn(false);
		
		assertFalse(desafio.verificarRestriccionesTemporales(muestra));
	}
	
	@Test
	void testEsMuestraValida() {
		when(restriccion1.verificar(muestra.getFecha())).thenReturn(true);
		when(restriccion2.verificar(muestra.getFecha())).thenReturn(true);
		when(areaDesafio.verificarCoordenada(muestra.getCoordenada())).thenReturn(true);
		
		assertTrue(desafio.esMuestraValida(muestra));
	}
	
	@Test
	void testEsMuestraInvalidaPorArea() {
		when(restriccion1.verificar(muestra.getFecha())).thenReturn(true);
		when(restriccion2.verificar(muestra.getFecha())).thenReturn(true);
		when(areaDesafio.verificarCoordenada(muestra.getCoordenada())).thenReturn(false);
		
		assertFalse(desafio.esMuestraValida(muestra));
	}

}
