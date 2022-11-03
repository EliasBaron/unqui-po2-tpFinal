package ar.edu.unq.po2.tpFinal;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class DesafioTest {
	
	private Desafio desafio;
	private List<RestriccionTemporal> restriccionesTemporales;
	private Date fechaInicio;
	private Date fechaFin;
	private RestriccionSemana restriccionSemana;
	private RestriccionFecha restriccionFecha;
	private Area areaDesafio;
	private Coordenada coordenadaDesafio;
	
	private Muestra muestraTest;
	private Coordenada coordenadaMuestra;
	private Date fechaMuestra;
	
	
	private Area area;
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		fechaInicio = new GregorianCalendar(2022, 05 - 1, 01).getTime();
		fechaFin = new GregorianCalendar(2022, 05 - 1, 31).getTime();
		restriccionSemana = new RestriccionSemana();
		restriccionFecha = new RestriccionFecha(fechaInicio, fechaFin);
		restriccionesTemporales = new ArrayList<>(Arrays.asList(restriccionFecha, restriccionSemana));
		coordenadaDesafio = new Coordenada(10, 10);
		areaDesafio = new Area(coordenadaDesafio, 10);
		desafio = new Desafio(0, 0, 0, areaDesafio, restriccionesTemporales);
		
	}

	@Test
	void testRestriccionesTemporalesValidas() {
		coordenadaMuestra = new Coordenada(10, 10);
		fechaMuestra = new GregorianCalendar(2022, 05 - 1, 27).getTime();
		muestraTest = new Muestra(fechaMuestra, 0, coordenadaMuestra);

		assertTrue(desafio.verificarRestriccionesTemporales(muestraTest));
	}
	
	@Test
	void testRestriccionesTemporalesInvalidasPorFinde() {
		coordenadaMuestra = new Coordenada(10, 10);
		fechaMuestra = new GregorianCalendar(2022, 05 - 1, 28).getTime();
		muestraTest = new Muestra(fechaMuestra, 0, coordenadaMuestra);

		assertFalse(desafio.verificarRestriccionesTemporales(muestraTest));
	}
	
	@Test
	void testRestriccionesTemporalesInvalidasPorFueraDeFechaPeroSemana() {
		coordenadaMuestra = new Coordenada(10, 10);
		fechaMuestra = new GregorianCalendar(2022, 11 - 1, 02).getTime();
		muestraTest = new Muestra(fechaMuestra, 0, coordenadaMuestra);

		assertFalse(desafio.verificarRestriccionesTemporales(muestraTest));
	}
	
	@Test
	void esMuestraValida() {
		coordenadaMuestra = new Coordenada(15, 18);
		fechaMuestra = new GregorianCalendar(2022, 05 - 1, 27).getTime();
		muestraTest = new Muestra(fechaMuestra, 0, coordenadaMuestra);
		
		assertTrue(desafio.esMuestraValida(muestraTest));
	}
	
	@Test
	void esMuestraInvalidaPorAreaSolamente() {
		coordenadaMuestra = new Coordenada(30, 20);
		fechaMuestra = new GregorianCalendar(2022, 05 - 1, 27).getTime();
		muestraTest = new Muestra(fechaMuestra, 0, coordenadaMuestra);
		
		assertFalse(desafio.esMuestraValida(muestraTest));
	}
	
	@Test
	void esMuestraInvalidaPorFechaSolamente() {
		coordenadaMuestra = new Coordenada(12, 15);
		fechaMuestra = new GregorianCalendar(2022, 10 - 1, 27).getTime();
		muestraTest = new Muestra(fechaMuestra, 0, coordenadaMuestra);
		
		assertFalse(desafio.esMuestraValida(muestraTest));
	}
	
	@Test
	void esMuestraInvalidaPorFechaYArea() {
		coordenadaMuestra = new Coordenada(30, 15);
		fechaMuestra = new GregorianCalendar(2022, 10 - 1, 27).getTime();
		muestraTest = new Muestra(fechaMuestra, 0, coordenadaMuestra);
		
		assertFalse(desafio.esMuestraValida(muestraTest));
	}

}
