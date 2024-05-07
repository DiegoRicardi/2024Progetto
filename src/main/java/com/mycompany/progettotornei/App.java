/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.progettotornei;

import Eccezioni.NessunGiocatoreException;
import Eccezioni.NessunIncontroException;
import Eccezioni.PartecipantiDispariException;
import Eccezioni.TorneoPienoException;
import static java.lang.System.out;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author studente
 */
public class App {

    public static void main(String[] args) {
        String[] vociMenu;
        int numeroVoci = 8;
        vociMenu = new String[numeroVoci];
        Menu menu;
        int voceScelta;
        GestioneTornei torneo = new GestioneTornei();
        Scanner tastiera = new Scanner(System.in);

        vociMenu[0] = "0\t--> Esci";
        vociMenu[1] = "1\t--> Visualizza giocatori presenti";
        vociMenu[2] = "2\t--> Aggiungi giocatore";
        vociMenu[3] = "3\t--> Rimuovi giocatore";
        vociMenu[4] = "4\t--> Genera incontri";
        vociMenu[5] = "5\t--> Gioca partita";
        vociMenu[6] = "6\t--> Visualizza classifica";
        vociMenu[7] = "7\t--> Modifica nome";

        menu = new Menu(vociMenu);

        // Gestione menu
        do {
            System.out.println("Menu:");
            voceScelta = menu.sceltaMenu();
            switch (voceScelta) {
                case 0:
                    System.out.println("Arrivederci!");
                    break;
                case 1:
                    System.out.println(torneo.toString());
                    break;
                case 2:
                    System.out.println("Inserisci il nome del giocatore: ");
                    String nomeGiocatore = tastiera.nextLine();
                    System.out.println("Inserisci il cognome del giocatore: ");
                    String cognomeGiocatore = tastiera.nextLine();
                    try {
                        torneo.aggiungiGiocatore(new Giocatore(nomeGiocatore, cognomeGiocatore));
                        System.out.println("Giocatore aggiunto correttamente.");
                    } catch (TorneoPienoException ex) {
                        System.out.println("Numero massimo di giocatori raggiunto");
                    }
                    break;
                case 3:
                    System.out.println("Inserisci il nome del giocatore da rimuovere: ");
                    String nomeGiocatoreRim = tastiera.nextLine();
                    System.out.println("Inserisci il cognome del giocatore da rimuovere: ");
                    String cognomeGiocatoreRim = tastiera.nextLine();
                    Giocatore giocatoreRim = new Giocatore(nomeGiocatoreRim, cognomeGiocatoreRim);
                    try {
                        torneo.rimuoviGiocatore(giocatoreRim);
                        System.out.println("Giocatore rimosso correttamente.");
                    } catch (NessunGiocatoreException ex) {
                        System.out.println("Giocatore non trovato");
                    }
                    break;

                case 4:
                    try {
                        torneo.generaIncontri();
                    } catch (PartecipantiDispariException ex) {
                        System.out.println("Devi avere un numero pari di partecipanti per generare gli incontri.");
                    }
                    break;

                case 5:
                    try {
                        torneo.giocaPartita();
                    } catch (NessunIncontroException ex) {
                        System.out.println("Devi prima generare gli incontri.");
                    }
                    break;

                case 6:
                    torneo.visualizzaClassifica();
                    break;

                case 7:
                    System.out.println("Inserisci il nome del giocatore da modificare: ");
                    String nomeGiocatoreDaModificare = tastiera.nextLine();
                    System.out.println("Inserisci il cognome del giocatore da modificare: ");
                    String cognomeGiocatoreDaModificare = tastiera.nextLine();
                    System.out.println("Inserisci il nuovo nome: ");
                    String nuovoNome = tastiera.nextLine();
                    Giocatore giocatoreDaModificare = new Giocatore(nomeGiocatoreDaModificare, cognomeGiocatoreDaModificare);
                    try {
                        torneo.modificaNomeGiocatore(nomeGiocatoreDaModificare, cognomeGiocatoreDaModificare, nuovoNome);
                        System.out.println("Nome modificato correttamente.");
                    } catch (NessunGiocatoreException ex) {
                        System.out.println("Giocatore non trovato.");
                    }
                    break;
            }
        } while (voceScelta != 0);
    }
}