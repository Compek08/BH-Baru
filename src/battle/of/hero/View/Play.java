package battle.of.hero.View;

import javax.swing.JButton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rakas
 */
public class Play extends javax.swing.JFrame {

    /**
     * Creates new form Play
     */
    int rgbIn = 16711680, rgbOut = 10027008;

    public Play() {
        initComponents();
    }

    public JButton getBtnArcade() {
        return btnArcade;
    }

    public JButton getBtnClassic() {
        return btnClassic;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnClassic = new javax.swing.JButton();
        btnArcade = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnClassic.setBackground(new java.awt.Color(153, 0, 0));
        btnClassic.setFont(new java.awt.Font("Bell MT", 1, 36)); // NOI18N
        btnClassic.setContentAreaFilled(false);
        btnClassic.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClassic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnClassicMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnClassicMouseExited(evt);
            }
        });
        btnClassic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClassicActionPerformed(evt);
            }
        });
        getContentPane().add(btnClassic, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 270, 380, 70));

        btnArcade.setBackground(new java.awt.Color(153, 0, 0));
        btnArcade.setFont(new java.awt.Font("Bell MT", 1, 36)); // NOI18N
        btnArcade.setContentAreaFilled(false);
        btnArcade.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnArcade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnArcadeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnArcadeMouseExited(evt);
            }
        });
        btnArcade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArcadeActionPerformed(evt);
            }
        });
        getContentPane().add(btnArcade, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 410, 370, 70));

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
        getContentPane().add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, 100, 100));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/battle/of/hero/image/pilihan.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClassicMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClassicMouseEntered
        btnClassic.setBackground(new java.awt.Color(rgbIn));
    }//GEN-LAST:event_btnClassicMouseEntered

    private void btnClassicMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClassicMouseExited
        btnClassic.setBackground(new java.awt.Color(rgbOut));
    }//GEN-LAST:event_btnClassicMouseExited

    private void btnClassicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClassicActionPerformed
//        PlayClassic Classic = new PlayClassic();
//        Classic.setVisible(true);
//        this.dispose();
    }//GEN-LAST:event_btnClassicActionPerformed

    private void btnArcadeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnArcadeMouseEntered
        btnArcade.setBackground(new java.awt.Color(rgbIn));
    }//GEN-LAST:event_btnArcadeMouseEntered

    private void btnArcadeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnArcadeMouseExited
        btnArcade.setBackground(new java.awt.Color(rgbOut));
    }//GEN-LAST:event_btnArcadeMouseExited

    private void btnArcadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArcadeActionPerformed
//        PlayArcade Arcade = new PlayArcade();
//        Arcade.setVisible(true);
//        this.dispose();
    }//GEN-LAST:event_btnArcadeActionPerformed

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
            java.util.logging.Logger.getLogger(Play.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Play.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Play.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Play.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Play().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JButton btnArcade;
    private javax.swing.JButton btnClassic;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
