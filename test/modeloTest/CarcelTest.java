package modeloTest;

import org.junit.Assert;
import org.junit.Test;

import modelo.Carcel;

public class CarcelTest {

	@Test
	public void testCrearCarcelNoDevuelveNULL() {
		Carcel carcel = new Carcel();
		Assert.assertNotNull(carcel);
	}

}
