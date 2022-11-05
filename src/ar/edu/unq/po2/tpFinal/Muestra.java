package ar.edu.unq.po2.tpFinal;

import java.util.Date;

public class Muestra {

	private Date fecha;
	Coordenada coordenada;

	public Muestra(Date fecha, Coordenada coordenada) {
		this.fecha = fecha;
		this.coordenada = coordenada;
	}

	public Date getFecha() {
		return fecha;
	}

	public Coordenada getCoordenada() {
		return coordenada;
	}

}
