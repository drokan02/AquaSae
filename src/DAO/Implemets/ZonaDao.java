/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Implemets;

/**
 *
 * @author jimibilibob
 *
 */
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
public class ZonaDao implements Dao<Zona>{
    
   private Connector conn;
   private Connection con;
   protected Statement st;
   protected ResultSet rt;
   protected PreparedStatement pst;
    @Override
    public String insert(Zona a) {
        String res = "";
        String insert = "INSERT into zone(name) VALUES(?)";
    
        conn = new Connector();
        conn.conectar();
        con = conn.getConexion();
       try {
            pst = con.prepareStatement(insert);
            pst.setString(1, a.getNombre());
            int n = pst.executeUpdate();
            if (n > 0) {
              conn.desconectar();
             
                  res = "Zona registrada correctamente";
             
            }
       } catch (SQLException ex) {
           res = Errors.errorMessage(ex.getErrorCode(), ex.getMessage());
       }
       return res;
    }
    

    @Override
    public String edit(Zona a) {
    String res = "";
    conn = new Connector();
    conn.conectar();
    con = conn.getConexion();
    String edit = "UPDATE zone SET "
            + " name = '" + a.getNombre()+ "' "
            + "WHERE id = " + a.getId()+ "";
    try {
      st = con.createStatement();
      int n = st.executeUpdate(edit);
      if (n > 0) {
        res = "Zona editada correctamente";
        conn.desconectar();
      }
    } catch (SQLException ex) {
      res = Errors.errorMessage(ex.getErrorCode(), ex.getMessage());
    }
    return res;
    }

    
    // TODO Implement softdelete.
    @Override
    public String delete(Zona a) {
    String res = "";
    conn = new Connector();
    conn.conectar();
    con = conn.getConexion();
    String delete = "DELETE from zone "
            + "WHERE id = '" + a.getId() + "'";
    try {
      st = con.createStatement();
      int n = st.executeUpdate(delete);
      if (n > 0) {
        res = "Zona eliminada correctamente";
        conn.desconectar();
      }
    } catch (SQLException ex) {
      res = Errors.errorMessage(ex.getErrorCode(), ex.getMessage());
    }
    return res;
    }

    @Override
    public ArrayList<Zona> list(String description) {
        ArrayList<Zona> res = new ArrayList<>();
    conn = new Connector();
    conn.conectar();
    con = conn.getConexion();
    String list = "SELECT id, name "
            + "FROM zone "
            + "WHERE concat(id,' ',name) like '%"
            + description + "%'";

    try {
      st = con.createStatement();
      
      rt = st.executeQuery(list);
      //mientras rt tenga datos se iterara
      while (rt.next()) {
        //accedes en el orden q espesificaste en el select rt.getInt(1) = id_user;
        res.add(new Zona(rt.getInt(1), rt.getString(2)));
      }
      System.out.println("Lista de zonas recuperadas correctamente");
      conn.desconectar();
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, ex);
    }
    return res;
    }

    @Override
    public Zona search(Zona a) {
    conn = new Connector();
    conn.conectar();
    con = conn.getConexion();
    String search = "SELECT id, name "
            + "FROM zone "
            + "WHERE id = '" + a.getId() + "' "
//            Trying with logical connector OR, but at the begin was AND
            + "or   name = '" + a.getNombre() + "'";
    try {
      st = con.createStatement();
      rt = st.executeQuery(search);
      if (rt.next()) {
        a.setId(rt.getInt(1));
        a.setNombre(rt.getString(2));
      }
      conn.desconectar();
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null,
              Errors.errorMessage(ex.getErrorCode(), ex.getMessage()));
    }
    return a;  
    }
    
}
