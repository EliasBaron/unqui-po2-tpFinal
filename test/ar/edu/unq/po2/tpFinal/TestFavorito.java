package ar.edu.unq.po2.tpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestFavorito {

	private Favorito favorito;//SUT
	private List<Desafio> listaDesafios;
	private Desafio d1;	//DOC
	private Desafio d2;	//DOC
	private Desafio d3;	//DOC
	private Desafio d4;	//DOC
	private Desafio d5;	//DOC
	private Desafio d6;	//DOC
	private Desafio d7;	//DOC
	private Desafio d8;	//DOC
	private Desafio d9;	//DOC
	private Desafio d10;	//DOC
	private Desafio desafioFavorito;	//DOC
	private Usuario usuario;	//DOC
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		d1 = mock(Desafio.class);
		d2 = mock(Desafio.class);
		d3 = mock(Desafio.class);
		d4 = mock(Desafio.class);
		d5 = mock(Desafio.class);
		d6 = mock(Desafio.class);
		d7 = mock(Desafio.class);
		d8 = mock(Desafio.class);
		d9 = mock(Desafio.class);
		d10 = mock(Desafio.class);
		desafioFavorito = mock(Desafio.class);
		
		
		when(d1.getCantidadDeMuestrasNecesarias()).thenReturn(5);
		when(d1.getDificultad()).thenReturn(5);
		when(d1.getRecompensa()).thenReturn(5);
		
		when(d2.getCantidadDeMuestrasNecesarias()).thenReturn(2);
		when(d2.getDificultad()).thenReturn(2);
		when(d2.getRecompensa()).thenReturn(2);
		
		when(d3.getCantidadDeMuestrasNecesarias()).thenReturn(3);
		when(d3.getDificultad()).thenReturn(3);
		when(d3.getRecompensa()).thenReturn(3);
		
		when(d4.getCantidadDeMuestrasNecesarias()).thenReturn(1);
		when(d4.getDificultad()).thenReturn(1);
		when(d4.getRecompensa()).thenReturn(1);
		
		when(d5.getCantidadDeMuestrasNecesarias()).thenReturn(12);
		when(d5.getDificultad()).thenReturn(12);
		when(d5.getRecompensa()).thenReturn(12);
		
		when(d6.getCantidadDeMuestrasNecesarias()).thenReturn(11);
		when(d6.getDificultad()).thenReturn(11);
		when(d6.getRecompensa()).thenReturn(11);
		
		when(d7.getCantidadDeMuestrasNecesarias()).thenReturn(10);
		when(d7.getDificultad()).thenReturn(10);
		when(d7.getRecompensa()).thenReturn(10);
		
		when(d8.getCantidadDeMuestrasNecesarias()).thenReturn(9);
		when(d8.getDificultad()).thenReturn(9);
		when(d8.getRecompensa()).thenReturn(9);
		
		when(d9.getCantidadDeMuestrasNecesarias()).thenReturn(8);
		when(d9.getDificultad()).thenReturn(8);
		when(d9.getRecompensa()).thenReturn(8);
		
		when(d10.getCantidadDeMuestrasNecesarias()).thenReturn(7);
		when(d10.getDificultad()).thenReturn(7);
		when(d10.getRecompensa()).thenReturn(7);
		
		when(desafioFavorito.getCantidadDeMuestrasNecesarias()).thenReturn(12);
		when(desafioFavorito.getDificultad()).thenReturn(12);
		when(desafioFavorito.getRecompensa()).thenReturn(12);
		
		listaDesafios = Arrays.asList(d1,d2,d3,d4,d5,d6,d7,d8,d9,d10);
		
		usuario = mock(Usuario.class);
		
		when(usuario.devolverDesafioMayorPuntaje()).thenReturn(desafioFavorito);
		
		when(usuario.getCantidadMuestrasPreferida()).thenReturn(5);
		when(usuario.getDificultadPreferida()).thenReturn(5);
		when(usuario.getRecompensaPreferida()).thenReturn(5);
		
		favorito = new Favorito();
		
	}

	@Test
	void testRecomendar() {	
		
		assertEquals(Arrays.asList(d5,d6,d7,d8,d9), favorito.recomendar(usuario, listaDesafios));
		
		
	}


}
