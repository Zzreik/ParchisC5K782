/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parchisc5k782.model;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author sebas
 */
public class BancoPregunta {
   
    private ArrayList<Pregunta> listaPregunta;
    private Random random;

    public BancoPregunta() {
        listaPregunta = new ArrayList<Pregunta>();
        random = new Random();
        crearPreguntas();
    }
    
    public Pregunta getPreguntaAleatoria(){
        
        if (listaPregunta.isEmpty()){
            return null;
        }
        int index = random.nextInt(listaPregunta.size());
        return listaPregunta.get(index);     
    }
    
    
    public void crearPreguntas(){
        agregar(new Pregunta("¿Java es un lenguaje orientado a objetos?",0));
        agregar(new Pregunta("¿Se puede ejecutar código Java sin compilarlo primero?",1));
        agregar(new Pregunta("¿Se puede usar System.out.println para leer datos del usuario?",1));
        agregar(new Pregunta("¿Java permite herencia múltiple directa entre clases?",1));
        agregar(new Pregunta("¿El método main es obligatorio para ejecutar un programa Java?",0));
        agregar(new Pregunta("¿La extensión de archivo para código fuente Java es .java?",0));
        agregar(new Pregunta("¿Se puede usar super para acceder a miembros de una subclase?",1));
        agregar(new Pregunta("¿Se puede usar break dentro de un bucle for?",0));
        agregar(new Pregunta("¿El paquete java.util incluye clases para trabajar con listas?",0));
        agregar(new Pregunta("¿Java permite definir múltiples métodos main en una misma clase?",1));
        agregar(new Pregunta("¿Se puede usar this para referirse al objeto actual?",0));
        agregar(new Pregunta("¿Se puede crear una instancia de una clase abstracta?",1));
        agregar(new Pregunta("¿El ciclo while se ejecuta al menos una vez siempre?",1));
        agregar(new Pregunta("¿Java permite el uso de anotaciones como @Override?",0));
        agregar(new Pregunta("¿El operador == compara el contenido de objetos?",1));
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
