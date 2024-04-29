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
    private int punteggio;
    private LocalDate dataRegistrazione;
    private static long prossimoId = 1;

    public Giocatore(long id, String nome, int punteggio, LocalDate dataRegistrazione) 
    {
        this.id = id;
        this.nome = nome;
        this.punteggio = punteggio;
        this.dataRegistrazione = dataRegistrazione;
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

    public int getPunteggio() 
    {
        return punteggio;
    }

    public void setPunteggio(int punti) 
    {
        this.punteggio += punti;
    }

    public LocalDate getDataRegistrazione() 
    {
        return dataRegistrazione;
    }


    public static long getProssimoId() {
        return prossimoId ++;
    }

    public static void setProssimoId(long prossimoId) {
        Giocatore.prossimoId = prossimoId;
    }

    @Override
    public String toString() 
    {
        return "Giocatore{" + "id=" + id + ", nome=" + nome + ", punteggio=" + punteggio + ", dataRegistrazione=" + dataRegistrazione + '}';
    }

    

    
    
}
