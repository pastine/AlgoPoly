package modelo.propiedad.estados;

import modelo.jugador.Jugador;

public class EstadoCobroServicio {
    protected int costoServicio;

    public EstadoCobroServicio(int costoServicio){
        this.costoServicio = costoServicio;
    }

    public void cobrar(Jugador duenio, Jugador jugador, int pasosTotal){
        if (duenio == null) {
            //jugador.ofrecerComprarPropiedad();
        } else {
            int costoFinal = pasosTotal * costoServicio;
            jugador.quitarDinero(costoFinal);
            duenio.recibirDinero(costoFinal);
        }
    }
}
