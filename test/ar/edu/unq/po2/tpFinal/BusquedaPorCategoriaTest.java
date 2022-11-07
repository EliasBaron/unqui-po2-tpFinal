package ar.edu.unq.po2.tpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BusquedaPorCategoriaTest {

	private BusquedaPorCategoria busqueda;	//SUT
	private Categoria categoria1;	//DOC
	private Categoria categoria2;	//DOC
	private Categoria categoria3;	//DOC
	private List<Categoria> categoriasAIncluir;	//DOC
	private List<Proyecto> proyectos;	//DOC
	private Proyecto p1;	//DOC
	private Proyecto p2;	//DOC
	private Proyecto p3;	//DOC
	private Proyecto p4;	//DOC
	private Proyecto p5;	//DOC
	
	@BeforeEach
	void setUp() throws Exception {
		
		categoria1 = mock(Categoria.class);
		categoria2 = mock(Categoria.class);
		categoria3 = mock(Categoria.class);
		categoriasAIncluir = Arrays.asList(categoria1,categoria2,categoria3);
		p1 = mock(Proyecto.class);
		p2 = mock(Proyecto.class);
		p3 = mock(Proyecto.class);
		p4 = mock(Proyecto.class);
		p5 = mock(Proyecto.class);
		proyectos = Arrays.asList(p1,p2,p3,p4,p5);
		
		when(p1.incluyeCategorias(categoriasAIncluir)).thenReturn(true);
		when(p2.incluyeCategorias(categoriasAIncluir)).thenReturn(false);
		when(p3.incluyeCategorias(categoriasAIncluir)).thenReturn(true);
		when(p4.incluyeCategorias(categoriasAIncluir)).thenReturn(false);
		when(p5.incluyeCategorias(categoriasAIncluir)).thenReturn(true);
		
		busqueda = new BusquedaPorCategoria(categoriasAIncluir);
	}

	@Test
	void testFiltrar() {
		
		assertEquals(Arrays.asList(p1,p3,p5), busqueda.filtrar(proyectos));
		
	}

}
