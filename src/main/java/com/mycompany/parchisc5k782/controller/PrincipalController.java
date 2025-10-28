/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parchisc5k782.controller;

import com.mycompany.parchisc5k782.view.GUICreditos;
import com.mycompany.parchisc5k782.view.GUIHistoriaJuego;
import com.mycompany.parchisc5k782.view.GUIInstrucciones;
import com.mycompany.parchisc5k782.view.GUIJugador;
import com.mycompany.parchisc5k782.view.GUIPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author sebas
 */
public class PrincipalController implements ActionListener {

    private GUIPrincipal guiPrincipal;
    private GUICreditos guiCreditos;
    private GUIInstrucciones guiInstrucciones;
    private GUIHistoriaJuego guiHistoriaJuego;
    private ControladorJuego controladorJuego;
    private GUIJugador guiJugador;

    public PrincipalController() {
        guiPrincipal = new GUIPrincipal(this);
        guiPrincipal.setVisible(true);
        guiCreditos = new GUICreditos(this);
        guiInstrucciones = new GUIInstrucciones(this);
        guiHistoriaJuego = new GUIHistoriaJuego(this);
        guiJugador = new GUIJugador(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {

            case "Jugar":
                guiPrincipal.setVisible(false);
                guiJugador.setVisible(true);
                
                break;
                
                
            case "Continuar":
               controladorJuego = new ControladorJuego(guiPrincipal);
                break;
                

            case "Instrucciones":
                guiPrincipal.setVisible(false);
                guiInstrucciones.setVisible(true);
                break;

            case "atrasInstrucciones":
                guiInstrucciones.setVisible(false);
                guiPrincipal.setVisible(true);
                break;

            case "Creditos":
                guiPrincipal.setVisible(false);
                guiCreditos.setVisible(true);
                break;

            case "atrasCreditos":
                guiCreditos.setVisible(false);
                guiPrincipal.setVisible(true);
                break;

            case "HistoriaJuego":
                guiPrincipal.setVisible(false);
                guiHistoriaJuego.setVisible(true);
                break;

            case "atrasHistoriaJuego":
                guiHistoriaJuego.setVisible(false);
                guiPrincipal.setVisible(true);
                break;

            case "Salir":
                System.exit(0);
                break;

        }
    }

}
