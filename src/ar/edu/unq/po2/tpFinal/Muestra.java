package ar.edu.unq.po2.tpFinal;

import java.util.Date;

public class Muestra {

	private Date fecha;
	private double hora;
	Coordenada coordenada;

	public Muestra(Date fecha, double hora, Coordenada coordenada) {
		this.fecha = fecha;
		this.hora = hora;
		this.coordenada = coordenada;
	}

	public Date getFecha() {
		return fecha;
	}

	public double getHora() {
		return hora;
	}

	public Coordenada getCoordenada() {
		return coordenada;
	}

}
