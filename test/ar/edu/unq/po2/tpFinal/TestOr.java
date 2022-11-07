package ar.edu.unq.po2.tpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestOr {
	
	private Or or;	//SUT
	private Filtro operando1;	//DOC
	private Filtro operando2;	//DOC
	private List<Proyecto> listaProyectos;
	private Proyecto p1;	//DOC
	private Proyecto p2;	//DOC
	private Proyecto p3;	//DOC
	private Proyecto p4;	//DOC
	private Proyecto p5;	//DOC


	@BeforeEach
	void setUp() throws Exception {
		
		operando1 = mock(Filtro.class);
		operando2 = mock(Filtro.class);
		p1 = mock(Proyecto.class);
		p2 = mock(Proyecto.class);
		p3 = mock(Proyecto.class);
		p4 = mock(Proyecto.class);
		p5 = mock(Proyecto.class);
		
		listaProyectos = Arrays.asList(p1,p2,p3,p4,p5);
		
		
		or = new Or(operando1, operando2);
	}
	
	@Test
	void testFiltrar() {
		when(operando1.filtrar(listaProyectos)).thenReturn(Arrays.asList(p1,p2));
		when(operando2.filtrar(listaProyectos)).thenReturn(Arrays.asList(p4,p5));
		
		assertEquals(Arrays.asList(p1,p2,p4,p5), or.filtrar(listaProyectos));
	}

}
