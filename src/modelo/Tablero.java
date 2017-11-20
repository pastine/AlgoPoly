package modelo;

import modelo.propiedad.Servicio;
import modelo.propiedad.Terreno;
import modelo.propiedad.TerrenoDoble;

import java.util.ArrayList;


public class Tablero {
    private ArrayList<Casillero> casilleros = new ArrayList<Casillero>();
    private static Tablero tablero = null;

    private Tablero(){
        //prohibe la instanciacion
    }

    public static Tablero darTablero(){
        if(tablero == null) tablero = new Tablero();
        return tablero;
    }

    public void agregarCasillero(Casillero unCasillero){
        casilleros.add(unCasillero);
    }


    public Casillero obtenerSiguiente(Casillero unCasillero) {
        int posicion = casilleros.indexOf(unCasillero);
        if (posicion == -1) throw new CasilleroNoEncontradoException();
        if (posicion == casilleros.size() - 1) posicion = 0;
        else posicion += 1;
        return casilleros.get(posicion);
    }

    public Casillero obtenerAnterior(Casillero unCasillero) {
        int posicion = casilleros.indexOf(unCasillero);
        if (posicion == -1) throw new CasilleroNoEncontradoException();
        if (posicion == 0) posicion = casilleros.size() - 1;
        else posicion -= 1;
        return casilleros.get(posicion);
    }

    public void limpiarTablero() {
        casilleros = new ArrayList<Casillero>();
    }

    public Tablero inicializar(){

        // Instanciación de todos los casilleros
        Casillero salida = new Casillero();
        Quini6 quini6 = new Quini6();
        TerrenoDoble buenosAiresSur = new TerrenoDoble(20000, 2000, 3000, 3500, 5000, 5000, 8000);
        Servicio edesur = new Servicio(35000, 500, 1000);
        TerrenoDoble buenosAiresNorte = new TerrenoDoble(25000, 2500, 3500, 4000, 6000, 5500, 9000);
        Carcel carcel = new Carcel();
        TerrenoDoble cordobaSur = new TerrenoDoble(18000, 1000, 1500, 2500, 3000, 2000, 3000);
        AvanceDinamico avanceDinamico = new AvanceDinamico();
        Servicio subte = new Servicio(40000, 600, 1100);
        TerrenoDoble cordobaNorte = new TerrenoDoble(20000, 1300, 1800, 2900, 3500, 2200, 3500);
        ImpuestoAlLujo impuestoAlLujo = new ImpuestoAlLujo();
        Terreno santaFe = new Terreno(15000, 1500, 3500, 4000);
        Servicio aysa = new Servicio(30000, 300, 500);
        TerrenoDoble saltaNorte = new TerrenoDoble(23000, 2000, 3250, 3850, 5500, 4500, 7500);
        TerrenoDoble saltaSur = new TerrenoDoble(23000, 2000, 3250, 3850, 5500, 4500, 7500);
        Policia policia = new Policia(carcel);
        Servicio tren = new Servicio(38000, 450, 800);
        Terreno neuquen = new Terreno(17000, 1800, 3800, 4800);
        RetrocesoDinamico retrocesoDinamico = new RetrocesoDinamico();
        Terreno tucuman = new Terreno(25000, 2500, 4500, 7000);

        // Relaciones entre casilleros
        buenosAiresNorte.asigarHermano(buenosAiresSur);
        buenosAiresSur.asigarHermano(buenosAiresNorte);

        cordobaNorte.asigarHermano(cordobaSur);
        cordobaSur.asigarHermano(cordobaNorte);

        saltaNorte.asigarHermano(saltaSur);
        saltaSur.asigarHermano(saltaNorte);

        subte.asigarHermano(tren);
        tren.asigarHermano(subte);

        aysa.asigarHermano(edesur);
        edesur.asigarHermano(aysa);

        //Agrego los casilleros en orden al tablero
        Tablero tablero = new Tablero();
        tablero.agregarCasillero(salida);
        tablero.agregarCasillero(quini6);
        tablero.agregarCasillero(buenosAiresSur);
        tablero.agregarCasillero(edesur);
        tablero.agregarCasillero(buenosAiresNorte);
        tablero.agregarCasillero(carcel);
        tablero.agregarCasillero(cordobaSur);
        tablero.agregarCasillero(avanceDinamico);
        tablero.agregarCasillero(subte);
        tablero.agregarCasillero(cordobaNorte);
        tablero.agregarCasillero(impuestoAlLujo);
        tablero.agregarCasillero(santaFe);
        tablero.agregarCasillero(aysa);
        tablero.agregarCasillero(saltaNorte);
        tablero.agregarCasillero(saltaSur);
        tablero.agregarCasillero(policia);
        tablero.agregarCasillero(tren);
        tablero.agregarCasillero(neuquen);
        tablero.agregarCasillero(retrocesoDinamico);
        tablero.agregarCasillero(tucuman);

        return tablero;
    }


}
