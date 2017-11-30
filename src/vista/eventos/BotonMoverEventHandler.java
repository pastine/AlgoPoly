package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.AlgoPoly;
import vista.ContenedorPrincipal;
import vista.VistaJugador;



public class BotonMoverEventHandler implements EventHandler<ActionEvent> {
	private final ContenedorPrincipal contenedor;
	private final AlgoPoly algoPoly;
	private final VistaJugador vistaJugador;

	public BotonMoverEventHandler (ContenedorPrincipal contenedor, AlgoPoly algoPoly, VistaJugador vistaJugador) {
		this.contenedor = contenedor;
		this.algoPoly = algoPoly;
		this.vistaJugador = vistaJugador;
	}
	
    @Override
    public void handle(ActionEvent actionEvent) {
    	algoPoly.lanzarDadosYMover();
        vistaJugador.update();
        contenedor.deshabilitarBotonesTrasMover();
	}
    
}
