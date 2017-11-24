package modeloTest;
import modelo.AlgoPoly;
import org.junit.Assert;
import org.junit.Test;


public class AlgoPolyTest {
    @Test
    public void test() {
        AlgoPoly algoPoly = new AlgoPoly();
        algoPoly.iniciarJuego();
        Assert.assertTrue(true);
    }
}
