/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Productos;

import Vista.Pedido.*;
import Vista.*;

/**
 *
 * @author DroKaN
 */
public class ListaProductos extends javax.swing.JPanel {

    /**
     * Creates new form VistaInicio
     */
    public ListaProductos() {
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

        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnCliente = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(128, 128, 131));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("PRODUCTOS");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1630, 77));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Buscar:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, -1, -1));

        txtNombre.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 410, -1));

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "Direccion", "Zona", "Telefono"
            }
        ));
        jTable1.setAutoscrolls(false);
        jTable1.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 1280, 730));

        btnCliente.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_New_Product_50px.png"))); // NOI18N
        btnCliente.setText("Nuevo Producto");
        btnCliente.setBorder(null);
        btnCliente.setBorderPainted(false);
        btnCliente.setContentAreaFilled(false);
        btnCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCliente.setFocusPainted(false);
        btnCliente.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btnCliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCliente.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_New_Product_50px_1.png"))); // NOI18N
        btnCliente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        add(btnCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 130, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    public javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
