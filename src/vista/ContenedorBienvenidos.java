package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import modelo.AlgoPoly;
import vista.eventos.BotonJugarEventHandler;
import vista.eventos.BotonNombresEventHandler;



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
	    
	    TextField jugador1 = new TextField();
    	jugador1.setPromptText("nombre");
    	jugador1.setMaxWidth(250);
    	jugador1.setText("Jugador 1");
    	
    	TextField jugador2 = new TextField();
    	jugador2.setPromptText("nombre");
    	jugador2.setMaxWidth(250);
    	jugador2.setText("Jugador 2");
    	
    	TextField jugador3 = new TextField();
    	jugador3.setPromptText("nombre");
    	jugador3.setMaxWidth(250);
    	jugador3.setText("Jugador 3");
    	
    	Button botonNombres = new Button();
        botonNombres.setText("Aceptar");
	    BotonNombresEventHandler botonNombesHandler = new BotonNombresEventHandler(algoPoly, jugador1, jugador2, jugador3);
	    botonNombres.setOnAction(botonNombesHandler);
	    
        BotonJugarEventHandler botonJugarHandler = new BotonJugarEventHandler(stage, algoPoly, mediaplayer, jugador1.getText(), jugador2.getText(), jugador3.getText());
        botonJugar.setOnAction(botonJugarHandler);

        this.getChildren().addAll(botonJugar, jugador1, jugador2, jugador3, botonNombres);
    }
    

}
