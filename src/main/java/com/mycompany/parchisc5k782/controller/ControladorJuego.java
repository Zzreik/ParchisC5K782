/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parchisc5k782.controller;

import com.mycompany.parchisc5k782.model.AreaJuego;
import com.mycompany.parchisc5k782.model.Dado;
import com.mycompany.parchisc5k782.model.Ficha;
import com.mycompany.parchisc5k782.model.Posicion;
import com.mycompany.parchisc5k782.view.GUIJuego;
import com.mycompany.parchisc5k782.view.GUIPrincipal;
import com.mycompany.parchisc5k782.view.PanelControl;
import com.mycompany.parchisc5k782.view.PanelJuego;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;

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
    
    private int resultadoDado = 0;
    private boolean turnoTerminado = true;

    public ControladorJuego(GUIPrincipal guiPrincipal, String colorJugador1, String nombreJugador1,  String nombreJugador2) {
        this.guiPrincipal = guiPrincipal;
        guiJuego = new GUIJuego(this);
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
                    
                    if(resultadoDado == 5){
                        turnoTerminado = false;
                        System.out.println("Jugador 1: !Saca una ficha de la casa!");
                        
                    } else {
                    
                        turnoTerminado = true;
                    
                    }
                
                } else {
                
                    System.out.println("Debes mover una ficha antes de volver a tirar el dado.");
                
                }
                break;

            case "AtrasPanelControl":
                guiJuego.dispose();
                guiPrincipal.setVisible(true);
                break;

        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("X " + e.getX() + " Y " + e.getY());
        if(resultadoDado == 5 && !turnoTerminado){
        
          if(areaJuego.isContains(e.getX(), e.getY())){
          
              int indexFicha = areaJuego.getIndexFicha(e.getX(), e.getY());
              
              if (indexFicha != -1){
              
                  System.out.println("Moviendo ficha en indice de casa: " + indexFicha);
                  
                  areaJuego.sacarFicha(indexFicha);
                  
                  turnoTerminado = true;
                  resultadoDado = 0;
              
              }
          
          }
        
        }
        panelJuego.repaint();
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
