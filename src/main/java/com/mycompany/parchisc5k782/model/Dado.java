/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parchisc5k782.model;

import java.util.Random;

/**
 *
 * @author sebas
 */
public class Dado {
    
    private Random random;
    private int numero;
    
    public Dado(){
        this.random = new Random();
    
    }
    
    public int getNumero(){
        return numero;
    
    }
    
    public Dado(Random random, int numero){
        this.random = random;
        this.numero = numero;
    }
    
    public int lanzar(){
        numero = random.nextInt(6) + 1;
        return numero;
    }
    
}
