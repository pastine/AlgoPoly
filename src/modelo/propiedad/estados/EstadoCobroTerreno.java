package modelo.propiedad.estados;

import modelo.jugador.Jugador;

public class EstadoCobroTerreno {

    protected int costoAlquiler;

    public EstadoCobroTerreno(int costoAlquiler){
        this.costoAlquiler = costoAlquiler;
    }

    public void cobrar(Jugador duenio, Jugador jugador){
        if (duenio != null) {
        	jugador.quitarDinero(costoAlquiler);
            duenio.recibirDinero(costoAlquiler);
        }
    }

	public int obtenerCostoAlquiler() {
		return costoAlquiler;
	}

}
