package modelo;

import modelo.Carcel;

public class Policia {
    private Carcel carcel;

    public Policia(Carcel carcel){
        this.carcel = carcel;
    }

    public void apresarJugador(Jugador jugador){
        this.carcel.apresarJugador(jugador);
    }
}
