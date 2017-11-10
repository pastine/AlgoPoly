package modelo;

public class Jugador {
	private int saldo;
	
	
	public Jugador() {
		this.saldo=100000;
	}
	
	public int verSaldo() {
		return this.saldo;
	}
	
	public void recibirDinero(int dinero) {
		this.saldo += dinero;
	}
	
	public void quitarDinero(int cantidad) {
		this.saldo -= cantidad;
	}
}
