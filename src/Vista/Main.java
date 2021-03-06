/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Complemento;
import Controlador.Consola;
import Controlador.MenuController;
import Modelo.Connector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author DroKaN
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Main() {

        initComponents();
        this.setLocationRelativeTo(null);
        Complemento.nuevoIcono("logo.png", jLabel1,true);
        new Hilo(this).start();

    }
    public void cargar(){
            for (int i = 0; i < 5; i++) {
                System.err.println(i);
                boolean conectado = new Connector().probarConeccion();
                if(conectado){
                    i = 6;
                }
                Complemento.dormir(500);
            }   
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
class Hilo extends Thread{
    private Main main;
    public Hilo(Main main){
        this.main = main;
    }
    
    public void run(){
        mostrarMenu();
    }
    
    private void mostrarMenu(){
        boolean conectado = false;  
       /* String rutabd =  System.getProperty("user.dir") + "\\bd\\importarBD.bat";
              

         try {
             Consola.ejecutarCMD("\\xampp\\mysql_start.bat");
             conectado = new Connector().probarConeccion();
             if(!conectado){
                 Consola.ejecutarCMD(rutabd);
             }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(main, "No se  encontro la direccion C:\\xampp\\mysql_start.bat");
        }

         */
         for (int i = 0; i < 4; i++) {
                conectado = new Connector().probarConeccion();
                System.err.println(i);
                Complemento.dormir(1000);
        }
        
        if(conectado){
            main.dispose();
            Complemento.dormir(500);
            Principal view = new Principal();
            MenuController controller = new MenuController(view);
            controller.mostrar();             
        }else{
            
            JOptionPane.showMessageDialog(main, "No se  encontro la base de datos");
            main.dispose();
        }
         
         
       
    }
}