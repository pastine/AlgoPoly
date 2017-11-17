package modeloTest;

import org.junit.Assert;
import modelo.Dado;
import org.junit.Test;

public class DadoTest {

	@Test
	public void test() {
		Dado dado = new Dado();
		
		for (int i=0;i<100;i++){
			int resultado = dado.tirarDado();
			Assert.assertTrue(resultado<=6 && resultado>=1);
		}
	}

}
