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
import Modelo.Pedido;
import Modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import static java.time.Clock.system;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author DroKaN
 */
public class PedidoDao implements Dao<Pedido>{

   private Connector conn;
   private Connection con;
   protected Statement st;
   protected ResultSet rt;
   protected PreparedStatement pst;
   private java.util.Date fecha = new Date();
    @Override
    public String insert(Pedido a) {
        String res = "";
        String insert = "INSERT INTO `client_prod` (`id_client`, `id_prod`,"
                + " `fecha_pedido`, `quantity`, `total`, `delivered`) "
                + "VALUES (?,?,?,?,?,?);";
    
        conn = new Connector();
        conn.conectar();
        con = conn.getConexion();
       try {
            pst = con.prepareStatement(insert);
            pst.setInt(1, a.getCliente().getId());
            pst.setInt(2, a.getProducto().getId());
            pst.setString(3, formatDate());
            pst.setInt(4, a.getCantidad());
            pst.setDouble(5, a.getTotal());
            pst.setInt(6, a.getEntregado());
            int n = pst.executeUpdate();
            if (n > 0) {
              conn.desconectar();
             
                  res = "Pedido registrado correctamente";
             
            }
       } catch (SQLException ex) {
           res = Errors.errorMessage(ex.getErrorCode(), ex.getMessage());
       }
       System.out.println(res);
       return res;
    }

    @Override
    public String edit(Pedido a) {
        String res = "";
    conn = new Connector();
    conn.conectar();
    con = conn.getConexion();
    String edit = "UPDATE client_prod SET "
            + " id_client = " + a.getCliente().getId()+ ", "
            + " id_prod = " + a.getProducto().getId()+ ", "
            + " quantity = " + a.getCantidad()+ ", "
//            Total is not editable
            + " total = '" + a.getTotal()+ "' "
            
//            Check this boolean atribute
//            + " delivered = '" + a.isEntregado()+ "' "
//            TODO change state from pedido. Column 'delivered is not set'
//            En la interface "Registrar Orden" vamos a usar como PK la fecha.
            + "WHERE id = " + a.getId()+ "";
    try {
      st = con.createStatement();
      int n = st.executeUpdate(edit);
      if (n > 0) {
        res = "Pedido editado correctamente";
        conn.desconectar();
      }
    } catch (SQLException ex) {
      res = Errors.errorMessage(ex.getErrorCode(), ex.getMessage());
    }
    System.out.println(res);
    return res;
    }

    @Override
    public String delete(Pedido a) {
        String res = "";
        conn = new Connector();
        conn.conectar();
        con = conn.getConexion();
        String delete = "DELETE from client_prod "
                + "WHERE id = '" + a.getId() + "'";
        try {
          st = con.createStatement();
          int n = st.executeUpdate(delete);
          if (n > 0) {
            res = "Pedido eliminado correctamente";
            conn.desconectar();
          }
        } catch (SQLException ex) {
          res = Errors.errorMessage(ex.getErrorCode(), ex.getMessage());
        }
        return res;

    }

    //this method return a list of Pedidos with today's date
    @Override
    public ArrayList<Pedido> list(String description) {
        ArrayList<Pedido> res = new ArrayList<>();
        conn = new Connector();
        conn.conectar();
        con = conn.getConexion();
//        This query is to find description in client or prodict tables.
        String list = "SELECT DISTINCT client_prod.id, client_prod.id_client, "
                + "client_prod.id_prod, DATE_FORMAT(client_prod.fecha_pedido, '%Y-%m-%d') , client_prod.quantity,"
                + "client_prod.total, client_prod.delivered "
                + "FROM client_prod INNER JOIN client ON client_prod.id_client=client.id "
                + "INNER JOIN client_zone ON client_zone.id_client=client.id "
                + "INNER JOIN zone ON client_zone.id_zone=zone.id "
                + "WHERE DATE(client_prod.fecha_pedido) = CURDATE() AND concat(client.name,' ',client.surname,' ', zone.name,"
                + "' ',client_prod.fecha_pedido,' ',client_prod.quantity) like '%"
//                + description + "%' GROUP BY client_prod.id ORDER BY zone.name ";
                + description + "%' ORDER BY zone.name ";
    try {
      st = con.createStatement();
      
      rt = st.executeQuery(list);
      //mientras rt tenga datos se iterara
      while (rt.next()) {
        //accedes en el orden q especificaste en el select rt.getInt(1) = id_user;
        Producto producto = new Producto();
        ProductoDao p= new ProductoDao();
        Cliente cliente = new Cliente();
        ClienteDao c = new ClienteDao();
        cliente.setId(rt.getInt(2));
        producto.setId(rt.getInt(3));
//        Añadimos todos los datos del objeto cliente y producto
        cliente = c.searchById(cliente);

        producto = p.search(producto);
 
        
        producto.setId(rt.getInt(3));
        res.add(new Pedido(rt.getInt(1), cliente,
                            producto, rt.getDate(4),
                            rt.getInt(5), rt.getDouble(6),
                            rt.getInt(7)));
      }
      conn.desconectar();
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, ex);
    }
    return res;
    }
    
//    Lista de pedidos cuya fecha de vencimiento es hoy. Fecha de entrega + 10 días.
    public ArrayList<Pedido> listAlert(String description) {
        ArrayList<Pedido> res = new ArrayList<>();
        conn = new Connector();
        conn.conectar();
        con = conn.getConexion();
//        This query is to find description in client or prodict tables.
        String list = "SELECT DISTINCT client_prod.id, client_prod.id_client, "
                + "client_prod.id_prod, DATE_FORMAT(client_prod.fecha_pedido, '%Y-%m-%d') , client_prod.quantity,"
                + "client_prod.total, client_prod.delivered "
                + "FROM client_prod INNER JOIN client ON client_prod.id_client=client.id "
                + "INNER JOIN client_zone ON client_zone.id_client=client.id "
                + "INNER JOIN zone ON client_zone.id_zone=zone.id "
                + "WHERE DATE(client_prod.fecha_pedido) = DATE_SUB(CURDATE(),INTERVAL 11 DAY) AND concat(client.name,' ',client.surname,' ', zone.name,"
                + "' ',client_prod.fecha_pedido,' ',client_prod.quantity) like '%"
                + description + "%' ORDER BY zone.name ";
    try {
      st = con.createStatement();
      
      rt = st.executeQuery(list);
      //mientras rt tenga datos se iterara
      while (rt.next()) {
        //accedes en el orden q especificaste en el select rt.getInt(1) = id_user;
        Producto producto = new Producto();
        ProductoDao p= new ProductoDao();
        Cliente cliente = new Cliente();
        ClienteDao c = new ClienteDao();
        cliente.setId(rt.getInt(2));
        producto.setId(rt.getInt(3));
//        Añadimos todos los datos del objeto cliente y producto
        cliente = c.searchById(cliente);

        producto = p.search(producto);
 
        
        producto.setId(rt.getInt(3));
        res.add(new Pedido(rt.getInt(1), cliente,
                            producto, rt.getDate(4),
                            rt.getInt(5), rt.getDouble(6),
                            rt.getInt(7)));
      }
      conn.desconectar();
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, ex);
    }
    System.out.println("-------------------->"+res.size());
    return res;
    }
    
    
    public ArrayList<Pedido> listToDeliver(String description) {
        ArrayList<Pedido> res = new ArrayList<>();
        conn = new Connector();
        conn.conectar();
        con = conn.getConexion();
//        This query is to find description in client or prodict tables.
        String list = "SELECT DISTINCT client_prod.id, client_prod.id_client, "
                + "client_prod.id_prod, DATE_FORMAT(client_prod.fecha_pedido, '%Y-%m-%d') , client_prod.quantity,"
                + "client_prod.total, client_prod.delivered "
                + "FROM client_prod INNER JOIN client ON client_prod.id_client=client.id "
                + "INNER JOIN client_zone ON client_zone.id_client=client.id "
                + "INNER JOIN zone ON client_zone.id_zone=zone.id "
                + "WHERE DATE(client_prod.fecha_pedido) = DATE_SUB(CURDATE(),INTERVAL 1 DAY) AND concat(client.name,' ',client.surname,' ', zone.name,"
                + "' ',client_prod.fecha_pedido,' ',client_prod.quantity) like '%"
//                + description + "%' GROUP BY client_prod.id ORDER BY zone.name ";
                + description + "%' ORDER BY zone.name ";
    try {
      st = con.createStatement();
      
      rt = st.executeQuery(list);
      //mientras rt tenga datos se iterara
      while (rt.next()) {
        //accedes en el orden q especificaste en el select rt.getInt(1) = id_user;
        Producto producto = new Producto();
        ProductoDao p= new ProductoDao();
        Cliente cliente = new Cliente();
        ClienteDao c = new ClienteDao();
        cliente.setId(rt.getInt(2));
        producto.setId(rt.getInt(3));
//        Añadimos todos los datos del objeto cliente y producto
        cliente = c.searchById(cliente);

        producto = p.search(producto);
 
        
        producto.setId(rt.getInt(3));
        res.add(new Pedido(rt.getInt(1), cliente,
                            producto, rt.getDate(4),
                            rt.getInt(5), rt.getDouble(6),
                            rt.getInt(7)));
      }
      conn.desconectar();
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, ex);
    }
    return res;
    }

    @Override
    public Pedido search(Pedido a) {
    conn = new Connector();
    conn.conectar();
    con = conn.getConexion();
    String search = "SELECT client_prod.id id_pedido, client_prod.id_client, "
                + "client_prod.id_prod, client_prod.fecha_pedido, client_prod.quantity cantidad,"
                + "client_prod.total, client_prod.delivered"
                + " FROM client_prod "
                + "WHERE id = '" + a.getId() + "' ";
//            Trying with logical connector OR, but at the begin was AND
//            + "or   name = '" + a.getNombre() + "'";
//    String search = "SELECT id, name "
//            + "FROM zone "
//            + "WHERE concat(id,' ',name) like '%" + a.getNombre()+ "%' ";
    
    try {
      st = con.createStatement();
      rt = st.executeQuery(search);
      if (rt.next()) {
        Producto producto = new Producto();
        ProductoDao p = new ProductoDao();
        Cliente cliente = new Cliente();
        ClienteDao c = new ClienteDao();
        cliente.setId(rt.getInt(2));
        producto.setId(rt.getInt(3));
        
        cliente = c.searchById(cliente);
        producto = p.search(producto);
        a = new Pedido(rt.getInt(1), cliente,
                            producto, rt.getDate(4),
                            rt.getInt(5), rt.getDouble(6),
                            rt.getInt(7));

      }
      conn.desconectar();
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null,
              Errors.errorMessage(ex.getErrorCode(), ex.getMessage()));
    }
    return a;  
    }
    
    public String formatDate() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return sdf.format(date);
    }
    
   public ArrayList<Cliente> nuevosPedidos(String fecha) {
        ArrayList<Cliente> res = new ArrayList<>();
        conn = new Connector();
        conn.conectar();
        con = conn.getConexion();
//        This query is to find description in client or prodict tables.
        String list = "SELECT client_prod.id_client FROM client_prod "
                + "WHERE fecha_pedido = '"+fecha+"'";
    try {
      st = con.createStatement();
      
      rt = st.executeQuery(list);
      //mientras rt tenga datos se iterara
      while (rt.next()) {
        Cliente cliente = new Cliente();
        ClienteDao c = new ClienteDao();
        cliente.setId(rt.getInt(1));
        cliente = c.searchById(cliente);
        res.add(cliente);
      }
      conn.desconectar();
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, ex);
    }
    return res;
    }
    
}   
