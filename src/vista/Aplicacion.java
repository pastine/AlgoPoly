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
	MediaPlayer mediaplayer;
	
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
        
        String path = Aplicacion.class.getResource("sonidos/cancionDeFondo.mp3").toString();

        
        Media file = new Media(path);

		mediaplayer = new MediaPlayer(file);
		mediaplayer.setAutoPlay(true);
		mediaplayer.setVolume(0.1);
		
		//MediaView mediaView = new MediaView(mediaplayer);
        mediaplayer.play();
     
        
        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage, jugador);
        Scene escenaJuego = new Scene(contenedorPrincipal, 640, 480);
        
        ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(stage, escenaJuego);
        Scene escenaBienvenidos = new Scene(contenedorBienvenidos, 640, 480);

        stage.setScene(escenaBienvenidos);
        stage.setFullScreen(false);

        stage.show();
    }

}
