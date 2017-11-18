package modelo;

import modelo.Carcel;
import modelo.jugador.Jugador;

public class Policia extends Casillero{
    private Carcel carcel;

    public Policia(Carcel carcel){
        this.carcel = carcel;
    }
    
    public void agregarJugador(Jugador jugador){
    	apresarJugador(jugador);
    }

    private void apresarJugador(Jugador jugador){
        this.carcel.agregarJugador(jugador);
    }
}
