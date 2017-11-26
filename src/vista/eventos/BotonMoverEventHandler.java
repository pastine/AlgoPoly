package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.AlgoPoly;
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
    	int pasosTotal = algoPoly.lanzarDadosYMover();
        vistaJugador.update(pasosTotal);
        System.out.println(pasosTotal);
    }
    
}
