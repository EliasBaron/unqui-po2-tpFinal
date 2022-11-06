package ar.edu.unq.po2.tpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestDesafioCompleto {
	
	DesafioCompleto desafioCompleto;
	DesafioUsuario desafioUsuario;
	Date fechaSuperacion;

	@BeforeEach
	void setUp() throws Exception {
		desafioUsuario = mock(DesafioUsuario.class);
		
		desafioCompleto = new DesafioCompleto(desafioUsuario);
	}

	@Test
	void testGetMomentoSuperacion() {
		when(desafioUsuario.getMomentoSuperacion()).thenReturn(fechaSuperacion);
		
		assertEquals(fechaSuperacion, desafioCompleto.getMomentoSuperacion(fechaSuperacion));
	}
	
	@Test
	void testGetEstaCompleto() {
		assertTrue(desafioCompleto.getEstaCompleto());
	}
	
	@Test
	void testEstaAceptadoAlMomento() {
		assertFalse(desafioCompleto.estaAceptadoAlMomento());
	}
	
	@Test
	void testSerAceptadoDesafioUsuario() {
		assertTrue(desafioCompleto.fueAceptadoPreviamente());
	}
	
	@Test
	void testEvaluarMuestra() {
		desafioCompleto.evaluarMuestra(null, null); // EL METODO NO HACE NADA
	}
	
	@Test
	void puedeSerCalificado() {
		assertTrue(desafioCompleto.puedeSerCalificado());
	}
	
	@Test
	void testFueAceptadoPreviamente() {
		assertTrue(desafioCompleto.fueAceptadoPreviamente());
	}

}
