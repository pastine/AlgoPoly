package vista;

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
import vista.eventos.BotonVenderEventHandler;

import java.util.ArrayList;

public class VenderVentana {
    public static void MostrarVentana(Stage stage,AlgoPoly algoPoly) {
        Stage ventana = new Stage();
        ventana.setHeight(500);
        ventana.setWidth(400);
        
        
        
        ventana.initOwner(stage);
        ventana.initModality(Modality.APPLICATION_MODAL);
        ventana.setTitle("Vender");
        BorderPane contenedor = new BorderPane();
        
        Scene escena = new Scene(contenedor);
        setEscena(ventana,contenedor,algoPoly);
        ventana.setScene(escena);
        ventana.showAndWait();
    }

    private static void setEscena(Stage ventana,BorderPane contenedor,AlgoPoly algoPoly) {
    	VBox layoutIzq = new VBox(5);
    	VBox layoutDer = new VBox(5);
    	//layoutIzq.setAlignment(Pos.CENTER);
        Jugador jugadorActual = algoPoly.devolverJugadorActual();
        ArrayList<Propiedad> propiedades = algoPoly.obtenerPropiedades(jugadorActual);
        ListView<Propiedad> listaDePropiedades = new ListView<>();
        
        for (Propiedad propiedade : propiedades) {
            listaDePropiedades.getItems().add(propiedade);
        }
        
        listaDePropiedades.getSelectionModel().selectedItemProperty().addListener((v,valorViejo,valorNuevo) -> {
        	layoutDer.getChildren().clear();
        	
        	Label mostrarValorTotal = new Label();
        	mostrarValorTotal.setText("Valor total de propiedad: " + valorNuevo.obtenerValorTotal());
        	
        	Label mostrarValorDeVenta = new Label();
        	mostrarValorDeVenta.setText("Vender esta propiedad a: " + valorNuevo.obtenerValorDeVenta());
        	layoutDer.getChildren().addAll(mostrarValorTotal,mostrarValorDeVenta);
        });
        
        Button botonVender = new Button();
        botonVender.setText("Vender");
        BotonVenderEventHandler botonVenderHandler = new BotonVenderEventHandler(ventana,algoPoly,listaDePropiedades);
        botonVender.setOnAction(botonVenderHandler);
        
        contenedor.setLeft(layoutIzq);
        contenedor.setRight(layoutDer);
        
        layoutIzq.getChildren().addAll(listaDePropiedades,botonVender);
    }
}
