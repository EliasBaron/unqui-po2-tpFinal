package ar.edu.unq.po2.tpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestAnd {

	And and;
	Filtro operando1;
	Filtro operando2;
	List<Proyecto> listaProyectos;
	Proyecto p1;
	Proyecto p2;
	Proyecto p3;
	Proyecto p4;
	Proyecto p5;

	@BeforeEach
	void setUp() throws Exception {

		operando1 = mock(Filtro.class);
		operando2 = mock(Filtro.class);
		p1 = mock(Proyecto.class);
		p2 = mock(Proyecto.class);
		p3 = mock(Proyecto.class);
		p4 = mock(Proyecto.class);
		p5 = mock(Proyecto.class);

		listaProyectos = Arrays.asList(p1, p2, p3, p4, p5);

		and = new And(operando1, operando2);

	}

	@Test
	void testFiltrarAlgunosProyectos() {
		when(operando1.filtrar(listaProyectos)).thenReturn(Arrays.asList(p3, p4, p5));
		when(operando2.filtrar(listaProyectos)).thenReturn(Arrays.asList(p1, p2, p3));

		assertEquals(Arrays.asList(p3), and.filtrar(listaProyectos));
	}

}
