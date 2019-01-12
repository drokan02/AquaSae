/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.Implemets.ClienteDao;
import DAO.Implemets.ZonaDao;
import Modelo.Cliente;
import Modelo.Telefono;
import Modelo.Zona;
import Vista.Clientes.FormCliente;
import Vista.Clientes.ListaCliente;
import Vista.Principal;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author DroKaN
 */
public class ClienteController implements KeyListener,ActionListener,MouseListener{
    private final ListaCliente listCliente;
    private FormCliente formCliente;
    private ArrayList<Cliente> clientes;
    private ArrayList<Zona> zonas;
    private Cliente cli;
    public ClienteController(ListaCliente listCliente){
        this.listCliente = listCliente;
        this.formCliente = new FormCliente();
        agregarEventos();
        llenarTabla();

        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == listCliente.btnCliente){
            formCliente.txtTitulo.setText("REGISTRAR CLIENTE");
            formCliente.btnRegistrar.setText("Registrar");
            agregarZonas();
           
            MenuController.cambiarPanel(formCliente);
        }
        
        if(e.getSource()== formCliente.btnRegistrar){
            String registrar = formCliente.btnRegistrar.getText();
            if(registrar.equals("Registrar")){
                registrarCliente();
            }else{
                modificarCliente();
            }
        }
        
        if(e.getSource() == formCliente.btnCancelar){
             MenuController.cambiarPanel(listCliente);
        }
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {
        
        if(ke.getSource() == formCliente.txtNombre){
           Validador.validarLetrasMasEspacio(ke);
        }
        
        if(ke.getSource() == formCliente.txtApellido){
            Validador.validarLetrasMasEspacio(ke);
        }
        
        if(ke.getSource() == formCliente.txtDireccion){
            //Validador.validarNumerosLetras(ke);
        }
        
        if(ke.getSource() == formCliente.txtTelefono){
            Validador.validarNumero(ke);
        }
        
        if(ke.getSource() == listCliente.txtBuscar){
            //Validador.validarLetrasMasEspacioMasNumero(ke);
            System.out.println(getBuscador());

            buscarClientes();
        }
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
       
        
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        if(ke.getSource() == listCliente.txtBuscar){
            //Validador.validarLetrasMasEspacioMasNumero(ke);
            System.out.println(getBuscador());

            buscarClientes();
        }
    }
    
     @Override
    public void mouseClicked(MouseEvent me) {
        int fila = listCliente.jtClientes.rowAtPoint(me.getPoint());
        int columna = listCliente.jtClientes.columnAtPoint(me.getPoint());
        //eliminar fila
        if( columna == 7){
            int resp = JOptionPane.showConfirmDialog(listCliente, "¿Esta seguro de Eliminar?", "Alerta!", 
                                                    JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
            if(resp == 0){
                eliminarCliente(fila);
            }
        //editar fila
        }else if(columna == 6){
            formCliente.txtTitulo.setText("EDITAR CLIENTE");
            formCliente.btnRegistrar.setText("Modificar");
            agregarZonas();
            editarCliente(fila);
            MenuController.cambiarPanel(formCliente);
        //ver numeros telefonicos
        }else if (columna == 5){
            mostrarTelefonos(fila);
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
    
    
    
    
     private void agregarEventos(){
        formCliente.txtNombre.addKeyListener(this);
        formCliente.txtApellido.addKeyListener(this);
        formCliente.txtDireccion.addKeyListener(this);
        formCliente.txtTelefono.addKeyListener(this);
        formCliente.btnCancelar.addActionListener(this);
        formCliente.btnRegistrar.addActionListener(this);
        listCliente.btnCliente.addActionListener(this);
        listCliente.jtClientes.addMouseListener(this);
        listCliente.txtBuscar.addKeyListener(this);
        formCliente.setFocusTraversalPolicy(new FocusTraversalOnArray(
                new Component[]{formCliente.txtNombre, formCliente.txtApellido,
                    formCliente.txtDireccion,formCliente.comZona,formCliente.txtTelefono,
                    formCliente.txtTelefono1,formCliente.txtTelefono2,formCliente.txtTelefono3,
                    formCliente.txtTelefono4
                })
        );
    }
     
     private void agregarZonas(){
         if(formCliente.comZona.getItemCount() == 0){
                zonas = new ZonaDao().list("");
                addZona("");
                for (Zona zona : zonas) {
                    addZona(zona.getNombre());
                }
           }
         
     }
     
     private void addZona(String zona){
         formCliente.comZona.add(zona);
     }
    //llenamos la tabla con datos de la base de datos
    private void llenarTabla(){
        clientes = new ClienteDao().list(listCliente.txtBuscar.getText());
        DefaultTableModel modelo = new DefaultTableModel(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        listCliente.jtClientes.setDefaultRenderer(Object.class, new Render());
        listCliente.jtClientes.setModel(modelo);
        modelo.addColumn("N°");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Direccion");
        modelo.addColumn("Zona");
        modelo.addColumn(" ");
        modelo.addColumn(" ");
        modelo.addColumn(" ");
        //llena las filas con datos de la base de datos
        int cont = 1;
        for (Cliente cliente : clientes) {
            Object [] fila = new Object[8];
            fila[0] = cont++;
            fila[1] = cliente.getNombre();
            fila[2] = cliente.getApellidos();
            fila[3] = cliente.getDireccion();
            fila[4] = cliente.getZona().getNombre();
            fila[5] = Principal.btTelefonos;
            fila[6] = Principal.btEditar;
            fila[7] = Principal.btEliminar;
            modelo.addRow(fila);
        }
        setTamanioColumna(listCliente.jtClientes.getColumnModel());
    }
    
    private void setTamanioColumna(TableColumnModel col){
       col.getColumn(0).setPreferredWidth(5);
       col.getColumn(1).setPreferredWidth(200);
       col.getColumn(2).setPreferredWidth(200);
       col.getColumn(3).setPreferredWidth(150);
       col.getColumn(4).setPreferredWidth(150);
       col.getColumn(5).setPreferredWidth(3);
       col.getColumn(6).setPreferredWidth(3);
       col.getColumn(7).setPreferredWidth(3);
    }
    
    private void registrarCliente(){
        cli = nuevoCliente();
        String mensaje = validarCampos();
        if(mensaje.equals("")){
             mensaje = new ClienteDao().insert(cli);
             MenuController.cambiarPanel(listCliente);
            JOptionPane.showMessageDialog(listCliente, mensaje);
            llenarTabla();
            
        }else{
            JOptionPane.showMessageDialog(formCliente, mensaje);
        }   
    }
    
    private void editarCliente(int i){
        cli = clientes.get(i);
        formCliente.txtNombre.setText(cli.getNombre());
        formCliente.txtApellido.setText(cli.getApellidos());
        formCliente.txtDireccion.setText(cli.getDireccion());
        formCliente.comZona.select(cli.getZona().getNombre());
        editarNumerosTelefonicos(cli.getTelefonos());
    }
    
    private void editarNumerosTelefonicos(ArrayList<Telefono> tels){
        ArrayList<JTextField> txtTelfs= new ArrayList();
        txtTelfs.add(formCliente.txtTelefono);
        txtTelfs.add(formCliente.txtTelefono1);
        txtTelfs.add(formCliente.txtTelefono2);
        txtTelfs.add(formCliente.txtTelefono3);
        txtTelfs.add(formCliente.txtTelefono4);
        int n = 0;
        for (Telefono t : tels) {
            String telefono = "";
            if(t.getTelefono() != 0){
                telefono += t.getTelefono();
            }
            txtTelfs.get(n).setText(telefono);
            n++;
        }
    }
    
    private void modificarCliente(){
        String mensaje = validarCampos();
        if(mensaje.equals("")){
             cli.setNombre(getNombre());
             cli.setApellidos(getApellido());
             cli.setDireccion(getDireccion());
             cli.setZona(getZona());
             cli.setTelefonos(modificarNumero(cli.getTelefonos()));
             mensaje = new ClienteDao().edit(cli);
             MenuController.cambiarPanel(listCliente);
             JOptionPane.showMessageDialog(listCliente, mensaje);
             llenarTabla();
            
        }else{
            JOptionPane.showMessageDialog(formCliente, mensaje);
        }   
    }
    
    private ArrayList<Telefono> modificarNumero(ArrayList<Telefono> tels){
        ArrayList<Telefono> res = new ArrayList();
        ArrayList<JTextField> txtTelfs= new ArrayList();
        txtTelfs.add(formCliente.txtTelefono);
        txtTelfs.add(formCliente.txtTelefono1);
        txtTelfs.add(formCliente.txtTelefono2);
        txtTelfs.add(formCliente.txtTelefono3);
        txtTelfs.add(formCliente.txtTelefono4);
        int n = 0;
        for (Telefono t : tels) {
            Telefono aux = nuevoTelf(txtTelfs.get(n));
            aux.setId(t.getId());
            res.add(aux);
            n++;
        }
        return res;
    }
  
    private void eliminarCliente(int i){
         Cliente cli = clientes.get(i);
         String mensaje = new ClienteDao().delete(cli);
         JOptionPane.showMessageDialog(listCliente, mensaje);
         llenarTabla();
    }
    
    private void buscarClientes(){
        String busqueda = getBuscador();
        clientes = new ClienteDao().list(busqueda);
        llenarTabla();
    }
    
    private Cliente nuevoCliente(){
        Cliente cli = new Cliente();
        cli.setNombre(getNombre());
        cli.setApellidos(getApellido());
        cli.setDireccion(getDireccion());
        cli.setZona(getZona());
        cli.addTelefono(getTelf1());
        cli.addTelefono(getTelf2());
        cli.addTelefono(getTelf3());
        cli.addTelefono(getTelf4());
        cli.addTelefono(getTelf5());
        return cli;
    }

    
    private String getNombre(){
        return formCliente.txtNombre.getText();
    }
    
    private String getApellido(){
        return formCliente.txtApellido.getText();
    }
    
    private String getDireccion(){
        return formCliente.txtDireccion.getText();
    }
    
    private Zona getZona(){
        int i = formCliente.comZona.getSelectedIndex()-1;
        return zonas.get(i);
    }
    
    private String getBuscador(){
        return listCliente.txtBuscar.getText();
    }
    private Telefono getTelf1(){
        return nuevoTelf(formCliente.txtTelefono);
    }
    
    private Telefono getTelf2(){
        return nuevoTelf(formCliente.txtTelefono1);
    }
    private Telefono getTelf3(){
        return nuevoTelf(formCliente.txtTelefono2);
    }
    private Telefono getTelf4(){
        return nuevoTelf(formCliente.txtTelefono3);
    }
    private Telefono getTelf5(){
        return nuevoTelf(formCliente.txtTelefono4);
    }
    
    private Telefono nuevoTelf(JTextField telef){
        String aux = telef.getText();
        int telf = 0;
        if(!aux.equals("")){
            telf = Integer.parseInt(aux);
        }   
        Telefono t = new Telefono();
        t.setTelefono(telf);
        return t;
    }
    
    private void mostrarTelefonos(int fila){
        Cliente cli = clientes.get(fila);
        String aux = "Telefono";
        String telefs = "";
        for(int i = 0 ; i < cli.getTelefonos().size() ; i++){
            telefs += aux+"( "+(i+1)+" ) : "+cli.getTelefonos().get(i).getTelefono()+"\n";
        }
        JOptionPane.showMessageDialog(null, telefs);
    }
    
    
    //VALIDAR CAMPOS PARA REGISTRAR O EDITAR
    private String validarCampos(){
        String mensaje = "";
        if(getNombre().equals("")){
            mensaje += "Debe ingresar el nombre  \n";
        }
        if(getApellido().equals("")){
            mensaje += "Debe ingresar los apellidos \n";
        }
        if(getDireccion().equals("")){
            mensaje += "Debe ingresar la direccion  \n";
        }
        if(getZona().getNombre().equals("")){
            mensaje += "Debe seleccionar la zona \n";
        }
        if(getTelf1().getTelefono() == 0 && getTelf2().getTelefono() == 0 && 
           getTelf3().getTelefono() == 0 && getTelf4().getTelefono() == 0 && 
           getTelf5().getTelefono() == 0){
            mensaje += "Debe ingresar almenos el primer numero Telefonico \n";
        }else{
            
            if(getTelf1().getTelefono() > 0){
                
                if(!validarTelefono(getTelf1())){
                    mensaje += "Otro cliente ya tiene registrado el telefono(1) \n";
                }
            }
            
            if(getTelf2().getTelefono() > 0){
                if(!validarTelefono(getTelf2())){
                    mensaje += "Otro cliente ya tiene registrado el telefono(2) \n";
                }
            }
            
            if(getTelf3().getTelefono() > 0){
                if(!validarTelefono(getTelf3())){
                    mensaje += "Otro cliente ya tiene registrado el telefono(3) \n";
                }
            }
            
            if(getTelf4().getTelefono() > 0){
                if(!validarTelefono(getTelf4())){
                    mensaje += "Otro cliente ya tiene registrado el telefono(4) \n";
                }
            }
            
            if(getTelf5().getTelefono() > 0){
                if(!validarTelefono(getTelf5())){
                    mensaje += "Otro cliente ya tiene registrado el telefono(5) \n";
                }
            }
            
            
        }
        
        return mensaje;
    }
    
    private boolean validarTelefono(Telefono t){
        int telefono = t.getTelefono();
        int id_client = cli.getId();
        return new ClienteDao().validarTelefono(telefono,id_client);
    }
}
