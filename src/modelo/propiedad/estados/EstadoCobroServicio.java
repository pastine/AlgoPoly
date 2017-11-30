package modelo.propiedad.estados;

import modelo.jugador.Jugador;

public class EstadoCobroServicio {
    private final int costoServicio;

    public EstadoCobroServicio(int costoServicio){
        this.costoServicio = costoServicio;
    }

    public void cobrar(Jugador duenio, Jugador jugador, int pasosTotal){
        if (duenio != null) {
            int costoFinal = pasosTotal * costoServicio;
            jugador.quitarDinero(costoFinal);
            duenio.recibirDinero(costoFinal);
        }
    }
    
    public int obtenerCostoServicio() {
    	return costoServicio;
    }
}
