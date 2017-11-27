package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.AlgoPoly;
import modelo.jugador.Jugador;
import vista.ContenedorPrincipal;
import vista.VistaJugador;

public class BotonComprarPropiedadEventHandler implements EventHandler<ActionEvent>{

	ContenedorPrincipal contenedor;
	AlgoPoly algoPoly;
	VistaJugador vistaJugador;
	
	public BotonComprarPropiedadEventHandler (ContenedorPrincipal contenedor,AlgoPoly algoPoly, VistaJugador vistaJugador) {
		this.contenedor = contenedor;
		this.vistaJugador = vistaJugador;
		this.algoPoly = algoPoly;
	}
	
	@Override
    public void handle(ActionEvent actionEvent) {
		Jugador jugadorActual = algoPoly.devolverJugadorActual();
		if (algoPoly.puedoComprar(jugadorActual))
			algoPoly.comprarPropiedad(jugadorActual);
		vistaJugador.update();
		contenedor.deshabilitarBotonesTrasComprar();
	}
	
}
