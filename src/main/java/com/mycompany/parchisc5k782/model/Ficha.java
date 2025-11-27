/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parchisc5k782.model;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author sebas
 */
public class Ficha {
    private Posicion posicion;
    private ImageIcon imagen;
    private String color;
    private Rectangle hitbox;
    private boolean inTablero;
    private boolean inPasillo;

    public Ficha(Posicion posicion, ImageIcon imagen, String color) {
        this.posicion = posicion;
        this.imagen = imagen;
        this.color = color;
        hitbox = new Rectangle(posicion.getX(), posicion.getY(),30,30);
        inTablero=false;
        inPasillo=false;
    }
    
    public boolean isContains(int x, int y){
    
        return hitbox.contains(x, y);
    
    }

    public boolean isInPasillo(){
        return inPasillo;
    
    }
    
    public void setInPasillo(boolean inPasillo){
        this.inPasillo = inPasillo;
    }
    
    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
        this.hitbox.setLocation(posicion.getX(), posicion.getY());
    }

    public ImageIcon getImagen() {
        return imagen;
    }

    public void setImagen(ImageIcon imagen) {
        this.imagen = imagen;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public void dibujar(Component c, Graphics g){
    
        imagen.paintIcon(c,g,posicion.getX(),posicion.getY());
    
    }
    
}
