/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author DroKaN
 */
public class Cliente {
    private int id;
    private String nombre;
    private String Apellidos;
    private String direccion;
    private Zona zona;
    private ArrayList<Telefono> telefonos;

    public Cliente(){
        this.id = 0;
        this.nombre = "";
        this.Apellidos = "";
        this.direccion = "";
        this.zona = new Zona();
        this.telefonos = new ArrayList();
    }
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTelefonos(ArrayList<Telefono> telefonos) {
        this.telefonos = telefonos;
    }

    public Zona getZona() {
        return zona;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }
    
    public void addTelefono(Telefono telefono){
        telefonos.add(telefono);
    }

    public ArrayList<Telefono> getTelefonos() {
        return telefonos;
    }
    
}
