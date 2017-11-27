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
    	Jugador jugadorActual = algoPoly.devolverJugadorActual();
    	algoPoly.lanzarDadosYMover();
        vistaJugador.update();
        contenedor.deshabilitarBotonesTrasMover(jugadorActual);
	}
    
}
