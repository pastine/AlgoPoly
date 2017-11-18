package modelo;

public class Terreno extends Casillero{
	private int precio;
	
	public Terreno(int unPrecio) {
		this.precio = unPrecio;
	}
	
	public int obtenerPrecio() {
		return precio;
	}
}
