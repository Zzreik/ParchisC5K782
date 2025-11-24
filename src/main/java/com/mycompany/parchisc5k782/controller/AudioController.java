/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parchisc5k782.controller;

import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author sebas
 */
public class AudioController {
    
   private Clip clip;
    
    
    public void iniciarMusica(String ruta){ //Entra un parametro que será la ruta del audio
        try{ //Este evalua diferentes excepcione que podrían haber
               URL url = getClass().getResource(ruta); //getClass() = clase actual,  getResource(nombreSonido)= busca un archivo de resources
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);/*AudioSystem = Maneja todo lo relacionado con audios (reproducir, 
                                                                                        grabaciones,cargar audios,etc) y getAudioInputStream(url)=lee el 
                                                                                           archivo y verifica si es compatible */
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.loop(10);/* inicia la reproducción en bucle desde la posición actual, en este caso el audio se reproduce la primera vez y 
                                          10 veces más (luego se detiene).*/
                clip.start();
            }
        catch(UnsupportedAudioFileException | IOException | LineUnavailableException ex){ /* Evalua formato (siempre debe de ser .wav)/problemas con el archivo (archivos dañados
                                                                                              no existe, rutas incorrectas, etc)/Si hay más de un audio reproduciendose*/
            // Si se desea saber cual es la exepción exacta usar: ex.printStackTrace(); 
            System.out.print("Error al reproducir el sonido");
        }
    }
    
    //Detiene la música si está sonando
    public void detener(){
    if (clip != null && clip.isRunning()){
        clip.stop();
    }
    }
    public boolean estaReproduciendo(){
      if(clip != null && clip.isRunning()){
  return true;
}
return false;
} 
    
}
