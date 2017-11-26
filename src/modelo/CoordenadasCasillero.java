package modelo;

public class CoordenadasCasillero {
    int x;
    int y;

    public CoordenadasCasillero(int horizontal, int vertical){
        this.x = horizontal;
        this.y = vertical;
    }

    public int obtenerCoordenadaHorizontal(){
        return x;
    }

    public int obtenerCoordenadaVertical(){
        return y;
    }

}
