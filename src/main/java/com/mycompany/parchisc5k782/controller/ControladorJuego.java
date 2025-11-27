/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parchisc5k782.controller;

import com.mycompany.parchisc5k782.model.AreaJuego;
import com.mycompany.parchisc5k782.model.Cronometro;
import com.mycompany.parchisc5k782.model.Dado;
import com.mycompany.parchisc5k782.model.Ficha;
import com.mycompany.parchisc5k782.model.Posicion;
import com.mycompany.parchisc5k782.model.Pregunta;
import com.mycompany.parchisc5k782.model.Tablero;
import com.mycompany.parchisc5k782.view.GUIGameOver;
import com.mycompany.parchisc5k782.view.GUIJuego;
import com.mycompany.parchisc5k782.view.GUIPrincipal;
import com.mycompany.parchisc5k782.view.GUIWin;
import com.mycompany.parchisc5k782.view.PanelControl;
import com.mycompany.parchisc5k782.view.PanelJuego;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author sebas
 */
public class ControladorJuego implements ActionListener, MouseListener {

    
    
    
    private GUIJuego guiJuego;
    private Tablero  tablero;
    private PanelJuego panelJuego;
    private PanelControl panelControl;
    private GUIPrincipal guiPrincipal;
    private Ficha ficha;
    private AreaJuego areaJuego;
    private Dado dado;
    private GUIGameOver guiGameOver;
    private GUIWin guiWin;
    private Timer timer;
    private Cronometro cronometro;

    
    
    private int turnoActual;
    private int valorDado;
    private boolean fichaEnJuegoSeleccionada;
    private int resultadoDado = 0;
    private boolean turnoTerminado = true;

    public ControladorJuego(GUIPrincipal guiPrincipal, String colorJugador1, String nombreJugador1,  String nombreJugador2) {
        this.guiPrincipal = guiPrincipal;
        guiJuego = new GUIJuego(this);
        guiGameOver = new GUIGameOver();
        guiWin = new GUIWin();
        guiGameOver.setListener(this);
        guiWin.setListener(this);
        panelJuego = guiJuego.getPanelJuego();
        areaJuego = new AreaJuego(colorJugador1,nombreJugador1,nombreJugador2);
        panelControl = guiJuego.getPanelControl();
        panelControl.setJlNombreJugador1(nombreJugador1);
        panelControl.setJlNombreJugador2(nombreJugador2);
        dado = new Dado();
        timer = new Timer(30, this);
        cronometro = new Cronometro();
        update();
        
        this.turnoActual = 1;
        this.valorDado = 0;
        this.fichaEnJuegoSeleccionada = false;
        
        guiJuego.getPanelControl().resaltarTurno(turnoActual);
        
        guiJuego.setVisible(true);
        
        
        //Aficha = new Ficha(new Posicion(100, 100), new ImageIcon("./src/main/resources/img/pieceblue.png"), "Amarillo");
        //453,468
    }

    public void dibujar(Component c, Graphics g) {

        //ficha.dibujar(c, g);
        areaJuego.dibujar(c, g);

    }

    
    private void hacerPregunta(){
        Pregunta pregunta = areaJuego.getPreguntaAleatroia();
        if (pregunta == null){
        System.out.println("Error: No hay preguntas en el banco.");
        return;
        }
        
        int respuestaCorrecta = pregunta.isRespuesta();
        String enunciado = pregunta.getEnunciado();
        
        int respuestaUsuarioInt = JOptionPane.showConfirmDialog(guiJuego,enunciado,"Pregunta",JOptionPane.YES_NO_OPTION);
        
        boolean acierto = (respuestaUsuarioInt == respuestaCorrecta);
        
        if (acierto) {
            JOptionPane.showMessageDialog(guiJuego, "!Respuesata correcta! +1 punto.");
            areaJuego.aplicarResultadoPregunta(true, turnoActual);

        } else {
            JOptionPane.showMessageDialog(guiJuego, "!Respuesata incorrecta! -1 punto.");
            areaJuego.aplicarResultadoPregunta(false, turnoActual);
        }
        
        if (turnoActual == 1){
            
            panelControl.setJLPuntosJugador1(areaJuego.getPuntosJugador1());
        } else {
            panelControl.setJLPuntosJugador2(areaJuego.getPuntosJugador2());
        }
        verificarFinJuego();
        
        
        
    }
    
    private void cambiarTurno(){
        valorDado = 0;
        fichaEnJuegoSeleccionada = false;
        turnoActual = (turnoActual == 1) ? 2 : 1;
        guiJuego.getPanelControl().resaltarTurno(turnoActual);
        
        String nombreActivo = (turnoActual == 1) ? areaJuego.getNombreJugador1() : areaJuego.getNombreJugador2();
        System.out.println("--- Turno de: " + nombreActivo + "---");
    }
    
    private void finalizarTurno(){
        System.out.println("Turno finalizado");
        turnoTerminado = true;
        resultadoDado = 0;
        panelJuego.repaint();
    
    }
    
    public void mostrarGameOver(int puntajeFinal){
        guiJuego.setVisible(false);
        if(guiGameOver == null) {
        guiGameOver = new GUIGameOver();
        
        }
        guiGameOver.setPuntajeFinal(puntajeFinal);
        guiGameOver.setVisible(true);
        
    }
    
    
    
    
    public void mostrarWin(int puntajeFinal){
        
        guiJuego.setVisible(false);
        if(guiWin == null) {
        guiWin = new GUIWin();
        
        }
        guiWin.setEstadisticas(String.valueOf(puntajeFinal));
        guiWin.setVisible(true);
        
    }
    
    public void verificarFinJuego(){
        int puntosJ1 = areaJuego.getPuntosJugador1();
        int puntosJ2 = areaJuego.getPuntosJugador2();
        
        if (puntosJ1 <= 0){
            mostrarGameOver(puntosJ1);
            return;
        }
        
        if (puntosJ2 <= 0){
            mostrarWin(puntosJ1);
            return;
        
        }
    }
    
 
    public int getIndexFichaEnTablero(int x, int y, String color) {
        return tablero.getIndexFichaEnTablero(x, y, color);
    }
    

    private void hacerPreguntaColision(int indiceCelda){
    
        Pregunta pregunta = areaJuego.getPreguntaAleatroia();
        if (pregunta == null){
            System.out.println("Error: No hay preguntas en el banco de pregutnas. Aplicadno castigo por defecto");
            areaJuego.aplicarResultadoPreguntaColision(false,turnoActual, indiceCelda);
            return;
        }
        
        int respuestaCorrecta = pregunta.isRespuesta();
        String enunciado = pregunta.getEnunciado();
        
        int respuestaUsuarioInt = JOptionPane.showConfirmDialog(
                null, enunciado, "Pregunta de castigo por colision", JOptionPane.YES_NO_OPTION);
        
        boolean acierto = (respuestaUsuarioInt == respuestaCorrecta);
        
        if (acierto){
            JOptionPane.showMessageDialog(guiJuego, "Respuesta Correcta! Tu ficha es liberada. +2 puntos.");
        
        } else {
            JOptionPane.showMessageDialog(guiJuego, "Respuesta Incorrecta! Regreasas a Casa. -3 puntos");
            
        }
        
        areaJuego.aplicarResultadoPreguntaColision(acierto, turnoActual, indiceCelda);
        
        panelControl.setJLPuntosJugador1(areaJuego.getPuntosJugador1());
        panelControl.setJLPuntosJugador2(areaJuego.getPuntosJugador2());
        verificarFinJuego();
        panelJuego.repaint();
        
    }
    
    public void update() {

        panelControl.setJlTime(cronometro.getFormattedTime());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        String nombreActivo = (turnoActual == 1)
                  ? areaJuego.getNombreJugador1()
                  : areaJuego.getNombreJugador2();
        
        String colorActivo = (turnoActual == 1)
                  ? areaJuego.getColorJugador1()
                  : areaJuego.getColorJugador2();
        
        if (e.getActionCommand() != null) {
        switch (e.getActionCommand()) {

            case "Dado":
                if(turnoTerminado){
                    resultadoDado = dado.lanzar();
                    turnoTerminado = false;
                    System.out.println("Resultado de dado:" + resultadoDado);
                    String rutaImagen = "/img/dado" + resultadoDado + ".1.png";
                    ImageIcon iconoDado = new ImageIcon(getClass().getResource(rutaImagen));
                    javax.swing.JButton btn = panelControl.getBtnDado();
                    btn.setIcon(iconoDado);
                    btn.setText("");
                    panelJuego.repaint();
                    
                    if(resultadoDado != 5 && !areaJuego.tieneFichasEnTablero(colorActivo)){
                    
                        System.out.println(nombreActivo + ": Sin movimientos posibles. Pasa el turno");
                        finalizarTurno();
                        cambiarTurno();
                        
                        break;
                    }
                                                       
                    if(resultadoDado == 5){
                        
                        System.out.println(nombreActivo + ": !Saca o mueve una ficha!");
                        
                    } else {
                    
                        System.out.println(nombreActivo + ": Mueve " + resultadoDado + " casillas.");
                    
                    }
                
                } else {
                
                    System.out.println("Debes mover una ficha antes de volver a tirar el dado.");
                
                }
                break;

            case "AtrasPanelControl":
                guiJuego.dispose();
                guiPrincipal.setVisible(true);
                break;
                
                
             case "Menu":
                guiPrincipal.setVisible(true);
                guiGameOver.setVisible(false);
                break;   
            
             case "MenuWin":
                guiPrincipal.setVisible(true);
                guiWin.setVisible(false);
                break;
                
            case "Reiniciar":
            case "ReiniciarWin":
                
                String colorJ1 = areaJuego.getColorJugador1();
                String nombreJ1 = areaJuego.getNombreJugador1();
                String nombreJ2 = areaJuego.getNombreJugador2();
                
                if (e.getActionCommand().equals("Reiniciar")){
                    guiGameOver.setVisible(false);
                    
                } else {
                    guiWin.setVisible(false);
                }
                
                new ControladorJuego(guiPrincipal, colorJ1, nombreJ1, nombreJ2);
                break;

            case "Iniciar":
                     
                cronometro.start();
                timer.start();
                break;
                   
            case "Detener":
                cronometro.reset();
                timer.restart();
                break;
                
            case "Pausar":
                cronometro.stop();
                timer.stop();
                break;    
            }
        }
       if (timer.isRunning()) {
            update();
          
             if (cronometro.getElapsedTime()>= 20000) {
                        timer.stop();
                        cronometro.stop();
                    }
        } 

    }
    
    
    

    @Override
    public void mouseClicked(MouseEvent e) {
        
        System.out.println("X " + e.getX() + " Y " + e.getY());
        String colorActivo = (turnoActual == 1)
                  ? areaJuego.getColorJugador1()
                  : areaJuego.getColorJugador2();
      
        
        if (turnoTerminado || resultadoDado == 0) {
            System.out.println("Espera, debes lanzar el dado primero o terminar de mover.");
            return;
        }
        
        if (resultadoDado == 5){

            int indexFichaCasa = areaJuego.getIndexFichaCasa(e.getX(), e.getY(), colorActivo);

            if (indexFichaCasa != -1){
            System.out.println("Moviendo ficha en indice de casa: " + indexFichaCasa); 
            areaJuego.sacarFicha(indexFichaCasa, colorActivo);
            
            finalizarTurno();
            cambiarTurno();
            return;
            
            }
            
        }
        
        int indiceCelda = areaJuego.getIndexFichaEnTablero(e.getX(), e.getY(), colorActivo);
        if (indiceCelda != -1) {
            System.out.println("Moviendo ficha de celda " + (indiceCelda+1) + " " + resultadoDado + " pasos.");
            int resultadoMovimiento = areaJuego.moverFicha(indiceCelda, resultadoDado, colorActivo);
            panelJuego.repaint();
            
            if (resultadoMovimiento >= 700) {
                int indiceColision = resultadoMovimiento - 700;
                System.out.println("Colision detectada en la celda: " +indiceColision+ "!");
                hacerPreguntaColision(indiceColision);
                return;
            } else if (!areaJuego.isCeldaNormal(resultadoMovimiento)){
                
                 System.out.println("Casilla especial, mostrando pregunta!");
                 hacerPregunta();
                
            } else {
              System.out.println("Casilla normal, no hay pregunta.");
            }
                finalizarTurno();
                cambiarTurno();
                return;
          }
        
            System.out.println("Click en un area no valida. Intenta de nuevo.");
        }
            
           

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
