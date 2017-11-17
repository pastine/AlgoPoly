package modelo;

import java.util.Random;

public class Dado {
	public int tirarDado(){
		Random rand = new Random();
		return (rand.nextInt(6)+1);
	}
}
