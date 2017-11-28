package vista;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.AlgoPoly;
import modelo.jugador.Jugador;
import modelo.propiedad.Propiedad;
import vista.eventos.BotonConstruirEventHandler;
import vista.eventos.BotonSilenciarEventHandler;

public class ConstruirVentana {

	public static void MostrarVentana(Stage stage,AlgoPoly algoPoly) {
		Stage ventana = new Stage();
		ventana.initOwner(stage);
		ventana.initModality(Modality.APPLICATION_MODAL);
		ventana.setTitle("Construir");
		VBox layout = new VBox(5);
		Scene escena = new Scene(layout);
		setEscena(ventana,layout,algoPoly);
		ventana.setScene(escena);
		ventana.showAndWait();
	}
	
	private static void setEscena(Stage ventana,VBox layout,AlgoPoly algoPoly) {
		layout.setAlignment(Pos.CENTER);
		Jugador jugadorActual = algoPoly.devolverJugadorActual();
		ArrayList<Propiedad> propiedades = algoPoly.obtenerPropiedades(jugadorActual);
		ListView<Propiedad> listaDePropiedades = new ListView<>();
		for (int i=0; i<propiedades.size();i++) {
			Propiedad propiedad = propiedades.get(i);
			if (algoPoly.puedoConstruir(propiedad))
				listaDePropiedades.getItems().add(propiedades.get(i));
		}
		Button botonConstruir = new Button();
		botonConstruir.setText("Construir");
	    BotonConstruirEventHandler botonConstruirHandler = new BotonConstruirEventHandler(ventana,algoPoly,listaDePropiedades);
	    botonConstruir.setOnAction(botonConstruirHandler);
	    
		
		layout.getChildren().addAll(listaDePropiedades,botonConstruir);
	}
}
