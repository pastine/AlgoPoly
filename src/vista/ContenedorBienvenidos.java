package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import modelo.AlgoPoly;
import vista.eventos.BotonJugarEventHandler;
import vista.eventos.BotonPedirEventHandler;



public class ContenedorBienvenidos extends VBox {

    Stage stage;
	
    public ContenedorBienvenidos(Stage stage, AlgoPoly algoPoly) {
    	super();
    	MediaPlayer mediaplayer;
 
        String path = Aplicacion.class.getResource("sonidos/cancionDeBienvenida1.mp3").toString();
        
        Media file = new Media(path);
		mediaplayer = new MediaPlayer(file);
		mediaplayer.setAutoPlay(true);
		mediaplayer.setVolume(0.2);
		mediaplayer.setCycleCount(MediaPlayer.INDEFINITE);
		mediaplayer.play();
	
        this.stage = stage;

        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));
        
        Image imagen = new Image("vista/imagenes/hombrecitoDelMonopoly.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
       
        Button botonJugar = new Button();
        botonJugar.setText("JUGAR");
        botonJugar.setDefaultButton(true);
        botonJugar.setPrefSize(100, 50);
        
	    Button botonPedir = new Button();
	    botonPedir.setText("Pedir nombre");
	    BotonPedirEventHandler botonPedirHandler = new BotonPedirEventHandler(algoPoly); 
	    botonPedir.setOnAction(botonPedirHandler);
	    
	    
        BotonJugarEventHandler botonJugarHandler = new BotonJugarEventHandler(stage,algoPoly,mediaplayer);
        botonJugar.setOnAction(botonJugarHandler);

        this.getChildren().addAll(botonJugar, botonPedir);
    }
    

}
