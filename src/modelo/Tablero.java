package modelo;

import java.util.ArrayList;


public class Tablero {
    private ArrayList<Casillero> casilleros = new ArrayList<Casillero>();
    private static Tablero tablero = null;

    private Tablero(){
        //prohibe la instanciacion
    }

    public static Tablero darTablero(){
        if(tablero == null) tablero = new Tablero();
        return tablero;
    }

    public void agregarCasillero(Casillero unCasillero){
        casilleros.add(unCasillero);
    }


    public Casillero obtenerSiguiente(Casillero unCasillero) {
        int posicion = casilleros.indexOf(unCasillero);
        if (posicion == -1) throw new CasilleroNoEncontradoException();
        if (posicion == casilleros.size() - 1) posicion = 0;
        else posicion += 1;
        return casilleros.get(posicion);
    }

    public Casillero obtenerAnterior(Casillero unCasillero) {
        int posicion = casilleros.indexOf(unCasillero);
        if (posicion == -1) throw new CasilleroNoEncontradoException();
        if (posicion == 0) posicion = casilleros.size() - 1;
        else posicion -= 1;
        return casilleros.get(posicion);
    }

    public void limpiarTablero() {
        casilleros = new ArrayList<Casillero>();
    }


}
