package modelo.propiedad;

import modelo.propiedad.ConstruccionNoPermitidaException;
import modelo.propiedad.Terreno;
import modelo.propiedad.estados.EstadoCobroTerreno;

public class TerrenoDoble extends Terreno {
    private int precioConstruccionHotel;

    public TerrenoDoble(int unPrecio, int alquilerSinCasa, int alquilerConUnaCasa, int alquilerConDosCasas, int alquilerConHotel, int costoConstruccionCasa, int costoConstruccionHotel){
        super(unPrecio, alquilerSinCasa, alquilerConUnaCasa, costoConstruccionCasa);
        precioConstruccionHotel = costoConstruccionHotel;
        preciosAlquiler.add(alquilerConDosCasas);
        preciosAlquiler.add(alquilerConHotel);
    }

    public void construirHotel(){
        if (!puedeConstruirHotel()) throw new ConstruccionNoPermitidaException();
        duenio.quitarDinero(precioConstruccionHotel);
        numeroCasas += 1;
        estadoCobroTerreno = new EstadoCobroTerreno(preciosAlquiler.get(numeroCasas));
    }

    public boolean puedeConstruirCasa(){
        int diferencia = ((Terreno)hermano).obtenerCantidadDeConstrucciones() - this.numeroCasas;
        return (diferencia == 1 || diferencia == 0) && (numeroCasas < 2);
    }

    public boolean puedeConstruirHotel(){
        int diferencia = ((Terreno)hermano).obtenerCantidadDeConstrucciones() - this.numeroCasas;
        return (diferencia == 1 || diferencia == 0) && (numeroCasas == 2);
    }
    
    public int obtenerValorTotal(){
    	int valor = this.precio;
    	if(this.numeroCasas>0) valor += this.precioConstruccionCasa;
    	if(this.numeroCasas>1) valor += this.precioConstruccionCasa;
    	if(this.numeroCasas>2) valor += this.precioConstruccionHotel;
    	return valor;
    }

}

