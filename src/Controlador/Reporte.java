/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Connector;
import Vista.Principal;
import java.awt.Dimension;
import java.sql.Connection;
import java.util.Map;
import javax.swing.JDialog;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author DroKaN
 */
public class Reporte {
    private Connector conn;
    private Connection con;
    private JDialog ventana;
    
    public  void mostrarReporte(String reporte,Map parametros,Principal principal)
    {
      conn = new Connector();
      conn.conectar();
      con = conn.getConexion();
      String report = System.getProperty("user.dir") + "\\src\\Reportes\\"+reporte+".jrxml";
      try
      {
        JasperReport jr = JasperCompileManager.compileReport(report);
        JasperPrint jp = JasperFillManager.fillReport(jr, parametros, con);
        JasperViewer visor = new JasperViewer(jp, false);
        crearVentana(principal);
        ventana.getContentPane().add(new JRViewer(jp));
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        conn.conectar();
      }
      catch (JRException e)
      {
         // JOptionPane.showMessageDialog(null, e);
      }
    }
    
    private  void crearVentana(Principal principal){
        ventana = new JDialog(principal,"Reporte", true);
        ventana.setPreferredSize(new Dimension(1000, 1000));
    }
}
