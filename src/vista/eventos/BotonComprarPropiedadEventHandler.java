package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.AlgoPoly;
import modelo.jugador.Jugador;
import vista.ContenedorPrincipal;

public class BotonComprarPropiedadEventHandler implements EventHandler<ActionEvent>{

	ContenedorPrincipal contenedor;
	AlgoPoly algoPoly;
	
	public BotonComprarPropiedadEventHandler (ContenedorPrincipal contenedor,AlgoPoly algoPoly) {
		this.contenedor = contenedor;
		this.algoPoly = algoPoly;
	}
	
	@Override
    public void handle(ActionEvent actionEvent) {
		Jugador jugadorActual = algoPoly.devolverJugadorActual();
		if (algoPoly.puedoComprar(jugadorActual))
			algoPoly.comprarPropiedad(jugadorActual);
	}
	
}
