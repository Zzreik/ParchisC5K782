/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parchisc5k782.model;

import com.mycompany.parchisc5k782.model.Celda;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author lab01
 */
public class Tablero {

    private Celda[] tablero;
    private Celda[] pasilloAmarillo;
    private Celda[] pasilloAzul;
    private Celda[] pasilloRojo;
    private Celda[] pasilloVerde;
    private Casa casaJugador1;
    private Casa casaJugador2;

    public Tablero() {
        tablero = new Celda[68];
        pasilloAmarillo = new Celda[8];
        pasilloAzul = new Celda[8];
        pasilloRojo = new Celda[8];
        pasilloVerde = new Celda[8];
        iniciar();
        iniciarPasillos();
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
        for (int indice = 42; indice < 45; indice++) {
            tablero[indice] = new Celda(new Posicion(x, y));
            //tablero[indice].setFicha(new Ficha(new Posicion(x, y), new ImageIcon("./src/main/resources/img/pieceblack.png"), "negra"));
            x -= 30;
        }
        tablero[44] = new CeldaEspecial(new Posicion(x, y), "zona segura");
        //tablero[44].setFicha(new Ficha(new Posicion(x, y), new ImageIcon("./src/main/resources/img/pieceblue.png"), "negra"));
        x -= 30;

        for (int indice = 46; indice < 50; indice++) {
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

    public void iniciarPasillos() {
        int x = 422;
        int y = 589;

        for (int indice = 0; indice < 8; indice++) {
            y -= 30;
            pasilloAmarillo[indice] = new Celda(new Posicion(x, y));
        }

        x = 592;
        y = 422;

        for (int indice = 0; indice < 8; indice++) {
            x -= 30;
            pasilloAzul[indice] = new Celda(new Posicion(x, y));
        }

        x = 422;
        y = 3;

        for (int indice = 0; indice < 8; indice++) {
            y += 30;
            pasilloRojo[indice] = new Celda(new Posicion(x, y));
        }

        x = 1;
        y = 422;

        for (int indice = 0; indice < 8; indice++) {
            x += 30;
            pasilloVerde[indice] = new Celda(new Posicion(x, y));
        }
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

        dibujarArray(pasilloAmarillo, component, g);
        dibujarArray(pasilloAzul, component, g);
        dibujarArray(pasilloRojo, component, g);
        dibujarArray(pasilloVerde, component, g);
    }

    private void dibujarArray(Celda[] array, Component component, Graphics g) {
        for (Celda c : array) {
            if (c != null && c.getFicha() != null) {
                c.getFicha().dibujar(component, g);
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

    public int getIndexFichaJugador(int x, int y, String colorJugador) {
        for (int i = 0; i < tablero.length; i++) {
            if (tablero[i] != null && tablero[i].getFicha() != null) {
                if (tablero[i].getFicha().getColor().equals(colorJugador)) {
                    if (tablero[i].getFicha().isContains(x, y)) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    public int getIndexFichaEnTablero(int x, int y, String color) {

        for (int i = 0; i < tablero.length; i++) {
            if (tablero[i] != null && tablero[i].getFicha() != null) {
                if (tablero[i].getFicha().getColor().equals(color)) {
                    if (tablero[i].getFicha().isContains(x, y)) {
                        return i;
                    }
                }
            }
        }

        // 2. Buscar en el pasillo correspondiente al color (1000 - 1007)
        Celda[] pasillo = getPasilloPorColor(color); // Usa el auxiliar que creamos antes
        if (pasillo != null) {
            for (int i = 0; i < pasillo.length; i++) {
                if (pasillo[i] != null && pasillo[i].getFicha() != null) {
                    // No necesitamos verificar color porque el pasillo YA es de ese color
                    if (pasillo[i].getFicha().isContains(x, y)) {
                        // Retornamos el índice "mágico"
                        return 1000 + i;
                    }
                }
            }
        }

        return -1;

    }

    public boolean tieneFichasEnTablero(String color) {

        for (int i = 0; i < tablero.length; i++) {
            if (tablero[i] != null && tablero[i].getFicha() != null) {
                if (tablero[i].getFicha().getColor().equals(color)) {
                    return true;
                }
            }
        }

        return false;

    }

    public Celda[] getCeldas() {
        return tablero;
    }

    public Celda getCeldas(int indice) {
        if (indice >= 0 && indice < tablero.length) {
            return tablero[indice];
        }
        return null;
    }

    public int moverFicha(int indiceActual, int pasos, String color) {

        Ficha ficha = null;
        Celda[] pasilloActual = getPasilloPorColor(color); // Método auxiliar abajo

        // CASO 1: La ficha YA está en el pasillo
        // Necesitas saber en qué índice del pasillo está. 
        // Como tu método recibe "indiceActual", asumiremos que si es > 100 o usas el flag de la ficha
        // Para simplificar, primero recuperamos la ficha:
        if (isFichaInPasillo(indiceActual, color)) {
            // Lógica para mover DENTRO del pasillo (indice 0 a 7)
            return moverInPasillo(indiceActual, pasos, color, pasilloActual);
        }

        // CASO 2: La ficha está en el TABLERO NORMAL
        ficha = tablero[indiceActual].getFicha();
        int entradaPasillo = getEntradaPasillo(color);

        // Calcular el nuevo índice potencial
        int nuevoIndice = (indiceActual + pasos) % 68;

        // VERIFICAR SI CRUZA LA ENTRADA
        // El caso difícil es Amarillo porque pasa de 67 a 0.
        boolean cruzaEntrada = false;
        int pasosRestantes = 0;

        if (color.equals("Amarillo")) {
            // Si estaba antes del 0 (ej 66) y el nuevo índice pasó el 0 (ej 2)
            if (indiceActual > 50 && nuevoIndice >= 0 && nuevoIndice < 10) {
                pasosRestantes = (68 - indiceActual) + (pasos - (68 - indiceActual)) - 1;
                // Simplificado: pasosRestantes = pasos - (distancia a la entrada)
                int distancia = (68 - indiceActual);
                if (pasos >= distancia) {
                    pasosRestantes = pasos - distancia;
                    cruzaEntrada = true;
                }
            }
        } else {
            // Para los demás colores, es lineal
            if (indiceActual <= entradaPasillo && nuevoIndice > entradaPasillo) {
                cruzaEntrada = true;
                pasosRestantes = nuevoIndice - entradaPasillo - 1;
            }
        }

        if (cruzaEntrada) {
            // --- ENTRAR AL PASILLO ---
            System.out.println("¡Entrando al pasillo " + color + "!");

            if (pasosRestantes < 8 && pasilloActual[pasosRestantes].getFicha() == null) {
                // Mover de Tablero -> Pasillo
                tablero[indiceActual].setFicha(null); // Quitar del tablero
                ficha.setInPasillo(true);             // Marcar flag
                pasilloActual[pasosRestantes].setFicha(ficha); // Poner en pasillo
                ficha.setPosicion(pasilloActual[pasosRestantes].getPosicion());
                return 1000 + pasosRestantes; // Retornamos un código especial (ej. 1000+) para saber que está en pasillo
            } else {
                // Rebote o casilla ocupada: no se mueve o rebota (puedes implementar rebote luego)
                return indiceActual;
            }
        }

        // CASO 3: Movimiento normal en tablero (tu código original mejorado)
        if (tablero[nuevoIndice].getFicha() != null) {
            Ficha fichaExistente = tablero[nuevoIndice].getFicha();
            if (!fichaExistente.getColor().equals(color)) {
                if (isCeldaNormal(nuevoIndice)) {
                    // Comer ficha
                    tablero[indiceActual].setFicha(null);
                    tablero[nuevoIndice].setFicha(ficha);
                    ficha.setPosicion(tablero[nuevoIndice].getPosicion());
                    return 700 + nuevoIndice; // Código de captura
                }
            }
            return indiceActual; // Está bloqueado
        }

        // Movimiento libre normal
        tablero[indiceActual].setFicha(null);
        tablero[nuevoIndice].setFicha(ficha);
        ficha.setPosicion(tablero[nuevoIndice].getPosicion());
        return nuevoIndice;

    }

    public boolean isFichaInPasillo(int indiceActual, String color) {
        // Si el índice es 1000 o más, significa que ya estamos dentro de un pasillo
        return indiceActual >= 1000;
    }

    public int moverInPasillo(int indiceActual, int pasos, String color, Celda[] pasilloActual) {
        // 1. Decodificar el índice real (quitamos el 1000)
        // Ejemplo: Si entra 1002, es la posición 2 del array del pasillo
        int posReal = indiceActual - 1000;

        // 2. Calcular nueva posición
        int nuevaPos = posReal + pasos;

        // 3. Validar que no se salga del pasillo (Longitud 8)
        if (nuevaPos >= pasilloActual.length) {
            System.out.println("Movimiento inválido: Se pasa de la meta.");
            return indiceActual; // No se mueve, rebota o se queda quieto
        }

        // 4. Validar colisión (si ya hay una ficha tuya ahí)
        if (pasilloActual[nuevaPos].getFicha() != null) {
            System.out.println("Movimiento inválido: Casilla ocupada.");
            return indiceActual;
        }

        // 5. Mover la ficha físicamente
        Ficha ficha = pasilloActual[posReal].getFicha(); // Tomamos la ficha
        pasilloActual[posReal].setFicha(null);           // Borramos de la anterior
        pasilloActual[nuevaPos].setFicha(ficha);         // Ponemos en la nueva

        // Actualizamos la posición visual (X, Y) para que se dibuje bien
        ficha.setPosicion(pasilloActual[nuevaPos].getPosicion());

        // 6. Retornar el nuevo índice codificado
        return 1000 + nuevaPos;
    }

    private Celda[] getPasilloPorColor(String color) {
        switch (color) {
            case "Amarillo":
                return pasilloAmarillo;
            case "Azul":
                return pasilloAzul;
            case "Rojo":
                return pasilloRojo;
            case "Verde":
                return pasilloVerde;
            default:
                return null;
        }
    }

    private int getEntradaPasillo(String color) {
        switch (color) {
            case "Amarillo":
                return 0;  // Ajustar si es necesario
            case "Azul":
                return 17;
            case "Rojo":
                return 34;
            case "Verde":
                return 51;
            default:
                return -1;
        }
    }

    public boolean isCeldaNormal(int indice) {
        if (indice < 0 || indice >= tablero.length || tablero[indice] == null) {
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
