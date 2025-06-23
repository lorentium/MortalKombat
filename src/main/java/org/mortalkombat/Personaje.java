package org.mortalkombat;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Personaje {
    private int id;
    private String nombre;
    private int saludMaxima;
    private NivelPoder NivelPoder;
    private ArrayList<String> movimientosEspeciales = new ArrayList<>();

    public Personaje( String nombre, int saludMaxima, NivelPoder nivelPoder, ArrayList<String> movimientosEspeciales) {
        this.id = ThreadLocalRandom.current().nextInt(1, 1000001);
        this.nombre = nombre;
        this.saludMaxima = saludMaxima;
        NivelPoder = nivelPoder;
        this.movimientosEspeciales = movimientosEspeciales;
    }

    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public int getSaludMaxima() {
        return saludMaxima;
    }
    public NivelPoder getNivelPoder() {
        return NivelPoder;
    }
    public ArrayList<String> getMovimientosEspeciales() {
        return movimientosEspeciales;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setSaludMaxima(int saludMaxima) {
        this.saludMaxima = saludMaxima;
    }
    public void setNivelPoder(NivelPoder nivelPoder) {
        NivelPoder = nivelPoder;
    }
    public void setMovimientosEspeciales(ArrayList<String> movimientosEspeciales) {
        this.movimientosEspeciales = movimientosEspeciales;
    }

}
