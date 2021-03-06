/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author Israel Aguilar
 */
import DAO.Implemets.ZonaDao;
import Modelo.Zona;
import Vista.Zonas.FormZona;
import Vista.Zonas.ListaZonas;
import Vista.Principal;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class ZonaController implements KeyListener,ActionListener,MouseListener{
    
    private final ListaZonas listZona;
    private final FormZona formZona;
    // This variable has code value of actual Zona
    int actualRow;
    
    public ZonaController(ListaZonas listZona){
        this.listZona = listZona;
        this.formZona = new FormZona();
        actualRow = -1;
        agregarEventos();
        llenarTabla();
        formZona.txtCodigo.setVisible(false);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        //TODO how to do update and create.
        
        if(e.getSource() == listZona.btnZona){
            System.out.println("Pressed Button");
            formZona.txtTitulo.setText("REGISTRAR ZONA");
            formZona.btnRegistrar.setText("Registrar");
            MenuController.cambiarPanel(formZona);
            
        }
        
        if(e.getSource()== formZona.btnRegistrar){
            if(formZona.btnRegistrar.getText().equals("Actualizar")){         
                actualizarZona(actualRow);
            }if(formZona.btnRegistrar.getText().equals("Registrar")){
                registrarZona();
            }
            
        }
        
        if(e.getSource() == formZona.btnCancelar){
             MenuController.cambiarPanel(listZona);
        }
   
    }
    
    @Override
    //TODO Chango components name. Replace it for atributes' zone.
    public void keyTyped(KeyEvent ke) {
        
        if(ke.getSource() == formZona.txtNombre){
           Validador.validarLetrasMasEspacio(ke);
        }
        
        if(ke.getSource() == listZona.txtBuscar){
            Validador.validarLetrasMasEspacioMasNumero(ke);
            llenarTabla();
        }
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
       
        
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        
    }
    
     @Override
    public void mouseClicked(MouseEvent me) {
        int fila = listZona.jtZonas.rowAtPoint(me.getPoint());
        int columna = listZona.jtZonas.columnAtPoint(me.getPoint());
        DefaultTableModel modelo = (DefaultTableModel) listZona.jtZonas.getModel();
//        // In variable 'zonaSeleccionada' I just storage the value 'id'(codigo) from the row selected.
        String zonaSeleccionada = modelo.getValueAt(fila, 0).toString();
        zonaSeleccionada.trim();
        System.out.println("Zona seleccionada para ser eliminada" + zonaSeleccionada);
        actualRow = Integer.parseInt(zonaSeleccionada);
        //eliminar fila
        if( columna == 3){
            int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro de Eliminar?", "Alerta!", 
                                                    JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
            if( resp == 0){
                actualRow = Integer.parseInt(zonaSeleccionada);
                eliminarZona(actualRow);
            }            
        }else if(columna == 2){
            String codigoEditar = modelo.getValueAt(fila, 0).toString();;
            String nombreEditar = modelo.getValueAt(fila, 1).toString();;
            formZona.txtTitulo.setText("EDITAR ZONA");
            formZona.txtCodigo.setText(codigoEditar);
            formZona.txtNombre.setText(nombreEditar);
            formZona.btnRegistrar.setText("Actualizar");
            MenuController.cambiarPanel(formZona);
        
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent me) {

    }

    @Override
    public void mouseExited(MouseEvent me) {

    }

    private void agregarEventos(){
        formZona.txtNombre.addKeyListener(this);
        formZona.txtCodigo.addKeyListener(this);
        listZona.txtBuscar.addKeyListener(this);
        formZona.btnCancelar.addActionListener(this);
        formZona.btnRegistrar.addActionListener(this);
        listZona.btnZona.addActionListener(this);
        listZona.jtZonas.addMouseListener(this);
        formZona.setFocusTraversalPolicy(new FocusTraversalOnArray(
                new Component[]{formZona.txtNombre, formZona.txtCodigo
                })
        );
    }
    //llenamos la tabla con datos de la base de datos
    private void llenarTabla(){        
        DefaultTableModel modelo = new DefaultTableModel(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        listZona.jtZonas.setDefaultRenderer(Object.class, new Render());
        listZona.jtZonas.setModel(modelo);
        modelo.addColumn("N°");
        modelo.addColumn("Nombre");
        modelo.addColumn(" ");
        modelo.addColumn(" ");
        ZonaDao z = new ZonaDao();
        String descripcion = listZona.txtBuscar.getText();
        ArrayList <Zona> zonas = z.list(descripcion);
        for (Zona zona : zonas){
            //Fill the table with Zona Objects from Data Base
            Object [] fila = new Object[4];
            fila[0] = zona.getId();
            fila[1] = zona.getNombre();
            fila[2] = Principal.btEditar;
            fila[3] = Principal.btEliminar;
            modelo.addRow(fila);
        }
        setTamanioCol(listZona.jtZonas.getColumnModel());   
    }
    
    private void setTamanioCol(TableColumnModel col){
       
       col.getColumn(0).setPreferredWidth(10);
       col.getColumn(0).setCellRenderer(Complemento.alinearDer());
       col.getColumn(1).setPreferredWidth(600);
       col.getColumn(1).setCellRenderer(Complemento.alinearCentro());
       col.getColumn(2).setPreferredWidth(20);
       col.getColumn(3).setPreferredWidth(20);
    }
    
    private void registrarZona(){
      ZonaDao z = new ZonaDao();  
      Zona newZone = new Zona();
      String mensaje = validarCampos();
      if(mensaje.equals("")){
            String nombreReg = formZona.txtNombre.getText(); 
            newZone.setNombre(nombreReg);
             mensaje = z.insert(newZone);
             MenuController.cambiarPanel(listZona);
            JOptionPane.showMessageDialog(listZona, mensaje);
            llenarTabla();
            
        }else{
            JOptionPane.showMessageDialog(formZona, mensaje);
        }   

      vaciarFormulario();
    }


    private void eliminarZona(int eliminar) {
      String mensaje;
      ZonaDao z = new ZonaDao();
      Zona zonaEliminar = new Zona();
      zonaEliminar.setId(eliminar);
      mensaje = z.delete(zonaEliminar);
      llenarTabla();
      JOptionPane.showMessageDialog(formZona, mensaje);
    }

    private void actualizarZona(int row) {
      ZonaDao z = new ZonaDao();
      Zona zonaEditar = new Zona();
      String mensaje = validarCampos();
      if(mensaje.equals("")){
        zonaEditar.setId(row);
        String nombreEdit = formZona.txtNombre.getText();
        zonaEditar.setNombre(nombreEdit);
        mensaje = z.edit(zonaEditar);
        llenarTabla();
        MenuController.cambiarPanel(listZona);
        JOptionPane.showMessageDialog(listZona, mensaje);
        vaciarFormulario();
      }
      else{
        JOptionPane.showMessageDialog(listZona, mensaje);

      }
    }
    
    private void vaciarFormulario() {
        formZona.txtCodigo.setText("");
        formZona.txtNombre.setText("");
    }

    private void vaciarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) listZona.jtZonas.getModel();
        int filasTotales = modelo.getRowCount();
        
        
        for(int i = 0; i<filasTotales ; i++){
            modelo.removeRow(i);
            i-=1;
        }
        
    }
    
    private String validarCampos(){
        String mensaje = "";
        if(formZona.txtNombre.getText().equals("")){
            mensaje += "Debe ingresar el nombre  \n";
        }
        return mensaje;
    }
   
}
