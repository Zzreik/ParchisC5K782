/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parchisc5k782.model;

import java.awt.Component;
import java.awt.Graphics;

/**
 *
 * @author lab01
 */
public class Casa {

    private Ficha[] fichas;
    private String color;

    public Casa(String color) {
        fichas = new Ficha[4];
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFicha(int posicion, Ficha ficha) {

        fichas[posicion] = ficha;

    }

    public Ficha getFicha(int posicion) {

        return fichas[posicion];

    }

    public void dibujar(Component component, Graphics g){
       if (fichas != null){
           for (int indice = 0;indice<fichas.length;indice ++){
               if(fichas[indice] != null){
                   fichas[indice].dibujar(component, g);
               }
           }
       }
   }
    
    public int getCantidadFichas(){
    
        return fichas.length;
    
    }
}
