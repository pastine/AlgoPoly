package modeloTest;

import modelo.CoordenadasCasillero;
import org.junit.Assert;
import org.junit.Test;

public class CoordenadasCasilleroTest {
    @Test
    public void testAlCrearUnasCoordenadasCasilleroSeObtienenLasCoordenadasCorrectas() {
        CoordenadasCasillero coordenadas = new CoordenadasCasillero(10, 20);
        Assert.assertEquals(coordenadas.obtenerCoordenadaHorizontal(),10);
        Assert.assertEquals(coordenadas.obtenerCoordenadaVertical(),20);
    }
}
