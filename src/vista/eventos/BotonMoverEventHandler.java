package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.AlgoPoly;
import modelo.jugador.Jugador;
import vista.ContenedorPrincipal;
import vista.VistaJugador;



public class BotonMoverEventHandler implements EventHandler<ActionEvent> {
	ContenedorPrincipal contenedor;
	AlgoPoly algoPoly;
	VistaJugador vistaJugador;

	public BotonMoverEventHandler (ContenedorPrincipal contenedor, AlgoPoly algoPoly, VistaJugador vistaJugador) {
		this.contenedor = contenedor;
		this.algoPoly = algoPoly;
		this.vistaJugador = vistaJugador;
	}
	
    @Override
    public void handle(ActionEvent actionEvent) {
		//contenedor.deshabilitarBotonesTrasMover();
    	Jugador jugadorActual = algoPoly.devolverJugadorActual();
    	int pasosTotal = algoPoly.lanzarDadosYMover();
        vistaJugador.update(pasosTotal, jugadorActual);
        contenedor.deshabilitarBotonesTrasMover();
        System.out.println("DEBUG: El jugador " + jugadorActual.toString() + " avanzo "+ pasosTotal + " pasos y tiene $" + jugadorActual.obtenerSaldo());
	}
    
}
