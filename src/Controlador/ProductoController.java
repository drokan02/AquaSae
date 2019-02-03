
package Controlador;

import DAO.Implemets.ProductoDao;
import Modelo.Producto;
import Vista.Principal;
import Vista.Productos.FormProducto;
import Vista.Productos.ListaProductos;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


public class ProductoController implements KeyListener,ActionListener,MouseListener{
    private final ListaProductos listProductos;
    private final FormProducto formProducto;
    private ArrayList<Producto> productos;
    private Producto producto;
    
    public ProductoController(ListaProductos listaProductos){
        this.listProductos = listaProductos;
        this.formProducto = new FormProducto();
        agregarEventos();
        llenarTabla();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == listProductos.btnProducto){
            limpiar();
            formProducto.txtTitulo.setText("REGISTRAR PRODUCTO");
            formProducto.btnRegistrar.setText("Registrar");
            MenuController.cambiarPanel(formProducto);
        }
        
        if(e.getSource()== formProducto.btnRegistrar){
            String registrar = formProducto.btnRegistrar.getText();
            if(registrar.equals("Registrar")){
                registrarProducto();
            }else{
                modificarProducto();
            }
        }
        
        if(e.getSource() == formProducto.btnCancelar){
             MenuController.cambiarPanel(listProductos);
        }
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {
        if(ke.getSource() == formProducto.txtNombre) {
            Validador.validarLetrasMasEspacioMasNumero(ke);
        }
        
        if(ke.getSource() == formProducto.txtDescripcion) {
            //Validador.validarLetrasMasEspacioMasNumero(ke);
        }
        
        if(ke.getSource() == formProducto.txtPrecio) {
            Validador.validarMoneda(ke, formProducto.txtPrecio.getText());
        }
        
        if(ke.getSource() == formProducto.txtStock) {
           Validador.validarNumero(ke);
        }
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {

    }

    @Override
    public void keyReleased(KeyEvent ke) {
        if(ke.getSource() == listProductos.txtBuscar){
            //Validador.validarLetrasMasEspacioMasNumero(ke);
            buscarProducto();
        }
    }


    @Override
    public void mouseClicked(MouseEvent me) {
        int fila = listProductos.jtProductos.rowAtPoint(me.getPoint());
        int columna = listProductos.jtProductos.columnAtPoint(me.getPoint());
        //eliminar fila
        if( columna == 6){
            int resp = JOptionPane.showConfirmDialog(listProductos, "¿Esta seguro de Eliminar?", "Alerta!", 
                                                    JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
            if(resp == 0){
                eliminarProducto(fila);
            }
        //editar fila
        }else if(columna == 5){
            formProducto.txtTitulo.setText("EDITAR CLIENTE");
            formProducto.btnRegistrar.setText("Modificar");
            editarProducto(fila);
            MenuController.cambiarPanel(formProducto);
        //ver numeros telefonicos
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {

    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent me) {

    }

    @Override
    public void mouseExited(MouseEvent me) {

    }

    private void agregarEventos() {
        formProducto.txtNombre.addKeyListener(this);
        formProducto.txtDescripcion.addKeyListener(this);
        formProducto.txtPrecio.addKeyListener(this);
        formProducto.txtStock.addKeyListener(this);
        listProductos.txtBuscar.addKeyListener(this);
        
        formProducto.btnRegistrar.addActionListener(this);
        formProducto.btnCancelar.addActionListener(this);
        listProductos.btnProducto.addActionListener(this);
        
        listProductos.jtProductos.addMouseListener(this);
        
        formProducto.setFocusTraversalPolicy(new FocusTraversalOnArray(
                new Component[]{
                    formProducto.txtNombre,
                    formProducto.txtDescripcion,
                    formProducto.txtStock,
                    formProducto.txtPrecio,
                })
        );
    }

    private void llenarTabla() {
        productos = new ProductoDao().list(listProductos.txtBuscar.getText());
        DefaultTableModel modelo = new DefaultTableModel(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        listProductos.jtProductos.setDefaultRenderer(Object.class, new Render());
        listProductos.jtProductos.setModel(modelo);
        modelo.addColumn("N°");
        modelo.addColumn("Nombre");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Precio(Bs)");
        modelo.addColumn("Stock");
        modelo.addColumn(" ");
        modelo.addColumn(" ");
        //llena las filas con datos de la base de datos
        int cont = 1;
        for (Producto prod : productos) {
            Object [] fila = new Object[7];
            fila[0] = cont++;
            fila[1] = prod.getNombre();
            fila[2] = prod.getDescripcion();
            fila[3] = prod.getPrecio();
            fila[4] = prod.getStock();
            fila[5] = Principal.btEditar;
            fila[6] = Principal.btEliminar;
            modelo.addRow(fila);
        }
        setTamanioColumna(listProductos.jtProductos.getColumnModel());
    }
    
    private void setTamanioColumna(TableColumnModel col){
       col.getColumn(0).setPreferredWidth(5);
       col.getColumn(0).setCellRenderer(Tabla.alinearCentro());
       col.getColumn(1).setPreferredWidth(300);
       col.getColumn(1).setCellRenderer(Tabla.alinearCentro());
       col.getColumn(2).setPreferredWidth(300);
       col.getColumn(2).setCellRenderer(Tabla.alinearCentro());
       col.getColumn(3).setPreferredWidth(100);
       col.getColumn(3).setCellRenderer(Tabla.alinearDerecha());
       col.getColumn(4).setPreferredWidth(100);
       col.getColumn(4).setCellRenderer(Tabla.alinearDerecha());
       col.getColumn(5).setPreferredWidth(3);
       col.getColumn(6).setPreferredWidth(3);
    }

    private void limpiar(){
        formProducto.txtNombre.setText("");
        formProducto.txtDescripcion.setText("");
        formProducto.txtPrecio.setText("");
        formProducto.txtStock.setText("");
    }
    
    private void registrarProducto() {
        String mensaje = validarCampos();
        if(mensaje.equals("")){
            producto = nuevoProducto();
             mensaje = new ProductoDao().insert(producto);
             MenuController.cambiarPanel(listProductos);
            JOptionPane.showMessageDialog(listProductos, mensaje);
            llenarTabla();
            
        }else{
            JOptionPane.showMessageDialog(formProducto, mensaje);
        }
    }

    private void editarProducto(int fila){
       producto = productos.get(fila);
       formProducto.txtNombre.setText(producto.getNombre());
       formProducto.txtDescripcion.setText(producto.getDescripcion());
       formProducto.txtPrecio.setText(producto.getPrecio()+"");
       formProducto.txtStock.setText(producto.getStock()+"");
    }
    private void modificarProducto() {
        String mensaje = validarCampos();
        if(mensaje.equals("")){
             producto.setNombre(getNombre());
             producto.setDescripcion(getDescripcion());
             producto.setPrecio(getPrecio());
             producto.setStock(getStock());
             mensaje = new ProductoDao().edit(producto);
             MenuController.cambiarPanel(listProductos);
             JOptionPane.showMessageDialog(listProductos, mensaje);
             llenarTabla();
            
        }else{
            JOptionPane.showMessageDialog(formProducto, mensaje);
        }   
    }

    private void eliminarProducto(int fila){
        Producto prod = productos.get(fila);
         String mensaje = new ProductoDao().delete(prod);
         JOptionPane.showMessageDialog(listProductos, mensaje);
         llenarTabla();
    }
    
    private void buscarProducto(){
        String busqueda = getBuscador();
        productos = new ProductoDao().list(busqueda);
        llenarTabla();
    }
    
    private Producto nuevoProducto() {
        Producto prod = new Producto();
        prod.setNombre(getNombre());
        prod.setDescripcion(getDescripcion());
        prod.setPrecio(getPrecio());
        prod.setStock(getStock());
        return prod;
    }

    private String getNombre() {
        return formProducto.txtNombre.getText();
    }

    private String getDescripcion() {
        return formProducto.txtDescripcion.getText();
    }

    private double getPrecio() {
        String aux = formProducto.txtPrecio.getText();
        double res = 0;
        if(!aux.equals(""))
            try {
              res = Double.parseDouble(aux);  
            } catch (NumberFormatException e) {
                
            }      
        return res;
    }

    private int getStock() {
        String aux = formProducto.txtStock.getText();
        if(!aux.equals(""))
            return Integer.parseInt(aux);
        else
            return 0;
    }
    
    private String getBuscador(){
        return listProductos.txtBuscar.getText();
    }
    
    //VALIDAR CAMPOS DEL FORMULARIO
    private String validarCampos() {
        String mensaje = "";
        if(getNombre().equals("")){
            mensaje += "Debe ingresar el nombre  \n";
        }
        
        if(getDescripcion().equals("")){
            mensaje += "Debe ingresar la Descripcion \n";
        }
        
        if(getPrecio() == 0){
            mensaje += "Debe ingresar el Precio \n";
        }
        
        if(getStock() == 0){
            mensaje += "Debe ingresar el stock  \n";
        }
        return mensaje;
    }
}
