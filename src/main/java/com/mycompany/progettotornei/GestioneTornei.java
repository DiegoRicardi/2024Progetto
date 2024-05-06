/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progettotornei;

import static java.lang.Math.random;
import static java.lang.StrictMath.random;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Studente
 */
public class GestioneTornei
{
    
    private static final int NUM_MAX_PARTECIPANTI = 100;
    private Giocatore[] partecipanti;
    private int maxGiocatori;
    private Random random = new Random();
    
    public GestioneTornei()
    {
        partecipanti = new Giocatore[NUM_MAX_PARTECIPANTI];
        maxGiocatori = 0;
    }
    
    public void aggiungiGiocatore(Giocatore giocatore) 
    {
        if (maxGiocatori >= NUM_MAX_PARTECIPANTI) 
        {
            System.out.println("Numero massimo di giocatori raggiunto");
            return;
        }
        partecipanti[maxGiocatori++] = giocatore;
    }
    
    public void rimuoviGiocatore(Giocatore giocatore) 
    {
        for (int i = 0; i < maxGiocatori; i++) 
        {
            if (partecipanti[i].equals(giocatore)) 
            {
                for (int j = i; j < maxGiocatori - 1; j++) 
                {
                    partecipanti[j] = partecipanti[j + 1];
                }
                partecipanti[--maxGiocatori] = null;
                return;
            }
        }
        System.out.println("Giocatore non trovato");
    }
    
    public void generaIncontri() 
    {
        // Filtra solo i giocatori effettivi
        ArrayList<Giocatore> giocatoriEffettivi = new ArrayList<>();
        for (int i = 0; i < maxGiocatori; i++) 
        {
            if (partecipanti[i] != null) 
            {
                giocatoriEffettivi.add(partecipanti[i]);
            }
        }
        
        //Creazione degli incontri
        for (int i = 0; i < giocatoriEffettivi.size() - 1; i += 2) 
        {
            Giocatore giocatore1 = giocatoriEffettivi.get(i);
            Giocatore giocatore2 = giocatoriEffettivi.get(i + 1);
            System.out.println(giocatore1.getNome() + " vs " + giocatore2.getNome());
        }
    }
    
    public void giocaPartita() {
        // Implementa la logica per giocare una partita
        if (maxGiocatori < 2) {
            System.out.println("Non ci sono abbastanza giocatori per giocare una partita.");
            return;
        }
 
        Giocatore giocatore1 = partecipanti[0];
        Giocatore giocatore2 = partecipanti[1];
 
        // Esempio di determinazione del vincitore in modo casuale
        Scanner s1 = new Scanner(System.in);
        System.out.println("0 = pareggio, 1 = vince giocatore1, 2 = vince giocatore 2");
        System.out.println(giocatore1.getNome()+" "+giocatore1.getCognome()+" VS "+giocatore2.getNome()+" "+giocatore2.getCognome());
        int esitoPartita = s1.nextInt(); // 0 = pareggio, 1 = vince giocatore1, 2 = vince giocatore 2
 
        if (esitoPartita == 0) //pareggio
        { 
            giocatore1.incrementaPunteggio(1);
            giocatore2.incrementaPunteggio(1);
        } 
        else if (esitoPartita == 1) //vincitore giocatore 1
        { 
            giocatore1.incrementaPunteggio(3);
        } 
        else //vincitore giocatore 2
        { 
            giocatore2.incrementaPunteggio(3);
        }
 
        System.out.println("Partita giocata:");
        System.out.println(giocatore1.getNome() + " vs " + giocatore2.getNome());
        System.out.println("Esito: " + (esitoPartita == 0 ? "Pareggio" : esitoPartita == 1 ? giocatore1.getNome() + " vince" : giocatore2.getNome() + " vince"));
 
        // Rimuove i giocatori dalla lista
        for (int i = 0; i < 2; i++) {
            for (int j = i; j < maxGiocatori - 1; j++) {
                partecipanti[j] = partecipanti[j + 1];
            }
            partecipanti[--maxGiocatori] = null;
        }
    }

    @Override
    public String toString() 
    {
        return "GestioneTorneo{" + "partecipanti=" + partecipanti.toString() + ", maxGiocatori=" + maxGiocatori + '}';
    }
    
    
}

