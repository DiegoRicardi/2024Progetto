/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progettotornei;

import Eccezioni.NessunGiocatoreException;
import Eccezioni.NessunIncontroException;
import Eccezioni.PartecipantiDispariException;
import Eccezioni.TorneoPienoException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;



/**
 * classe che gestisce un torneo
 * @author studente
 */
public class GestioneTornei {

    private static final int NUM_MAX_PARTECIPANTI = 16; // Numero massimo di partecipanti
    private List<Giocatore> partecipanti; // Lista dei partecipanti al torneo
    private List<String> incontri; // Lista degli incontri
    private Scanner scanner; // Scanner per l'input da tastiera

    /**
     * Costruttore della classe GestioneTornei.
     * Inizializza le liste dei partecipanti e degli incontri, e il scanner per l'input da tastiera.
     */
    public GestioneTornei() {
        partecipanti = new ArrayList<>();
        incontri = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    /**
     * Aggiunge un giocatore al torneo.
     * @param giocatore Il giocatore da aggiungere.
     * @throws TorneoPienoException Se il numero massimo di partecipanti è stato raggiunto.
     */
    public void aggiungiGiocatore(Giocatore giocatore) throws TorneoPienoException {
        if (partecipanti.size() >= NUM_MAX_PARTECIPANTI) {
            throw new TorneoPienoException();
        }
        partecipanti.add(giocatore);
    }

    /**
     * Rimuove un giocatore dal torneo.
     * @param giocatore Il giocatore da rimuovere.
     * @throws NessunGiocatoreException Se il giocatore specificato non è presente nel torneo.
     */
    public void rimuoviGiocatore(Giocatore giocatore) throws NessunGiocatoreException {
       boolean giocatoreTrovato = false;
       for (Giocatore g : partecipanti) {
           if (g.getNome().equals(giocatore.getNome()) && g.getCognome().equals(giocatore.getCognome())) {
               partecipanti.remove(g);
               giocatoreTrovato = true;
               break; // Usciamo dal ciclo una volta trovato il giocatore
           }
       }
       if (!giocatoreTrovato) {
           throw new NessunGiocatoreException();
       }
    }

    /**
     * Genera gli incontri tra i giocatori.
     * @throws PartecipantiDispariException Se il numero di partecipanti è dispari.
     */
    public void generaIncontri() throws PartecipantiDispariException {
        if (partecipanti.size() % 2 != 0) {
            throw new PartecipantiDispariException();
        }

        List<Giocatore> giocatoriEffettivi = new ArrayList<>();
        for (Giocatore giocatore : partecipanti) {
            if (giocatore != null) {
                giocatoriEffettivi.add(giocatore);
            }
        }

        Collections.shuffle(giocatoriEffettivi);

        incontri.clear();
        for (int i = 0; i < giocatoriEffettivi.size(); i += 2) {
            Giocatore giocatore1 = giocatoriEffettivi.get(i);
            Giocatore giocatore2 = giocatoriEffettivi.get(i + 1);
            String incontro = giocatore1.getNome() + " vs " + giocatore2.getNome();
            incontri.add(incontro);
            System.out.println(incontro);
        }
    }

    /**
     * Simula lo svolgimento di una partita tra i giocatori.
     * @throws NessunIncontroException Se non ci sono incontri da giocare.
     */
    public void giocaPartita() throws NessunIncontroException {
        if (incontri.isEmpty()) {
            throw new NessunIncontroException();
        }

        for (int i = 0; i < incontri.size(); i++) {
            String incontro = incontri.get(i);
            String[] nomiGiocatori = incontro.split(" vs ");
            Giocatore giocatore1 = trovaGiocatorePerNome(nomiGiocatori[0]);
            Giocatore giocatore2 = trovaGiocatorePerNome(nomiGiocatori[1]);

            System.out.println("0 = pareggio, 1 = vince " + giocatore1.getNome() + ", 2 = vince " + giocatore2.getNome());
            System.out.println(giocatore1.getNome() + " " + giocatore1.getCognome() + " VS " + giocatore2.getNome() + " " + giocatore2.getCognome());
            int esitoPartita = scanner.nextInt();

            if (esitoPartita == 0) {
                giocatore1.incrementaPunteggio(1);
                giocatore2.incrementaPunteggio(1);
            } else if (esitoPartita == 1) {
                giocatore1.incrementaPunteggio(3);
            } else {
                giocatore2.incrementaPunteggio(3);
            }

            System.out.println("Partita giocata:");
            System.out.println(giocatore1.getNome() + " vs " + giocatore2.getNome());
            System.out.println("Esito: " + (esitoPartita == 0 ? "Pareggio" : esitoPartita == 1 ? giocatore1.getNome() + " vince" : giocatore2.getNome() + " vince"));
        }
    }

    /**
     * Visualizza la classifica dei giocatori.
     */
    public void visualizzaClassifica() {
        System.out.println("Classifica dei partecipanti:");
        int posizione = 1;
        for (Giocatore giocatore : partecipanti) {
            if (giocatore != null) {
                System.out.println(posizione++ + ". " + giocatore.getNome() + " " + giocatore.getCognome() + " - Punteggio: " + giocatore.getPunteggio());
            }
        }
    }

    /**
     * Modifica il nome di un giocatore.
     * @param nomeVecchio Il vecchio nome del giocatore.
     * @param cognome Il cognome del giocatore.
     * @param nuovoNome Il nuovo nome da assegnare al giocatore.
     * @throws NessunGiocatoreException Se il giocatore specificato non è presente nel torneo.
     */
    public void modificaNomeGiocatore(String nomeVecchio, String cognome, String nuovoNome) throws NessunGiocatoreException {
        boolean trovato = false;
        for (Giocatore giocatore : partecipanti) {
            if (giocatore.getNome().equals(nomeVecchio) && giocatore.getCognome().equals(cognome)) {
                giocatore.setNome(nuovoNome);
                trovato = true;
                break;
            }
        }
        if (!trovato) {
            throw new NessunGiocatoreException();
        }
    }

    /**
     * Trova un giocatore per nome.
     * @param nome Il nome del giocatore da cercare.
     * @return Il giocatore corrispondente al nome specificato, null se non trovato.
     */
    private Giocatore trovaGiocatorePerNome(String nome) {
        for (Giocatore giocatore : partecipanti) {
            if (giocatore.getNome().equals(nome)) {
                return giocatore;
            }
        }
        return null;
    }

    /**
     * Esporta i dati dei giocatori in un file CSV.
     * @param nomeFile Il nome del file CSV.
     */
    public void esportaCSV(String nomeFile) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeFile))) {
            for (Giocatore giocatore : partecipanti) {
                writer.println(giocatore.getId() + "," +
                        giocatore.getNome() + "," +
                        giocatore.getCognome() + "," +
                        giocatore.getPunteggio() + "," +
                        giocatore.getDataRegistrazione());
            }
            System.out.println("Esportazione avvenuta con successo!");
        } catch (IOException e) {
            System.out.println("Errore durante l'esportazione dei dati: " + e.getMessage());
        }
    }

    /**
     * Importa i dati dei giocatori da un file CSV.
     * @param nomeFile Il nome del file CSV.
     */
    public void importaCSV(String nomeFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeFile))) {
            String riga;
            while ((riga = reader.readLine()) != null) {
                String[] datiGiocatore = riga.split(",");
                long id = Long.parseLong(datiGiocatore[0]);
                String nome = datiGiocatore[1];
                String cognome = datiGiocatore[2];
                int punteggio = Integer.parseInt(datiGiocatore[3]);
                LocalDate dataRegistrazione = LocalDate.parse(datiGiocatore[4]);

                Giocatore giocatore = new Giocatore(id, nome, cognome, punteggio, dataRegistrazione);
                partecipanti.add(giocatore);
            }
            System.out.println("Importazione avvenuta con successo.");
        } catch (IOException e) {
            System.out.println("Errore durante l'importazione dei dati: " + e.getMessage());
        }
    }
    
    /**
     * Restituisce la lista degli incontri.
     * @return La lista degli incontri.
     */
    public List<String> getIncontri() {
        return incontri;
    }
    
    /**
     * Restituisce la lista dei partecipanti al torneo.
     * @return La lista dei partecipanti al torneo.
     */
    public List<Giocatore> getPartecipanti() {
        return partecipanti;
    }
    
    /**
     * Restituisce una rappresentazione in formato stringa degli incontri tra i giocatori.
     * @return Una stringa contenente gli incontri.
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < NUM_MAX_PARTECIPANTI; i++) {
            s.append(i).append("\t--> ");
            if (i < partecipanti.size() && partecipanti.get(i) != null) {
                s.append(partecipanti.get(i)).append("\n");
            } else {
                s.append("\n");
            }
        }
        return s.toString();
    }
}