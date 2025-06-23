package org.mortalkombat.test;


import org.junit.jupiter.api.Test;
import org.mortalkombat.NivelPoder;
import org.mortalkombat.Personaje;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonajeTest {

    @Test
    public void testCrearPersonaje() {
        ArrayList<String> movimientos = new ArrayList<>(List.of("Lanzar cadena", "Teletransportarse", "Lanzar fuego"));
        Personaje personaje = new Personaje("Scorpion", 100, NivelPoder.ALTO, movimientos);
        assertEquals("Scorpion", personaje.getNombre());
        assertEquals(100, personaje.getSaludMaxima());
        assertEquals(NivelPoder.ALTO, personaje.getNivelPoder());
        assertEquals(movimientos, personaje.getMovimientosEspeciales());
    }

}
