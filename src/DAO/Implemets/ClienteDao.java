/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Implemets;

import DAO.Dao;
import Modelo.Cliente;
import Modelo.Connector;
import Modelo.Errors;
import Modelo.Telefono;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DroKaN
 */
public class ClienteDao implements Dao<Cliente>{
    
   private Connector conn;
   private Connection con;
   protected Statement st;
   protected ResultSet rt;
   protected PreparedStatement pst;

    @Override
    public String insert(Cliente a) {
        String res = "";
        String insert = "INSERT into client(name,surname,dir) VALUES(?,?,?)";
    
        conn = new Connector();
        conn.conectar();
        con = conn.getConexion();
       try {
            pst = con.prepareStatement(insert);
            pst.setString(1, a.getNombre());
            pst.setString(2, a.getApellidos());
            pst.setString(3, a.getDireccion());
            int n = pst.executeUpdate();
            if (n > 0) {
              conn.desconectar();
              //Cliente cli = search(a);
              //int z = insertarZona(cli,a);
              //int t = insertarTelefonos(cli,a);
              //if(z > 0 && t > 0){
                  res = "Cliente registrado correctamente";
              //}
            }
       } catch (SQLException ex) {
           res = Errors.errorMessage(ex.getErrorCode(), ex.getMessage());
       }
       return res;
    }

    @Override
    public String edit(Cliente a) {
        return "";
    }

    @Override
    public String delete(Cliente a) {
        return "";
    }

    @Override
    public ArrayList<Cliente> list(String description) {
        return null;
    }

    @Override
    public Cliente search(Cliente a) {
        return null;
    }
   
    //insertar la zona de un cliente
    private int insertarZona(Cliente cli,Cliente a){
        int res = 0;
         String insert = "INSERT into client_zone(id_client,id_zone) VALUES(?,?)";
         conn.conectar();
         con = conn.getConexion();
       try {
           pst = con.prepareStatement(insert);
           pst.setInt(1, cli.getId());
           pst.setInt(2, a.getZona().getId());
           res = pst.executeUpdate();
           if(res > 0){
               conn.desconectar();
               return res;
           }
       } catch (SQLException ex) {
          String mensaje = Errors.errorMessage(ex.getErrorCode(), ex.getMessage());
          System.out.println(mensaje);
       }
       return res;
    }
   
    private int insertarTelefonos(Cliente cli,Cliente a){
        int res = 0;
        ArrayList<Telefono> ts = a.getTelefonos();
         String insert = "INSERT into client_phone(id_client,phone) VALUES(?,?)";
         conn.conectar();
         con = conn.getConexion();
       try {
           for (Telefono t : ts) {
                pst = con.prepareStatement(insert);
                pst.setInt(1, cli.getId());
                pst.setInt(2, t.getTelefono());
                res = pst.executeUpdate();  
           }
           
           if(res > 0){
               conn.desconectar();
               return res;
           }
       } catch (SQLException ex) {
          String mensaje = Errors.errorMessage(ex.getErrorCode(), ex.getMessage());
          System.out.println(mensaje);
       }
       return res;
    }
}
