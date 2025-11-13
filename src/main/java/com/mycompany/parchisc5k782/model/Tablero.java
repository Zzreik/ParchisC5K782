/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parchisc5k782.model;

import java.awt.Component;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author lab01
 */
public class Tablero {

    private Celda[] tablero;
    private Casa casaJugador1;
    private Casa casaJugador2;

    public Tablero() {
        tablero = new Celda[68];
        iniciar();
    }

    public void iniciar() {
        int x = 351;
        int y = 589;

        for (int indice = 0; indice < 4; indice++) {
            tablero[indice] = new Celda(new Posicion(x, y));
            //tablero[indice].setFicha(new Ficha(new Posicion(x, y), new ImageIcon("./src/main/resources/img/pieceblack.png"), "negra"));
            y -= 30;
        }
        tablero[4] = new CeldaEspecialColor(new Posicion(x, y), "salida Amarillo", "Amarillo");
        //tablero[4].setFicha(new Ficha(new Posicion(x, y), new ImageIcon("./src/main/resources/img/pieceblue.png"), "negra"));
        y -= 30;
        for (int indice = 5; indice < 8; indice++) {
            tablero[indice] = new Celda(new Posicion(x, y));
            //tablero[indice].setFicha(new Ficha(new Posicion(x, y), new ImageIcon("./src/main/resources/img/pieceblack.png"), "negra"));
            y -= 30;
        }
        x = 383;
        y = 349;
        for (int indice = 8; indice < 11; indice++) {
            tablero[indice] = new Celda(new Posicion(x, y));
            //tablero[indice].setFicha(new Ficha(new Posicion(x, y), new ImageIcon("./src/main/resources/img/pieceblack.png"), "negra"));
            x += 30;
        }
        tablero[11] = new CeldaEspecial(new Posicion(x, y), "zona segura");
        //tablero[11].setFicha(new Ficha(new Posicion(x, y), new ImageIcon("./src/main/resources/img/pieceblue.png"), "negra"));
        x += 30;
        for (int indice = 12; indice < 16; indice++) {
            tablero[indice] = new Celda(new Posicion(x, y));
            //tablero[indice].setFicha(new Ficha(new Posicion(x, y), new ImageIcon("./src/main/resources/img/pieceblack.png"), "negra"));
            x += 30;
        }
        x = 592;
        y = 289;
        tablero[16] = new CeldaEspecial(new Posicion(x, y), "zona segura");
        //tablero[16].setFicha(new Ficha(new Posicion(x, y), new ImageIcon("./src/main/resources/img/pieceblue.png"), "negra"));

        x = 590;
        y = 245;
        for (int indice = 17; indice < 21; indice++) {
            tablero[indice] = new Celda(new Posicion(x, y));
            //tablero[indice].setFicha(new Ficha(new Posicion(x, y), new ImageIcon("./src/main/resources/img/pieceblack.png"), "negra"));
            x -= 30;
        }
        tablero[21] = new CeldaEspecialColor(new Posicion(x, y), "salida Azul", "Azul");
        //tablero[21].setFicha(new Ficha(new Posicion(x, y), new ImageIcon("./src/main/resources/img/pieceblue.png"), "negra"));
        x -= 30;
        for (int indice = 22; indice < 25; indice++) {
            tablero[indice] = new Celda(new Posicion(x, y));
            //tablero[indice].setFicha(new Ficha(new Posicion(x, y), new ImageIcon("./src/main/resources/img/pieceblack.png"), "negra"));
            x -= 30;
        }
        x = 351;
        y = 213;
        for (int indice = 25; indice < 28; indice++) {
            tablero[indice] = new Celda(new Posicion(x, y));
            //tablero[indice].setFicha(new Ficha(new Posicion(x, y), new ImageIcon("./src/main/resources/img/pieceblack.png"), "negra"));
            y -= 30;
        }
        tablero[28] = new CeldaEspecial(new Posicion(x, y), "zona segura");
        //tablero[28].setFicha(new Ficha(new Posicion(x, y), new ImageIcon("./src/main/resources/img/pieceblue.png"), "negra"));
        y -= 30;
        for (int indice = 29; indice < 33; indice++) {
            tablero[indice] = new Celda(new Posicion(x, y));
            //tablero[indice].setFicha(new Ficha(new Posicion(x, y), new ImageIcon("./src/main/resources/img/pieceblack.png"), "negra"));
            y -= 30;
        }

        x = 295;
        y = 3;
        tablero[33] = new CeldaEspecial(new Posicion(x, y), "zona segura");
        //tablero[33].setFicha(new Ficha(new Posicion(x, y), new ImageIcon("./src/main/resources/img/pieceblue.png"), "negra"));

        x = 253;
        y = 3;
        for (int indice = 34; indice < 38; indice++) {
            tablero[indice] = new Celda(new Posicion(x, y));
            //tablero[indice].setFicha(new Ficha(new Posicion(x, y), new ImageIcon("./src/main/resources/img/pieceblack.png"), "negra"));
            y += 30;
        }
        tablero[38] = new CeldaEspecialColor(new Posicion(x, y), "salida Rojo", "Rojo");
        //tablero[38].setFicha(new Ficha(new Posicion(x, y), new ImageIcon("./src/main/resources/img/pieceblue.png"), "negra"));
        y += 30;
        for (int indice = 39; indice < 42; indice++) {
            tablero[indice] = new Celda(new Posicion(x, y));
            //tablero[indice].setFicha(new Ficha(new Posicion(x, y), new ImageIcon("./src/main/resources/img/pieceblack.png"), "negra"));
            y += 30;
        }

        x = 209;
        y = 245;
        for (int indice = 42; indice < 44; indice++) {
            tablero[indice] = new Celda(new Posicion(x, y));
            //tablero[indice].setFicha(new Ficha(new Posicion(x, y), new ImageIcon("./src/main/resources/img/pieceblack.png"), "negra"));
            x -= 30;
        }
        tablero[44] = new CeldaEspecial(new Posicion(x, y), "zona segura");
        //tablero[44].setFicha(new Ficha(new Posicion(x, y), new ImageIcon("./src/main/resources/img/pieceblue.png"), "negra"));
        x -= 30;

        for (int indice = 45; indice < 50; indice++) {
            tablero[indice] = new Celda(new Posicion(x, y));
            //tablero[indice].setFicha(new Ficha(new Posicion(x, y), new ImageIcon("./src/main/resources/img/pieceblack.png"), "negra"));
            x -= 30;
        }

        x = 1;
        y = 289;
        tablero[50] = new CeldaEspecial(new Posicion(x, y), "zona segura");
        //tablero[50].setFicha(new Ficha(new Posicion(x, y), new ImageIcon("./src/main/resources/img/pieceblue.png"), "negra"));

        x = 1;
        y = 347;
        for (int indice = 51; indice < 55; indice++) {
            tablero[indice] = new Celda(new Posicion(x, y));
            //tablero[indice].setFicha(new Ficha(new Posicion(x, y), new ImageIcon("./src/main/resources/img/pieceblack.png"), "negra"));
            x += 30;
        }
        tablero[55] = new CeldaEspecialColor(new Posicion(x, y), "salida Verde", "Verde");
        //tablero[55].setFicha(new Ficha(new Posicion(x, y), new ImageIcon("./src/main/resources/img/pieceblue.png"), "negra"));
        x += 30;
        for (int indice = 56; indice < 59; indice++) {
            tablero[indice] = new Celda(new Posicion(x, y));
            //tablero[indice].setFicha(new Ficha(new Posicion(x, y), new ImageIcon("./src/main/resources/img/pieceblack.png"), "negra"));
            x += 30;
        }

        x = 245;
        y = 380;
        for (int indice = 59; indice < 62; indice++) {
            tablero[indice] = new Celda(new Posicion(x, y));
            //tablero[indice].setFicha(new Ficha(new Posicion(x, y), new ImageIcon("./src/main/resources/img/pieceblack.png"), "negra"));
            y += 30;
        }
        tablero[62] = new CeldaEspecial(new Posicion(x, y), "zona segura");
        //tablero[62].setFicha(new Ficha(new Posicion(x, y), new ImageIcon("./src/main/resources/img/pieceblue.png"), "negra"));
        y += 30;
        for (int indice = 63; indice < 67; indice++) {
            tablero[indice] = new Celda(new Posicion(x, y));
            //tablero[indice].setFicha(new Ficha(new Posicion(x, y), new ImageIcon("./src/main/resources/img/pieceblack.png"), "negra"));
            y += 30;
        }

        x = 297;
        y = 592;
        tablero[67] = new CeldaEspecial(new Posicion(x, y), "zona segura");
        //tablero[67].setFicha(new Ficha(new Posicion(x, y), new ImageIcon("./src/main/resources/img/pieceblue.png"), "negra"));  

    }

    public void crearCasas(String colorJugador1) {
        if (colorJugador1.equals("Amarillo")) {
            casaJugador1 = new Casa("Amarillo");
            casaJugador1.setFicha(0, new Ficha(new Posicion(455, 462), new ImageIcon("./src/main/resources/img/pieceyellow.png"), "Amarillo"));
            casaJugador1.setFicha(1, new Ficha(new Posicion(540, 462), new ImageIcon("./src/main/resources/img/pieceyellow.png"), "Amarillo"));
            casaJugador1.setFicha(2, new Ficha(new Posicion(455, 526), new ImageIcon("./src/main/resources/img/pieceyellow.png"), "Amarillo"));
            casaJugador1.setFicha(3, new Ficha(new Posicion(540, 526), new ImageIcon("./src/main/resources/img/pieceyellow.png"), "Amarillo"));
            casaJugador2 = new Casa("Rojo");
            casaJugador2.setFicha(0, new Ficha(new Posicion(40, 54), new ImageIcon("./src/main/resources/img/piecered.png"), "Rojo"));
            casaJugador2.setFicha(1, new Ficha(new Posicion(131, 54), new ImageIcon("./src/main/resources/img/piecered.png"), "Rojo"));
            casaJugador2.setFicha(2, new Ficha(new Posicion(40, 124), new ImageIcon("./src/main/resources/img/piecered.png"), "Rojo"));
            casaJugador2.setFicha(3, new Ficha(new Posicion(131, 124), new ImageIcon("./src/main/resources/img/piecered.png"), "Rojo"));
        }
        if (colorJugador1.equals("Azul")) {
            casaJugador1 = new Casa("Azul");
            casaJugador1.setFicha(0, new Ficha(new Posicion(455, 54), new ImageIcon("./src/main/resources/img/pieceblue.png"), "Azul"));
            casaJugador1.setFicha(1, new Ficha(new Posicion(540, 54), new ImageIcon("./src/main/resources/img/pieceblue.png"), "Azul"));
            casaJugador1.setFicha(2, new Ficha(new Posicion(455, 124), new ImageIcon("./src/main/resources/img/pieceblue.png"), "Azul"));
            casaJugador1.setFicha(3, new Ficha(new Posicion(540, 124), new ImageIcon("./src/main/resources/img/pieceblue.png"), "Azul"));
            casaJugador2 = new Casa("Verde");
            casaJugador2.setFicha(0, new Ficha(new Posicion(40, 462), new ImageIcon("./src/main/resources/img/piecegreen.png"), "Verde"));
            casaJugador2.setFicha(1, new Ficha(new Posicion(131, 462), new ImageIcon("./src/main/resources/img/piecegreen.png"), "Verde"));
            casaJugador2.setFicha(2, new Ficha(new Posicion(40, 526), new ImageIcon("./src/main/resources/img/piecegreen.png"), "Verde"));
            casaJugador2.setFicha(3, new Ficha(new Posicion(131, 526), new ImageIcon("./src/main/resources/img/piecegreen.png"), "Verde"));

        }

        if (colorJugador1.equals("Rojo")) {
            casaJugador2 = new Casa("Amarillo");
            casaJugador2.setFicha(0, new Ficha(new Posicion(455, 462), new ImageIcon("./src/main/resources/img/pieceyellow.png"), "Amarillo"));
            casaJugador2.setFicha(1, new Ficha(new Posicion(540, 462), new ImageIcon("./src/main/resources/img/pieceyellow.png"), "Amarillo"));
            casaJugador2.setFicha(2, new Ficha(new Posicion(455, 526), new ImageIcon("./src/main/resources/img/pieceyellow.png"), "Amarillo"));
            casaJugador2.setFicha(3, new Ficha(new Posicion(540, 526), new ImageIcon("./src/main/resources/img/pieceyellow.png"), "Amarillo"));
            casaJugador1 = new Casa("Rojo");
            casaJugador1.setFicha(0, new Ficha(new Posicion(40, 54), new ImageIcon("./src/main/resources/img/piecered.png"), "Rojo"));
            casaJugador1.setFicha(1, new Ficha(new Posicion(131, 54), new ImageIcon("./src/main/resources/img/piecered.png"), "Rojo"));
            casaJugador1.setFicha(2, new Ficha(new Posicion(40, 124), new ImageIcon("./src/main/resources/img/piecered.png"), "Rojo"));
            casaJugador1.setFicha(3, new Ficha(new Posicion(131, 124), new ImageIcon("./src/main/resources/img/piecered.png"), "Rojo"));
        }

        if (colorJugador1.equals("Verde")) {
            casaJugador2 = new Casa("Azul");
            casaJugador2.setFicha(0, new Ficha(new Posicion(455, 54), new ImageIcon("./src/main/resources/img/pieceblue.png"), "Azul"));
            casaJugador2.setFicha(1, new Ficha(new Posicion(540, 54), new ImageIcon("./src/main/resources/img/pieceblue.png"), "Azul"));
            casaJugador2.setFicha(2, new Ficha(new Posicion(455, 124), new ImageIcon("./src/main/resources/img/pieceblue.png"), "Azul"));
            casaJugador2.setFicha(3, new Ficha(new Posicion(540, 124), new ImageIcon("./src/main/resources/img/pieceblue.png"), "Azul"));
            casaJugador1 = new Casa("Verde");
            casaJugador1.setFicha(0, new Ficha(new Posicion(40, 462), new ImageIcon("./src/main/resources/img/piecegreen.png"), "Verde"));
            casaJugador1.setFicha(1, new Ficha(new Posicion(131, 462), new ImageIcon("./src/main/resources/img/piecegreen.png"), "Verde"));
            casaJugador1.setFicha(2, new Ficha(new Posicion(40, 526), new ImageIcon("./src/main/resources/img/piecegreen.png"), "Verde"));
            casaJugador1.setFicha(3, new Ficha(new Posicion(131, 526), new ImageIcon("./src/main/resources/img/piecegreen.png"), "Verde"));

        }

    }

    public void dibujar(Component component, Graphics g) {
        casaJugador1.dibujar(component, g);
        casaJugador2.dibujar(component, g);

        for (int indice = 0; indice < tablero.length; indice++) {
            if (tablero[indice] != null) {
                if (tablero[indice].getFicha() != null) {
                    tablero[indice].getFicha().dibujar(component, g);
                }
            }
        }
    }

    public boolean isContains(int x, int y) {

        for (int index = 0; index < casaJugador1.getCantidadFichas(); index++) {

            if (casaJugador1.getFicha(index) != null) {
                if (casaJugador1.getFicha(index).isContains(x, y)) {
                    return true;
                }

            }

        }
        return false;
    }

    public int getIndexFicha(int x, int y) {

        for (int index = 0; index < casaJugador1.getCantidadFichas(); index++) {

            if (casaJugador1.getFicha(index) != null) {
                if (casaJugador1.getFicha(index).isContains(x, y)) {
                    return index;
                }

            }

        }
        return -1;
    }

    public int getIndexFichaEnTablero(int x, int y) {

        for (int i = 0; i < tablero.length; i++) {

            if (tablero[i] != null && tablero[i].getFicha() != null) {

                if (tablero[i].getFicha().getColor().equals(casaJugador1.getColor())) {
                    if (tablero[i].getFicha().isContains(x, y)) {

                        return i;
                    }
                }

            }

        }
        return -1;

    }
    
    public int moverFicha(int indiceActual, int pasos){
    
        int nuevoIndice = (indiceActual + pasos) % 68;
        
        Ficha ficha = tablero[indiceActual].getFicha();
        tablero[indiceActual].setFicha(null);
        tablero[nuevoIndice].setFicha(ficha);
        ficha.setPosicion(tablero[nuevoIndice].getPosicion());
        return nuevoIndice;
    
    }
    
    public boolean isCeldaNormal(int indice){
        if (indice < 0 || indice >= tablero.length || tablero[indice] == null){
            return false;
        }
        return !(tablero[indice] instanceof CeldaEspecial);
    }
    
    

    public void sacarFicha(Ficha ficha, String color) {

        int indiceSalida = -1;

        switch (color) {
            case "Amarillo":
                indiceSalida = 4;
                break;
            case "Azul":
                indiceSalida = 21;
                break;
            case "Rojo":
                indiceSalida = 38;
                break;
            case "Verde":
                indiceSalida = 55;
                break;
        }

        if (indiceSalida != -1) {
            tablero[indiceSalida].setFicha(ficha);
            Posicion posSalida = tablero[indiceSalida].getPosicion();
            ficha.setPosicion(posSalida);

        }

    }

    public Casa getCasaJugador1() {
        return casaJugador1;
    }

    public Casa getCasaJugador2() {
        return casaJugador2;
    }

}
