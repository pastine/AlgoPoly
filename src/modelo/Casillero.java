package modelo;

public class Casillero {
	//private Casillero anterior;
	private Casillero siguiente;
	
	public Casillero() {
		//anterior = null;
		siguiente = null;
	}
	
	public void agregarSiguiente(Casillero casillero) {
		this.siguiente = casillero;
	}
	
	public Casillero avanzar(int pasosTotal) {
		Casillero actual = this;
		for (int pasosDados = 0; pasosDados < pasosTotal; pasosDados ++) {
			actual = actual.siguiente;
		}
		return actual;
	}
}
