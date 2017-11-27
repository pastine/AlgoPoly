package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import vista.eventos.BotonJugarEventHandler;
import vista.eventos.BotonPedirEventHandler;



public class ContenedorBienvenidos extends VBox {

    Stage stage;
	
    public ContenedorBienvenidos(Stage stage, Scene proximaEscena) {

        super();

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
	    BotonPedirEventHandler botonPedirHandler = new BotonPedirEventHandler();
	    botonPedir.setOnAction(botonPedirHandler);

        BotonJugarEventHandler botonJugarHandler = new BotonJugarEventHandler(stage, proximaEscena);
        botonJugar.setOnAction(botonJugarHandler);

        this.getChildren().addAll(botonJugar, botonPedir);
    }
    

}
