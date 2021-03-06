/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Pedido;

import Vista.*;

/**
 *
 * @author DroKaN
 */
public class FormPedido extends javax.swing.JPanel {

    /**
     * Creates new form VistaInicio
     */
    public FormPedido() {
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

        txtTotal = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        comCliente = new java.awt.Choice();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtZona = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        comProducto = new java.awt.Choice();
        btnCancelar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        txtStock = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTotal.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 387, 217, -1));

        txtCantidad.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 355, 420, -1));

        comCliente.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        add(comCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 158, 418, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel9.setText("Total:");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 387, -1, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel8.setText("Cliente:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 158, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel6.setText("Cantidad:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 355, -1, -1));

        txtTitulo.setFont(new java.awt.Font("Roboto", 1, 30)); // NOI18N
        txtTitulo.setForeground(new java.awt.Color(128, 128, 131));
        txtTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTitulo.setText("NUEVO PEDIDO");
        add(txtTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 36));

        txtDireccion.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 191, 418, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel2.setText("Dirección:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 191, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel3.setText("Zona:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 223, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel4.setText("Producto:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 258, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel5.setText("Precio:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 323, -1, -1));

        txtZona.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        add(txtZona, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 223, 420, -1));

        txtPrecio.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 323, 420, -1));

        comProducto.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        add(comProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 258, 420, -1));

        btnCancelar.setBackground(new java.awt.Color(102, 102, 102));
        btnCancelar.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(new javax.swing.border.MatteBorder(null));
        btnCancelar.setFocusPainted(false);
        add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 456, 421, 32));

        btnRegistrar.setBackground(new java.awt.Color(51, 51, 255));
        btnRegistrar.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("Registrar");
        btnRegistrar.setBorder(new javax.swing.border.MatteBorder(null));
        btnRegistrar.setFocusPainted(false);
        add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 419, 421, 30));

        txtStock.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        add(txtStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(241, 291, 422, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel7.setText("Stock:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 291, -1, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel10.setText("  Bs");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(464, 390, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnRegistrar;
    public java.awt.Choice comCliente;
    public java.awt.Choice comProducto;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public javax.swing.JTextField txtCantidad;
    public javax.swing.JTextField txtDireccion;
    public javax.swing.JTextField txtPrecio;
    public javax.swing.JTextField txtStock;
    public javax.swing.JLabel txtTitulo;
    public javax.swing.JTextField txtTotal;
    public javax.swing.JTextField txtZona;
    // End of variables declaration//GEN-END:variables
}
