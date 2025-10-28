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

    public ControladorJuego(GUIPrincipal guiPrincipal) {
        this.guiPrincipal = guiPrincipal;
        guiJuego = new GUIJuego(this);
        panelJuego = guiJuego.getPanelJuego();
        areaJuego = new AreaJuego();
        panelControl = guiJuego.getPanelControl();
        dado = new Dado();
        guiJuego.setVisible(true);
        
        ficha = new Ficha(new Posicion(100, 100), new ImageIcon("./src/main/resources/img/pieceblue.png"), "Amarillo");
        //453,468
    }

    public void dibujar(Component c, Graphics g) {

        ficha.dibujar(c, g);
        areaJuego.dibujar(c, g);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {

            case "Dado":
                System.out.println("Resultado de dado:" + dado.lanzar());
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
        ficha.getPosicion().setX(e.getX());
        ficha.getPosicion().setY(e.getY());
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
