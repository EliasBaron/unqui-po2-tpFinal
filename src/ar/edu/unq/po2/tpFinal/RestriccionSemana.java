package ar.edu.unq.po2.tpFinal;

import java.util.Calendar;
import java.util.Date;

public class RestriccionSemana extends RestriccionTemporal{
	
	/* en el return se hace la comparacion con >=2 y <= 6 porque el domingo es el dia 1 */

	@Override
	public boolean verificar(Date fechaAVerificar) {
		Calendar c = Calendar.getInstance();
		c.setTime(fechaAVerificar);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		return dayOfWeek >= 2 && dayOfWeek <= 6;
	}

}
