package ar.edu.unq.po2.tpFinal;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RestriccionSemanaTest {
	private RestriccionSemana restriccionSemana;

	private Date fechaPrueba;

	@BeforeEach
	void setUp() throws Exception {
		restriccionSemana = new RestriccionSemana();
	}

	@Test
	void testDiaViernes() {
		fechaPrueba = new GregorianCalendar(2022, 5-1, 27).getTime();
		assertTrue(restriccionSemana.verificar(fechaPrueba));
	}
	
	@Test
	void testDiaLunes() {
		fechaPrueba = new GregorianCalendar(2022, 11-1, 01).getTime();
		assertTrue(restriccionSemana.verificar(fechaPrueba));
	}

	@Test
	void testDiaSabado() {
		fechaPrueba = new GregorianCalendar(2022, 10-1, 29).getTime();
		assertFalse(restriccionSemana.verificar(fechaPrueba));
	}
	
	@Test
	void testDiaDomingo() {
		fechaPrueba = new GregorianCalendar(2022, 10-1, 30).getTime();
		assertFalse(restriccionSemana.verificar(fechaPrueba));
	}
}
