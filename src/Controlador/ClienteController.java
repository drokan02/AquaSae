/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.Clientes.FormCliente;
import Vista.Clientes.ListaCliente;
import Vista.Principal;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author DroKaN
 */
public class ClienteController implements KeyListener,ActionListener,MouseListener{
    private final ListaCliente listCliente;
    private final FormCliente formCliente;
    public ClienteController(ListaCliente listCliente){
        this.listCliente = listCliente;
        this.formCliente = new FormCliente();
        agregarEventos();
        llenarTabla();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == listCliente.btnCliente){
            formCliente.txtTitulo.setText("REGISTRAR CLIENTE");
            MenuController.cambiarPanel(formCliente);
        }
        
        if(e.getSource()== formCliente.btnRegistrar){
            registrarCliente();
            MenuController.cambiarPanel(listCliente);
        }
        
        if(e.getSource() == formCliente.btnCancelar){
             MenuController.cambiarPanel(listCliente);
        }
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {
        
        if(ke.getSource() == formCliente.txtNombre){
           Validador.validarLetrasMasEspacio(ke);
        }
        
        if(ke.getSource() == formCliente.txtApellido){
            Validador.validarLetrasMasEspacio(ke);
        }
        
        if(ke.getSource() == formCliente.txtDireccion){
            Validador.validarNumerosLetras(ke);
        }
        
        if(ke.getSource() == formCliente.txtTelefono){
            Validador.validarNumero(ke);
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
        int fila = listCliente.jtClientes.rowAtPoint(me.getPoint());
        int columna = listCliente.jtClientes.columnAtPoint(me.getPoint());
        //eliminar fila
        if( columna == 7){
            int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro de Eliminar?", "Alerta!", 
                                                    JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
        //editar fila
        }else if(columna == 6){
            formCliente.txtTitulo.setText("EDITAR CLIENTE");
            MenuController.cambiarPanel(formCliente);
        //ver numeros telefonicos
        }else if (columna == 5){
            JOptionPane.showMessageDialog(null, "NUMEROS TELEFONICOS");
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
        formCliente.txtNombre.addKeyListener(this);
        formCliente.txtApellido.addKeyListener(this);
        formCliente.txtDireccion.addKeyListener(this);
        formCliente.txtTelefono.addKeyListener(this);
        formCliente.btnCancelar.addActionListener(this);
        formCliente.btnRegistrar.addActionListener(this);
        listCliente.btnCliente.addActionListener(this);
        listCliente.jtClientes.addMouseListener(this);
        formCliente.setFocusTraversalPolicy(new FocusTraversalOnArray(
                new Component[]{formCliente.txtNombre, formCliente.txtApellido,
                    formCliente.txtDireccion,formCliente.comZona,formCliente.txtTelefono,
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
        listCliente.jtClientes.setDefaultRenderer(Object.class, new Render());
        listCliente.jtClientes.setModel(modelo);
        modelo.addColumn("N°");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Direccion");
        modelo.addColumn("Zona");
        modelo.addColumn(" ");
        modelo.addColumn(" ");
        modelo.addColumn(" ");
        //llena las filas con datos de la base de datos
        for(int i = 1 ; i < 30 ; i++){
            Object [] fila = new Object[8];
            fila[5] = Principal.btTelefonos;
            fila[6] = Principal.btEditar;
            fila[7] = Principal.btEliminar;
            modelo.addRow(fila);
        }
        setTamanioCol(listCliente.jtClientes.getColumnModel());
    }
    
    private void setTamanioCol(TableColumnModel col){
       col.getColumn(0).setPreferredWidth(5);
       col.getColumn(1).setPreferredWidth(300);
       col.getColumn(2).setPreferredWidth(300);
       col.getColumn(3).setPreferredWidth(130);
       col.getColumn(4).setPreferredWidth(100);
       col.getColumn(5).setPreferredWidth(5);
       col.getColumn(6).setPreferredWidth(5);
       col.getColumn(7).setPreferredWidth(5);
    }
    
    private void registrarCliente(){
      
    }

   
}
