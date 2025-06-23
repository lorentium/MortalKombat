package org.mortalkombat;

import java.util.*;

public class PersonajeRepository {
    private Map<Long, Personaje> personajes = new HashMap<>();
    public void agregarPersonaje(Personaje personaje) {
        personajes.put(personaje.getId(), personaje);
    }


    public boolean editarPersonaje(long id, String nombre, int saludMaxima, NivelPoder nivelPoder, ArrayList<String> movimientosEspeciales) {
        Personaje personaje = personajes.get(id);
        if (personaje != null) {
            personaje.setNombre(nombre);
            personaje.setSaludMaxima(saludMaxima);
            personaje.setNivelPoder(nivelPoder);
            personaje.setMovimientosEspeciales(movimientosEspeciales);
            return true;
        }
        return false;
    }

    public List<Personaje> obtenerPorNivelPoderMinimo(NivelPoder nivelMinimo) {
        List<Personaje> resultado = new ArrayList<>();
        for (Personaje p : personajes.values()) {
            if (p.getNivelPoder().ordinal() >= nivelMinimo.ordinal()) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    public List<Personaje> buscarPorNombre(String subcadena) {
        String sub = subcadena.toLowerCase();
        List<Personaje> resultado = new ArrayList<>();
        for (Personaje p : personajes.values()) {
            if (p.getNombre().toLowerCase().contains(sub)) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    public List<Personaje> listarPorSaludMaximaDesc() {
        List<Personaje> lista = new ArrayList<>(personajes.values());
        lista.sort((a, b) -> Integer.compare(b.getSaludMaxima(), a.getSaludMaxima()));
        return lista;
    }


    public Optional<Personaje> obtenerPersonajePorId(long id) {
        return Optional.ofNullable(personajes.get(id));
    }

    public ArrayList<Personaje> obtenerPersonajes() {
        return new ArrayList<>(personajes.values());
    }

    public void eliminarPersonaje(long id) {
        personajes.remove(id);
    }


}
