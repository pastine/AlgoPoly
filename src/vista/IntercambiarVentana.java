package vista;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.AlgoPoly;
import modelo.jugador.Jugador;
import modelo.propiedad.Propiedad;
import vista.eventos.BotonIntercambiarEventHandler;


public class IntercambiarVentana {
	public static void MostrarVentana(Stage stage,AlgoPoly algoPoly) {
        Stage ventana = new Stage();
        ventana.initOwner(stage);
        ventana.initModality(Modality.APPLICATION_MODAL);
        ventana.setTitle("Intercambiar Propiedades");
        BorderPane contenedor = new BorderPane();
        Scene escena = new Scene(contenedor);
        setEscena(ventana,contenedor,algoPoly);
        ventana.setScene(escena);
        ventana.showAndWait();
    }

    private static void setEscena(Stage ventana,BorderPane contenedor,AlgoPoly algoPoly) {
    	VBox layoutIzq = new VBox(5);
    	
        VBox layoutMed = new VBox(5);
        layoutMed.setAlignment(Pos.CENTER);
        
        VBox layoutDer = new VBox(5);

        Jugador jugadorActual = algoPoly.devolverJugadorActual();
        
       
        ArrayList<Propiedad> propiedades = algoPoly.obtenerPropiedades(jugadorActual);
        ArrayList<Jugador> jugadores = algoPoly.devolverJugadores();
        
        Label labelPropiedadJugadorActual = new Label();
        labelPropiedadJugadorActual.setText("Propiedades del Jugador Actual:");
        ListView<Propiedad> listaDePropiedades = new ListView<>();
        
        Label labelJugadores = new Label();
        labelJugadores.setText("Jugadores:");
        ListView<Jugador> listaDeJugadores = new ListView<>();
        
        Label labelPropiedadJugadorSeleccionado = new Label();
        labelPropiedadJugadorSeleccionado.setText("Propiedades del Jugador Seleccionado:");
        ListView<Propiedad> listaDePropiedadesOtroJugador = new ListView<>();
        
        listaDeJugadores.getSelectionModel().selectedItemProperty().addListener((v,valorViejo,valorNuevo) -> {
        	ArrayList<Propiedad> propiedadesJugadorSeleccionado = algoPoly.obtenerPropiedades(valorNuevo);
        	listaDePropiedadesOtroJugador.getItems().clear();
            for (Propiedad aPropiedadesJugadorSeleccionado : propiedadesJugadorSeleccionado) {
                listaDePropiedadesOtroJugador.getItems().add(aPropiedadesJugadorSeleccionado);
            }
        });


        for (Propiedad propiedade : propiedades) {
            listaDePropiedades.getItems().add(propiedade);
        }

        for (Jugador jugadore : jugadores) {
            if (jugadore != jugadorActual)
                listaDeJugadores.getItems().add(jugadore);
        }
        
        
        Button botonIntercambiar = new Button();
        botonIntercambiar.setText("Intercambiar");
        BotonIntercambiarEventHandler botonIntercambiarHandler = new BotonIntercambiarEventHandler(ventana,algoPoly,listaDeJugadores,listaDePropiedades,listaDePropiedadesOtroJugador);
        botonIntercambiar.setOnAction(botonIntercambiarHandler);
        
        layoutIzq.getChildren().addAll(labelPropiedadJugadorActual,listaDePropiedades);
        layoutMed.getChildren().addAll(labelJugadores,listaDeJugadores,botonIntercambiar);
        layoutDer.getChildren().addAll(labelPropiedadJugadorSeleccionado,listaDePropiedadesOtroJugador);
        
        layoutIzq.setPadding(new Insets(15));
        layoutMed.setPadding(new Insets(15));
        layoutDer.setPadding(new Insets(15));
        
        contenedor.setLeft(layoutIzq);
        contenedor.setCenter(layoutMed);
        contenedor.setRight(layoutDer);
    }
}
