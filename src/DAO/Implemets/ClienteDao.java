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
import Modelo.Zona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
        String res = "";
        conn = new Connector();
        conn.conectar();
        con = conn.getConexion();
        String edit = "UPDATE client SET "
                + "name  = '" + a.getNombre() + "', "
                + "surname = " + a.getApellidos() + ", "
                + "dir = " + a.getDireccion() + ""
                 + "WHERE id = " + a.getId() + "";
               
        try {
          st = con.createStatement();
          int n = st.executeUpdate(edit);
          if (n > 0) {
            conn.desconectar();
            int z = editarZona(a);
            int t = editarTelefonos(a);
            if(z > 0 && t > 0){
                res = "Cliente modificado correctamente";
            }
          }
        } catch (SQLException ex) {
          res = Errors.errorMessage(ex.getErrorCode(), ex.getMessage());
        }
        return res;
    }

    @Override
    public String delete(Cliente a) {
        String res = "";
        conn = new Connector();
        conn.conectar();
        con = conn.getConexion();
        String delete = "DELETE from client "
                + "WHERE id = '" + a.getId() + "'";
        try {
          st = con.createStatement();
          int n = st.executeUpdate(delete);
          if (n > 0) {
            res = "Cliente Eliminado correctamente";
            conn.desconectar();
          }
        } catch (SQLException ex) {
          res = Errors.errorMessage(ex.getErrorCode(), ex.getMessage());
        }
        return res;
    }

    @Override
    public ArrayList<Cliente> list(String description) {
        return null;
    }

    @Override
    public Cliente search(Cliente a) {
         conn = new Connector();
        conn.conectar();
        con = conn.getConexion();
        String search = "SELECT client.id id_client, client.name nombre, client.surname apellido, "
                + "client.dir direccion, zone.id id_zona, zone.name zona FROM client "
                + "INNER JOIN client_zone ON client.id=client_zone.id_client "
                + "INNER JOIN zone ON client_zone.id_zone=zone.id "
                + "WHERE client.id = "+a.getId();
        try {
          st = con.createStatement();
          rt = st.executeQuery(search);
          if (rt.next()) {
              Zona zona = new Zona();
              ArrayList<Telefono> telefonos = buscarTelefonos(rt.getInt(1));
              zona.setId(rt.getInt("id_zona"));
              zona.setNombre(rt.getString("zona"));
              a.setId(rt.getInt("id_client"));
              a.setNombre(rt.getString("nombre"));
              a.setApellidos(rt.getString("apellido"));
              a.setZona(zona);
              a.setTelefonos(telefonos);
          }
          conn.desconectar();
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null,
                  Errors.errorMessage(ex.getErrorCode(), ex.getMessage()));
        }
        return a; 
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
    
    private int editarZona(Cliente a){
       int res = 0;
       conn.conectar();
        con = conn.getConexion();
        String edit = "UPDATE client_zone SET "
                    + "id_zone  = '" + a.getZona().getId() + "', "
                     + "WHERE id = " + a.getZona().getId() + "";
               
        try {
          st = con.createStatement();
          res = st.executeUpdate(edit);
          if (res > 0) {
              conn.desconectar();
              return res;
            
          }
        } catch (SQLException ex) {
          String mensaje = Errors.errorMessage(ex.getErrorCode(), ex.getMessage());
          System.out.println(mensaje);
        } 
        return res;
    }
    
     private int editarTelefonos(Cliente a){
       int res = 0;
       conn.conectar();
        con = conn.getConexion();
          
        try {
          for (Telefono t : a.getTelefonos()) {
           String edit = "UPDATE client_phone SET "
                       + "phone  = '" + a.getZona().getId() + "', "
                       + "WHERE id = " + t.getId() + "";  
           st = con.createStatement();
           res = st.executeUpdate(edit);
         }
          
          if (res > 0) {
              conn.desconectar();
              return res;  
          }
        } catch (SQLException ex) {
          String mensaje = Errors.errorMessage(ex.getErrorCode(), ex.getMessage());
          System.out.println(mensaje);
        } 
        return res;
    }
     
    private ArrayList<Telefono> buscarTelefonos(int id_cli){
        ArrayList<Telefono> res = new ArrayList();
        String buscar = "SELECT id,phone telefono from client_phone"
                      + "WHERE id_client = " + id_cli;
        
       try {
           st = con.createStatement();
           rt = st.executeQuery(buscar);
          while (rt.next()) {
              Telefono telf = new Telefono();
              telf.setCliente_id(id_cli);
              telf.setId(rt.getInt("id"));
              telf.setTelefono(rt.getInt("telefono"));
              res.add(telf);
          }
          conn.desconectar();
       } catch (SQLException ex) {
           Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
       }
       return res;
    }
}
