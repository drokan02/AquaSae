/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import java.awt.event.KeyEvent;

/**
 *
 * @author DroKaN
 */
public class Validador {
    public static void validarTexto(KeyEvent e){
        char car = e.getKeyChar();
        if(!Character.isLetter(car)){
            e.consume();
        }
    }
    
    public static void validarNumero(KeyEvent e){
        char car = e.getKeyChar();
        if(!Character.isDigit(car)){
            e.consume();
        }
    }
    
    public static void validarNumerosLetras(KeyEvent e){
        char car = e.getKeyChar();
        if(Character.isLetter(car) || Character.isDigit(car)){
            
        }else{
            e.consume();
        }
    }
    
    public static void validarLetrasMasEspacio(KeyEvent e){
        char car = e.getKeyChar();
        if(!Character.isLetter(car) && car != KeyEvent.VK_SPACE){
            e.consume();
        }
    }
    
    public static void validarLetrasMasEspacioMasNumero(KeyEvent e){
        char car = e.getKeyChar();
        if(!Character.isLetter(car) && car != KeyEvent.VK_SPACE && !Character.isDigit(car)){
            e.consume();
        }
    }
    
    public static void validarMonto(KeyEvent e){
        
    }
    
    public static void validarFecha(){
        
    }
}
