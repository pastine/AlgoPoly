package modelo.casillero;

import modelo.jugador.Jugador;

public class Policia extends Casillero{
    private final Carcel carcel;

    public Policia(Carcel carcel){
        this.carcel = carcel;
    }
    
    public void accionar(Jugador jugador, int pasosTotal){
    	apresarJugador(jugador, pasosTotal);
    }

    private void apresarJugador(Jugador jugador, int pasosTotal){
        this.carcel.agregarJugador(jugador, pasosTotal);
    }
}
