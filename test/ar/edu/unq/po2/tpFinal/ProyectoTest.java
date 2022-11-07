package ar.edu.unq.po2.tpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProyectoTest {

	private Proyecto proyecto;	//SUT
	private String titulo;	//DOC
	private String descripcion;	//DOC
	private Categoria categoria1;	//DOC
	private Categoria categoria2;	//DOC
	private Desafio desafio1;	//DOC
	private Desafio desafio2;	//DOC
	private Usuario usuario1;	//DOC
	private Usuario usuario2;	//DOC
	private Muestra muestra1;	//DOC
	private Muestra muestra2;	//DOC
	private List<Categoria> categorias;	//DOC
	private List<Desafio> desafiosDisponibles;	//DOC
	private List<Usuario> usuarios;	//DOC
	private List<Muestra> muestras;	//DOC

	@BeforeEach
	void setUp() throws Exception {
		titulo = " esto es un titulo";
		descripcion = "esto es una descripción";
		categoria1 = mock(Categoria.class);
		categoria2 = mock(Categoria.class);
		desafio1 = mock(Desafio.class);
		desafio2 = mock(Desafio.class);
		usuario1 = mock(Usuario.class);
		usuario2 = mock(Usuario.class);
		muestra1 = mock(Muestra.class);
		muestra2 = mock(Muestra.class);
		categorias = Arrays.asList(categoria1, categoria2);
		desafiosDisponibles = Arrays.asList(desafio1, desafio2);
		usuarios = Arrays.asList(usuario1, usuario2);
		muestras = Arrays.asList(muestra1, muestra2);

		proyecto = new Proyecto(titulo, descripcion, categorias, desafiosDisponibles);
		proyecto.addMuestra(muestra1);
		proyecto.addMuestra(muestra2);
		
		
	}

	@Test
	void testgetDescripcion() {
		assertEquals(descripcion, proyecto.getDescripcion());
	}
	
	@Test
	void testgetMuestras() {
		assertEquals(muestras, proyecto.getMuestras());
	}

	@Test
	void testgetCategorias() {
		assertEquals(categorias, proyecto.getCategorias());
	}

	@Test
	void testgetDesafiosDisponibles() {
		assertEquals(desafiosDisponibles, proyecto.getDesafiosDisponibles());
	}

	@Test
	void testEstaDisponibleElDesafio() {
		assertTrue(proyecto.estaDisponible(desafio1));
	}

	@Test
	void testIncluyeTodasLasCategorias() {
		assertTrue(proyecto.incluyeCategorias(categorias));
	}

	@Test
	void testincluyeTextoEnTitulo() {
		String texto = "esto es";
		assertTrue(proyecto.incluyeTextoEnTitulo(texto));
	}
	
	@Test
	void testAddUsuario() {
		proyecto.addUsuario(usuario1);		
		assertEquals(Arrays.asList(usuario1),proyecto.getUsuarios());
	}
	
	@Test
	void testgetUsuarios() {
		proyecto.addUsuario(usuario1);
		proyecto.addUsuario(usuario2);
		assertEquals(usuarios, proyecto.getUsuarios());
	}

}
