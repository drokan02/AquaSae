    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import Vista.Pedido.ListaPedido;
import Vista.Principal;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class PedidoController implements KeyListener,ActionListener,MouseListener{
    
    private final ListaPedido listPedido;
    private final FormPedido formPedido;
    private ArrayList <Pedido> pedidos;
    private ArrayList <Cliente> clientes;
    private ArrayList <Producto> productos;
    // aux is to determinate the id's pedido to update
    private Pedido aux;
    // This variable has code value of actual Zona
    int actualRow;
    
    public PedidoController(ListaPedido listPedido){
        this.listPedido = listPedido;
        this.formPedido = new FormPedido();
        pedidos = new ArrayList();
        actualRow = -1;
        aux = new Pedido();
        agregarEventos();
        llenarTabla();
        formPedido.txtDireccion.setEditable(false);
        formPedido.txtZona.setEditable(false);
        formPedido.txtPrecio.setEditable(false);
        formPedido.txtTotal.setEditable(false);
        formPedido.txtStock.setEditable(false);
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
             if(e.getSource() == listPedido.txtBuscar){
             Validador.validarLetrasMasEspacioMasNumero(e);
             llenarTabla();
            }
             if(e.getSource() == formPedido.txtCantidad){
             Validador.validarNumero(e);
                 
            }
            
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == listPedido.btnPedido){
            System.out.println("Pressed Button");
            llenarCombos();
            formPedido.txtTitulo.setText("REGISTRAR PEDIDO");
            formPedido.btnRegistrar.setText("Registrar");
            MenuController.cambiarPanel(formPedido);
            
        }
        
        if(e.getSource()== formPedido.btnRegistrar){
            if(formPedido.btnRegistrar.getText().equals("Actualizar")){
                actualizarPedido(aux);
                llenarTabla();
            }if(formPedido.btnRegistrar.getText().equals("Registrar")){
                registrarPedido();
            }
            
        }
        
        if(e.getSource() == formPedido.btnCancelar){
             MenuController.cambiarPanel(listPedido);
             vaciarFormulario();
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        int fila = listPedido.jtPedidos.rowAtPoint(me.getPoint());
        int columna = listPedido.jtPedidos.columnAtPoint(me.getPoint());
        DefaultTableModel modelo = (DefaultTableModel) listPedido.jtPedidos.getModel();
//        // In variable 'zonaSeleccionada' I just storage the value 'id'(codigo) from the row selected.
        String pedidoSeleccionado = modelo.getValueAt(fila, 0).toString();
        pedidoSeleccionado.trim();
        actualRow = Integer.parseInt(pedidoSeleccionado);
        aux = pedidos.get(actualRow-1);
        //eliminar fila
        if( columna == 8){
            int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro de Eliminar?", "Alerta!", 
                                                    JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
            if( resp == 0){
                eliminarPedido(aux.getId());
            }            
        }else if(columna == 7){
            // Check dates to edit
            llenarCombos();
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
        formPedido.txtDireccion.addKeyListener(this);
        formPedido.txtZona.addKeyListener(this);
        formPedido.txtPrecio.addKeyListener(this);
        formPedido.txtCantidad.addKeyListener(this);
        formPedido.txtTotal.addKeyListener(this);
        listPedido.txtBuscar.addKeyListener(this);
        formPedido.btnCancelar.addActionListener(this);
        formPedido.btnRegistrar.addActionListener(this);
        listPedido.btnPedido.addActionListener(this);
        listPedido.jtPedidos.addMouseListener(this);
        formPedido.setFocusTraversalPolicy(new FocusTraversalOnArray(
                new Component[]{formPedido.comCliente
                })
        );
    }

    private void actualizarPedido(Pedido aux) {
      PedidoDao p = new PedidoDao();
      Pedido pedidoEditar = new Pedido();
      pedidoEditar = aux;
      String mensaje = validarCampos();
      if(mensaje.equals("")){
            for(Cliente cliente : clientes){
                      String fullName = cliente.getNombre()+ " " + cliente.getApellidos();
                      String selectedClient = formPedido.comCliente.getSelectedItem();
                      if((fullName.equals(selectedClient))){
                          for(Producto producto : productos){
                              String nomProd = producto.getNombre();
                              String selectedProd = formPedido.comProducto.getSelectedItem();
                              if(nomProd.equals(selectedProd)){
                                  
                                  int stockAntiguo = producto.getStock()+pedidoEditar.getCantidad();
                                  int stockTemporal;
                                  producto.setStock(stockAntiguo);
                                  System.out.println("____-------------______---------------->"+pedidoEditar.getCantidad()+"------"+stockAntiguo);
                                  stockTemporal = calcularStock(Integer.parseInt(formPedido.txtCantidad.getText()),
                                    producto);
                                  mensaje = validarStock(stockTemporal);
                                  if(mensaje.equals("")){
                                        pedidoEditar.setCantidad(Integer.parseInt(formPedido.txtCantidad.getText()));
                                        pedidoEditar.setCliente(cliente);
                                        pedidoEditar.setProducto(producto);
                                        pedidoEditar.setTotal(Double.parseDouble(formPedido.txtTotal.getText()));
                                        mensaje = p.edit(pedidoEditar);
                                        producto.setStock(stockTemporal);
                                        new ProductoDao().edit(producto);
                                        vaciarFormulario();
                                        MenuController.cambiarPanel(listPedido);
                                        llenarTabla();
                                        JOptionPane.showMessageDialog(listPedido, mensaje);
                                        
                                  }
                                  
                                    else{
                                    JOptionPane.showMessageDialog(listPedido, mensaje);
                                    }               
                              }
                          }

                      }
      }
      }
      else{
            JOptionPane.showMessageDialog(listPedido, mensaje);
      }
    }

    private void llenarTabla() {
        DefaultTableModel modelo = new DefaultTableModel(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        listPedido.jtPedidos.setDefaultRenderer(Object.class, new Render());
        listPedido.jtPedidos.setModel(modelo);
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
        String descripcion = listPedido.txtBuscar.getText();
        pedidos = p.list(descripcion);
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
        setTamanioCol(listPedido.jtPedidos.getColumnModel());
    }

    private void registrarPedido() {
      PedidoDao p = new PedidoDao();  
      Pedido newPedido = new Pedido();
      String mensaje = validarCampos();
      if(mensaje.equals("")){
            for(Cliente cliente : clientes){
                String fullName = cliente.getNombre()+ " " + cliente.getApellidos();
                String selectedClient = formPedido.comCliente.getSelectedItem();
                if((fullName.equals(selectedClient))){
                    for(Producto producto : productos){
                        String nomProd = producto.getNombre();
                        String selectedProd = formPedido.comProducto.getSelectedItem();
                        if(nomProd.equals(selectedProd)){
                            int stockTemporal;
                            stockTemporal = calcularStock(Integer.parseInt(formPedido.txtCantidad.getText()),
                                    producto);
                            System.out.println("--------------------->>>>"+stockTemporal);
                            mensaje = validarStock(stockTemporal);
                            if(mensaje.equals("")){
                                    newPedido.setCantidad(Integer.parseInt(formPedido.txtCantidad.getText()));
                                    newPedido.setCliente(cliente);
                                    newPedido.setProducto(producto);
                                    producto.setStock(stockTemporal);
                                    newPedido.setTotal(Double.parseDouble(formPedido.txtTotal.getText()));
                                    mensaje = p.insert(newPedido);
//                                    mensaje= mensaje +"\n" +new ProductoDao().edit(producto);
                                    vaciarFormulario();
                                    MenuController.cambiarPanel(listPedido);
                                    llenarTabla();
                                    JOptionPane.showMessageDialog(listPedido, mensaje);
                                    
                            }
                            else{
                                    JOptionPane.showMessageDialog(listPedido, mensaje);
                                }
                        }
                    }

                }
            }
        }
      else{
            JOptionPane.showMessageDialog(listPedido, mensaje);
      }
    }

    private void eliminarPedido(int eliminar) {
      PedidoDao p = new PedidoDao();
      Pedido pedidoEliminar = new Pedido();
      String mensaje;
      pedidoEliminar.setId(eliminar);
      mensaje = p.delete(pedidoEliminar);
      JOptionPane.showMessageDialog(listPedido, mensaje);
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
                            formPedido.txtStock.setText(Integer.toString(producto.getStock()));
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
        formPedido.txtStock.setText(String.valueOf(pedidoEditar.getProducto().getStock()));
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
        if(!cantidadCadena.equals("") && !precioCadena.equals("")){
            System.out.println(Integer.parseInt(formPedido.txtCantidad.getText()));
            cantidad = Integer.parseInt(formPedido.txtCantidad.getText());
            precio = Double.parseDouble(formPedido.txtPrecio.getText());
            total = precio*cantidad;
            formPedido.txtTotal.setText(total.toString());
        } else {
        }
    }

    private String validarCampos(){
        String mensaje = "";
        if(formPedido.txtDireccion.getText().equals("") && formPedido.txtZona.getText().equals("")){
            mensaje += "Debe seleccionar un cliente  \n";
        }
        if(formPedido.txtPrecio.getText().equals("") && formPedido.txtStock.getText().equals("")){
            mensaje += "Debe seleccionar un producto  \n";
        }
        if(formPedido.txtCantidad.getText().equals("")){
            mensaje += "Debe ingresar la cantidad  \n";
        }
        
        return mensaje;
    }
    
    private int calcularStock(int cantidad, Producto prod){
        return prod.getStock()-cantidad;
    }
    
    private String validarStock(int stockTemporal){
        String mensaje;
        if(stockTemporal<0){
            mensaje = "La cantidad debe ser menor o igual al stock del producto";
        }
        else{
            mensaje = "";
        }
        return mensaje;
    }
    
}


