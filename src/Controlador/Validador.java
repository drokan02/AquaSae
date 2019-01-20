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
    
    public static void validarMoneda(KeyEvent e,String monto){
        char car = e.getKeyChar();
        if( car != '.' && !Character.isDigit(car)){
            e.consume();
        }else{
            if(car == '.'){
                boolean existPunto = buscarPunto(monto);
                if(existPunto){
                   e.consume();
                }
            }else{
                boolean existPunto = buscarPunto(monto);
                if(existPunto){
                   if(decimalValido(monto)){
                       e.consume();
                   }
                }
            }
        }
    }
    
    private static boolean buscarPunto(String monto){
        boolean res = false;
        int i = 0;
        if(monto.length() == 0){
            res = true;
        }
        while(i < monto.length()){
            if(monto.charAt(i) == '.'){
                res = true;
                i = monto.length();
            }else{
                i++;
            }
        }
        return res;
    }
    
    private static boolean decimalValido(String monto){
        boolean res = false;
        int i = 0;
        int nroD= -1;
        while(i < monto.length()){
            if(nroD > -1){
                nroD += 1;
                if(nroD == 2){
                    res = true;
                    i = monto.length();
                }
            }else if(monto.charAt(i) == '.'){
                nroD = 0;
            }
            i++;
        }
        return res;
    }
    public static void validarFecha(){
        
    }
}
