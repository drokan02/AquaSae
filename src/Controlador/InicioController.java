
package Controlador;

import DAO.Implemets.ClienteDao;
import DAO.Implemets.PedidoDao;
import DAO.Implemets.ProductoDao;
import DAO.Implemets.ZonaDao;
import Modelo.Cliente;
import Modelo.Pedido;
import Modelo.Producto;
import Modelo.Zona;
import Vista.Pedido.FormPedido;
import Vista.Principal;
import Vista.VistaInicio;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class InicioController implements KeyListener,ActionListener,MouseListener{
    
    private final Principal principal;
    private final VistaInicio vistaInicio;
    private final FormPedido formPedido;
    private ArrayList <Pedido> pedidos;
    private ArrayList <Cliente> nuevosP;
    private ArrayList <Cliente> clientes;
    private ArrayList <Producto> productos;
    private Pedido aux;
    // This variable has code value of actual Zona
    int actualRow;
    
    public InicioController(VistaInicio vistaInicio,Principal principal1){
        this.vistaInicio = vistaInicio;
        this.formPedido = new FormPedido();
        this.principal = principal1;
        pedidos = new ArrayList();
        actualRow = -1;
        agregarEventos();
        llenarTabla();
        formPedido.txtDireccion.setEditable(false);
        formPedido.txtZona.setEditable(false);
        formPedido.txtPrecio.setEditable(false);
        formPedido.txtTotal.setEditable(false);
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
            if(e.getSource() == formPedido.txtCantidad){
                calcularTotal();
            }
             if(e.getSource() == vistaInicio.txtBuscar){
             Validador.validarLetrasMasEspacioMasNumero(e);
             llenarTabla();
            }
             if(e.getSource() == formPedido.txtCantidad){
             Validador.validarNumero(e);
        }
            
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == vistaInicio.btnImprimir){
           Map params = new HashMap();
                params.put("fecha", fecha(-1));
                String reporte = "zonaPedidos";
                new Reporte().mostrarReporte(reporte, params,principal);
       } 
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        int fila = vistaInicio.jtPedidos.rowAtPoint(me.getPoint());
        int columna = vistaInicio.jtPedidos.columnAtPoint(me.getPoint());
        DefaultTableModel modelo = (DefaultTableModel) vistaInicio.jtPedidos.getModel();
//        // In variable 'zonaSeleccionada' I just storage the value 'id'(codigo) from the row selected.
        String pedidoSeleccionado = modelo.getValueAt(fila, 0).toString();
        pedidoSeleccionado.trim();
        System.out.println("Pedido seleccionado para ser eliminado" + pedidoSeleccionado);
        actualRow = Integer.parseInt(pedidoSeleccionado);
        aux = pedidos.get(actualRow-1);
        //eliminar fila
        if( columna == 8){
            int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro de Eliminar?", "Alerta!", 
                                                    JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
            if( resp == 0){
                // In variable 'eliminar' I just storage the value 'id'(codigo) from the row selected.
                actualRow = Integer.parseInt(pedidoSeleccionado);
                eliminarPedido(actualRow);
            }            
        }else if(columna == 7){
            // Check dates to edit
            llenarCombos();
            int codigoEditar = Integer.parseInt(modelo.getValueAt(fila, 0).toString());
            formPedido.btnRegistrar.setText("Actualizar");
            formularioEditar(aux.getId());
            formPedido.txtTitulo.setText("EDITAR PEDIDO");
            MenuController.cambiarPanel(formPedido);
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
    private void agregarEventos(){
        vistaInicio.btnImprimir.addActionListener(this);
        vistaInicio.txtBuscar.addKeyListener(this);
        vistaInicio.jtPedidos.addMouseListener(this);
        formPedido.setFocusTraversalPolicy(new FocusTraversalOnArray(
                new Component[]{formPedido.comCliente
                })
        );
    }

    private void actualizarPedido(int row) {
      PedidoDao p = new PedidoDao();
      Pedido pedidoEditar = new Pedido();
      
    for(Cliente cliente : clientes){
              String fullName = cliente.getNombre()+ " " + cliente.getApellidos();
              String selectedClient = formPedido.comCliente.getSelectedItem();
              if((fullName.equals(selectedClient))){
                  for(Producto producto : productos){
                      String nomProd = producto.getNombre();
                      String selectedProd = formPedido.comProducto.getSelectedItem();
                      if(nomProd.equals(selectedProd)){
                          pedidoEditar.setId(row);
                          pedidoEditar.setCantidad(Integer.parseInt(formPedido.txtCantidad.getText()));
                          pedidoEditar.setCliente(cliente);
                          pedidoEditar.setProducto(producto);
                          pedidoEditar.setEntregado(0);
                          pedidoEditar.setTotal(Double.parseDouble(formPedido.txtTotal.getText()));
                      }
                  }

              }
          }

      p.edit(pedidoEditar);
      vaciarFormulario();
    }

    private void llenarTabla() {
        DefaultTableModel modelo = new DefaultTableModel(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        vistaInicio.jtPedidos.setDefaultRenderer(Object.class, new Render());
        vistaInicio.jtPedidos.setModel(modelo);
        modelo.addColumn("N° Pedido");
        modelo.addColumn("Zona");
        modelo.addColumn("Cliente");
        modelo.addColumn("Producto");
        modelo.addColumn("Fecha");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Total");
        modelo.addColumn("");
        modelo.addColumn("");
        PedidoDao p = new PedidoDao();
        String descripcion = vistaInicio.txtBuscar.getText();
        pedidos = p.listToDeliver(descripcion);
        int contador=1;
        for (Pedido pedido : pedidos){
            Object [] fila = new Object[10];
            fila[0] = contador;
            fila[1] = pedido.getCliente().getZona().getId()+" "+pedido.getCliente().getZona().getNombre();
            fila[2] = pedido.getCliente().getNombre()+ " " +pedido.getCliente().getApellidos();
            fila[3] = pedido.getProducto().getNombre();
            fila[4] = pedido.getFecha_pedido();
            fila[5] = pedido.getCantidad();
            fila[6] = pedido.getTotal();
            fila[7] = Principal.btEditar;
            fila[8] = Principal.btEliminar;
            modelo.addRow(fila);
            contador++;
        }
        setTamanioCol(vistaInicio.jtPedidos.getColumnModel());
    }

    private void nuevosPedidos(){
        PedidoDao p = new PedidoDao();
        nuevosP = p.nuevosPedidos(fecha(-10));
        if(nuevosP.size()>0){
            JOptionPane.showMessageDialog(vistaInicio, "De algunos clientes esta por caducar su producto ");
        }
    }
    
    private void registrarPedido() {
      PedidoDao p = new PedidoDao();  
      Pedido newPedido = new Pedido();
      for(Cliente cliente : clientes){
          String fullName = cliente.getNombre()+ " " + cliente.getApellidos();
          String selectedClient = formPedido.comCliente.getSelectedItem();
          if((fullName.equals(selectedClient))){
              for(Producto producto : productos){
                  String nomProd = producto.getNombre();
                  String selectedProd = formPedido.comProducto.getSelectedItem();
                  if(nomProd.equals(selectedProd)){
                      newPedido.setCantidad(Integer.parseInt(formPedido.txtCantidad.getText()));
                      newPedido.setCliente(cliente);
                      newPedido.setProducto(producto);
                      newPedido.setEntregado(0);
                      newPedido.setTotal(Double.parseDouble(formPedido.txtTotal.getText()));
                  }
              }
              
          }
      }
//      String nombreReg = formPedido.txtNombre.getText(); 
//      newPedido.setNombre(nombreReg);
      //Review this because the code's zona is not generating automatically.
//      
      p.insert(newPedido);
//      
//
//
//
      vaciarFormulario();
    }

    private void eliminarPedido(int eliminar) {
      PedidoDao p = new PedidoDao();
      Pedido pedidoEliminar = new Pedido();
      pedidoEliminar.setId(eliminar);
      p.delete(pedidoEliminar);
      llenarTabla();
    }

    private void setTamanioCol(TableColumnModel col) {
      col.getColumn(0).setPreferredWidth(50);
      col.getColumn(0).setCellRenderer(Tabla.alinearCentro());
      col.getColumn(1).setPreferredWidth(200);
      col.getColumn(1).setCellRenderer(Tabla.alinearCentro());
      col.getColumn(2).setPreferredWidth(200);
      col.getColumn(2).setCellRenderer(Tabla.alinearCentro());
      col.getColumn(3).setPreferredWidth(200);
      col.getColumn(3).setCellRenderer(Tabla.alinearCentro());
      col.getColumn(4).setPreferredWidth(100);
      col.getColumn(4).setCellRenderer(Tabla.alinearCentro());
      col.getColumn(5).setPreferredWidth(50);
      col.getColumn(5).setCellRenderer(Tabla.alinearDerecha());
      col.getColumn(6).setPreferredWidth(50);
      col.getColumn(6).setCellRenderer(Tabla.alinearDerecha());
      col.getColumn(7).setPreferredWidth(5);
      col.getColumn(8).setPreferredWidth(5);
    }

    private void vaciarFormulario() {
        formPedido.txtDireccion.setText("");
        formPedido.txtCantidad.setText("");
        formPedido.txtPrecio.setText("");
        formPedido.txtTotal.setText("");
        formPedido.txtZona.setText("");
        formPedido.comCliente.removeAll();
        formPedido.comProducto.removeAll();
        
    }

    private void llenarCombos() {
        ClienteDao c = new ClienteDao();
        clientes = c.list("");
        ProductoDao p = new ProductoDao();
        productos = p.list("");
        
         for(Cliente cliente : clientes){
            formPedido.comCliente.addItem(cliente.getNombre()+" "+ cliente.getApellidos());
        }
        
        for(Producto producto : productos){
            formPedido.comProducto.add(producto.getNombre());
        }
       
        formPedido.comCliente.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent arg0){
                if(arg0.getStateChange()==ItemEvent.SELECTED){
                    for (Cliente cliente : clientes){
                        Zona zona = new Zona();
                        ZonaDao z = new ZonaDao();
                        String fullName = cliente.getNombre()+" "+cliente.getApellidos();
                        if(formPedido.comCliente.getSelectedItem().equals(fullName)){
                            formPedido.txtDireccion.setText(cliente.getDireccion());
                            formPedido.txtZona.setText(cliente.getZona().getNombre());
                        }
                    }
                }
            }
        });
        formPedido.comProducto.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent arg0){
                if(arg0.getStateChange()==ItemEvent.SELECTED){
                    for(Producto producto : productos){
                        if(formPedido.comProducto.getSelectedItem().equals(producto.getNombre())){
                            formPedido.txtPrecio.setText(Double.toString(producto.getPrecio()));
                        }
                    }
                }
                calcularTotal();
            }
        });
    }

    private void formularioEditar(int codigoEditar) {
        Pedido pedidoEditar = new Pedido();
        PedidoDao p = new PedidoDao();
        pedidoEditar.setId(codigoEditar);
        pedidoEditar = p.search(pedidoEditar);
        String fullName = pedidoEditar.getCliente().getNombre()+ " " + pedidoEditar.getCliente().getApellidos();
        formPedido.comCliente.select(fullName);
        formPedido.txtDireccion.setText(pedidoEditar.getCliente().getDireccion());
        formPedido.txtZona.setText(pedidoEditar.getCliente().getZona().getNombre());
        formPedido.comProducto.select(pedidoEditar.getProducto().getNombre());
        formPedido.txtCantidad.setText(String.valueOf(pedidoEditar.getCantidad()));
        formPedido.txtPrecio.setText(String.valueOf(pedidoEditar.getProducto().getPrecio()));
        formPedido.txtTotal.setText(String.valueOf(pedidoEditar.getTotal()));
    }
    
    private void calcularTotal(){
        String cantidadCadena = formPedido.txtCantidad.getText();
        String precioCadena = formPedido.txtPrecio.getText();
        int cantidad = 0;
        Double precio = 0.0;
        Double total = 0.0;
    //  if(!(cantidadCadena != null && !cantidadCadena.trim().isEmpty()) || (precioCadena != null && !precioCadena.trim().isEmpty())){
        if(!((cantidadCadena.isEmpty()) && (precioCadena.isEmpty()))){
            System.out.println(Integer.parseInt(formPedido.txtCantidad.getText()));
            cantidad = Integer.parseInt(formPedido.txtCantidad.getText());
            precio = Double.parseDouble(formPedido.txtPrecio.getText());
            total = precio*cantidad;
            formPedido.txtTotal.setText(total.toString());
        }
    }
//  Method to become '0' into NO, and '1' into SI  
    private String ceroFalse(int estado){
        String res= "NO";
        if(estado==1) res = "SI" ;
        if(estado==0) res = "NO" ;
        return res;
    }
    
    private String fecha(int dias){
        Calendar hoy = Calendar.getInstance();
        hoy.add(Calendar.DATE, dias);
        Date d = hoy.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
        JOptionPane.showMessageDialog(principal, sdf.format(d));
        return sdf.format(d);
    }
}
