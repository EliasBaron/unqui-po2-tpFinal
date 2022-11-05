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
	private DesafioUsuario desafio1;
	private DesafioUsuario desafio2;
	private Proyecto proyecto1;
	private Desafio desafio;

	@BeforeEach
	void setUp() throws Exception {

		muestra1 = mock(Muestra.class);
		muestra2 = mock(Muestra.class);
		recomendacion = mock(TipoRecomendacion.class);
		usuario = new Usuario(2, 4, 5, recomendacion);
		desafio1 = mock(DesafioUsuario.class);
		desafio2 = mock(DesafioUsuario.class);
		proyecto1 = mock(Proyecto.class);
		desafio = mock(Desafio.class);
		when(desafio1.getDesafio()).thenReturn(desafio);

		usuario.addProyecto(proyecto1);
		//usuario.agregarDesafioPorAceptar(desafio1.getDesafio());

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

//	@Test
//	void testDesafiosUsuarioAceptados() {
//		when(proyecto1.estaDisponible(desafio1.getDesafio())).thenReturn(true);
//		usuario.aceptarDesafio(desafio1);
//		when(desafio1.estaAceptadoAlMomento()).thenReturn(true);
//		when(desafio2.estaAceptadoAlMomento()).thenReturn(false);
//		assertEquals(Arrays.asList(desafio1), usuario.desafiosUsuarioAceptados());
//	}

	@Test
	void testNotificacionDesafios() {
		
		usuario.addMuestra(muestra1);
		usuario.notificarDesafios(muestra1);
	    verify(desafio1,times(1)).evaluarMuestra(muestra1);
		
		
		
	}

//	@Test
//	void testgetDesafiosCompletos() {
//		usuario.estaCompletoDesafio(desafio1);
//		assertEquals(Arrays.asList(desafio1),usuario.getDesafiosCompletos());
//	}
}
