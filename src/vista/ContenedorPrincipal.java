package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import modelo.AlgoPoly;
import vista.eventos.BotonSilenciarEventHandler;
import vista.eventos.BotonComprarPropiedadEventHandler;
import vista.eventos.BotonFinalizarTurnoEventHandler;
import vista.eventos.BotonMoverEventHandler;
import vista.eventos.BotonSalirEventHandler;

public class ContenedorPrincipal extends BorderPane{
	
	Stage stage;
	AlgoPoly algoPoly;
	Canvas canvasCentral;
	VBox contenedorCentral;
	VBox contenedorLeft;
	VistaJugador vistaJugador;
	MediaPlayer mediaplayer;
	
	public ContenedorPrincipal(Stage stage, AlgoPoly algoPoly) {

        this.setCentro(algoPoly);
        
        String path = Aplicacion.class.getResource("sonidos/cancionDeFondo2.mp3").toString();
        Media file = new Media(path);
		mediaplayer = new MediaPlayer(file);
		mediaplayer.setAutoPlay(true);
		mediaplayer.setVolume(0.2);
		mediaplayer.setCycleCount(MediaPlayer.INDEFINITE);
		mediaplayer.play();
        
		this.setBotonera(algoPoly);
	}
	
	private void setBotonera(AlgoPoly algoPoly) {

	    Button botonMover = new Button();
	    botonMover.setText("Mover");
	    botonMover.setDefaultButton(true);
	    BotonMoverEventHandler botonMoverHandler = new BotonMoverEventHandler(this, algoPoly, vistaJugador);
	    botonMover.setOnAction(botonMoverHandler);
	    
	    Button botonComprar = new Button();
	    botonComprar.setText("Comprar");
	    BotonComprarPropiedadEventHandler botonComprarHandler = new BotonComprarPropiedadEventHandler(this, algoPoly);
	    botonComprar.setOnAction(botonComprarHandler);
	    botonComprar.setDisable(true);

	    Button botonFinalizarTurno = new Button();
	    botonFinalizarTurno.setText("FinalizarTurno");
	    BotonFinalizarTurnoEventHandler botonFinalizarHandler = new BotonFinalizarTurnoEventHandler(this, algoPoly);
	    botonFinalizarTurno.setOnAction(botonFinalizarHandler);
	    
	    Button botonDetenerMusica = new Button();
	    botonDetenerMusica.setText("Silenciar");
	    botonDetenerMusica.setCancelButton(true);
	    BotonSilenciarEventHandler botonDetenerHandler = new BotonSilenciarEventHandler(mediaplayer);
	    botonDetenerMusica.setOnAction(botonDetenerHandler);
	    
	    Button botonExit = new Button();
	    botonExit.setText("Exit");
	    //botonExit.setCancelButton(true);
	    BotonSalirEventHandler botonExitHandler = new BotonSalirEventHandler();
	    botonExit.setOnAction(botonExitHandler);
	    
	    
        contenedorLeft = new VBox(botonMover, botonComprar, botonFinalizarTurno, botonDetenerMusica, botonExit);
		contenedorLeft.setPadding(new Insets(15));
		contenedorLeft.setSpacing(25);
        
        Image imagen = new Image("vista/imagenes/negro.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		contenedorLeft.setBackground(new Background(imagenDeFondo));
        this.setLeft(contenedorLeft);
    }
	
	private void setCentro(AlgoPoly algoPoly) {
		canvasCentral = new Canvas(930, 520);
		vistaJugador = new VistaJugador(canvasCentral, algoPoly);
        vistaJugador.dibujar();
		contenedorCentral = new VBox(canvasCentral);
        contenedorCentral.setAlignment(Pos.CENTER);
        contenedorCentral.setSpacing(20);
        contenedorCentral.setPadding(new Insets(25));
        Image imagen = new Image("vista/imagenes/tableroFoto.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        contenedorCentral.setBackground(new Background(imagenDeFondo));

        this.setCenter(contenedorCentral);
    }

	public void deshabilitarBotonesAlFinalizarTurno() {
		contenedorLeft.getChildren().get(0).setDisable(false);
		contenedorLeft.getChildren().get(1).setDisable(true);
		contenedorLeft.getChildren().get(2).setDisable(true);
	}


    public void deshabilitarBotonesTrasMover() {
		contenedorLeft.getChildren().get(0).setDisable(true);
		//Jugador jugadorActual = algoPoly.devolverJugadorActual();
		//if (algoPoly.puedoComprar(jugadorActual))
			contenedorLeft.getChildren().get(1).setDisable(false);
		contenedorLeft.getChildren().get(2).setDisable(false);
	}


}