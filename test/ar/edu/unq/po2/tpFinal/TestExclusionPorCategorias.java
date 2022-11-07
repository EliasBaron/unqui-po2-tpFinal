package ar.edu.unq.po2.tpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestExclusionPorCategorias {

	private ExclusionPorCategoria exclusionPorCategoria;	//SUT
	private List<Proyecto> listaProyectos;
	private List<Categoria> listaCategoriasAExcluir;
	private Proyecto p1;	//DOC
	private Proyecto p2;	//DOC
	private Proyecto p3;	//DOC
	private Proyecto p4;	//DOC
	private Proyecto p5;	//DOC
	private Categoria c;	//DOC
	
	@BeforeEach
	void setUp() throws Exception {
		c = mock(Categoria.class);
		p1 = mock(Proyecto.class);
		p2 = mock(Proyecto.class);
		p3 = mock(Proyecto.class);
		p4 = mock(Proyecto.class);
		p5 = mock(Proyecto.class);
		
		listaProyectos = Arrays.asList(p1,p2,p3,p4,p5);
		listaCategoriasAExcluir = Arrays.asList(c);
		
		when(p1.incluyeCategorias(listaCategoriasAExcluir)).thenReturn(true);
		when(p2.incluyeCategorias(listaCategoriasAExcluir)).thenReturn(false);
		when(p3.incluyeCategorias(listaCategoriasAExcluir)).thenReturn(true);
		when(p4.incluyeCategorias(listaCategoriasAExcluir)).thenReturn(false);
		when(p5.incluyeCategorias(listaCategoriasAExcluir)).thenReturn(true);
		
		exclusionPorCategoria = new ExclusionPorCategoria(listaCategoriasAExcluir);
	}

	@Test
	void testFiltrar() {
		
		assertEquals(Arrays.asList(p2,p4), exclusionPorCategoria.filtrar(listaProyectos));
		
	}

}
