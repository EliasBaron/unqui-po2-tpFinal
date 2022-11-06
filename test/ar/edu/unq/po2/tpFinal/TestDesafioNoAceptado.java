package ar.edu.unq.po2.tpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestDesafioNoAceptado {

	DesafioNoAceptado desafioNoAceptado; //SUT
	DesafioUsuario desafioUsuario; //DOC
	EstadoDesafioUsuario estado;
	
	@BeforeEach
	void setUp() throws Exception {
		desafioUsuario = mock(DesafioUsuario.class);
		estado = mock(EstadoDesafioUsuario.class);
		
		desafioNoAceptado = new DesafioNoAceptado(desafioUsuario);
	}

	@Test
	void testGetMomentoSuperacion() {
		assertEquals(null, desafioNoAceptado.getMomentoSuperacion(null));
	}
	
	@Test
	void testGetEstaCompleto() {
		assertFalse(desafioNoAceptado.getEstaCompleto());
	}
	
	@Test
	void testEstaAceptadoAlMomento() {
		assertFalse(desafioNoAceptado.estaAceptadoAlMomento());
	}
	
	@Test
	void testPuedeSerCalificado() {
		assertFalse(desafioNoAceptado.puedeSerCalificado());
	}
	
	@Test
	void testFueAceptadoPreviamente() {
		assertFalse(desafioNoAceptado.fueAceptadoPreviamente());
	}

}
