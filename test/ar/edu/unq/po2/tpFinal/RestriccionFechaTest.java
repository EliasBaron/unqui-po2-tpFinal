package ar.edu.unq.po2.tpFinal;

import static org.junit.jupiter.api.Assertions.*;


import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RestriccionFechaTest {
	
	private RestriccionFecha restriccionFecha;
	private Date fechaPrueba;
	private Date fechaInicio;
	private Date fechaFin;
	

	@BeforeEach
	void setUp() throws Exception {
		fechaInicio= new GregorianCalendar(2022, 05 - 1, 20).getTime();
		fechaFin = new GregorianCalendar(2022, 06 - 1, 20).getTime();
		restriccionFecha= new RestriccionFecha(fechaInicio,fechaFin);
	}

	@Test
	void testEntreFechas() {
		fechaPrueba= new GregorianCalendar(2022, 05 - 1, 27).getTime();
		assertTrue(restriccionFecha.verificar(fechaPrueba));
	}
	
	@Test
	void testMismaFechaInicio() {
		fechaPrueba= fechaInicio;
		assertTrue(restriccionFecha.verificar(fechaPrueba));
	}
	
	@Test
	void testMismaFechaFin() {
		fechaPrueba= fechaFin;
		assertTrue(restriccionFecha.verificar(fechaPrueba));
	}
	
	@Test
	void testFueraDeFecha() {
		fechaPrueba= new GregorianCalendar(2022, 07 - 1, 20).getTime();
		assertFalse(restriccionFecha.verificar(fechaPrueba));
	}

}
