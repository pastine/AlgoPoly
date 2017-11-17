package modelo;

import java.util.Random;

public class Dado {
	private static Dado dado = null;
	
	private Dado(){
		//prohibe la instanciacion
	}
	
	public int tirarDado(){
		Random rand = new Random();
		return (rand.nextInt(6)+1);
	}
	
	public static Dado darDado(){
		if(dado == null) dado = new Dado();
		return dado;
	}
}
