/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.Image;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author DroKaN
 */
public class Complemento {
    
    public static void nuevoIcono(String nombreImg,JLabel lb,boolean setTamanio){
        String img = System.getProperty("user.dir") + "\\img\\"+nombreImg;
       ImageIcon i = new ImageIcon(img);
       Icon icon;
       if(setTamanio)
            icon= new ImageIcon(i.getImage().getScaledInstance(lb.getWidth(), lb.getHeight(), Image.SCALE_DEFAULT));
       else 
            icon = new ImageIcon(i.getImage());
       lb.setIcon(icon);
    }
    
    public static void dormir(int tiempo){
           try {
                Thread.sleep(tiempo);
              } catch (Exception ex) {
              }
    }
    
    public  static DefaultTableCellRenderer alinearCentro(){
        DefaultTableCellRenderer cr = new DefaultTableCellRenderer();
        cr.setHorizontalAlignment(SwingConstants.CENTER);
        return cr;
    }
    public  static DefaultTableCellRenderer alinearDer(){
        DefaultTableCellRenderer cr = new DefaultTableCellRenderer();
        cr.setHorizontalAlignment(SwingConstants.RIGHT);
        return cr;
    }
    
    public static  String fecha(Date fechaBD){
  
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formato2 = new SimpleDateFormat("dd-MM-yyyy");

        try {
            java.util.Date fecha  = formato.parse(fechaBD.toString());
            return formato2.format(fecha);
        } catch (ParseException ex) {
            return "";
        }
       
        
    }
}
