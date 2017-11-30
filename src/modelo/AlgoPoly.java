package modelo;

import modelo.casillero.Casillero;
import modelo.jugador.Jugador;
import modelo.jugador.excepciones.JugadorEstaPresoException;
import modelo.jugador.excepciones.SaldoInsuficienteException;
import modelo.propiedad.Propiedad;

import java.util.ArrayList;
import java.util.Collections;

public class AlgoPoly {
    private final ArrayList<Jugador> jugadores;
    private Turnos turnos;
    private int ultimoDado1 = 1;
    private int ultimoDado2 = 2;


    public AlgoPoly(){
        jugadores = new ArrayList<>();
    }

    public void iniciarJuego(){
        crearTableroYJugadores();
        turnos = new Turnos(jugadores);
    }
    

    public void cambiarNombres(String nombreJugador1, String nombreJugador2, String nombreJugador3) {
    	ArrayList<String> nombresJugadores = new ArrayList<>();
    	nombresJugadores.add(nombreJugador1);
    	nombresJugadores.add(nombreJugador2);
    	nombresJugadores.add(nombreJugador3);
    	
    	Collections.shuffle(nombresJugadores);
        jugadores.get(0).asginarNombre(nombresJugadores.get(0));
        jugadores.get(1).asginarNombre(nombresJugadores.get(1));
        jugadores.get(2).asginarNombre(nombresJugadores.get(2));
    }
    
    public void lanzarDadosYMover() {
    	Jugador jugadorActual = turnos.obtenerJugadorDelTurnoActual();
        boolean pierdeTurno = false;
        for (int i = 1; i < 3; i++) {
        	ultimoDado1 = jugadorActual.lanzarDados();
            ultimoDado2 = jugadorActual.lanzarDados();
            if (ultimoDado1 != ultimoDado2) {
            	break;
            } else if (i == 2){
                pierdeTurno = true;
            }
        }
        if(pierdeTurno){
            return;
        }

        int sumaPasos = ultimoDado1 + ultimoDado2;
        try{
        	jugadorActual.mover(sumaPasos);
        } catch (SaldoInsuficienteException e){
        	Jugador jugadorEliminado = turnos.removerJugadorDelJuego();
        	jugadores.remove(jugadorEliminado);

        } catch (JugadorEstaPresoException ignored) {
        }
    }

    private void crearTableroYJugadores(){
        Tablero tablero = Tablero.inicializar();
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
    	return casilleroActual.permiteSerComprado(jugadorActual.obtenerSaldo());
    }
    
    public void comprarPropiedad(Jugador jugadorActual) {
    	Casillero casilleroActual = jugadorActual.obtenerCasillero();
    	jugadorActual.comprarPropiedad((Propiedad) casilleroActual);
    }
    
    public boolean puedoConstruir(Propiedad propiedad) {
    	return propiedad.permiteConstruir(devolverJugadorActual().obtenerSaldo());
    }
    
    public void construir(Propiedad propiedad) {
    	propiedad.construir();
    }
    
    public ArrayList<Propiedad> obtenerPropiedades(Jugador jugadorActual){
    	return jugadorActual.obtenerPropiedades();
    }
    
	public String pedirSituacionJugador(Jugador jugador) {
		Jugador jugadorActual = this.devolverJugadorActual();
		
		StringBuilder situacionJugador = new StringBuilder("Jugador: ");
		situacionJugador.append(jugador.pedirNombre());
		situacionJugador.append("\nSaldo actual: $");
		situacionJugador.append(jugador.obtenerSaldo()).append("\n");
		if (jugador.obtenerCantidadDePropiedades() > 0)
            situacionJugador.append("Propiedades:\n");
        for (Propiedad propiedad: jugador.obtenerPropiedades()) {
            situacionJugador.append("-").append(propiedad.toString()).append("\n");
        }
        if (jugadorActual == jugador)
			situacionJugador.append("TURNO ACTUAL.");
		return situacionJugador.toString();
	}

	public String pedirSituacionCasillero(Jugador jugadorActual) {
		Casillero casilleroActual = jugadorActual.obtenerCasillero();
		String situacionCasillero = "Casillero: ";
		situacionCasillero += casilleroActual.pedirNombre() + "\n";
		situacionCasillero += casilleroActual.pedirSituacion();
		if (!puedoMover(jugadorActual)) {
			situacionCasillero += "Turnos restantes: " + jugadorActual.diasDeCarcelRestantes();
			situacionCasillero += "\nFianza: $45000";
		}
		return situacionCasillero;
	}

	private boolean puedoMover(Jugador jugadorActual) {
		return (jugadorActual.diasDeCarcelRestantes() == 0);
	}

	public boolean puedoPagarFianza(Jugador jugadorActual) {
		return (jugadorActual.diasDeCarcelRestantes() == 2 || jugadorActual.diasDeCarcelRestantes() == 1) && jugadorActual.obtenerSaldo() >= 45000;
	}

	public void pagarFianzajugadorActual(Jugador jugadorActual) {
		jugadorActual.pagarFianza();
	}

	public int obtenerPrimerDadoActual(){
        return ultimoDado1;
    }

    public int obtenerSegundoDadoActual(){
        return ultimoDado2;
    }
}
