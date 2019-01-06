/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Clientes;

import Vista.Pedido.*;
import Vista.*;

/**
 *
 * @author DroKaN
 */
public class ListaCliente extends javax.swing.JPanel {

    /**
     * Creates new form VistaInicio
     */
    public ListaCliente() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btEditar = new javax.swing.JButton();
        btTelefonos = new javax.swing.JButton();
        btEliminar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jsClientes = new javax.swing.JScrollPane();
        jtClientes = new rojerusan.RSTableMetro();
        txtNombre = new javax.swing.JTextField();
        btnCliente = new javax.swing.JButton();

        btEditar.setBackground(new java.awt.Color(255, 51, 0));
        btEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_Edit_Property_26px.png"))); // NOI18N
        btEditar.setBorderPainted(false);
        btEditar.setContentAreaFilled(false);
        btEditar.setFocusPainted(false);
        btEditar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_Edit_Property_26px.png"))); // NOI18N

        btTelefonos.setBackground(new java.awt.Color(255, 51, 0));
        btTelefonos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_Office_Phone_26px.png"))); // NOI18N
        btTelefonos.setBorderPainted(false);
        btTelefonos.setContentAreaFilled(false);
        btTelefonos.setFocusPainted(false);
        btTelefonos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_Office_Phone_26px.png"))); // NOI18N

        btEliminar.setBackground(new java.awt.Color(255, 51, 0));
        btEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_Close_Window_26px_5.png"))); // NOI18N
        btEliminar.setBorderPainted(false);
        btEliminar.setContentAreaFilled(false);
        btEliminar.setFocusPainted(false);
        btEliminar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_Close_Window_26px_5.png"))); // NOI18N

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(128, 128, 131));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("CLIENTES");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1630, 77));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Buscar:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, -1, -1));

        jsClientes.setBorder(null);

        jtClientes = new rojerusan.RSTableMetro(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        jtClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtClientes.setFuenteFilas(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jtClientes.setGridColor(new java.awt.Color(102, 102, 102));
        jtClientes.setGrosorBordeFilas(0);
        jtClientes.setGrosorBordeHead(0);
        jtClientes.setRowHeight(30);
        jtClientes.getTableHeader().setReorderingAllowed(false);
        jsClientes.setViewportView(jtClientes);

        add(jsClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 210, 1280, 740));

        txtNombre.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 410, -1));

        btnCliente.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_Add_User_Male_50px.png"))); // NOI18N
        btnCliente.setText("Nuevo Cliente");
        btnCliente.setBorder(null);
        btnCliente.setBorderPainted(false);
        btnCliente.setContentAreaFilled(false);
        btnCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCliente.setFocusPainted(false);
        btnCliente.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btnCliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCliente.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_Add_User_Male_50px_1.png"))); // NOI18N
        btnCliente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        add(btnCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 130, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btEditar;
    public javax.swing.JButton btEliminar;
    public javax.swing.JButton btTelefonos;
    public javax.swing.JButton btnCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jsClientes;
    public rojerusan.RSTableMetro jtClientes;
    public javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
