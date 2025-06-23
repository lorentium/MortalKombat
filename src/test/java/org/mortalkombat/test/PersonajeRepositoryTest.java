package org.mortalkombat.test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mortalkombat.Personaje;
import org.mortalkombat.PersonajeRepository;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mortalkombat.NivelPoder.*;

public class PersonajeRepositoryTest {
    private Personaje personaje1;
    private Personaje personaje2;
    private PersonajeRepository repo;


    @BeforeEach
    public void setUp() {
        PersonajeRepository repo = new PersonajeRepository();
        Personaje personaje1 = new Personaje("Scorpion", 100, ALTO, new ArrayList<>());
        Personaje personaje2 = new Personaje("Sub-Zero", 120, MEDIO, new ArrayList<>());
        repo.agregarPersonaje(personaje1);
        repo.agregarPersonaje(personaje2);

    }


    @Test
    public void testAgregarPersonaje() {
        repo.agregarPersonaje(personaje1);
        assertTrue(repo.obtenerPersonajes().contains(personaje1));
    }

    @Test
    public void testEditarPersonaje() {
        repo.agregarPersonaje(personaje1);

        boolean editado = repo.editarPersonaje(personaje1.getId(), "Sub-Zero", 120, ALTO, new ArrayList<>());
        assertTrue(editado);

        Optional<Personaje> encontrado = repo.obtenerPersonajePorId(personaje1.getId());
        assertTrue(encontrado.isPresent());
        assertEquals(120, encontrado.get().getSaludMaxima());
        assertEquals(ALTO, encontrado.get().getNivelPoder());
    }

    @Test
    public void testObtenerPersonajePorId() {
        repo.agregarPersonaje(personaje1);
        Optional<Personaje> encontrado = repo.obtenerPersonajePorId(personaje1.getId());
        assertTrue(encontrado.isPresent());
        assertEquals(personaje1, encontrado.get());
    }

    @Test
    public void testObtenerPersonajes() {
        repo.agregarPersonaje(personaje1);
        repo.agregarPersonaje(personaje2);
        ArrayList<Personaje> personajes = repo.obtenerPersonajes();
        assertEquals(2, personajes.size());
        assertTrue(personajes.contains(personaje1));
        assertTrue(personajes.contains(personaje2));
    }

    @Test
    public void testEliminarPersonaje() {
        repo.agregarPersonaje(personaje1);
        repo.eliminarPersonaje(personaje1.getId());
        assertFalse(repo.obtenerPersonajes().contains(personaje1));
    }
}
