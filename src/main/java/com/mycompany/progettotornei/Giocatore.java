/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progettotornei;

import java.time.LocalDate;

/**
 *
 * @author ettore
 */
public class Giocatore 
{
    private long id;
    private String nome;
    private String cognome;
    private int punteggio;
    private LocalDate dataRegistrazione;

    public Giocatore(long id, String nome, String cognome, int punteggio, LocalDate dataRegistrazione) 
    {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.punteggio = punteggio;
        this.dataRegistrazione = dataRegistrazione;
    }
    
    public Giocatore(String nome, String cognome)
    {
        this.nome = nome;
        this.cognome = cognome;
    }
            
    
    public long getId() 
    {
        return id;
    }


    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }
    
    
    public String getCognome()
    {
        return cognome;
    }
    
    public void setCognome(String cognome)
    {
        this.cognome = cognome;
    }

    public int getPunteggio() 
    {
        return punteggio;
    }

    public void incrementaPunteggio(int punti) 
    {
        this.punteggio += punti;
    }

    public LocalDate getDataRegistrazione() 
    {
        return dataRegistrazione;
    }

    @Override
    public String toString() {
        return "Giocatore{" + "id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", punteggio=" + punteggio + ", dataRegistrazione=" + dataRegistrazione + '}';
    }
}
