/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Axel Reyez
 */
public class principalito extends javax.swing.JPanel {

private int bandera=0;
 Conection db=new Conection();
   int paquete=0;

   ResultSet rs;
    public principalito() {
        try {
            try {
                UIManager.setLookAndFeel("UpperEssential.UpperEssentialLookAndFeel");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(principalito.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(principalito.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(principalito.class.getName()).log(Level.SEVERE, null, ex);
            }
         } catch (UnsupportedLookAndFeelException ex) {
             Logger.getLogger(Chapatas.class.getName()).log(Level.SEVERE, null, ex);
         }
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

        barrita = new javax.swing.JTabbedPane();

        barrita.setFont(new java.awt.Font("Rockwell", 3, 24)); // NOI18N
        barrita.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                barritaMouseMoved(evt);
            }
        });
        barrita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                barritaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(barrita, javax.swing.GroupLayout.PREFERRED_SIZE, 1235, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(barrita, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void barritaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barritaMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_barritaMouseMoved

    private void barritaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barritaMouseClicked
        // TODO add your handling code here:
            // TODO add your handling code here:
    }//GEN-LAST:event_barritaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTabbedPane barrita;
    // End of variables declaration//GEN-END:variables
}
