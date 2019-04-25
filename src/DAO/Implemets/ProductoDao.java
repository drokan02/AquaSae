
package DAO.Implemets;

import DAO.Dao;
import Modelo.Connector;
import Modelo.Errors;
import Modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProductoDao implements Dao<Producto>{
    private Connector conn;
    private Connection con;
    protected Statement st;
    protected ResultSet rt;
    protected PreparedStatement pst;
    @Override
    public String insert(Producto a) {
        String res = "";
        String insert = "INSERT into product(name,product.desc,price,stock) VALUES(?,?,?,?)";
        conn = new Connector();
        conn.conectar();
        con = conn.getConexion();
       try {
            pst = con.prepareStatement(insert);
            pst.setString(1, a.getNombre());
            pst.setString(2, a.getDescripcion());
            pst.setDouble(3, a.getPrecio());
            pst.setInt(4, a.getStock());
            int n = pst.executeUpdate();
            if (n > 0) {
              conn.desconectar();   
              res = "Producto registrado correctamente";
              
            }
       } catch (SQLException ex) {
           res = Errors.errorMessage(ex.getErrorCode(), ex.getMessage());
       }
       return res;
    }

    @Override
    public String edit(Producto a) {
       
        String res = "";
        conn = new Connector();
        conn.conectar();
        con = conn.getConexion();
        String edit = "UPDATE product SET "
                    + "name  = '" + a.getNombre() + "', "
                    + "product.desc = '"+a.getDescripcion()+"', "
                    + "price = '" + a.getPrecio() + "', "
                    + "stock = '" + a.getStock()+ "' "
                    + "WHERE id = " + a.getId() + "";
               
        try {
             System.out.println("producto edidato"+a.getId());
          st = con.createStatement();
          int n = st.executeUpdate(edit) ;
          if (n > 0) {
            conn.desconectar();
            res = "Producto modificado correctamente";
          }
        } catch (SQLException ex) {
             System.out.println("error al editar el producto del pedido"+ex.getMessage());
          res = Errors.errorMessage(ex.getErrorCode(), ex.getMessage());
        }
        return res;
    }

    @Override
    public String delete(Producto a) {
        String res = "";
        conn = new Connector();
        conn.conectar();
        con = conn.getConexion();
       
        String delete = "DELETE FROM product " +
                        "where id = " +a.getId()+"";
                
        try {
          st = con.createStatement();
          int n = st.executeUpdate(delete);
          if (n > 0) {
            res = "Producto Eliminado correctamente";
            conn.desconectar();
          }
        } catch (SQLException ex) {
          res = Errors.errorMessage(ex.getErrorCode(), ex.getMessage());
          if(ex.getErrorCode() == 1451){
              res = "El producto que desea eliminar esta siendo usada por algunos pedidos registados, Por favor elimine primero los pedidos"
                      + " que estén registrados con ese producto";
              return res;
          }
        }
        return res;
    }

    @Override
    public ArrayList<Producto> list(String description) {
        ArrayList<Producto> res = new ArrayList<>();
        conn = new Connector();
        conn.conectar();
        con = conn.getConexion();
        String list = "SELECT * "
                    + "FROM product "
                    + "WHERE concat(name,' ',product.desc,' ',stock) "
                    + "like '%"+ description + "%' "
                    + "ORDER BY id DESC";

        try {
          st = con.createStatement();

          rt = st.executeQuery(list);
          //mientras rt tenga datos se iterara
          while (rt.next()) {
            Producto prod = new Producto();         
            prod.setId(rt.getInt("id"));
            prod.setNombre(rt.getString("name"));
            prod.setDescripcion(rt.getString("desc"));
            prod.setPrecio(rt.getDouble("price"));
            prod.setStock(rt.getInt("stock"));
            res.add(prod);
          }
          conn.desconectar();
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, ex);
        }
        return res;
    }

    @Override
    public Producto search(Producto a) {
        Producto prod = new Producto();
        conn = new Connector();
        conn.conectar();
        con = conn.getConexion();
        String list = "SELECT * "
                    + "FROM product "
                    + "WHERE id = "+a.getId()+"";

        try {
          st = con.createStatement();

          rt = st.executeQuery(list);
          //mientras rt tenga datos se iterara
          if (rt.next()) {  
            prod.setId(rt.getInt("id"));
            prod.setNombre(rt.getString("name"));
            prod.setDescripcion(rt.getString("desc"));
            prod.setPrecio(rt.getDouble("price"));
            prod.setStock(rt.getInt("stock"));

          }
          conn.desconectar();
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, ex);
        }
        return prod;
    }
    
}
