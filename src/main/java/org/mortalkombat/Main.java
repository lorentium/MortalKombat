package org.mortalkombat;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Personaje personaje = new Personaje(
                "Scorpion",
                100,
                NivelPoder.ALTO,
                new ArrayList<>(List.of("Lanzar cadena", "Teletransportarse", "Lanzar fuego"))
        );
        PersonajeRepository repo = new PersonajeRepository();



    }

}