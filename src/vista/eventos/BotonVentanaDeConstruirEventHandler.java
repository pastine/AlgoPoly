package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import modelo.AlgoPoly;
import vista.ConstruirVentana;
import vista.ContenedorPrincipal;
import vista.VistaJugador;


public class BotonVentanaDeConstruirEventHandler implements EventHandler<ActionEvent> {
	Stage stage;
	AlgoPoly algoPoly;
	VistaJugador vistaJugador;
	
	public BotonVentanaDeConstruirEventHandler (Stage stage, AlgoPoly algoPoly, VistaJugador vistaJugador) {
		this.stage = stage;
		this.algoPoly = algoPoly;
		this.vistaJugador=vistaJugador;
	}
	
    @Override
    public void handle(ActionEvent actionEvent) {
    	ConstruirVentana.MostrarVentana(stage,algoPoly);
    	vistaJugador.update();
 
    }
}