/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Zonas;

import Vista.Productos.*;
import Vista.Pedido.*;
import Vista.*;

/**
 *
 * @author DroKaN
 */
public class ListaZonas extends javax.swing.JPanel {

    /**
     * Creates new form VistaInicio
     */
    public ListaZonas() {
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
        jsClientes = new javax.swing.JScrollPane();
        jtZonas = new rojerusan.RSTableMetro();
        btnZona = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(128, 128, 131));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("ZONAS DE DISTRIBUCION");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1630, 77));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Buscar:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, -1, -1));

        txtNombre.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 410, -1));

        jsClientes.setBorder(null);

        jtZonas = new rojerusan.RSTableMetro(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        jtZonas.setModel(new javax.swing.table.DefaultTableModel(
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
        jtZonas.setFuenteFilas(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jtZonas.setGridColor(new java.awt.Color(102, 102, 102));
        jtZonas.setGrosorBordeFilas(0);
        jtZonas.setGrosorBordeHead(0);
        jtZonas.setRowHeight(30);
        jtZonas.getTableHeader().setReorderingAllowed(false);
        jsClientes.setViewportView(jtZonas);

        add(jsClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 210, 1280, 740));

        btnZona.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnZona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_Address_50px.png"))); // NOI18N
        btnZona.setText("Nueva Zona");
        btnZona.setBorder(null);
        btnZona.setBorderPainted(false);
        btnZona.setContentAreaFilled(false);
        btnZona.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnZona.setFocusPainted(false);
        btnZona.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btnZona.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnZona.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_Address_50px_1.png"))); // NOI18N
        btnZona.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        add(btnZona, new org.netbeans.lib.awtextra.AbsoluteConstraints(1380, 130, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnZona;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jsClientes;
    public rojerusan.RSTableMetro jtZonas;
    public javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
