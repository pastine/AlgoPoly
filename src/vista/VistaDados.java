package vista;

import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import modelo.AlgoPoly;

public class VistaDados {
    AlgoPoly algoPoly;
    Canvas canvas;
    Image imagenDado1;
    Image imagenDado2;


    public VistaDados(Canvas canvas, AlgoPoly algoPoly) {
        this.algoPoly = algoPoly;
        this.canvas = canvas;
    }

    public void recargarImagenes(){
        canvas.getGraphicsContext2D().clearRect(0, 0, 220, 220);
        canvas.getGraphicsContext2D().setFill(Color.WHITE);
        String urlPrimerDado = "";
        String urlSegundoDado = "";

        for (int i = 1; i < 7; i++) {
            if (algoPoly.obtenerPrimerDadoActual() == i)
                urlPrimerDado = "vista/imagenes/dado" + i + ".jpg";
            if (algoPoly.obtenerSegundoDadoActual() == i)
                urlSegundoDado = "vista/imagenes/dado" + i + ".jpg";
        }
        imagenDado1 = new Image(urlPrimerDado,100,100,false,false);
        imagenDado2 = new Image(urlSegundoDado,100,100,false,false);

        canvas.getGraphicsContext2D().drawImage(imagenDado1,0,0);
        canvas.getGraphicsContext2D().drawImage(imagenDado2,0,100);

        if (algoPoly.obtenerPrimerDadoActual() == algoPoly.obtenerSegundoDadoActual()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Turno perdido");
            alert.setHeaderText(null);
            alert.setContentText("Por haber sacado dos veces dados iguales perdes el turno!");

            alert.showAndWait();
        }
    }


    public void update() {
        this.recargarImagenes();
    }
}
