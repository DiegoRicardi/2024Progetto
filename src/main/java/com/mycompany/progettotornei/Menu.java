/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progettotornei;

import java.util.Scanner;

/**
 * Questa classe rappresenta un menu con un elenco di voci.
 * Ogni voce del menu è rappresentata da una stringa.
 * La classe fornisce metodi per visualizzare il menu e selezionare una voce.
 *
 * @author studente
 */
public class Menu 
{
    private String[] elencoVoci; // Ogni stringa è una voce del menu
    private int numeroVoci; // Numero di voci nel menu
    

    /**
     * Costruttore della classe Menu.
     * Crea un nuovo menu con le voci specificate nell'array di stringhe.
     *
     * @param elenco L'elenco delle voci del menu.
     */
    public Menu(String[] elenco)
    {
        numeroVoci = elenco.length; // Imposto il numero di voci del menu
        elencoVoci = new String[numeroVoci];
        
        // Copio ciascuna voce del parametro elenco nell'attributo elencoVoci
        for (int i = 0; i < numeroVoci; i++)
        {
            elencoVoci[i] = elenco[i];
        }
        
    }
    
    /**
     * Visualizza il menu stampando a video tutte le voci.
     */
    public void visualizzaMenu()
    {
        for (int i = 0; i < numeroVoci; i++)
        {
            System.out.println(elencoVoci[i]);
        }
    }
    
    /**
     * Consente all'utente di selezionare una voce del menu.
     * Restituisce l'indice della voce selezionata.
     *
     * @return L'indice della voce selezionata.
     */
    public int sceltaMenu()
    {
        Scanner tastiera = new Scanner(System.in);
        String input;
        boolean inputOK = false;
        int scelta = 0;
        String input2 = "0";

        do
        {
            inputOK = true;
            visualizzaMenu();
            System.out.println("Scegli: ");
            input = tastiera.nextLine();
            if (input.charAt(0) < '0' || input.charAt(0) > '9')
            {
                System.out.println("Input non corretto.");
                inputOK = false;
            }
            else
            {
                input2 = input2 + input.charAt(0);
                scelta = Integer.parseInt(input2);
                if (scelta < 0 || scelta >= numeroVoci)
                {
                     System.out.println("La voce scelta non è prevista.");
                    inputOK = false;
                }
            }
        } while (!inputOK);
        
        return scelta;
    }
}
