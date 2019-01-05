/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.Clientes.FormCliente;
import Vista.Clientes.ListaCliente;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;

/**
 *
 * @author DroKaN
 */
public class ClienteController implements KeyListener,ActionListener{
    private final ListaCliente listCliente;
    private final FormCliente formCliente;
    public ClienteController(ListaCliente listCliente){
        this.listCliente = listCliente;
        this.formCliente = new FormCliente();
        agregarEventos();
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
    
    
     private void agregarEventos(){
        formCliente.txtNombre.addKeyListener(this);
        formCliente.txtApellido.addKeyListener(this);
        formCliente.txtDireccion.addKeyListener(this);
        formCliente.txtTelefono.addKeyListener(this);
        formCliente.btnCancelar.addActionListener(this);
        formCliente.btnRegistrar.addActionListener(this);
        listCliente.btnCliente.addActionListener(this);
        formCliente.setFocusTraversalPolicy(new FocusTraversalOnArray(
                new Component[]{formCliente.txtNombre, formCliente.txtApellido,
                    formCliente.txtDireccion,formCliente.comZona,formCliente.txtTelefono,
                })
        );
    }
     
    private void registrarCliente(){
        
    }
}
