/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parchisc5k782.model;

/**
 *
 * @author lab01
 */
public class Celda {
    
    private Posicion posicion;
    private Ficha ficha;

    public Celda(Posicion posicion) {
        this.posicion = posicion;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public Ficha getFicha() {
        return ficha;
    }

    
    
    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }
    
    
    
    
    
    
    
}
