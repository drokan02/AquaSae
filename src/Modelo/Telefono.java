/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author DroKaN
 */
public class Telefono {
    private int id;
    private int cliente_id;
    private int telefono;

    public int getId() {
        return id;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    
}
