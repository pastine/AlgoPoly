package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modelo.AlgoPoly;
import vista.ContenedorPrincipal;

public class BotonJugarEventHandler implements EventHandler<ActionEvent> {

    Stage stage;
    Scene proximaEscena;
    AlgoPoly algoPoly;

    public BotonJugarEventHandler(Stage stage,AlgoPoly algoPoly) {
    	 this.stage = stage;
    	 this.algoPoly = algoPoly;
	}

    @Override
    public void handle(ActionEvent actionEvent) {
    	ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage, algoPoly);
        Scene escenaJuego = new Scene(contenedorPrincipal, 640, 480);
        stage.setScene(escenaJuego);
        stage.setFullScreenExitHint("");
        stage.setFullScreen(true);
    }
    
}
