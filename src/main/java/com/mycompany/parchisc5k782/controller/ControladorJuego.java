/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parchisc5k782.controller;

import com.mycompany.parchisc5k782.model.AreaJuego;
import com.mycompany.parchisc5k782.model.Dado;
import com.mycompany.parchisc5k782.model.Ficha;
import com.mycompany.parchisc5k782.model.Posicion;
import com.mycompany.parchisc5k782.model.Pregunta;
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

/**
 *
 * @author sebas
 */
public class ControladorJuego implements ActionListener, MouseListener {

    
    
    
    private GUIJuego guiJuego;
    private PanelJuego panelJuego;
    private PanelControl panelControl;
    private GUIPrincipal guiPrincipal;
    private Ficha ficha;
    private AreaJuego areaJuego;
    private Dado dado;
    private GUIGameOver guiGameOver;
    private GUIWin guiWin;
    
    
    private int resultadoDado = 0;
    private boolean turnoTerminado = true;

    public ControladorJuego(GUIPrincipal guiPrincipal, String colorJugador1, String nombreJugador1,  String nombreJugador2) {
        this.guiPrincipal = guiPrincipal;
        guiJuego = new GUIJuego(this);
        guiGameOver = new GUIGameOver();
        guiWin = new GUIWin();
        panelJuego = guiJuego.getPanelJuego();
        areaJuego = new AreaJuego(colorJugador1,nombreJugador1,nombreJugador2);
        panelControl = guiJuego.getPanelControl();
        panelControl.setJlNombreJugador1(nombreJugador1);
        panelControl.setJlNombreJugador2(nombreJugador2);
        dado = new Dado();
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
            areaJuego.aplicarResultadoPregunta(true);

        } else {
            JOptionPane.showMessageDialog(guiJuego, "!Respuesata incorrecta! -1 punto.");
            areaJuego.aplicarResultadoPregunta(false);
        }
        
        int puntosActuales = areaJuego.getPuntosJugador1();
        panelControl.setJlPuntosJugador1(puntosActuales);
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
    
    
    
//    public int mostrarWin(int puntaje){
//        
//        guiJuego.setVisible(false);
//        if(guiWin == null) {
//        guiWin = new GUIWin();
//        
//        }
//        guiWin.setEstadisticas(puntaje);
//        guiWin.setVisible(true);
//        
//    }
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {

            case "Dado":
                if(turnoTerminado){
                    resultadoDado = dado.lanzar();
                    System.out.println("Resultado de dado:" + resultadoDado);
                    String rutaImagen = "/img/dado" + resultadoDado + ".1.png";
                    ImageIcon iconoDado = new ImageIcon(getClass().getResource(rutaImagen));
                    javax.swing.JButton btn = panelControl.getBtnDado();
                    btn.setIcon(iconoDado);
                    btn.setText("");
                    panelJuego.repaint();
                    
                    turnoTerminado = false;
                    
                    
                    if(resultadoDado == 5){
                        
                        System.out.println("Jugador 1: !Saca o mueve una ficha!");
                        
                    } else {
                    
                        System.out.println("Jugador 1: Mueve " + resultadoDado + " casillas.");
                    
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
                guiGameOver.setVisible(false);
                break;
                
            case "Reiniciar":
                
                break;
                
            case "ReiniciarWin":
                
                break;

        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("X " + e.getX() + " Y " + e.getY());
        
        if (turnoTerminado) {
            System.out.println("Espera, debes lanzar el dado primero.");
            return;
        }
        
        if (resultadoDado == 5){
        
            int indexFichaCasa = areaJuego.getIndexFicha(e.getX(), e.getY());
            if (indexFichaCasa != -1){
            System.out.println("Moviendo ficha en indice de casa: " + indexFichaCasa); 
            areaJuego.sacarFicha(indexFichaCasa);
            
            finalizarTurno();
            return;
            
            }
            
        }
        
        int indiceCelda = areaJuego.getIndexFichaEnTablero(e.getX(), e.getY());
        if (indiceCelda != -1) {
            System.out.println("Moviendo ficha de celda " + indiceCelda + " " + resultadoDado + "pasos.");
            int nuevaCeldaIndice = areaJuego.moverFicha(indiceCelda, resultadoDado);
            panelJuego.repaint();
            if (areaJuego.isCeldaNormal(nuevaCeldaIndice)){
                System.out.println("Casilla normal, mostrando pregunta!");
                hacerPregunta();
            } else {
                System.out.println("Casilla especial, turno seguro.");
            }
            
            finalizarTurno();
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
