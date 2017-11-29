package vista.eventos;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import modelo.AlgoPoly;
import vista.ContenedorPrincipal;

public class BotonJugarEventHandler implements EventHandler<ActionEvent> {

    Stage stage;
    Scene proximaEscena;
    AlgoPoly algoPoly;
    MediaPlayer mediaplayer;
	private String jugador1Nombre;
	private String jugador2Nombre;
	private String jugador3Nombre;
    

    public BotonJugarEventHandler(Stage stage,AlgoPoly algoPoly, MediaPlayer mediaplayer, String jugador1Nombre, String jugador2Nombre, String jugador3Nombre) {
    	 this.stage = stage;
    	 this.algoPoly = algoPoly;
    	 this.mediaplayer = mediaplayer;
    	 this.jugador1Nombre = jugador1Nombre;
    	 this.jugador2Nombre = jugador2Nombre;
    	 this.jugador3Nombre = jugador3Nombre;
	}

    @Override
    public void handle(ActionEvent actionEvent) {
    	ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage, algoPoly);
    	mediaplayer.stop();
        Scene escenaJuego = new Scene(contenedorPrincipal, 640, 480);
        stage.setScene(escenaJuego);
        stage.setFullScreenExitHint("");
        stage.setFullScreen(true);
        algoPoly.cambiarNombres(this.jugador1Nombre, this.jugador2Nombre, this.jugador3Nombre);
    }
    
}
