package modeloTest;

//import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import modelo.RetrocesoDinamico;

public class RetrocesoDinamicoTest {

	
	@Test
	public void testDeberiaRetrocederDosCasillerosTirandoDadosConNumeroDos(){
		RetrocesoDinamico retroceso = new RetrocesoDinamico();
		Assert.assertEquals(retroceso.retroceder(2), 2);
	}
	
	@Test
	public void testDeberiaRetrocederTresCasillerosTirandoDadosConNumeroTres() {
		RetrocesoDinamico retroceso = new RetrocesoDinamico();
		Assert.assertEquals(retroceso.retroceder(3),3);
	}
	
	@Test
	public void testDeberiaRetrocederCuatroCasillerosTirandoDadosConNumeroCuatro() {
		RetrocesoDinamico retroceso = new RetrocesoDinamico();
		Assert.assertEquals(retroceso.retroceder(4),4);
	}
	/*
	@Test
	public void testDeberiaRetrocederCincoCasillerosTirandoDadosConNumeroCinco() {
		RetrocesoDinamico retroceso = new RetrocesoDinamico();
		Assert.assertEquals(retroceso.retroceder(5),5);
	}*/
	
	
}
