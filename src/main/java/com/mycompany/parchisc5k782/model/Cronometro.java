/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parchisc5k782.model;

/**
 *
 * @author sebas
 */
public class Cronometro {
    
    // La hora exacta en que se inició el cronómetro
    private long startTime;
    // El tiempo que ya había transcurrido antes de la pausa
    private long pausedTime = 0; 
    private boolean isRunning = false;

    public void start() {
        if (!isRunning) {
            // Calcula un nuevo punto de inicio restando el tiempo ya acumulado
            startTime = System.currentTimeMillis() - pausedTime;
            isRunning = true;
        }
    }

    public void stop() {
        if (isRunning) {
            // Guarda el tiempo transcurrido en pausedTime
            pausedTime = System.currentTimeMillis() - startTime;
            isRunning = false;
        }
    }

    public void reset() {
        pausedTime = 0;
        isRunning = false; // Asegura que no está corriendo
    }

    public long getElapsedTime() {
        if (isRunning) {
            // Si está corriendo, calcula el tiempo desde startTime hasta ahora
            return System.currentTimeMillis() - startTime;
        }
        // Si está detenido, devuelve el tiempo acumulado (pausedTime)
        return pausedTime;
    }

    public String getFormattedTime() {
        long totalMilliseconds = getElapsedTime();
        
        long hours = totalMilliseconds / 3600000;
        long minutes = (totalMilliseconds % 3600000) / 60000;
        long seconds = (totalMilliseconds % 60000) / 1000;
        long milliseconds = totalMilliseconds % 1000;
        
        // Formato HH:MM:SS.mmm
        return String.format("%02d:%02d:%02d.%03d", hours, minutes, seconds, milliseconds);
    }
    
}
