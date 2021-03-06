/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Pedido;

import Vista.Clientes.*;
import Vista.Pedido.*;
import Vista.*;

/**
 *
 * @author DroKaN
 */
public class ListaPedido extends javax.swing.JPanel {

    /**
     * Creates new form VistaInicio
     */
    public ListaPedido() {
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
        jtPedidos = new rojerusan.RSTableMetro();
        txtBuscar = new javax.swing.JTextField();
        btnPedido = new javax.swing.JButton();

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

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 30)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(128, 128, 131));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("PEDIDOS");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel1.setText("Buscar:");

        jsClientes.setBorder(null);

        jtPedidos = new rojerusan.RSTableMetro(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        jtPedidos.setModel(new javax.swing.table.DefaultTableModel(
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
        jtPedidos.setAltoHead(30);
        jtPedidos.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jtPedidos.setFuenteFilas(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jtPedidos.setFuenteFilasSelect(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jtPedidos.setFuenteHead(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jtPedidos.setGridColor(new java.awt.Color(102, 102, 102));
        jtPedidos.setGrosorBordeFilas(0);
        jtPedidos.setGrosorBordeHead(0);
        jtPedidos.setRowHeight(25);
        jtPedidos.getTableHeader().setReorderingAllowed(false);
        jsClientes.setViewportView(jtPedidos);

        txtBuscar.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        btnPedido.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_Missed_Call_50px_2.png"))); // NOI18N
        btnPedido.setText("Nuevo Pedido");
        btnPedido.setBorder(null);
        btnPedido.setBorderPainted(false);
        btnPedido.setContentAreaFilled(false);
        btnPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPedido.setFocusPainted(false);
        btnPedido.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btnPedido.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPedido.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_Missed_Call_50px_1.png"))); // NOI18N
        btnPedido.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(5, 5, 5)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(369, 369, 369)
                        .addComponent(btnPedido))
                    .addComponent(jsClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 767, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(116, Short.MAX_VALUE))
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnPedido))
                .addGap(13, 13, 13)
                .addComponent(jsClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btEditar;
    public javax.swing.JButton btEliminar;
    public javax.swing.JButton btTelefonos;
    public javax.swing.JButton btnPedido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jsClientes;
    public rojerusan.RSTableMetro jtPedidos;
    public javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
