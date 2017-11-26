package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.AlgoPoly;
import modelo.jugador.Jugador;
import vista.VistaJugador;

public class BotonMoverEventHandler implements EventHandler<ActionEvent> {
	
	AlgoPoly algoPoly;
	VistaJugador vistaJugador;

	public BotonMoverEventHandler (AlgoPoly algoPoly, VistaJugador vistaJugador) {
		this.algoPoly = algoPoly;
		this.vistaJugador = vistaJugador;
	}
	
    @Override
    public void handle(ActionEvent actionEvent) {
    	Jugador jugadorActual = algoPoly.devolverJugadorActual();
    	int pasosTotal = algoPoly.lanzarDadosYMover();
        vistaJugador.update(pasosTotal, jugadorActual);
        System.out.println("DEBUG: El jugador " + jugadorActual.toString() + " avanzo "+ pasosTotal + " pasos y tiene $" + jugadorActual.obtenerSaldo());
    }
    
}
