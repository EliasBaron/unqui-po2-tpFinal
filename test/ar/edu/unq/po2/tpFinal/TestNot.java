package ar.edu.unq.po2.tpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestNot {
	
	Not not;
	Filtro operando;
	List<Proyecto> listaProyectos;
	Proyecto p1;
	Proyecto p2;
	Proyecto p3;
	Proyecto p4;
	Proyecto p5;


	@BeforeEach
	void setUp() throws Exception {
		
		operando = mock(Filtro.class);
		p1 = mock(Proyecto.class);
		p2 = mock(Proyecto.class);
		p3 = mock(Proyecto.class);
		p4 = mock(Proyecto.class);
		p5 = mock(Proyecto.class);
		
		listaProyectos = Arrays.asList(p1,p2,p3,p4,p5);
		
		
		not = new Not(operando);
	}

	@Test
	void testFiltrarAlgunosProyectos() {
		when(operando.filtrar(listaProyectos)).thenReturn(Arrays.asList(p4,p5));
		
		assertEquals(Arrays.asList(p1,p2,p3), not.filtrar(listaProyectos));
	}

}
