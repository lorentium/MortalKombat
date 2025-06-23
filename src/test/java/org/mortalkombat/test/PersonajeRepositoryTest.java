package org.mortalkombat.test;
import org.junit.jupiter.api.Test;
import org.mortalkombat.Personaje;
import org.mortalkombat.PersonajeRepository;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonajeRepositoryTest {

    @Test
    public void testAgregarPersonaje() {
        PersonajeRepository repo = new PersonajeRepository();
        Personaje personaje = new Personaje("Scorpion", 100, null, new ArrayList<>());
        repo.agregarPersonaje(personaje);
        assertTrue(repo.obtenerPersonajes().contains(personaje));
    }

    @Test
    public void testObtenerPersonajePorId() {
        PersonajeRepository repo = new PersonajeRepository();
        Personaje personaje = new Personaje("Sub-Zero", 100, null, new ArrayList<>());
        repo.agregarPersonaje(personaje);
        Optional<Personaje> encontrado = repo.obtenerPersonajePorId(personaje.getId());
        assertTrue(encontrado.isPresent());
        assertEquals(personaje, encontrado.get());
    }

    @Test
    public void testObtenerPersonajes() {
        PersonajeRepository repo = new PersonajeRepository();
        Personaje p1 = new Personaje("Liu Kang", 100, null, new ArrayList<>());
        Personaje p2 = new Personaje("Raiden", 100, null, new ArrayList<>());
        repo.agregarPersonaje(p1);
        repo.agregarPersonaje(p2);
        ArrayList<Personaje> personajes = repo.obtenerPersonajes();
        assertEquals(2, personajes.size());
        assertTrue(personajes.contains(p1));
        assertTrue(personajes.contains(p2));
    }

    @Test
    public void testEliminarPersonaje() {
        PersonajeRepository repo = new PersonajeRepository();
        Personaje personaje = new Personaje("Kitana", 100, null, new ArrayList<>());
        repo.agregarPersonaje(personaje);
        repo.eliminarPersonaje(personaje.getId());
        assertFalse(repo.obtenerPersonajes().contains(personaje));
    }
}
