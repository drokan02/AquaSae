/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Clientes;

import Vista.*;

/**
 *
 * @author DroKaN
 */
public class FormCliente extends javax.swing.JPanel {

    /**
     * Creates new form VistaInicio
     */
    public FormCliente() {
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

        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        comZona = new java.awt.Choice();
        txtTelefono = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        txtApellido = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTelefono1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTelefono2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTelefono3 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtTelefono4 = new javax.swing.JTextField();
        txtTitulo = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setFocusTraversalPolicyProvider(true);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombre.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 150, 417, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel2.setText("Apellidos:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 190, 77, 22));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel3.setText("Direccion:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 263, -1, 25));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel4.setText("Zona:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 227, -1, 23));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel5.setText("Telefono(1):");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 311, -1, -1));

        txtDireccion.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 263, 411, -1));

        comZona.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        add(comZona, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 227, 410, -1));

        txtTelefono.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(223, 301, 410, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel8.setText("Nombre(s):");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 150, -1, 25));

        btnCancelar.setBackground(new java.awt.Color(102, 102, 102));
        btnCancelar.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(new javax.swing.border.MatteBorder(null));
        btnCancelar.setFocusPainted(false);
        add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(223, 537, 410, 30));

        btnRegistrar.setBackground(new java.awt.Color(51, 51, 255));
        btnRegistrar.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("Registrar");
        btnRegistrar.setBorder(new javax.swing.border.MatteBorder(null));
        btnRegistrar.setFocusPainted(false);
        add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(223, 497, 410, 30));

        txtApellido.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 190, 414, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel6.setText("Telefono(2):");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 341, -1, -1));

        txtTelefono1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        add(txtTelefono1, new org.netbeans.lib.awtextra.AbsoluteConstraints(223, 341, 410, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel7.setText("Telefono(3):");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 381, -1, -1));

        txtTelefono2.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        add(txtTelefono2, new org.netbeans.lib.awtextra.AbsoluteConstraints(223, 381, 410, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel9.setText("Telefono(4):");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 419, -1, -1));

        txtTelefono3.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        add(txtTelefono3, new org.netbeans.lib.awtextra.AbsoluteConstraints(223, 419, 410, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel10.setText("Telefono(5):");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 459, -1, -1));

        txtTelefono4.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        add(txtTelefono4, new org.netbeans.lib.awtextra.AbsoluteConstraints(223, 459, 410, -1));

        txtTitulo.setFont(new java.awt.Font("Roboto", 1, 30)); // NOI18N
        txtTitulo.setForeground(new java.awt.Color(128, 128, 131));
        txtTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTitulo.setText("NUEVO CLIENTE");
        add(txtTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 35));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnRegistrar;
    public java.awt.Choice comZona;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public javax.swing.JTextField txtApellido;
    public javax.swing.JTextField txtDireccion;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtTelefono;
    public javax.swing.JTextField txtTelefono1;
    public javax.swing.JTextField txtTelefono2;
    public javax.swing.JTextField txtTelefono3;
    public javax.swing.JTextField txtTelefono4;
    public javax.swing.JLabel txtTitulo;
    // End of variables declaration//GEN-END:variables
}
