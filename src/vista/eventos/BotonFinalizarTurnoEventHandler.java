package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.AlgoPoly;
import vista.ContenedorPrincipal;
import vista.VistaJugador;

public class BotonFinalizarTurnoEventHandler implements EventHandler<ActionEvent>{

	ContenedorPrincipal contenedor;
	VistaJugador vistaJugador;
	AlgoPoly algoPoly;
	
	public BotonFinalizarTurnoEventHandler (ContenedorPrincipal contenedor,AlgoPoly algoPoly, VistaJugador vistaJugador) {
		this.contenedor = contenedor;
		this.vistaJugador = vistaJugador;
		this.algoPoly = algoPoly;
	}
	
	@Override
    public void handle(ActionEvent actionEvent) {
		algoPoly.finalizarTurno();
		vistaJugador.update();
		contenedor.deshabilitarBotonesAlFinalizarTurno();
	}
	
}
