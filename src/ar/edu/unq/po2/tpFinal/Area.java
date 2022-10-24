package ar.edu.unq.po2.tpFinal;

public class Area {
	private Coordenada coordenada;
	private int radio;

	public Area(Coordenada coordenada, int radio) {
		this.coordenada = coordenada;
		this.radio = radio;
	}
	
	public boolean verificarCoordenada(Coordenada coordenadaAVerificar) {
		double xCentro = coordenada.getX();
		double yCentro = coordenada.getY();
		double xCoordenada = coordenadaAVerificar.getX();
		double yCoordenada = coordenadaAVerificar.getY();
		
		return(Math.sqrt(Math.pow((xCentro - xCoordenada), 2) + Math.pow((yCentro - yCoordenada), 2)) <= radio);
	}

}
