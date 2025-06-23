package org.mortalkombat;

import java.util.*;

public class PersonajeRepository {
    private Map<Long, Personaje> personajes = new HashMap<>();
    public void agregarPersonaje(Personaje personaje) {
        personajes.put(personaje.getId(), personaje);
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
