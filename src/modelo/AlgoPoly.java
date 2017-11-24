package modelo;

import modelo.casillero.Casillero;
import modelo.jugador.Jugador;
import modelo.jugador.JugadorEstaPresoException;
import modelo.jugador.SaldoInsuficienteException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ArrayBlockingQueue;

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
            Jugador jugadorActual = turnos.obtenerJugadorDelTurnoActual();
        while (turnos.cantidadDeJugadoresEnJuego() > 1) {
            // Ofrece las opciones de comprar casas, vender, intercambiar, etc.
            ofrecerOpciones(jugadorActual);
            //Tira los dados. Si saca 2 veces los mismos numeros pierde el turno.
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
                continue;
            }

            // Avanza
            int numeroPasos = numeroPasos1 + numeroPasos2;
            try{
                jugadorActual.mover(numeroPasos);
            } catch (SaldoInsuficienteException e){
                turnos.removerJugadorDelJuego();
                continue;
            } catch (JugadorEstaPresoException e) {

            }
            turnos.finalizarTurno();
        }
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

    private void ofrecerOpciones(Jugador jugadorActual){
        return;
    }

}
