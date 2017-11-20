package modelo.propiedad;

import modelo.jugador.Jugador;

public class EstadoCobroServicio {
    protected int costoServicio;

    public EstadoCobroServicio(int costoServicio){
        this.costoServicio = costoServicio;
    }

    public void cobrar(Jugador duenio, Jugador jugador, int pasosTotal){
        if (duenio == null) return;
        int costoFinal = pasosTotal * costoServicio;
        jugador.quitarDinero(costoFinal);
        duenio.recibirDinero(costoFinal);
    }
}
