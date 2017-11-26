package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.AlgoPoly;

public class BotonFinalizarTurnoEventHandler implements EventHandler<ActionEvent>{

	AlgoPoly algoPoly;
	
	public BotonFinalizarTurnoEventHandler (AlgoPoly algoPoly) {
		this.algoPoly = algoPoly;
	}
	
	@Override
    public void handle(ActionEvent actionEvent) {
		algoPoly.finalizarTurno();
	}
	
}
