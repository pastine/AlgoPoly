package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import modelo.AlgoPoly;
import vista.eventos.*;

public class ContenedorPrincipal extends BorderPane{
	
	private final Stage stage;
	private final AlgoPoly algoPoly;
    private VBox contenedorLeft;
	private VistaJugador vistaJugador;
	private VistaDados vistaDados;
	private MediaPlayer mediaplayer;
	
	public ContenedorPrincipal(Stage stage, AlgoPoly algoPoly) {
		this.algoPoly = algoPoly;
		this.stage = stage;
		this.setMusica();
        this.setCentro(algoPoly);
        
		this.setBotonera(algoPoly);
	
	}
	
	private void setMusica() {
        String path = Aplicacion.class.getResource("sonidos/cancionDeFondo3.mp3").toString();
        
        Media file = new Media(path);
		this.mediaplayer = new MediaPlayer(file);
		mediaplayer.setAutoPlay(true);
		mediaplayer.setVolume(0.2);
		mediaplayer.setCycleCount(MediaPlayer.INDEFINITE);
		mediaplayer.play();
	}
	private void setBotonera(AlgoPoly algoPoly) {

	    Button botonMover = new Button();
	    botonMover.setText("Mover");
	    botonMover.setDefaultButton(true);
	    BotonMoverEventHandler botonMoverHandler = new BotonMoverEventHandler(this, algoPoly, vistaJugador);
	    botonMover.setOnAction(botonMoverHandler);
	    
	    Button botonComprar = new Button();
	    botonComprar.setText("Comprar");
	    BotonComprarPropiedadEventHandler botonComprarHandler = new BotonComprarPropiedadEventHandler(this, algoPoly, vistaJugador);
	    botonComprar.setOnAction(botonComprarHandler);
	    botonComprar.setDisable(true);

		Button botonVender = new Button();
		botonVender.setText("Vender");
		BotonVentanaDeVenderEventHandler botonVenderHandler = new BotonVentanaDeVenderEventHandler(stage, algoPoly, vistaJugador);
		botonVender.setOnAction(botonVenderHandler);
		botonVender.setDisable(true);
		
		Button botonIntercambiar = new Button();
		botonIntercambiar.setText("Intercambiar");
		BotonVentanaDeIntercambiarEventHandler botonIntercambiarHandler = new BotonVentanaDeIntercambiarEventHandler(stage, algoPoly, vistaJugador);
		botonIntercambiar.setOnAction(botonIntercambiarHandler);
		botonIntercambiar.setDisable(true);
		    
		Button botonConstruir = new Button();
		botonConstruir.setText("Construir");
		BotonVentanaDeConstruirEventHandler botonConstruirHandler = new BotonVentanaDeConstruirEventHandler(stage, algoPoly, vistaJugador);
		botonConstruir.setOnAction(botonConstruirHandler);
		botonConstruir.setDisable(true);

		Button botonPagarFianza = new Button();
		botonPagarFianza.setText("Pagar fianza");
		BotonPagarFianzaEventHandler botonPagarFianzaHandler = new BotonPagarFianzaEventHandler(this, algoPoly, vistaJugador);
		botonPagarFianza.setOnAction(botonPagarFianzaHandler);
		botonPagarFianza.setDisable(true);


	    Button botonFinalizarTurno = new Button();
	    botonFinalizarTurno.setText("FinalizarTurno");
	    BotonFinalizarTurnoEventHandler botonFinalizarHandler = new BotonFinalizarTurnoEventHandler(this, algoPoly, vistaJugador);
	    botonFinalizarTurno.setOnAction(botonFinalizarHandler);
	    botonFinalizarTurno.setDisable(true);
	   
	    Button botonReproducirMusica = new Button();
	    botonReproducirMusica.setText("Reproducir");
	    BotonReproducirMusicaEventHandler botonReproducirHandler = new BotonReproducirMusicaEventHandler(this, mediaplayer);
	    botonReproducirMusica.setOnAction(botonReproducirHandler);
	    botonReproducirMusica.setDisable(true);
	    
	    Button botonDetenerMusica = new Button();
	    botonDetenerMusica.setText("Silenciar");
	    BotonSilenciarEventHandler botonDetenerHandler = new BotonSilenciarEventHandler(this, mediaplayer);
	    botonDetenerMusica.setOnAction(botonDetenerHandler);
	    
	    
	    Button botonExit = new Button();
	    botonExit.setText("Exit");
	    //botonExit.setCancelButton(true);
	    BotonSalirEventHandler botonExitHandler = new BotonSalirEventHandler();
	    botonExit.setOnAction(botonExitHandler);

		Canvas canvasDados = new Canvas(110, 220);
		vistaDados = new VistaDados(stage,canvasDados, algoPoly);
		vistaDados.update();
	    

	    contenedorLeft = new VBox(botonMover, botonComprar,botonIntercambiar, botonVender, botonConstruir, botonPagarFianza, botonFinalizarTurno,canvasDados, botonReproducirMusica, botonDetenerMusica, botonExit);

		contenedorLeft.setPadding(new Insets(15));
		contenedorLeft.setSpacing(25);
        
        Image imagen = new Image("vista/imagenes/negro.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		contenedorLeft.setBackground(new Background(imagenDeFondo));
        this.setLeft(contenedorLeft);
    }
	
	private void setCentro(AlgoPoly algoPoly) {
        Canvas canvasCentral = new Canvas(930, 520);
		
		
		vistaJugador = new VistaJugador(canvasCentral, algoPoly);
		vistaJugador.update();
        VBox contenedorCentral = new VBox(canvasCentral);
        contenedorCentral.setAlignment(Pos.CENTER);
        contenedorCentral.setSpacing(20);
        contenedorCentral.setPadding(new Insets(25));
        Image imagen = new Image("vista/imagenes/tableroFoto.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        contenedorCentral.setBackground(new Background(imagenDeFondo));

        this.setCenter(contenedorCentral);
    }

	public void deshabilitarBotonesAlFinalizarTurno() {
		contenedorLeft.getChildren().get(0).setDisable(false); // Mover 0
		((Button) contenedorLeft.getChildren().get(0)).setDefaultButton(true);
		contenedorLeft.getChildren().get(1).setDisable(true); // Comprar 1
		contenedorLeft.getChildren().get(2).setDisable(false); // Intercambiar 2
		contenedorLeft.getChildren().get(3).setDisable(false); // Vender 2
		contenedorLeft.getChildren().get(4).setDisable(false); // Construir 4
		contenedorLeft.getChildren().get(5).setDisable(true); // PagarFianza 5
		if (algoPoly.puedoPagarFianza(algoPoly.devolverJugadorActual()))
			contenedorLeft.getChildren().get(5).setDisable(false); // Pagar Fianza 5
		contenedorLeft.getChildren().get(6).setDisable(true); // Finalizar 6
		((Button) contenedorLeft.getChildren().get(6)).setDefaultButton(false);
	}

	public void deshabilitarBotonesTrasComprar() {
		contenedorLeft.getChildren().get(1).setDisable(true); // Comprar 1
	}

    public void deshabilitarBotonesTrasMover() {
		contenedorLeft.getChildren().get(0).setDisable(true); // Mover 0
		((Button) contenedorLeft.getChildren().get(0)).setDefaultButton(false);
		if (algoPoly.puedoComprar(algoPoly.devolverJugadorActual()))
			contenedorLeft.getChildren().get(1).setDisable(false); //Comprar 1
		contenedorLeft.getChildren().get(2).setDisable(true); // Intercambiar 2
		contenedorLeft.getChildren().get(3).setDisable(true); // Vender 2
		contenedorLeft.getChildren().get(4).setDisable(true); // Construir 4		
		contenedorLeft.getChildren().get(5).setDisable(true); // Pagar Fianza 5
		contenedorLeft.getChildren().get(6).setDisable(false); // Finalizar 6
		((Button) contenedorLeft.getChildren().get(6)).setDefaultButton(true);
		vistaDados.update();
	}

	public void deshabilitarTrasSilenciar() {
		contenedorLeft.getChildren().get(8).setDisable(false); // Reproducir 8
		contenedorLeft.getChildren().get(9).setDisable(true); // Silenciar 9
	}

	public void deshabilitarTrasReproducir() {
		contenedorLeft.getChildren().get(8).setDisable(true); // Reproducir 8
		contenedorLeft.getChildren().get(9).setDisable(false); // Silenciar 9
	}


}