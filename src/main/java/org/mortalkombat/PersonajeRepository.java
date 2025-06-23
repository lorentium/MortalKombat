package org.mortalkombat;

import java.util.ArrayList;
import java.util.Optional;

public class PersonajeRepository {
    private ArrayList<Personaje> personajes= new ArrayList<>();
    public void agregarPersonaje(Personaje personaje){
        personajes.add(personaje);
    }

    public Optional<Personaje> obtenerPersonajePorId(int id) {
        for (Personaje personaje : personajes) {
            if (personaje.getId() == id) {
                return Optional.of(personaje);
            }
        }
        return Optional.empty();
    }

    public ArrayList<Personaje> obtenerPersonajes() {
        return personajes ;
    }
    public void eliminarPersonaje(int id) {
        if (personajes != null) {
            personajes.removeIf(personaje -> personaje.getId() == id);
        }

    }


}
