/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.Principal;
import Vista.Reporte.Reportes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author DroKaN
 */
public class ReporteController implements ActionListener
{
    private final Reportes report;
    private final Principal principal;
    public ReporteController(Reportes report,Principal principal){
        this.report = report;
        this.principal = principal;
        agregarEventos();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == report.btnFechas){
            if(validarEntreFechas()){
                Map params = new HashMap();
                params.put("fecha1", formatDate(getDeFecha()));
                params.put("fecha2", formatDate(getAlaFecha()));
                String reporte = "pedidosEntreFechas";
                new Reporte().mostrarReporte(reporte, params,principal);
            }
        }
        
        if(e.getSource() == report.btnFecha){
            Map params = new HashMap();
            params.put("fecha", getFecha());
            String reporte = "pedidos";
            //Reporte.mostrarReporte(reporte, params);
        }
        
        if(e.getSource() == report.btnMes){
            Map params = new HashMap();
            params.put("mes", getMes());
            String reporte = "pedidos";
            //Reporte.mostrarReporte(reporte, params);            
        }
        
        if(e.getSource() == report.btnAnio){
            Map params = new HashMap();
            params.put("anio", getAnio());
            String reporte = "pedidos";
            //Reporte.mostrarReporte(reporte, params);           
        }
        
    }
    
    private void agregarEventos(){
        report.btnFechas.addActionListener(this);
        report.btnFecha.addActionListener(this);
        report.btnAnio.addActionListener(this);
        report.btnMes.addActionListener(this);
        ((JTextField) report.dtDel.getDateEditor()).setEditable(false); 
        ((JTextField) report.dtAl.getDateEditor()).setEditable(false); 
    }

    private Date getDeFecha() {
        Date d = report.dtDel.getDate();
        return d;
    }

    private Date getAlaFecha() {
        Date d = report.dtAl.getDate();
        return d;
    }

    private Date getFecha() {
        Date d = report.dtFecha.getDate();
        return d;
    }

    private String getMes() {
        String res = "";
        int mes = report.dtMes.getMonth()+1;
        int anio = report.dtMAnio.getYear();
        if(mes < 10)
             res = "0"+mes+"-"+anio;
        else
            res = ""+mes+"-"+anio;
        return res;
    }

    private String getAnio() {
        return report.dtAnio.getYear()+"";
    }

     public String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }
     
    private boolean validarEntreFechas() {
        boolean res = true;
       String mensaje = "";
       Date fecha1 = getDeFecha();
       Date fecha2 = getAlaFecha();
       if(fecha1 == null && fecha2 == null){
           res = false;
           mensaje = "Debe seleccionar el rango de fechas para el reporte";
       }
       else if(fecha1 == null){
           res = false;
           mensaje = "Debe seleccionar de que fecha se iniciara el reporte";
       }else if(fecha2 == null ){
           res = false;
           mensaje = "Debe seleccionar hasta que fecha sera el reporte";
       }else if(fecha1.getTime() >= fecha2.getTime()){
           res = false;
           mensaje = "La fecha de donde comenzara el reporte debe ser mayor a la fecha hasta donde sera el reporte";
       }
       if(!res)
        JOptionPane.showMessageDialog(report,mensaje, "Alerta!", JOptionPane.ERROR_MESSAGE);
       return res;
    }
}