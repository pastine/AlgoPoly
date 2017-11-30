package modelo.propiedad;

import modelo.jugador.Jugador;
import modelo.propiedad.estados.EstadoCobroTerreno;

public class TerrenoDoble extends Terreno {
    private final int precioConstruccionHotel;
    private TerrenoDoble hermano;

    public TerrenoDoble(int unPrecio, int alquilerSinCasa, int alquilerConUnaCasa, int alquilerConDosCasas, int alquilerConHotel, int costoConstruccionCasa, int costoConstruccionHotel){
        super(unPrecio, alquilerSinCasa, alquilerConUnaCasa, costoConstruccionCasa);
        precioConstruccionHotel = costoConstruccionHotel;
        preciosAlquiler.add(alquilerConDosCasas);
        preciosAlquiler.add(alquilerConHotel);
    }

    public void asignarHermano(TerrenoDoble hermano) {
        this.hermano = hermano;
    }

    public void construirHotel(){
        if (!permiteConstruirHotel(duenio.obtenerSaldo())) throw new ConstruccionNoPermitidaException();
        duenio.quitarDinero(precioConstruccionHotel);
        numeroCasas += 1;
        estadoCobroTerreno = new EstadoCobroTerreno(preciosAlquiler.get(numeroCasas));
    }
    
    public boolean permiteConstruir(int saldo) {
		return permiteConstruirCasa(saldo) || permiteConstruirHotel(saldo);
	}

    public void construir() {
        try {
            construirHotel();
        } catch (ConstruccionNoPermitidaException e) {
            construirCasa();
        }
    }

    public boolean permiteConstruirCasa(int saldo){
        int diferencia = hermano.obtenerCantidadDeConstrucciones() - this.numeroCasas;
        return (diferencia == 1 || diferencia == 0) && (numeroCasas < 2) && hermano.obtenerDuenio() == duenio && saldo >= precioConstruccionCasa;
    }
    
    public boolean permiteConstruirHotel(int saldo){
        int diferencia = hermano.obtenerCantidadDeConstrucciones() - this.numeroCasas;
        return (diferencia == 1 || diferencia == 0) && (numeroCasas == 2) && hermano.obtenerDuenio() == duenio && saldo >= precioConstruccionHotel;
    }
    
    public int obtenerValorTotal(){
    	return obtenerValorPropio() + obtenerValorDeLasConstruccionesDelHermano();
    }

    private int obtenerValorPropio(){
        int valor = this.precio;
        if(this.numeroCasas>0) valor += this.precioConstruccionCasa;
        if(this.numeroCasas>1) valor += this.precioConstruccionCasa;
        if(this.numeroCasas>2) valor += this.precioConstruccionHotel;
        return valor;
    }

    private int obtenerValorDeLasConstruccionesDelHermano(){
        return hermano.obtenerValorPropio() - hermano.obtenerPrecio();
    }


    @Override
    public void cambiarDuenio(Jugador jugador) {
        removerConstrucciones();
        this.hermano.removerConstrucciones();
        super.cambiarDuenio(jugador);
    }

}

