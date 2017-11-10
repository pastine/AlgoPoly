package modeloTest;
import modelo.Quini6;
import org.junit.Assert;
import org.junit.Test;


public class Quini6Test {
    @Test
    public void testAlCrearQuini6NoDevuelveNull() {

        Quini6 unQuini = new Quini6();

        Assert.assertNotNull(unQuini);
    }

}
    