/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Reporte;

import Vista.*;

/**
 *
 * @author DroKaN
 */
public class Formulario extends javax.swing.JPanel {

    /**
     * Creates new form VistaInicio
     */
    public Formulario() {
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
        jCTextField1 = new app.bolivia.swing.JCTextField();
        jCTextField2 = new app.bolivia.swing.JCTextField();
        jCTextField3 = new app.bolivia.swing.JCTextField();
        jCTextField4 = new app.bolivia.swing.JCTextField();
        jCTextField5 = new app.bolivia.swing.JCTextField();
        jCTextField6 = new app.bolivia.swing.JCTextField();
        jCTextField7 = new app.bolivia.swing.JCTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(128, 128, 131));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("INICIO");

        jCTextField1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jCTextField1.setForeground(new java.awt.Color(102, 102, 102));
        jCTextField1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jCTextField1.setPhColor(new java.awt.Color(102, 102, 102));
        jCTextField1.setPlaceholder("Apellidos ");

        jCTextField2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jCTextField2.setForeground(new java.awt.Color(102, 102, 102));
        jCTextField2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jCTextField2.setPhColor(new java.awt.Color(102, 102, 102));
        jCTextField2.setPlaceholder("Direccion");

        jCTextField3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jCTextField3.setForeground(new java.awt.Color(102, 102, 102));
        jCTextField3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jCTextField3.setPhColor(new java.awt.Color(102, 102, 102));
        jCTextField3.setPlaceholder("Nombres");

        jCTextField4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jCTextField4.setForeground(new java.awt.Color(102, 102, 102));
        jCTextField4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jCTextField4.setPhColor(new java.awt.Color(102, 102, 102));
        jCTextField4.setPlaceholder("Zona");

        jCTextField5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jCTextField5.setForeground(new java.awt.Color(102, 102, 102));
        jCTextField5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jCTextField5.setPhColor(new java.awt.Color(102, 102, 102));
        jCTextField5.setPlaceholder("Telefono 1");

        jCTextField6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jCTextField6.setForeground(new java.awt.Color(102, 102, 102));
        jCTextField6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jCTextField6.setPhColor(new java.awt.Color(102, 102, 102));
        jCTextField6.setPlaceholder("Telefono 2");

        jCTextField7.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jCTextField7.setForeground(new java.awt.Color(102, 102, 102));
        jCTextField7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jCTextField7.setPhColor(new java.awt.Color(102, 102, 102));
        jCTextField7.setPlaceholder("Telefono 3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 1112, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jCTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
                    .addComponent(jCTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jCTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(jCTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jCTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 270, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private app.bolivia.swing.JCTextField jCTextField1;
    private app.bolivia.swing.JCTextField jCTextField2;
    private app.bolivia.swing.JCTextField jCTextField3;
    private app.bolivia.swing.JCTextField jCTextField4;
    private app.bolivia.swing.JCTextField jCTextField5;
    private app.bolivia.swing.JCTextField jCTextField6;
    private app.bolivia.swing.JCTextField jCTextField7;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
