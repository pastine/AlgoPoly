package modeloTest;

import modelo.Dado;
import org.junit.Assert;
import org.junit.Test;

public class DadoTest {

	@Test
	public void test() {
		Dado dado = Dado.darDado();
		
		for (int i=0;i<100;i++){
			int resultado = dado.tirarDado();
			Assert.assertTrue(resultado<=6 && resultado>=1);
		}
	}

}
