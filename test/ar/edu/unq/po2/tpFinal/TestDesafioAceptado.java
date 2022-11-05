package ar.edu.unq.po2.tpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestDesafioAceptado {

	DesafioAceptado desafioAceptado;
	DesafioUsuario desafioUsuario;
	Desafio desafio;
	Muestra muestra;
	
	@BeforeEach
	void setUp() throws Exception {
		desafioUsuario = mock(DesafioUsuario.class);
		desafio = mock(Desafio.class);
		muestra = mock(Muestra.class);
		
		desafioAceptado = new DesafioAceptado(desafioUsuario);
	}

	@Test
	void testGetMomentoSuperacion() {
		assertEquals(null, desafioAceptado.getMomentoSuperacion(null));
	}
	
	@Test
	void testGetEstaCompleto() {
		assertFalse(desafioAceptado.getEstaCompleto());
	}
	
	@Test
	void testEstaAceptadoAlMomento() {
		assertTrue(desafioAceptado.estaAceptadoAlMomento());
	}
	
	@Test
	void testSerAceptado() {
		desafioAceptado.serAceptadoDesafioUsuario(desafioUsuario); // no hace nada
	}
	
	@Test
	void testEvaluarMuestra() {
		when(desafio.esMuestraValida(muestra)).thenReturn(true);
		desafioAceptado.evaluarMuestra(muestra, desafio);
		
		verify(desafioUsuario).sumarMuestra(muestra);
	}
	
	@Test
	void testPuedeSerCalificado() {
		assertTrue(desafioAceptado.puedeSerCalificado());
	}

}
