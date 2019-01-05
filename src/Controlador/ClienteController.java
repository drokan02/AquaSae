/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.Clientes.FormCliente;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author DroKaN
 */
public class ClienteController implements KeyListener{
    private final FormCliente formCliente;
    public ClienteController(FormCliente formCliente){
        this.formCliente = formCliente;
        agregarEventos();
    }
    @Override
    public void keyTyped(KeyEvent ke) {
        if(ke.getSource() == formCliente.txtNombre){
           Validador.validarTexto(ke);
        }
        
        if(ke.getSource() == formCliente.txtApellido){
            Validador.validarTexto(ke);
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
    }
    
}
