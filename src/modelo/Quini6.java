package modelo;

import java.util.HashMap;

public class Quini6 {

    private HashMap<Jugador, Integer> visitas;
    private HashMap<Integer, Integer> premio;


    public Quini6() {
        this.visitas = new HashMap<Jugador, Integer>();
        this.premio = new HashMap<Integer, Integer>();
        premio.put(1,50000);
        premio.put(2,30000);
    }

    public void darPremio(Jugador unJugador) {
        int numeroVisitas = visitas.getOrDefault(unJugador, 0) + 1;
        visitas.put(unJugador, numeroVisitas);
        unJugador.recibirDinero(premio.getOrDefault(numeroVisitas,0));
    }




}