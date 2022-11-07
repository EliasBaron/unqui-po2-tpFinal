package ar.edu.unq.po2.tpFinal;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UsuarioTest {
	
	private Usuario usuario; 	//SUT
	private Muestra muestra1;	//DOC
	private TipoRecomendacion recomendacion;	//DOC
	private Desafio desafio1;	//DOC
	private Desafio desafio2;	//DOC
	private List<DesafioUsuario> desafiosUsuario;
	private DesafioUsuario desafioUsuario1;	//DOC
	private DesafioUsuario desafioUsuario2;	//DOC
	private DesafioUsuario desafioUsuario3;	//DOC
	private Proyecto proyecto1;	//DOC
	private TipoRecomendacion recomendacion2;	//DOC
	

	@BeforeEach
	void setUp() throws Exception {

		muestra1 = mock(Muestra.class);

		recomendacion = mock(TipoRecomendacion.class);
		recomendacion2 = mock(TipoRecomendacion.class);

		desafio1 = mock(Desafio.class);
		desafio2 = mock(Desafio.class);

		desafioUsuario1 = mock(DesafioUsuario.class);
		desafioUsuario2 = mock(DesafioUsuario.class);
		desafioUsuario3 = mock(DesafioUsuario.class);

		desafiosUsuario = Arrays.asList(desafioUsuario1, desafioUsuario2, desafioUsuario3);

		proyecto1 = mock(Proyecto.class);

		usuario = new Usuario(2, 4, 5, recomendacion);
		
		usuario.setDesafiosUsuario(desafiosUsuario);
	}

	@Test
	void testGetRecomendacionPreferida() {
		assertEquals(recomendacion, usuario.getRecomendacionPreferida());
	}

	@Test
	void testGetProyectosUsuarioYAddProyecto() {
		usuario.addProyecto(proyecto1);
		assertEquals(Arrays.asList(proyecto1), usuario.getProyectosUsuario());
	}

	@Test
	void testGetyAddMuestrasUsuario() {
		usuario.addMuestra(muestra1);
		assertEquals(Arrays.asList(muestra1), usuario.getMuestrasUsuario());
	}

	@Test
	void getSetYGetDesafiosUsuario() {
		assertEquals(desafiosUsuario, usuario.getDesafiosUsuario());
	}

	@Test
	void testAddDesafios() {
		Usuario u2 = new Usuario(0,0,0,recomendacion);
		u2.addDesafioPorAceptar(desafio1);
		u2.addDesafioPorAceptar(desafio2);

		assertEquals(2, u2.getDesafiosUsuario().size()); // no los comparo con el get 
															  //porque son clases diferentes													// cuando se agregan.
	}

	@Test
	void testgetCantidadMuestrasPreferidas() {
		assertEquals(2, usuario.getCantidadMuestrasPreferida());
	}

	@Test
	void testgetDificultadPreferida() {
		assertEquals(4, usuario.getDificultadPreferida());

	}

	@Test
	void testgetRecompensaPreferida() {
		assertEquals(5, usuario.getRecompensaPreferida());

	}

	@Test
	void testDesafiosUsuarioAceptados() {
		when(desafioUsuario1.estaAceptadoAlMomento()).thenReturn(true);
		when(desafioUsuario2.estaAceptadoAlMomento()).thenReturn(false);
		when(desafioUsuario3.estaAceptadoAlMomento()).thenReturn(true);

		assertEquals(Arrays.asList(desafioUsuario1, desafioUsuario3), usuario.desafiosUsuarioAceptados());
	}

	@Test
	void testNotificarDesafios() {
		usuario.notificarDesafios(muestra1);

		verify(desafioUsuario1).evaluarMuestra(muestra1);
		verify(desafioUsuario2).evaluarMuestra(muestra1);
		verify(desafioUsuario3).evaluarMuestra(muestra1);
	}

	@Test
	void testAceptarDesafio() {
		usuario.addProyecto(proyecto1);
		when(desafioUsuario1.getDesafio()).thenReturn(desafio1);
		when(proyecto1.estaDisponible(desafio1)).thenReturn(true);
		when(desafioUsuario1.fueAceptadoPreviamente()).thenReturn(false);
		when(desafioUsuario2.fueAceptadoPreviamente()).thenReturn(true);
		usuario.aceptarDesafio(desafioUsuario1);

		verify(desafioUsuario1).serAceptado();
		verify(desafioUsuario2, times(0)).serAceptado();
	}

	@Test
	void testgetDesafiosCompletos() {
		when(desafioUsuario1.getEstaCompleto()).thenReturn(true);
		when(desafioUsuario2.getEstaCompleto()).thenReturn(true);

		assertEquals(Arrays.asList(desafioUsuario1, desafioUsuario2), usuario.getDesafiosCompletos());

	}

	@Test
	void testgetPromedioPorcentajeCompletitud() {
		when(desafioUsuario1.getEstaCompleto()).thenReturn(true);
		when(desafioUsuario2.getEstaCompleto()).thenReturn(true);
		when(desafioUsuario3.getEstaCompleto()).thenReturn(true);

		assertEquals(100, usuario.getPromedioPorcentajeCompletitud());

	}

	@Test
	void excluirDesafiosAceptados() {
		List<Desafio> desafiosAFiltrar = Arrays.asList(desafio1, desafio2);

		when(desafioUsuario1.getDesafio()).thenReturn(desafio1);
		when(desafioUsuario1.estaAceptadoAlMomento()).thenReturn(true);
		when(desafioUsuario2.estaAceptadoAlMomento()).thenReturn(true);
		when(desafioUsuario3.estaAceptadoAlMomento()).thenReturn(false);

		assertEquals(Arrays.asList(desafio2), usuario.excluirDesafiosAceptados(desafiosAFiltrar));
	}

	@Test
	void testEstaCompletoDesafio() {
		when(desafioUsuario1.getEstaCompleto()).thenReturn(true);

		assertTrue(usuario.estaCompletoDesafio(desafioUsuario1));
	}

	@Test
	void testCalificarDesafio() {
		usuario.calificarDesafio(desafioUsuario1, 5);
		verify(desafioUsuario1).recibirCalificacion(5);
	}

	@Test
	void testFechaSuperacion() {
		Date fechaDesafio = mock(Date.class);

		when(desafioUsuario1.getMomentoSuperacion()).thenReturn(fechaDesafio);

		assertEquals(fechaDesafio, usuario.fechaSuperacionDesafio(desafioUsuario1));
	}

	@Test
	void testDevolverDesafioMayorPuntaje() {		
		when(desafioUsuario1.getEstaCompleto()).thenReturn(true);
		when(desafioUsuario2.getEstaCompleto()).thenReturn(true);
		when(desafioUsuario3.getEstaCompleto()).thenReturn(true);
		
		when(desafioUsuario1.getDesafio()).thenReturn(desafio1);
		when(desafioUsuario2.getDesafio()).thenReturn(desafio2);
		when(desafioUsuario3.getDesafio()).thenReturn(desafio1);

		when(desafioUsuario1.getCalificacion()).thenReturn(4);
		when(desafioUsuario2.getCalificacion()).thenReturn(5);
		when(desafioUsuario3.getCalificacion()).thenReturn(3);

		assertEquals(desafio2, usuario.devolverDesafioMayorPuntaje());
	}
	
	@Test
	void testRecibirRecomendacion() {
		Usuario u2 = new Usuario(0,0,0,recomendacion);
		List<Desafio> desafios = Arrays.asList(desafio1, desafio2);
		when(recomendacion.recomendar(u2, desafios)).thenReturn(desafios);
		u2.recibirRecomendaciones(desafios);
		
		assertEquals(2,u2.getDesafiosUsuario().size());
	}
	
	@Test
	void testCambiarRecomendacion() {
		when(recomendacion.cambiarRecomendacion()).thenReturn(recomendacion2);
		usuario.cambiarTipoRecomendacion();
		
		
		assertEquals(recomendacion2,usuario.getRecomendacionPreferida());
		
	}
	
	@Test
	void testCambiarRecomendaciona() {
		when(recomendacion.cambiarRecomendacion()).thenReturn(recomendacion2);
		usuario.cambiarTipoRecomendacion();
		
		
		verify(recomendacion).cambiarRecomendacion();
		
	}
	
	@Test
	void testSetDesafiosUsuarios() {
		assertEquals(desafiosUsuario,usuario.getDesafiosUsuario());
	}

}
