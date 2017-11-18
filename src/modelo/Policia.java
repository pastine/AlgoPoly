package modelo;

import modelo.Carcel;
import modelo.jugador.Jugador;

public class Policia {
    private Carcel carcel;

    public Policia(Carcel carcel){
        this.carcel = carcel;
    }

    public void apresarJugador(Jugador jugador){
        this.carcel.agregarJugador(jugador);
    }
}
