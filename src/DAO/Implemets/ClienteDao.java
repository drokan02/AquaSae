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
              Cliente cli = idCliente(a);
              System.out.println(cli.getId()+" dasddadsadasd");
              int z = insertarZona(cli,a);
              int t = insertarTelefonos(cli,a);
              if(z > 0 && t > 0){
                  res = "Cliente registrado correctamente";
              }
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
                + "surname = '" + a.getApellidos() + "', "
                + "dir = '" + a.getDireccion() + "' "
                 + "WHERE id = " + a.getId() + "";
               
        try {
          st = con.createStatement();
          int n = st.executeUpdate(edit) ;
          if (n > 0) {
            conn.desconectar();
            System.out.println(a.getId());
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
    
    private int editarZona(Cliente a){
       int res = 0;
       conn.conectar();
        con = conn.getConexion();
        String edit = "UPDATE client_zone SET "
                    + "id_zone  = '" + a.getZona().getId() + "' "
                     + "WHERE client_zone.id_client = " + a.getId() + "";
               
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
                       + "phone  = " + t.getTelefono() + " "
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

    @Override
    public String delete(Cliente a) {
        String res = "";
        conn = new Connector();
        conn.conectar();
        con = conn.getConexion();
        String delete_datos = 
                        "DELETE client_phone,client_zone from client " +
                        "INNER JOIN client_phone ON client.id = client_phone.id_client " +
                        "INNER JOIN client_zone ON client_phone.id_client = client_zone.id_client "+
                        "where client.id = " +a.getId();
        String delete_Prod = 
                        "DELETE client_prod from client " +
                        "INNER JOIN client_prod ON client.id = client_prod.id_client " +
                        "WHERE client.id = " +a.getId();
        String delete =
                        "DELETE FROM client " +
                        "where client.id = " +a.getId()+"";
                
        try {
          st = con.createStatement();
          int n = 0;
          n = st.executeUpdate(delete_Prod);
          n = st.executeUpdate(delete_datos);
          n = st.executeUpdate(delete);
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
        ArrayList<Cliente> res = new ArrayList<>();
        conn = new Connector();
        conn.conectar();
        con = conn.getConexion();
        String list = "SELECT distinct client.id id_client, client.name nombre, client.surname apellido, "
                    + "client.dir direccion, zone.id id_zona, zone.name zona FROM client "
                    + "INNER JOIN client_phone ON client.id=client_phone.id_client "
                    + "INNER JOIN client_zone ON client.id=client_zone.id_client "
                    + "INNER JOIN zone ON client_zone.id_zone=zone.id "
                    + "WHERE concat(client.name,' ',client.surname,' ',client.dir,' ',zone.name,' ',phone) "
                    + "like '%"+ description + "%'";

        try {
          st = con.createStatement();

          rt = st.executeQuery(list);
          //mientras rt tenga datos se iterara
          while (rt.next()) {
            Cliente cliente = new Cliente();
            Zona zona = new Zona();
            ArrayList<Telefono> telefonos = buscarTelefonos(rt.getInt(1));
            zona.setId(rt.getInt("id_zona"));
            zona.setNombre(rt.getString("zona"));
            cliente.setId(rt.getInt("id_client"));
            cliente.setNombre(rt.getString("nombre"));
            cliente.setApellidos(rt.getString("apellido"));
            cliente.setDireccion(rt.getString("direccion"));
            cliente.setZona(zona);
            cliente.setTelefonos(telefonos);
            res.add(cliente);
          }
          conn.desconectar();
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, ex);
        }
        return res;
    }

    @Override
    public Cliente search(Cliente a) {
        conn = new Connector();
        conn.conectar();
        con = conn.getConexion();
        String search =  "SELECT client.id id_client, client.name nombre, client.surname apellido, "
                        + "client.dir direccion, zone.id id_zona, zone.name zona FROM client "
                        + "INNER JOIN client_zone ON client.id=client_zone.id_client "
                        + "INNER JOIN zone ON client_zone.id_zone=zone.id "
                        + "WHERE client.name = '"+a.getNombre()+"' "
                        + "AND   client.surname = '"+a.getApellidos()+"' "
                        + "AND   client.dir  = '"+a.getDireccion()+"'";
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
   
//    Result is an Array of only Clients by client table
      public ArrayList<Cliente> listClient(String description) {
        ArrayList<Cliente> res = new ArrayList<>();
        conn = new Connector();
        conn.conectar();
        con = conn.getConexion();
        String list = "SELECT * FROM client "
                    + "WHERE concat(client.name,' ',client.surname,' ',client.dir) "
                    + "like '%"+ description + "%' ORDER BY client.surname";

        try {
          st = con.createStatement();

          rt = st.executeQuery(list);
          //mientras rt tenga datos se iterara
          while (rt.next()) {
            Cliente cliente = new Cliente();
            cliente.setId(rt.getInt(1));
            cliente.setNombre(rt.getString(2));
            cliente.setApellidos(rt.getString(3));
            cliente.setDireccion(rt.getString(4));
            res.add(cliente);
          }
          conn.desconectar();
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, ex);
        }
        return res;
    }

    
    
//    Another method that only use de id_client to find one.
    public Cliente searchById(Cliente a) {
        conn = new Connector();
        conn.conectar();
        con = conn.getConexion();
        String search =  "SELECT client.id id_client, client.name nombre, client.surname apellido, "
                        + "client.dir direccion, zone.id id_zona, zone.name zona FROM client "
                        + "INNER JOIN client_zone ON client.id=client_zone.id_client "
                        + "INNER JOIN zone ON client_zone.id_zone=zone.id "
                        + "WHERE client.id = '"+a.getId()+"' ";
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
    
    
    
    
    public Cliente idCliente(Cliente a){
        Cliente cli = new Cliente();
        conn = new Connector();
        conn.conectar();
        con = conn.getConexion();
        String search =  "SELECT client.id id_client, client.name nombre, client.surname apellido "
                        + "FROM client "
                        + "WHERE name = '"+a.getNombre()+"' "
                        + "AND   surname = '"+a.getApellidos()+"' "
                        + "AND   dir  = '"+a.getDireccion()+"'";
        try {
          st = con.createStatement();
          rt = st.executeQuery(search);
          if (rt.next()) {
              cli.setId(rt.getInt("id_client"));
              cli.setNombre(rt.getString("nombre"));
              cli.setApellidos(rt.getString("apellido"));
          }
          conn.desconectar();
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null,
                  Errors.errorMessage(ex.getErrorCode(), ex.getMessage()));
        }
        return cli; 
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
    
    
     
    public ArrayList<Telefono> buscarTelefonos(int id_cli){
        ArrayList<Telefono> res = new ArrayList();
        String buscar = "SELECT client_phone.id id,phone from client_phone "
                      + "INNER JOIN client ON client_phone.id_client = client.id "
                      + "WHERE client_phone.id_client = "+id_cli;
        Connector conn = new Connector();
        conn.conectar();
        Connection con = conn.getConexion();
       try {
          Statement st = con.createStatement();
          ResultSet rt = st.executeQuery(buscar);
          while (rt.next()) {
              Telefono telf = new Telefono();
              telf.setId(rt.getInt("id"));
              telf.setCliente_id(id_cli);
              telf.setTelefono(rt.getInt("phone"));
              res.add(telf);
          }
          conn.desconectar();
       } catch (SQLException ex) {
           Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
       }
       return res;
    }
    
    
    //VALIDACIONES
    public boolean validarTelefono(int nro,int id_cli){
        boolean res = true;
        String buscar = "";
        if(id_cli == 0){
            buscar = "SELECT * from client_phone "
                   + "WHERE phone = '"+ nro+"'";
        }else{
            buscar = "SELECT * from client_phone "
                   + "WHERE phone = '"+ nro+"' "
                    + "AND  id_client != '"+id_cli+"'";
        }
       
        
        conn = new Connector();
        conn.conectar();
        con = conn.getConexion();
       try {
           st = con.createStatement();
           rt = st.executeQuery(buscar);
          if (rt.next()) {
              res = false;
          }
          conn.desconectar();
       } catch (SQLException ex) {
           Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
       }
       return res;
    }
}
