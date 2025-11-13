/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parchisc5k782.model;

/**
 *
 * @author lab01
 */
public class Jugador {
    
    private String nombre;
    private String color;
    private int puntos;
    
    public Jugador(String nombre, String color) {
        this.nombre = nombre;
        this.color = color;
        puntos = 5;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public int getPuntos(){
        return puntos;
    }
    
    public void sumarPuntos(){
        this.puntos++;
    }
    
    
    public void restarPunto(){
        if (this.puntos > 0){
         this.puntos--;
        }
    }   
    
}
