package modelo;

import modelo.casillero.*;
import modelo.propiedad.Servicio;
import modelo.propiedad.Terreno;
import modelo.propiedad.TerrenoDoble;

import java.util.ArrayList;


public class Tablero {
    private ArrayList<Casillero> casilleros = new ArrayList<>();
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
        casilleros = new ArrayList<>();
    }

    public static Tablero inicializar(){

        // Instanciación de todos los casilleros
        Casillero salida = new Casillero();
        salida.asignarNombre("SALIDA");
        Quini6 quini6 = new Quini6();
        quini6.asignarNombre("QUINI6");
        TerrenoDoble buenosAiresSur = new TerrenoDoble(20000, 2000, 3000, 3500, 5000, 5000, 8000);
        buenosAiresSur.asignarNombre("BUENOS AIRES SUR");
        Servicio edesur = new Servicio(35000, 500, 1000);
        edesur.asignarNombre("EDESUR");
        TerrenoDoble buenosAiresNorte = new TerrenoDoble(25000, 2500, 3500, 4000, 6000, 5500, 9000);
        buenosAiresNorte.asignarNombre("BUENOS AIRES NORTE");
        Carcel carcel = new Carcel();
        carcel.asignarNombre("CARCEL");
        TerrenoDoble cordobaSur = new TerrenoDoble(18000, 1000, 1500, 2500, 3000, 2000, 3000);
        cordobaSur.asignarNombre("CORDOBA SUR");
        AvanceDinamico avanceDinamico = new AvanceDinamico();
        avanceDinamico.asignarNombre("AVANCE DINAMICO");
        Servicio subte = new Servicio(40000, 600, 1100);
        subte.asignarNombre("SUBTE");
        TerrenoDoble cordobaNorte = new TerrenoDoble(20000, 1300, 1800, 2900, 3500, 2200, 3500);
        cordobaNorte.asignarNombre("CORDOBA NORTE");
        ImpuestoAlLujo impuestoAlLujo = new ImpuestoAlLujo();
        impuestoAlLujo.asignarNombre("IMPUESTO AL LUJO");
        Terreno santaFe = new Terreno(15000, 1500, 3500, 4000);
        santaFe.asignarNombre("SANTA FE");
        Servicio aysa = new Servicio(30000, 300, 500);
        aysa.asignarNombre("AYSA");
        TerrenoDoble saltaNorte = new TerrenoDoble(23000, 2000, 3250, 3850, 5500, 4500, 7500);
        saltaNorte.asignarNombre("SALTA NORTE");
        TerrenoDoble saltaSur = new TerrenoDoble(23000, 2000, 3250, 3850, 5500, 4500, 7500);
        saltaSur.asignarNombre("SALTA SUR");
        Policia policia = new Policia(carcel);
        policia.asignarNombre("POLICIA");
        Servicio tren = new Servicio(38000, 450, 800);
        tren.asignarNombre("TREN");
        Terreno neuquen = new Terreno(17000, 1800, 3800, 4800);
        neuquen.asignarNombre("NEUQUEN");
        RetrocesoDinamico retrocesoDinamico = new RetrocesoDinamico();
        retrocesoDinamico.asignarNombre("RETROCESO DINAMICO");
        Terreno tucuman = new Terreno(25000, 2500, 4500, 7000);
        tucuman.asignarNombre("TUCUMAN");

        // Relaciones entre casilleros
        buenosAiresNorte.asignarHermano(buenosAiresSur);
        buenosAiresSur.asignarHermano(buenosAiresNorte);

        cordobaNorte.asignarHermano(cordobaSur);
        cordobaSur.asignarHermano(cordobaNorte);

        saltaNorte.asignarHermano(saltaSur);
        saltaSur.asignarHermano(saltaNorte);

        subte.asignarHermano(tren);
        tren.asignarHermano(subte);

        aysa.asignarHermano(edesur);
        edesur.asignarHermano(aysa);

        //Agrego los casilleros en orden al tablero
        Tablero tablero = Tablero.darTablero();
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

        //Agrego coordenadas
        int x0 = 0;
        int x1 = 174;
        int x2 = 348;
        int x3 = 522;
        int x4 = 696;
        int x5 = 870;
        int y0 = 0;
        int y1 = 90;
        int y2 = 180;
        int y3 = 270;
        int y4 = 360;
        int y5 = 450;

        //Salida
        CoordenadasCasillero coordenadasSalida = new CoordenadasCasillero(x5,y5);
        salida.asignarCoordenadas(coordenadasSalida);
        CoordenadasCasillero coordenadasQuini6 = new CoordenadasCasillero(x4,y5);
        quini6.asignarCoordenadas(coordenadasQuini6);
        CoordenadasCasillero coordenadasBuenosAiresSur = new CoordenadasCasillero(x3,y5);
        buenosAiresSur.asignarCoordenadas(coordenadasBuenosAiresSur);
        CoordenadasCasillero coordenadasEdesur = new CoordenadasCasillero(x2,y5);
        edesur.asignarCoordenadas(coordenadasEdesur);
        CoordenadasCasillero coordenadasBuenosAiresNorte = new CoordenadasCasillero(x1,y5);
        buenosAiresNorte.asignarCoordenadas(coordenadasBuenosAiresNorte);
        //Carcel
        CoordenadasCasillero coordenadasCarcel = new CoordenadasCasillero(x0,y5);
        carcel.asignarCoordenadas(coordenadasCarcel);
        CoordenadasCasillero coordenadasCordobaSur = new CoordenadasCasillero(x0,y4);
        cordobaSur.asignarCoordenadas(coordenadasCordobaSur);
        CoordenadasCasillero coordenadasAvanceDinamico = new CoordenadasCasillero(x0,y3);
        avanceDinamico.asignarCoordenadas(coordenadasAvanceDinamico);
        CoordenadasCasillero coordenadasSubte = new CoordenadasCasillero(x0,y2);
        subte.asignarCoordenadas(coordenadasSubte);
        CoordenadasCasillero coordenadasCordobaNorte = new CoordenadasCasillero(x0,y1);
        cordobaNorte.asignarCoordenadas(coordenadasCordobaNorte);
        //Impuesto al lujo
        CoordenadasCasillero coordenadasImpuestoAlLujo = new CoordenadasCasillero(x0,y0);
        impuestoAlLujo.asignarCoordenadas(coordenadasImpuestoAlLujo);
        CoordenadasCasillero coordenadasSantaFe = new CoordenadasCasillero(x1,y0);
        santaFe.asignarCoordenadas(coordenadasSantaFe);
        CoordenadasCasillero coordenadasAysa = new CoordenadasCasillero(x2,y0);
        aysa.asignarCoordenadas(coordenadasAysa);
        CoordenadasCasillero coordenadasSaltaNorte = new CoordenadasCasillero(x3,y0);
        saltaNorte.asignarCoordenadas(coordenadasSaltaNorte);
        CoordenadasCasillero coordenadasSaltaSur = new CoordenadasCasillero(x4,y0);
        saltaSur.asignarCoordenadas(coordenadasSaltaSur);
        //Policia
        CoordenadasCasillero coordenadasPolicia = new CoordenadasCasillero(x5,y0);
        policia.asignarCoordenadas(coordenadasPolicia);
        CoordenadasCasillero coordenadasTren = new CoordenadasCasillero(x5,y1);
        tren.asignarCoordenadas(coordenadasTren);
        CoordenadasCasillero coordenadasNeuquen = new CoordenadasCasillero(x5,y2);
        neuquen.asignarCoordenadas(coordenadasNeuquen);
        CoordenadasCasillero coordenadasRetrocesoDinamico = new CoordenadasCasillero(x5,y3);
        retrocesoDinamico.asignarCoordenadas(coordenadasRetrocesoDinamico);
        CoordenadasCasillero coordenadasTucuman = new CoordenadasCasillero(x5,y4);
        tucuman.asignarCoordenadas(coordenadasTucuman);

        return tablero;
    }

    public Casillero obtenerPrimerCasillero(){
        return casilleros.get(0);
    }


}
