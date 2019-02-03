/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author DroKaN
 */
public class Tabla {
    public static DefaultTableCellRenderer alinearDerecha(){
        DefaultTableCellRenderer derecha = new DefaultTableCellRenderer();
        derecha.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
        return derecha;
    }
    
    public static DefaultTableCellRenderer alinearIzquierda(){
        DefaultTableCellRenderer izquierda = new DefaultTableCellRenderer();
        izquierda.setHorizontalAlignment(DefaultTableCellRenderer.LEFT);
        return izquierda;
    }
    
    public static DefaultTableCellRenderer alinearCentro(){
        DefaultTableCellRenderer centro = new DefaultTableCellRenderer();
        centro.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        return centro;
    }
}
