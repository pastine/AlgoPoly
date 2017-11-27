package modelo;

import modelo.casillero.Casillero;
import modelo.jugador.Jugador;
import modelo.jugador.JugadorEstaPresoException;
import modelo.jugador.SaldoInsuficienteException;
import modelo.propiedad.Propiedad;

import java.util.ArrayList;

public class AlgoPoly {
    private Tablero tablero;
    private ArrayList<Jugador> jugadores;
    private Turnos turnos;

    public AlgoPoly(){
        jugadores = new ArrayList<Jugador>();
    }

    public void iniciarJuego(){
        crearTableroYJugadores();
        turnos = new Turnos(jugadores);
        
        //La idea es pedir los nombres a traves de la vista.
        jugadores.get(0).asginarNombre("MARTA");
        jugadores.get(1).asginarNombre("NESTOR");
        jugadores.get(2).asginarNombre("ZULMA");
    }
    
    public int lanzarDadosYMover() {
    	Jugador jugadorActual = turnos.obtenerJugadorDelTurnoActual();
        int numeroPasos1 = 0;
        int numeroPasos2 = 0;
        boolean pierdeTurno = false;
        for (int i = 1; i < 3; i++) {
        	numeroPasos1 = jugadorActual.lanzarDados();
            numeroPasos2 = jugadorActual.lanzarDados();
            if (numeroPasos1 != numeroPasos2) {
            	break;
            } else if (i == 2){
                pierdeTurno = true;
            }
        }
        if(pierdeTurno){
            return 0;
        }

        int numeroPasos = numeroPasos1 + numeroPasos2;
        try{
        	jugadorActual.mover(numeroPasos);
        } catch (SaldoInsuficienteException e){
        	turnos.removerJugadorDelJuego();
            return 0;
        } catch (JugadorEstaPresoException e) {
            return 0;
        }
		return numeroPasos;
    }

    private void crearTableroYJugadores(){
        tablero = Tablero.inicializar();
        Casillero salida = tablero.obtenerPrimerCasillero();
        for (int i = 0; i < 3; i++) {
            Jugador auxiliar = new Jugador();
            jugadores.add(auxiliar);
            salida.agregarJugador(auxiliar,0);
        }
    }
    
    public ArrayList<Jugador> devolverJugadores() {
    	return jugadores;
    }
    
    public Jugador devolverJugadorActual() {
    	return turnos.obtenerJugadorDelTurnoActual();
    }
    
    public void finalizarTurno() {
    	turnos.finalizarTurno();
    }
    
    public boolean puedoComprar(Jugador jugadorActual) {
    	Casillero casilleroActual = jugadorActual.obtenerCasillero();
    	return casilleroActual.puedoComprar();
    }
    
    public void comprarPropiedad(Jugador jugadorActual) {
    	Casillero casilleroActual = jugadorActual.obtenerCasillero();
    	jugadorActual.comprarPropiedad((Propiedad) casilleroActual);
    }

	public String pedirSituacion(Jugador jugador) {
		Jugador jugadorActual = this.devolverJugadorActual();
		
		String situacionJugador = "Jugador: ";
		situacionJugador += jugador.pedirNombre();
		situacionJugador += "\nSaldo actual: ";
		situacionJugador += jugador.obtenerSaldo();
		
		if (jugadorActual == jugador)
			situacionJugador += "\nTURNO ACTUAL.";
		return situacionJugador;
	}

}
