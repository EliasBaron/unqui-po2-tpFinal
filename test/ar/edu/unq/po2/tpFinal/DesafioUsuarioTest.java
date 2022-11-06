package ar.edu.unq.po2.tpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DesafioUsuarioTest {

	DesafioUsuario desafioUsuario; //SUT
	Desafio desafio; //DOC
	EstadoDesafioUsuario estadoAceptado; //DOC
	EstadoDesafioUsuario estadoNoAceptado; //DOC
//	EstadoDesafioUsuario estadoCompleto; //DOC
	Date fechaSuperacion; //DOC
	Muestra muestra; //DOC
	
	@BeforeEach
	void setUp() throws Exception {
		desafio = mock(Desafio.class);
		when(desafio.getCantidadDeMuestrasNecesarias()).thenReturn(4);
		estadoNoAceptado = mock(DesafioNoAceptado.class);
		estadoAceptado = mock(DesafioAceptado.class);
//		estadoCompleto = mock(DesafioCompleto.class);
		
		fechaSuperacion = mock(Date.class);
		muestra = mock(Muestra.class);
		

		desafioUsuario = new DesafioUsuario(desafio);
	}

	@Test
	void testGetMomentoSuperacion() {
		assertEquals(null, desafioUsuario.getMomentoSuperacion());
	}
	
	@Test
	void getEstaCompletoEstadoInicio() {
		assertFalse(desafioUsuario.getEstaCompleto());
	}
	
	@Test
	void testFueAceptadoPreviamente() {
		assertFalse(desafioUsuario.fueAceptadoPreviamente());
	}
	
	@Test
	void noAgregaMuestrasEstadoInicial() {
		when(desafio.esMuestraValida(muestra)).thenReturn(true);
		desafioUsuario.evaluarMuestra(muestra);
		desafioUsuario.evaluarMuestra(muestra);
		desafioUsuario.evaluarMuestra(muestra);
		desafioUsuario.evaluarMuestra(muestra);
		
		assertFalse(desafioUsuario.getEstaCompleto());
	}
	
	@Test
	void testGetEstaCompletoEstandoCompleto() {
		desafioUsuario.serAceptado();
		when(desafio.esMuestraValida(muestra)).thenReturn(true);
		desafioUsuario.evaluarMuestra(muestra);
		desafioUsuario.evaluarMuestra(muestra);
		desafioUsuario.evaluarMuestra(muestra);
		desafioUsuario.evaluarMuestra(muestra);
		
		assertTrue(desafioUsuario.getEstaCompleto());
	}
	
	@Test
	void getEstaAceptadoAlMomentoYSerAceptado() {
		desafioUsuario.serAceptado();
		
		assertTrue(desafioUsuario.estaAceptadoAlMomento());
	}
	
	@Test
	void testGetEstaAceptado() {
		assertFalse(desafioUsuario.estaAceptadoAlMomento());
	}
	
	@Test
	void testSetEstado() {
		desafioUsuario.setEstado(new DesafioAceptado(desafioUsuario));  //no puedo hacer funcionar el setEstado usando mocks.
		
		assertTrue(desafioUsuario.estaAceptadoAlMomento());
	}
	
	@Test
	void testGetDesafio() {
		assertEquals(desafio, desafioUsuario.getDesafio());
	}
	
	@Test
	void testGetEstado() {
		DesafioAceptado desafioEstado = new DesafioAceptado(desafioUsuario); //no me funciona con mockito
		desafioUsuario.setEstado(desafioEstado);
		
		assertEquals(desafioEstado, desafioUsuario.getEstado());
	}
	
	@Test
	void testRecibirCalificacionEnEstadoNoAceptadoYGetCalificacion() {
		desafioUsuario.recibirCalificacion(5);
		
		assertEquals(0, desafioUsuario.getCalificacion());
	}
	
	@Test
	void testRecibirCalificacionEnEstadoAceptadoYGetCalificacion() {
		desafioUsuario.serAceptado();
		desafioUsuario.recibirCalificacion(5);
		
		assertEquals(5, desafioUsuario.getCalificacion());
	}
	
	@Test
	void testGetPorcentajeCompletitud0() {
		assertEquals(0, desafioUsuario.getPorcentajeCompletitud());
	}
	
	@Test
	void testGetPorcentajeCompletitud100() {
		desafioUsuario.serAceptado();
		when(desafio.esMuestraValida(muestra)).thenReturn(true);
		desafioUsuario.evaluarMuestra(muestra);
		desafioUsuario.evaluarMuestra(muestra);
		desafioUsuario.evaluarMuestra(muestra);
		desafioUsuario.evaluarMuestra(muestra);
		
		
		assertEquals(100, desafioUsuario.getPorcentajeCompletitud());
	}
}
