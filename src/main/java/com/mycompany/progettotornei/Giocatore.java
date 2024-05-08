/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progettotornei;

import java.time.LocalDate;

/**
 *Classe che rappresenta un Giocatore
 * @author studente
 */
public class Giocatore {
    private static long prossimoId = 1; // L'ID del prossimo giocatore da assegnare
    private long id; // Identificatore del giocatore
    private String nome; // Nome del giocatore
    private String cognome; // Cognome del giocatore
    private int punteggio; // Punteggio del giocatore
    private LocalDate dataRegistrazione; // Data di registrazione del giocatore

    /**
     * Costruttore di copia della classe Giocatore.
     * Crea un nuovo giocatore con nome e cognome specificati.
     * L'ID del giocatore viene assegnato automaticamente.
     * Il punteggio iniziale è 0 e la data di registrazione è impostata alla data corrente.
     * @param nome Il nome del giocatore.
     * @param cognome Il cognome del giocatore.
     */
    public Giocatore(String nome, String cognome) {
        this.id = prossimoId;
        prossimoId++;
        this.nome = nome;
        this.cognome = cognome;
        this.punteggio = 0;
        this.dataRegistrazione = LocalDate.now();
    }

    /**
     * Costruttore della classe Giocatore.
     * Crea un nuovo giocatore con tutti i dettagli specificati.
     * @param id L'ID del giocatore.
     * @param nome Il nome del giocatore.
     * @param cognome Il cognome del giocatore.
     * @param punteggio Il punteggio del giocatore.
     * @param dataRegistrazione La data di registrazione del giocatore.
     */
    public Giocatore(long id, String nome, String cognome, int punteggio, LocalDate dataRegistrazione) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.punteggio = punteggio;
        this.dataRegistrazione = dataRegistrazione;
        if (id >= prossimoId) {
            prossimoId = id + 1;
        }
    }

    /**
     * Restituisce l'ID del giocatore.
     * @return L'ID del giocatore.
     */
    public long getId() {
        return id;
    }

    /**
     * Restituisce il nome del giocatore.
     * @return Il nome del giocatore.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Imposta il nome del giocatore.
     * @param nome Il nuovo nome del giocatore.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Restituisce il cognome del giocatore.
     * @return Il cognome del giocatore.
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * Imposta il cognome del giocatore.
     * @param cognome Il nuovo cognome del giocatore.
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * Restituisce il punteggio del giocatore.
     * @return Il punteggio del giocatore.
     */
    public int getPunteggio() {
        return punteggio;
    }

    /**
     * Incrementa il punteggio del giocatore.
     * @param punti I punti da aggiungere al punteggio.
     */
    public void incrementaPunteggio(int punti) {
        this.punteggio += punti;
    }

    /**
     * Restituisce la data di registrazione del giocatore.
     * @return La data di registrazione del giocatore.
     */
    public LocalDate getDataRegistrazione() {
        return dataRegistrazione;
    }

    /**
     * Restituisce una rappresentazione in formato stringa del giocatore.
     * @return Una stringa che rappresenta il giocatore.
     */
    @Override
    public String toString() {
        return "Giocatore{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", punteggio=" + punteggio +
                ", dataRegistrazione=" + dataRegistrazione +
                '}';
    }
}