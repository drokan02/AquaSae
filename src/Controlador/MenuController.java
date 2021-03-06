/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.Implemets.PedidoDao;
import Modelo.Pedido;
import Modelo.Telefono;
import Vista.Clientes.FormCliente;
import Vista.Clientes.ListaCliente;
import Vista.Pedido.FormPedido;
import Vista.Pedido.ListaPedido;
import Vista.Principal;
import Vista.Productos.FormProducto;
import Vista.Productos.ListaProductos;
import Vista.Reporte.Reportes;
import Vista.VistaInicio;
import Vista.Zonas.ListaZonas;
import java.awt.Color;
import static java.awt.Frame.ICONIFIED;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import rsbuttom.RSButtonMetro;

/**
 *
 * @author DroKaN
 */
public class MenuController implements ActionListener,WindowListener{
    Principal principal;
    ArrayList<Pedido> pedidos;
    public MenuController(Principal principal){
        this.principal = principal;
        pedidos = new ArrayList<>();
        agregarEventos();
        agregarLogo();
    }
    
    
    public void mostrar(){
        principal.btInicio.requestFocus();
        //principal.setExtendedState(MAXIMIZED_BOTH);
        VistaInicio inicio = new VistaInicio();
        new InicioController(inicio,principal);
        cambiarPanel(inicio);
        principal.setVisible(true);
        principal.setLocationRelativeTo(null);
        //principal.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == principal.btInicio){
            VistaInicio inicio = new VistaInicio();
            seleccionarBoton(principal.btInicio);
            InicioController iniCont = new InicioController(inicio,principal);
            cambiarPanel(inicio);
        }
        
        if(e.getSource() == principal.btZonas){
            seleccionarBoton(principal.btZonas);
            ListaZonas listZona = new ListaZonas();
            cambiarPanel(listZona);
            ZonaController zonCont = new ZonaController(listZona);
              
        }
        
        if(e.getSource() == principal.btClientes){
            ListaCliente listCli = new ListaCliente();
            cambiarPanel(listCli);
            ClienteController cliCont = new ClienteController(listCli);
            seleccionarBoton(principal.btClientes);
            
        }
        
        if(e.getSource() == principal.btProductos){
            ListaProductos listProd = new ListaProductos();
            cambiarPanel(listProd);
            ProductoController ProdCont = new ProductoController(listProd);
            seleccionarBoton(principal.btProductos);
        }
        
        if(e.getSource() == principal.btPedidos){
            ListaPedido listPed = new ListaPedido();
            cambiarPanel(listPed);
            PedidoController pedCont = new PedidoController(listPed);
            seleccionarBoton(principal.btPedidos);
        }
        
        if(e.getSource() == principal.btReporte){
            seleccionarBoton(principal.btReporte);
            Reportes reportes = new Reportes();
            cambiarPanel(reportes);
            ReporteController repCont = new ReporteController(reportes,principal);
        }
        
        if(e.getSource() == principal.btCerrar){
            Consola.ejecutarCMD("\\xampp\\mysql_stop.bat");
            System.exit(0);
            //principal.dispose();
        }
        
        if(e.getSource() == principal.btMinim){
            principal.setExtendedState(ICONIFIED);
        }
    }


    @Override
    public void windowOpened(WindowEvent we) {
        VistaInicio inicio = new VistaInicio();
        seleccionarBoton(principal.btInicio);
        cambiarPanel(inicio);
        InicioController iniCont = new InicioController(inicio,principal);
        pedidos = new PedidoDao().listAlert("");
        if(!pedidos.isEmpty()){
            String mensaje ="Tiene clientes con productos que caducan hoy!";
            for(Pedido pedido: pedidos){
                ArrayList<Telefono> telefonos= pedido.getCliente().getTelefonos();
                mensaje= mensaje+"\n"+"Cliente: "+pedido.getCliente().getNombre()+" "+pedido.getCliente().getApellidos()+
                       "\nFecha de pedido: "+pedido.getFecha_pedido()+"\n"+"Teléfonos: ";
                for(Telefono telefono: telefonos){
                    mensaje = mensaje+Integer.toString(telefono.getTelefono())+"  ";
                }
            }
             JOptionPane.showMessageDialog(null, mensaje);
        }
    }

    @Override
    public void windowClosing(WindowEvent we) {

    }

    @Override
    public void windowClosed(WindowEvent we) {

    }

    @Override
    public void windowIconified(WindowEvent we) {
        
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
        principal.setVisible(true);
    }

    @Override
    public void windowActivated(WindowEvent we) {

    }

    @Override
    public void windowDeactivated(WindowEvent we) {

    }
    
     private void agregarEventos(){
        principal.btInicio.addActionListener(this);
       // principal.btInicio.addMouseListener(this);
       principal.btZonas.addActionListener(this);
        principal.btClientes.addActionListener(this);
       // principal.btClientes.addMouseListener(this);
        principal.btPedidos.addActionListener(this);
       // principal.btPedidos.addMouseListener(this);
        principal.btProductos.addActionListener(this);
       // principal.btProductos.addMouseListener(this);
        principal.btReporte.addActionListener(this);
       // principal.btReporte.addMouseListener(this);
       principal.btCerrar.addActionListener(this);
       
       principal.btMinim.addActionListener(this);
       principal.addWindowListener(this);
    }
    
    private void seleccionarBoton(RSButtonMetro bt){
        principal.btClientes.setColorNormal(new Color(239,238,244));
        principal.btClientes.setColorHover(new Color(204,204,204));
        principal.btClientes.setColorPressed(new Color(204,204,204));
        principal.btClientes.setSelected(false);
         
        principal.btInicio.setColorNormal(new Color(239,238,244));
        principal.btInicio.setColorHover(new Color(204,204,204));
        principal.btInicio.setColorPressed(new Color(204,204,204));
        principal.btInicio.setSelected(false);
        
        principal.btPedidos.setColorNormal(new Color(239,238,244));
        principal.btPedidos.setColorHover(new Color(204,204,204));
        principal.btPedidos.setColorPressed(new Color(204,204,204));
        principal.btPedidos.setSelected(false);
        
        principal.btProductos.setColorNormal(new Color(239,238,244));
        principal.btProductos.setColorHover(new Color(204,204,204));
        principal.btProductos.setColorPressed(new Color(204,204,204));
        principal.btProductos.setSelected(false);
        
        principal.btReporte.setColorNormal(new Color(239,238,244));
        principal.btReporte.setColorHover(new Color(204,204,204));
        principal.btReporte.setColorPressed(new Color(204,204,204));
        principal.btReporte.setSelected(false);
        
        principal.btZonas.setColorNormal(new Color(239,238,244));
        principal.btZonas.setColorHover(new Color(204,204,204));
        principal.btZonas.setColorPressed(new Color(204,204,204));
        principal.btZonas.setSelected(false);
        
        bt.setColorNormal(new Color(204,204,204));
        bt.setColorHover(new Color(204,204,204));
        bt.setColorPressed(new Color(204,204,204));
        bt.setSelected(true);
    }
    
    public static void cambiarPanel(JPanel content) {
        JPanel container = Principal.pnlPrincipal;
        container.removeAll();
        container.revalidate();
        container.repaint();
        container.add(content);
        container.revalidate();
        container.repaint();
    }

    private void agregarLogo() {
        JLabel logo = principal.lbLogo;
        Complemento.nuevoIcono("logo.png", logo, true);
    }
}

