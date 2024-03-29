package vista;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modelo.AlgoPoly;

public class Aplicacion extends Application {
	
	
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) throws Exception {

        stage.setTitle("AlgoPoly");
        
        AlgoPoly algoPoly = new AlgoPoly();
        algoPoly.iniciarJuego();
        
        ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(stage,algoPoly);
        Scene escenaBienvenidos = new Scene(contenedorBienvenidos, 640, 480);
        
        
        stage.setScene(escenaBienvenidos);
        stage.setFullScreen(true);

        stage.show();
    }

}
