package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import modelo.AlgoPoly;
import vista.IntercambiarVentana;
import vista.VistaJugador;

public class BotonVentanaDeIntercambiarEventHandler implements EventHandler<ActionEvent> {
    Stage stage;
    AlgoPoly algoPoly;
    VistaJugador vistaJugador;

    public BotonVentanaDeIntercambiarEventHandler (Stage stage, AlgoPoly algoPoly, VistaJugador vistaJugador) {
        this.stage = stage;
        this.algoPoly = algoPoly;
        this.vistaJugador = vistaJugador;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
    	IntercambiarVentana.MostrarVentana(stage,algoPoly);
        vistaJugador.update();
    }
}