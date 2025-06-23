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
