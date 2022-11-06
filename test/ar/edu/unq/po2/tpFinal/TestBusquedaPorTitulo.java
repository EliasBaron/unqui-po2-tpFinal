package ar.edu.unq.po2.tpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestBusquedaPorTitulo {
	
	private BusquedaPorTitulo buscador;
	List<Proyecto> listaProyectos;
	Proyecto p1;
	Proyecto p2;
	Proyecto p3;
	Proyecto p4;
	Proyecto p5;
	String texto;
	
	@BeforeEach
	void setUp() throws Exception {
		p1 = mock(Proyecto.class);
		p2 = mock(Proyecto.class);
		p3 = mock(Proyecto.class);
		p4 = mock(Proyecto.class);
		p5 = mock(Proyecto.class);
		texto = "Hola";
		
		listaProyectos = Arrays.asList(p1,p2,p3,p4,p5);
		
		when(p1.incluyeTextoEnTitulo(texto)).thenReturn(true);
		when(p2.incluyeTextoEnTitulo(texto)).thenReturn(false);
		when(p3.incluyeTextoEnTitulo(texto)).thenReturn(true);
		when(p4.incluyeTextoEnTitulo(texto)).thenReturn(false);
		when(p5.incluyeTextoEnTitulo(texto)).thenReturn(true);
		
		buscador = new BusquedaPorTitulo(texto);
	}

	@Test
	void testFiltrar() {
		
		assertEquals(Arrays.asList(p1,p3,p5), buscador.filtrar(listaProyectos));
		
	}
}
