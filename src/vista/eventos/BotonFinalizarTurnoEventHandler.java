package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import modelo.AlgoPoly;
import vista.ContenedorPrincipal;

public class BotonFinalizarTurnoEventHandler implements EventHandler<ActionEvent>{

	ContenedorPrincipal contenedor;
	AlgoPoly algoPoly;
	
	public BotonFinalizarTurnoEventHandler (ContenedorPrincipal contenedor,AlgoPoly algoPoly) {
		this.contenedor = contenedor;
		this.algoPoly = algoPoly;
	}
	
	@Override
    public void handle(ActionEvent actionEvent) {
		algoPoly.finalizarTurno();
		contenedor.deshabilitarBotonesAlFinalizarTurno();
	}
	
}
