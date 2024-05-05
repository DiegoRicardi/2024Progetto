/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.progettotornei;

public class App {

    public static void main(String[] args) {
        String[] vociMenu;
        int numeroVoci = 7;
        vociMenu = new String[numeroVoci];
        Menu menu;
        int voceScelta;
        GestioneTorneo torneo = new GestioneTorneo();
        Scanner tastiera = new Scanner(System.in);

        vociMenu[0] = "0\t--> Esci";
        vociMenu[1] = "1\t--> Visualizza giocatori presenti";
        vociMenu[2] = "2\t--> Aggiungi giocatore";
        vociMenu[3] = "3\t--> Rimuovi giocatore";
        vociMenu[4] = "4\t--> Genera incontri";
        vociMenu[5] = "5\t--> Gioca partita";
        vociMenu[6] = "6\t--> Visualizza classifica";

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
                    System.out.println("Inserisci il nome del giocatore:");
                    String nomeGiocatore = tastiera.nextLine();
                    torneo.aggiungiGiocatore(new Giocatore(nomeGiocatore));
                    System.out.println("Giocatore aggiunto correttamente.");
                    break;
                case 3:
                    System.out.println("Inserisci il nome del giocatore da rimuovere:");
                    String nomeGiocatoreRim = tastiera.nextLine();
                    Giocatore giocatoreRim = new Giocatore(nomeGiocatoreRim); // Questa riga crea un nuovo giocatore, ma non è necessaria per la rimozione
                    torneo.rimuoviGiocatore(giocatoreRim);
                    System.out.println("Giocatore rimosso correttamente.");
                    break;
                case 4:
                    torneo.generaIncontri();
                    break;
                case 5:
                    torneo.giocaPartita();
                    break;
                case 6:
                    torneo.visualizzaClassifica();
                    break;
            }
        } while (voceScelta != 0);
    }
}