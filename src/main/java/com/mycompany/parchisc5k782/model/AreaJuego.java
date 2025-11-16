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
    private BancoPregunta bancoPregunta;
    private String colorJugador1;
    private String nombreJugador1;
    private String colorJugador2;
    private String nombreJugador2;
    
    
    public AreaJuego(String colorJugador1, String nombreJugador1,  String nombreJugador2) {
        tablero = new Tablero();
        crearJugadores(colorJugador1,nombreJugador1,nombreJugador2);
        tablero.crearCasas(colorJugador1);
        bancoPregunta = new BancoPregunta();
    }
    
    public int getIndexFicha(int x, int y){
    
        return tablero.getIndexFicha(x, y);
    
    }
    
    public boolean isContains(int x, int y){
    
        return tablero.isContains(x, y);
    
    }
    
     public int getIndexFichaCasa(int x, int y, String color){
    
        Casa casaActiva = (jugador1.getColor().equals(color))
                ? tablero.getCasaJugador1()
                : tablero.getCasaJugador2();
        
        return casaActiva.getIndexFicha(x, y);
    
    }
    
    
    public void sacarFicha(int indexFichaCasa, String color){
        if(jugador1.getColor().equals(color)){
        Ficha fichaASacar = tablero.getCasaJugador1().getFicha(indexFichaCasa);
        tablero.sacarFicha(fichaASacar, jugador1.getColor());
        tablero.getCasaJugador1().setFicha(indexFichaCasa, null);
        } else if (jugador2.getColor().equals(color)){
        if(jugador2.getColor().equals(color)){
        Ficha fichaASacar = tablero.getCasaJugador2().getFicha(indexFichaCasa);
        tablero.sacarFicha(fichaASacar, jugador2.getColor());
        tablero.getCasaJugador2().setFicha(indexFichaCasa, null);
        }
      }
    }
    
    
    public int getIndexFichaEnTablero(int x, int y, String color){
    return tablero.getIndexFichaEnTablero(x,y,color);
    }
    
    public int moverFicha(int indiceActual, int pasos, String color){
        return tablero.moverFicha(indiceActual, pasos,color);
    }
    
    public boolean isCeldaNormal(int indice){
        return tablero.isCeldaNormal(indice);
    }
    
    public Pregunta getPreguntaAleatroia(){
        return bancoPregunta.getPreguntaAleatoria();
    }
    
    public int getPuntosJugador1(){
        return jugador1.getPuntos();
    }

   public int getPuntosJugador2(){
        return jugador2.getPuntos();
    }

    public String getColorJugador2() {
        return colorJugador2;
    }

    public String getColorJugador1() {
        return colorJugador1;
    }

    public String getNombreJugador2() {
        return nombreJugador2;
    }

    public String getNombreJugador1() {
        return nombreJugador1;
    }
    
    
    
    
    
    
    public void aplicarResultadoPregunta(boolean acierto, int jugadorId){
    
        Jugador jugadorActivo = (jugadorId == 1) ? jugador1 : jugador2;
        
        if(acierto){
            jugador1.sumarPuntos();
            System.out.println(jugadorActivo.getNombre() + " suma 1 punto. Total: " + jugador1.getPuntos());
        } else  {
            jugador1.restarPunto();
            System.out.println(jugadorActivo.getNombre() + " resta 1 punto. Total: " + jugador1.getPuntos());
        }
    
    }
    
    public void crearJugadores(String colorJugador1, String nombreJugador1,  String nombreJugador2){
    
        String colorJ2 = "";
        
        switch(colorJugador1){

        case "Amarillo":
            colorJ2 = "Rojo";
            break;

        case "Azul":
            colorJ2 = "Verde";
            break;

        case "Rojo":
            colorJ2 = "Amarillo";
            break;

        case "Verde":
            colorJ2 = "Azul";
            break;

        }  
        
        jugador1=new Jugador(nombreJugador1,colorJugador1);
        jugador2=new Jugador(nombreJugador2, colorJ2);
        
        this.colorJugador1 = jugador1.getColor();
        this.nombreJugador1 = jugador1.getNombre();
        this.colorJugador2 = jugador2.getColor();
        this.nombreJugador2 = jugador2.getNombre();
        
        
    }
    
    public Casa getCasaJugador1(){
        return tablero.getCasaJugador1();
    }
    
    public Casa getCasaJugador2(){
        return tablero.getCasaJugador2();
    }
    
    public void dibujar(Component component, Graphics g){
        tablero.dibujar(component, g);
    }
    
}
