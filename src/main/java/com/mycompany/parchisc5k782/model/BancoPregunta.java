/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parchisc5k782.model;

import java.util.ArrayList;

/**
 *
 * @author sebas
 */
public class BancoPregunta {
   
    private ArrayList<Pregunta> listaPregunta;

    public BancoPregunta() {
        listaPregunta = new ArrayList<Pregunta>();
    }
    
    public void crearPreguntas(){
        agregar(new Pregunta("Bruselas es la capital de Belgica?",0));
        agregar(new Pregunta("Carlos se va a quedar en ITM?",0));
        agregar(new Pregunta("El tomate es una fruta?",0));
        agregar(new Pregunta("Maria siempre llega temprano?",1));
        agregar(new Pregunta("Es posible acceder a un atributo" +
"               +con visibilidad privada directamente desde otra clase?",1));
    }
    
    public void agregar(Pregunta pregunta){
     listaPregunta.add(pregunta);
    }
    
    public Pregunta getPregunta(int posicion){
    return listaPregunta.get(posicion);
    }
    
    public int getElementos(){
        return listaPregunta.size();
    }
    
}
