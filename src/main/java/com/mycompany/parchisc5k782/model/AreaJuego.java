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

    public AreaJuego(String colorJugador1, String nombreJugador1,  String nombreJugador2) {
        tablero = new Tablero();
        crearJugadores(colorJugador1,nombreJugador1,nombreJugador2);
        tablero.crearCasas(colorJugador1);
    }
    
    public int getIndexFicha(int x, int y){
    
        return tablero.getIndexFicha(x, y);
    
    }
    
    public boolean isContains(int x, int y){
    
        return tablero.isContains(x, y);
    
    }
    
    public void sacarFicha(int indexFichaCasa){
        Ficha fichaASacar = tablero.getCasaJugador1().getFicha(indexFichaCasa);
        tablero.sacarFicha(fichaASacar, jugador1.getColor());
        tablero.getCasaJugador1().setFicha(indexFichaCasa, null);
    }
    
    public int getIndexFichaEnTablero(int x, int y){
        return tablero.getIndexFichaEnTablero(x,y);
    }
    
    public void moverFicha(int indiceActual, int pasos){
        tablero.moverFicha(indiceActual, pasos);
    }
    
    public void crearJugadores(String colorJugador1, String nombreJugador1,  String nombreJugador2){
    
        switch(colorJugador1){

        case "Amarillo":
        jugador1=new Jugador(nombreJugador1,colorJugador1);
        jugador2=new Jugador(nombreJugador2, "Rojo");
            break;

        case "Azul":
        jugador1=new Jugador(nombreJugador1,colorJugador1);
        jugador2=new Jugador(nombreJugador2, "Verde");
            break;

        case "Rojo":
        jugador1=new Jugador(nombreJugador1,colorJugador1);
        jugador2=new Jugador(nombreJugador2, "Amarillo");
            break;

        case "Verde":
        jugador1=new Jugador(nombreJugador1,colorJugador1);
        jugador2=new Jugador(nombreJugador2, "Azul");
            break;

        }   
    }
    
    public void dibujar(Component component, Graphics g){
        tablero.dibujar(component, g);
    }
    
}
