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
    private Personaje personaje3;
    private PersonajeRepository repo;


    @BeforeEach
    public void setUp() {
        repo = new PersonajeRepository();
        personaje1 = new Personaje("Scorpion", 100, ALTO, new ArrayList<>());
        personaje2 = new Personaje("Sub-Zero", 120, MEDIO, new ArrayList<>());
        personaje3 = new Personaje("Kitara", 50, BAJO, new ArrayList<>());
        repo.agregarPersonaje(personaje1);
        repo.agregarPersonaje(personaje2);

    }

    @Test
    public void testAgregarPersonaje() {
        repo.agregarPersonaje(personaje1);
        assertTrue(repo.obtenerPersonajes().contains(personaje1));
    }

    @Test
    public void testObtenerPorNivelPoderMinimo() {
        // personaje1: ALTO, personaje2: MEDIO, personaje3: BAJO
        var resultado = repo.obtenerPorNivelPoderMinimo(MEDIO);
        assertTrue(resultado.contains(personaje1));
        assertTrue(resultado.contains(personaje2));
        assertFalse(resultado.contains(personaje3));
        assertEquals(2, resultado.size());

        resultado = repo.obtenerPorNivelPoderMinimo(ALTO);
        assertTrue(resultado.contains(personaje1));
        assertFalse(resultado.contains(personaje2));
        assertFalse(resultado.contains(personaje3));


        assertEquals(1, resultado.size());
    }

    @Test
    public void testBuscarPorNombre() {
        var resultado = repo.buscarPorNombre("scor");
        assertTrue(resultado.contains(personaje1));
        assertFalse(resultado.contains(personaje2));

        resultado = repo.buscarPorNombre("SUB");
        assertTrue(resultado.contains(personaje2));
        assertFalse(resultado.contains(personaje1));
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
        repo.agregarPersonaje(personaje3);
        ArrayList<Personaje> personajes = repo.obtenerPersonajes();
        assertEquals(3, personajes.size());
        assertTrue(personajes.contains(personaje1));
        assertTrue(personajes.contains(personaje2));
        assertTrue(personajes.contains(personaje3));
    }

    @Test
    public void testEliminarPersonaje() {
        repo.agregarPersonaje(personaje1);
        repo.eliminarPersonaje(personaje1.getId());
        assertFalse(repo.obtenerPersonajes().contains(personaje1));
    }
}
