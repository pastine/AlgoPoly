package modeloTest;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import modelo.RetrocesoDinamico;

public class RetrocesoDinamicoTest {

	@Test
	public void testCrearRetrocesoDinamicoNoDevuelveNULL() {
		RetrocesoDinamico retroceso = new RetrocesoDinamico();
		Assert.assertNotNull(retroceso);
	}
	

}
