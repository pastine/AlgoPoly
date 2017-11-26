package modelo;

import modelo.casillero.Casillero;
import modelo.jugador.Jugador;
import modelo.jugador.JugadorEstaPresoException;
import modelo.jugador.SaldoInsuficienteException;

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
            turnos.finalizarTurno();
            return 0;
        }

        int numeroPasos = numeroPasos1 + numeroPasos2;
        try{
        	jugadorActual.mover(numeroPasos);
        } catch (SaldoInsuficienteException e){
        	if(jugadorActual.obtenerCantidadDePropiedades()==0){
        		turnos.removerJugadorDelJuego();
        	}
        	jugadorActual.venderPropiedad();
            return 0;
        } catch (JugadorEstaPresoException e) {
            turnos.finalizarTurno();
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
    
}
