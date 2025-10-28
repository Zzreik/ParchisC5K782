/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parchisc5k782.model;

import java.awt.Component;
import java.awt.Graphics;

/**
 *
 * @author sebas
 */
public class AreaJuego {
    
    private Tablero tablero;
    private Jugador jugador1;
    private Jugador jugador2;

    public AreaJuego() {
        tablero = new Tablero();
        tablero.crearCasas("Azul");
    }
    
    public void dibujar(Component component, Graphics g){
        tablero.dibujar(component, g);
    }
    
}
