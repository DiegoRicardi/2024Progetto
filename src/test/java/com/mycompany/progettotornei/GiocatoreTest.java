/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.progettotornei;

import java.time.LocalDate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ettore
 */
public class GiocatoreTest {
    @Test
    public void testCostruttoreConNomeECognome() {
        Giocatore giocatore = new Giocatore("Mario", "Rossi");
        assertEquals("Mario", giocatore.getNome());
        assertEquals("Rossi", giocatore.getCognome());
        assertEquals(0, giocatore.getPunteggio());
        assertEquals(LocalDate.now(), giocatore.getDataRegistrazione());
    }

    @Test
    public void testCostruttoreConDettagli() {
        LocalDate data = LocalDate.of(2022, 5, 1);
        Giocatore giocatore = new Giocatore(1, "Luigi", "Verdi", 100, data);
        assertEquals(1, giocatore.getId());
        assertEquals("Luigi", giocatore.getNome());
        assertEquals("Verdi", giocatore.getCognome());
        assertEquals(100, giocatore.getPunteggio());
        assertEquals(data, giocatore.getDataRegistrazione());
    }

    @Test
    public void testIncrementaPunteggio() {
        Giocatore giocatore = new Giocatore("Mario", "Rossi");
        assertEquals(0, giocatore.getPunteggio());
        giocatore.incrementaPunteggio(50);
        assertEquals(50, giocatore.getPunteggio());
        giocatore.incrementaPunteggio(100);
        assertEquals(150, giocatore.getPunteggio());
    }

    @Test
    public void testModificaNomeECognome() {
        Giocatore giocatore = new Giocatore("Mario", "Rossi");
        assertEquals("Mario", giocatore.getNome());
        assertEquals("Rossi", giocatore.getCognome());
        giocatore.setNome("Giovanni");
        giocatore.setCognome("Bianchi");
        assertEquals("Giovanni", giocatore.getNome());
        assertEquals("Bianchi", giocatore.getCognome());
    }

    @Test
    public void testToString() {
        LocalDate data = LocalDate.of(2022, 5, 1);
        Giocatore giocatore = new Giocatore(1, "Luigi", "Verdi", 100, data);
        String expectedString = "Giocatore{id=1, nome='Luigi', cognome='Verdi', punteggio=100, dataRegistrazione=2022-05-01}";
        assertEquals(expectedString, giocatore.toString());
    }
}
