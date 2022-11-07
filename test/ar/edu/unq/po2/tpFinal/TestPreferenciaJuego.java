package ar.edu.unq.po2.tpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestPreferenciaJuego {

	private PreferenciaJuego preferenciaJuego;//SUT
	private List<Desafio> listaDesafios;
	private Desafio d1;	//DOC
	private Desafio d2;	//DOC
	private Desafio d3;	//DOC
	private Desafio d4;	//DOC
	private Desafio d5;	//DOC
	private Desafio d6;	//DOC
	private Usuario usuario;	//DOC
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		d1 = mock(Desafio.class);
		d2 = mock(Desafio.class);
		d3 = mock(Desafio.class);
		d4 = mock(Desafio.class);
		d5 = mock(Desafio.class);
		d6 = mock(Desafio.class);
		
		when(d1.getCantidadDeMuestrasNecesarias()).thenReturn(5);
		when(d1.getDificultad()).thenReturn(5);
		when(d1.getRecompensa()).thenReturn(5);
		
		when(d2.getCantidadDeMuestrasNecesarias()).thenReturn(7);
		when(d2.getDificultad()).thenReturn(7);
		when(d2.getRecompensa()).thenReturn(7);
		
		when(d3.getCantidadDeMuestrasNecesarias()).thenReturn(6);
		when(d3.getDificultad()).thenReturn(6);
		when(d3.getRecompensa()).thenReturn(6);
		
		when(d4.getCantidadDeMuestrasNecesarias()).thenReturn(8);
		when(d4.getDificultad()).thenReturn(8);
		when(d4.getRecompensa()).thenReturn(8);
		
		when(d5.getCantidadDeMuestrasNecesarias()).thenReturn(12);
		when(d5.getDificultad()).thenReturn(12);
		when(d5.getRecompensa()).thenReturn(12);
		
		when(d6.getCantidadDeMuestrasNecesarias()).thenReturn(9);
		when(d6.getDificultad()).thenReturn(9);
		when(d6.getRecompensa()).thenReturn(9);
		
		listaDesafios = Arrays.asList(d1,d2,d3,d4,d5,d6);
		
		usuario = mock(Usuario.class);
		
		when(usuario.getCantidadMuestrasPreferida()).thenReturn(5);
		when(usuario.getDificultadPreferida()).thenReturn(5);
		when(usuario.getRecompensaPreferida()).thenReturn(5);
		
		preferenciaJuego = new PreferenciaJuego();
		
	}

	@Test
	void testRecomendar() {	
		assertEquals(Arrays.asList(d1,d3,d2,d4,d6), preferenciaJuego.recomendar(usuario, listaDesafios));
	}

}
