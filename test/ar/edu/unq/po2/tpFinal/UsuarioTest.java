package ar.edu.unq.po2.tpFinal;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UsuarioTest {

	private Muestra muestra1;
	private Muestra muestra2;
	// private List<Muestra> muestrasDelUsuario;
	private Usuario usuario;
	private TipoRecomendacion recomendacion;
	private Desafio desafio1;
	private Desafio desafio2;
	private List<DesafioUsuario> desafiosUsuario;
	private DesafioUsuario desafioUsuario1;
	private DesafioUsuario desafioUsuario2;
	private DesafioUsuario desafioUsuario3;
	private Proyecto proyecto1;

	@BeforeEach
	void setUp() throws Exception {

		muestra1 = mock(Muestra.class);
		muestra2 = mock(Muestra.class);
		
		recomendacion = mock(TipoRecomendacion.class);
		
		
		desafio1 = mock(Desafio.class);
		desafio2 = mock(Desafio.class);
		
		desafioUsuario1 = mock(DesafioUsuario.class);
		desafioUsuario2 = mock(DesafioUsuario.class);
		desafioUsuario3 = mock(DesafioUsuario.class);
		desafiosUsuario = Arrays.asList(desafioUsuario1, desafioUsuario2, desafioUsuario3);
		
		proyecto1 = mock(Proyecto.class);

		
		usuario = new Usuario(2, 4, 5, recomendacion);
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
		usuario.setDesafiosUsuario(desafiosUsuario);
		
		assertEquals(desafiosUsuario, usuario.getDesafiosUsuario());
	}
	
	@Test
	void testAddDesafios() {
		usuario.addDesafioPorAceptar(desafio1);
		usuario.addDesafioPorAceptar(desafio2);
		
		assertEquals(2, usuario.getDesafiosUsuario().size());   //no los comparo con el get porque son clases diferentes cuando se agregan.
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
		usuario.setDesafiosUsuario(desafiosUsuario);
		when(desafioUsuario1.estaAceptadoAlMomento()).thenReturn(true);
		when(desafioUsuario2.estaAceptadoAlMomento()).thenReturn(false);
		when(desafioUsuario3.estaAceptadoAlMomento()).thenReturn(true);
		
		assertEquals(Arrays.asList(desafioUsuario1, desafioUsuario3), usuario.desafiosUsuarioAceptados());
	}
	
	@Test
	void testNotificarDesafios() {
		usuario.setDesafiosUsuario(desafiosUsuario);
		usuario.notificarDesafios(muestra1);
		
		verify(desafioUsuario1).evaluarMuestra(muestra1);
		verify(desafioUsuario2).evaluarMuestra(muestra1);
		verify(desafioUsuario3).evaluarMuestra(muestra1);
	}
	
	@Test
	void testAceptarDesafio() {
		usuario.setDesafiosUsuario(desafiosUsuario);
		usuario.addProyecto(proyecto1);
		when(desafioUsuario1.getDesafio()).thenReturn(desafio1);
		when(proyecto1.estaDisponible(desafio1)).thenReturn(true);
		when(desafioUsuario1.fueAceptadoPreviamente()).thenReturn(false);
		when(desafioUsuario2.fueAceptadoPreviamente()).thenReturn(true);
		usuario.aceptarDesafio(desafioUsuario1);

		
		verify(desafioUsuario1).serAceptado();
		verify(desafioUsuario2, times(0)).serAceptado();
	}

}

