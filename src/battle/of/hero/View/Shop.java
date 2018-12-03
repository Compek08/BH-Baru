package battle.of.hero.View;

import javax.swing.JButton;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author rakas
 */
public class Shop extends javax.swing.JFrame {

    public JButton getBack() {
        return Back;
    }

    public JButton getgSpell() {
        return gSpell;
    }

    public JLabel getDapat() {
        return Dapat;
    }

    public JLabel getPoin() {
        return poin;
    }

    public JButton getgHero() {
        return gHero;
    }

    /**
     * Creates new form Toko
     */
    public Shop() {
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

        Back = new javax.swing.JButton();
        poin = new javax.swing.JLabel();
        gHero = new javax.swing.JButton();
        gSpell = new javax.swing.JButton();
        Dapat = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Back.setBackground(new java.awt.Color(51, 255, 51));
        Back.setFont(new java.awt.Font("Bell MT", 1, 14)); // NOI18N
        Back.setContentAreaFilled(false);
        Back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BackMouseExited(evt);
            }
        });
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        getContentPane().add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 620, 70, 60));

        poin.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        poin.setText("Poin");
        getContentPane().add(poin, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 190, 60));

        gHero.setContentAreaFilled(false);
        getContentPane().add(gHero, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 470, 370, 100));

        gSpell.setContentAreaFilled(false);
        getContentPane().add(gSpell, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 480, 370, 90));
        getContentPane().add(Dapat, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, 250, 400));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/battle/of/hero/image/SHOP.png"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseEntered
        Back.setBackground(new java.awt.Color(255, 255, 102));
    }//GEN-LAST:event_BackMouseEntered

    private void BackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseExited
        Back.setBackground(new java.awt.Color(51, 255, 51));
    }//GEN-LAST:event_BackMouseExited

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        MainMenu MainMenu = new MainMenu();
        MainMenu.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_BackActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Shop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Shop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Shop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Shop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Shop().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JLabel Dapat;
    private javax.swing.JButton gHero;
    private javax.swing.JButton gSpell;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel poin;
    // End of variables declaration//GEN-END:variables
}
