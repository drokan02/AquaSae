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
        }else{
            System.out.println((int)car);
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
    
    public static void validarMonto(KeyEvent e){
        
    }
    
    public static void validarFecha(){
        
    }
}
