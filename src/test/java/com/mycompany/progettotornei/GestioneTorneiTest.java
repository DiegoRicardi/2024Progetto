/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.progettotornei;

import Eccezioni.NessunGiocatoreException;
import Eccezioni.PartecipantiDispariException;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class GestioneTorneiTest {

    public GestioneTorneiTest() {
    }

    /**
     * Test of aggiungiGiocatore method, of class GestioneTornei.
     */
    @Test
    public void testAggiungiGiocatore() throws Exception {
        GestioneTornei gestioneTornei = new GestioneTornei();
        Giocatore giocatore1 = new Giocatore("Mario", "Rossi");
        Giocatore giocatore2 = new Giocatore("Luigi", "Verdi");

        assertDoesNotThrow(() -> gestioneTornei.aggiungiGiocatore(giocatore1));
        assertDoesNotThrow(() -> gestioneTornei.aggiungiGiocatore(giocatore2));

        assertEquals(2, gestioneTornei.getPartecipanti().size());
    }

    /**
     * Test of rimuoviGiocatore method, of class GestioneTornei.
     */
    @Test
    public void testRimuoviGiocatore() throws Exception {
        GestioneTornei gestioneTornei = new GestioneTornei();
        Giocatore giocatore1 = new Giocatore("Mario", "Rossi");
        Giocatore giocatore2 = new Giocatore("Luigi", "Verdi");

        assertDoesNotThrow(() -> gestioneTornei.aggiungiGiocatore(giocatore1));
        assertDoesNotThrow(() -> gestioneTornei.aggiungiGiocatore(giocatore2));

        assertDoesNotThrow(() -> gestioneTornei.rimuoviGiocatore(giocatore1));

        assertEquals(1, gestioneTornei.getPartecipanti().size());
        assertEquals("Luigi", gestioneTornei.getPartecipanti().get(0).getNome());
    }

    /**
     * Test of generaIncontri method, of class GestioneTornei.
     */
    @Test
    public void testGeneraIncontri() throws Exception {
        GestioneTornei gestioneTornei = new GestioneTornei();
        Giocatore giocatore1 = new Giocatore("Mario", "Rossi");
        Giocatore giocatore2 = new Giocatore("Luigi", "Verdi");
        Giocatore giocatore3 = new Giocatore("Giovanni", "Bianchi");

        assertDoesNotThrow(() -> gestioneTornei.aggiungiGiocatore(giocatore1));
        assertDoesNotThrow(() -> gestioneTornei.aggiungiGiocatore(giocatore2));
        assertDoesNotThrow(() -> gestioneTornei.aggiungiGiocatore(giocatore3));

        assertThrows(PartecipantiDispariException.class, () -> gestioneTornei.generaIncontri());

        Giocatore giocatore4 = new Giocatore("Marco", "Gialli");
        assertDoesNotThrow(() -> gestioneTornei.aggiungiGiocatore(giocatore4));

        assertDoesNotThrow(() -> gestioneTornei.generaIncontri());
        assertEquals(2, gestioneTornei.getIncontri().size());
    }

    /**
     * Test of giocaPartita method, of class GestioneTornei.
     */
    @Test
    public void testGiocaPartita() throws Exception {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        InputStream originalIn = System.in;
        String input = "1\n";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);

        GestioneTornei gestioneTornei = new GestioneTornei();
        Giocatore giocatore1 = new Giocatore("Mario", "Rossi");
        Giocatore giocatore2 = new Giocatore("Luigi", "Verdi");
        Giocatore giocatore3 = new Giocatore("Giovanni", "Bianchi");
        Giocatore giocatore4 = new Giocatore("Marco", "Gialli");

        assertDoesNotThrow(() -> gestioneTornei.aggiungiGiocatore(giocatore1));
        assertDoesNotThrow(() -> gestioneTornei.aggiungiGiocatore(giocatore2));
        assertDoesNotThrow(() -> gestioneTornei.aggiungiGiocatore(giocatore3));
        assertDoesNotThrow(() -> gestioneTornei.aggiungiGiocatore(giocatore4));

        assertDoesNotThrow(() -> gestioneTornei.generaIncontri());

        // Simulazione di partita in cui giocatore1 vince su giocatore2
        assertEquals(2, gestioneTornei.getIncontri().size());
        assertDoesNotThrow(() -> gestioneTornei.giocaPartita());
        assertEquals(3, giocatore1.getPunteggio());
        assertEquals(0, giocatore2.getPunteggio());

        System.setOut(System.out);
        System.setIn(originalIn);
    }

    /**
     * Test of visualizzaClassifica method, of class GestioneTornei.
     */
    @Test
public void testVisualizzaClassifica() {
    // Creiamo una ByteArrayOutputStream per catturare l'output
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    // Creiamo un'istanza di GestioneTornei
    GestioneTornei gestioneTornei = new GestioneTornei();

    // Aggiungiamo alcuni giocatori per testare
    Giocatore giocatore1 = new Giocatore(1, "Mario", "Rossi", 100, LocalDate.of(2022, 5, 1));
    Giocatore giocatore2 = new Giocatore(2, "Luigi", "Verdi", 200, LocalDate.of(2022, 5, 1));
    Giocatore giocatore3 = new Giocatore(3, "Giovanni", "Bianchi", 150, LocalDate.of(2022, 5, 1));

    // Aggiungiamo i giocatori al torneo
    assertDoesNotThrow(() -> gestioneTornei.aggiungiGiocatore(giocatore1));
    assertDoesNotThrow(() -> gestioneTornei.aggiungiGiocatore(giocatore2));
    assertDoesNotThrow(() -> gestioneTornei.aggiungiGiocatore(giocatore3));

    // Eseguiamo il metodo per visualizzare la classifica
    gestioneTornei.visualizzaClassifica();

    // Otteniamo il messaggio di output
    String output = outContent.toString().trim();

    // Creiamo il messaggio di output atteso
    String expectedOutput = "Classifica dei partecipanti:\n" +
                             "1. Mario Rossi - Punteggio: 100\n" +
                             "2. Luigi Verdi - Punteggio: 200\n" +
                             "3. Giovanni Bianchi - Punteggio: 150";

    // Confrontiamo il messaggio di output atteso con quello ottenuto
    assertEquals(expectedOutput, output);

    // Ripristiniamo il System.out
    System.setOut(System.out);
}

    /**
     * Test of modificaNomeGiocatore method, of class GestioneTornei.
     */
    @Test
    public void testModificaNomeGiocatore() throws Exception {
        GestioneTornei gestioneTornei = new GestioneTornei();
        Giocatore giocatore1 = new Giocatore("Mario", "Rossi");
        Giocatore giocatore2 = new Giocatore("Luigi", "Verdi");

        assertDoesNotThrow(() -> gestioneTornei.aggiungiGiocatore(giocatore1));
        assertDoesNotThrow(() -> gestioneTornei.aggiungiGiocatore(giocatore2));

        assertThrows(NessunGiocatoreException.class, () -> gestioneTornei.modificaNomeGiocatore("Giovanni", "Bianchi", "Gianni"));

        assertDoesNotThrow(() -> gestioneTornei.modificaNomeGiocatore("Mario", "Rossi", "Gianni"));
        assertEquals("Gianni", giocatore1.getNome());
    }

    /**
     * Test of esportaCSV method, of class GestioneTornei.
     */
    public void testEsportaCSV() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    GestioneTornei gestioneTornei = new GestioneTornei();
    Giocatore giocatore1 = new Giocatore(1, "Mario", "Rossi", 100, LocalDate.of(2022, 5, 1));
    Giocatore giocatore2 = new Giocatore(2, "Luigi", "Verdi", 200, LocalDate.of(2022, 5, 1));

    assertDoesNotThrow(() -> gestioneTornei.aggiungiGiocatore(giocatore1));
    assertDoesNotThrow(() -> gestioneTornei.aggiungiGiocatore(giocatore2));

    assertDoesNotThrow(() -> gestioneTornei.esportaCSV("giocatori.csv"));

    GestioneTornei nuovoGestioneTornei = new GestioneTornei();
    assertDoesNotThrow(() -> nuovoGestioneTornei.importaCSV("giocatori.csv"));

    // Otteniamo il messaggio di output e lo normalizziamo rimuovendo gli spazi extra e i caratteri di fine riga
    String outMsg = outContent.toString().trim();

    // Messaggio di output atteso
    String expectedMsg = "Esportazione avvenuta con successo!";

    // Verifica se il messaggio di output è uguale al messaggio atteso
    assertEquals(expectedMsg, outMsg);

    System.setOut(System.out);
}

    /**
     * Test of importaCSV method, of class GestioneTornei.
     */
    @Test
public void testImportaCSV() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    GestioneTornei gestioneTornei = new GestioneTornei();
    Giocatore giocatore1 = new Giocatore(1, "Mario", "Rossi", 100, LocalDate.of(2022, 5, 1));
    Giocatore giocatore2 = new Giocatore(2, "Luigi", "Verdi", 200, LocalDate.of(2022, 5, 1));

    assertDoesNotThrow(() -> gestioneTornei.aggiungiGiocatore(giocatore1));
    assertDoesNotThrow(() -> gestioneTornei.aggiungiGiocatore(giocatore2));

    assertDoesNotThrow(() -> gestioneTornei.esportaCSV("giocatori.csv"));

    GestioneTornei nuovoGestioneTornei = new GestioneTornei();
    assertDoesNotThrow(() -> nuovoGestioneTornei.importaCSV("giocatori.csv"));

    // Otteniamo i giocatori dal nuovoGestioneTornei dopo l'importazione
    List<Giocatore> giocatoriDopoImportazione = nuovoGestioneTornei.getPartecipanti();

    // Verifichiamo i nomi dei giocatori
    assertEquals(giocatore1.getNome(), giocatoriDopoImportazione.get(0).getNome());
    assertEquals(giocatore2.getNome(), giocatoriDopoImportazione.get(1).getNome());

    System.setOut(System.out);
}

    /**
     * Test of toString method, of class GestioneTornei.
     */
    @Test
    public void testToString() {
        GestioneTornei gestioneTornei = new GestioneTornei();
        Giocatore giocatore1 = new Giocatore("Mario", "Rossi");
        Giocatore giocatore2 = new Giocatore("Luigi", "Verdi");

        assertDoesNotThrow(() -> gestioneTornei.aggiungiGiocatore(giocatore1));
        assertDoesNotThrow(() -> gestioneTornei.aggiungiGiocatore(giocatore2));

        String expectedOutput = "0\t--> Giocatore{id=1, nome='Mario', cognome='Rossi', punteggio=0, dataRegistrazione=" + LocalDate.now() + "}\n" +
                                "1\t--> Giocatore{id=2, nome='Luigi', cognome='Verdi', punteggio=0, dataRegistrazione=" + LocalDate.now() + "}\n";

        assertEquals(expectedOutput, gestioneTornei.toString());
    }
}
