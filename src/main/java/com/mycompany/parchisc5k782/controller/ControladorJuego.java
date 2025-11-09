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
                int resultado = dado.lanzar();
                System.out.println("Resultado de dado:" + resultado);
                String rutaImagen = "/img/dado" + resultado + ".1.png";
                ImageIcon iconoDado = new ImageIcon(getClass().getResource(rutaImagen));
                javax.swing.JButton btn = panelControl.getBtnDado();
                btn.setIcon(iconoDado);
                btn.setText("");
                panelJuego.repaint();
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
//        ficha.getPosicion().setX(e.getX());
//        ficha.getPosicion().setY(e.getY());
        if(areaJuego.isContains(e.getX(), e.getY())){
        
            System.out.println("Si hay una Ficha");
            System.out.println("Indice de la ficha: " + areaJuego.getIndexFicha(e.getX(), e.getY()));
        } else {
        
            System.out.println("No hay una Ficha");
        
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
