package modelo;

import modelo.casillero.Carcel;
import modelo.casillero.Casillero;
import modelo.jugador.Jugador;
import modelo.jugador.JugadorEstaPresoException;
import modelo.jugador.SaldoInsuficienteException;
import modelo.propiedad.Propiedad;

import java.util.ArrayList;
import java.util.Collections;

public class AlgoPoly {
    private Tablero tablero;
    private ArrayList<Jugador> jugadores;
    private Turnos turnos;

    public AlgoPoly(){
        jugadores = new ArrayList<Jugador>();
    }

    public void iniciarJuego(){
        crearTableroYJugadores();
        
        cambiarNombres("MARTA","NESTOR","ZULMA");
        turnos = new Turnos(jugadores);
    }
    

    public void cambiarNombres(String nombreJugador1, String nombreJugador2, String nombreJugador3) {
    	ArrayList<String> nombresJugadores = new ArrayList<String>();
    	nombresJugadores.add(nombreJugador1);
    	nombresJugadores.add(nombreJugador2);
    	nombresJugadores.add(nombreJugador3);
    	
    	Collections.shuffle(nombresJugadores);
        jugadores.get(0).asginarNombre(nombresJugadores.get(0));
        jugadores.get(1).asginarNombre(nombresJugadores.get(1));
        jugadores.get(2).asginarNombre(nombresJugadores.get(2));
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
    	return casilleroActual.puedoComprar(jugadorActual.obtenerSaldo());
    }
    
    public void comprarPropiedad(Jugador jugadorActual) {
    	Casillero casilleroActual = jugadorActual.obtenerCasillero();
    	jugadorActual.comprarPropiedad((Propiedad) casilleroActual);
    }

	public String pedirSituacionJugador(Jugador jugador) {
		Jugador jugadorActual = this.devolverJugadorActual();
		
		String situacionJugador = "Jugador: ";
		situacionJugador += jugador.pedirNombre();
		situacionJugador += "\nSaldo actual: ";
		situacionJugador += jugador.obtenerSaldo();
		
		if (jugadorActual == jugador)
			situacionJugador += "\nTURNO ACTUAL.";
		return situacionJugador;
	}

	public String pedirSituacionCasillero(Jugador jugadorActual) {
		Casillero casilleroActual = jugadorActual.obtenerCasillero();
		String situacionCasillero = "Casillero: ";
		situacionCasillero += casilleroActual.pedirNombre() + "\n";
		situacionCasillero += casilleroActual.pedirSituacion();
		if (!puedoMover(jugadorActual))
			situacionCasillero += "Turnos restantes: " + jugadorActual.diasDeCarcelRestantes();
		return situacionCasillero;
	}

	public boolean puedoMover(Jugador jugadorActual) {
		return (jugadorActual.diasDeCarcelRestantes() == 0);
	}

	public boolean puedoPagarFianza(Jugador jugadorActual) {
		return (jugadorActual.diasDeCarcelRestantes() == 2 || jugadorActual.diasDeCarcelRestantes() == 1);
	}

	public void pagarFianzajugadorActual(Jugador jugadorActual) {
		jugadorActual.pagarFianza((Carcel) jugadorActual.obtenerCasillero());
	}

}
