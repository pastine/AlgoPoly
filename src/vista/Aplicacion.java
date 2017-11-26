package vista;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import modelo.AlgoPoly;
import modelo.jugador.Jugador;

public class Aplicacion extends Application {
	
	
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) throws Exception {

        stage.setTitle("AlgoPoly");
        
        AlgoPoly algoPoly = new AlgoPoly();
        Jugador jugador = new Jugador();
        algoPoly.iniciarJuego();
        algoPoly.lanzarDadosYMover();
       
     
        
        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage, jugador);
        Scene escenaJuego = new Scene(contenedorPrincipal, 640, 480);
        
        ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(stage, escenaJuego);
        Scene escenaBienvenidos = new Scene(contenedorBienvenidos, 640, 480);

        stage.setScene(escenaBienvenidos);
        stage.setFullScreen(false);

        stage.show();
    }

}
