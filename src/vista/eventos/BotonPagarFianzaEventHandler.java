package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.AlgoPoly;
import modelo.jugador.Jugador;
import vista.ContenedorPrincipal;
import vista.VistaJugador;

public class BotonPagarFianzaEventHandler implements EventHandler<ActionEvent> {
	
	private final ContenedorPrincipal contenedor;
	private final AlgoPoly algoPoly;
	private final VistaJugador vistaJugador;

	public BotonPagarFianzaEventHandler (ContenedorPrincipal contenedor, AlgoPoly algoPoly, VistaJugador vistaJugador) {
		this.contenedor = contenedor;
		this.algoPoly = algoPoly;
		this.vistaJugador = vistaJugador;
	}
	
    @Override
    public void handle(ActionEvent actionEvent) {
    	Jugador jugadorActual = algoPoly.devolverJugadorActual();
    	if (algoPoly.puedoPagarFianza(jugadorActual)) {
    		algoPoly.pagarFianzajugadorActual(jugadorActual);
    		vistaJugador.update();
    		contenedor.deshabilitarBotonesAlFinalizarTurno();
    	}
	}

}
