package battle.of.hero.View;

import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author rakas
 */
public class Heropedia extends javax.swing.JFrame {

    /**
     * Creates new form Heropedia
     */
    public Heropedia() {
        initComponents();
        Category.setSelected(radioAll.getModel(), rootPaneCheckingEnabled);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Category = new javax.swing.ButtonGroup();
        Back = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        cardList = new javax.swing.JList<>();
        radioAll = new javax.swing.JRadioButton();
        radioRare = new javax.swing.JRadioButton();
        radioLegend = new javax.swing.JRadioButton();
        radioEpic = new javax.swing.JRadioButton();
        radioSpell = new javax.swing.JRadioButton();
        imgSpell = new javax.swing.JLabel();
        imgHero = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        Category.add(radioEpic);
        Category.add(radioLegend);
        Category.add(radioRare);
        Category.add(radioSpell);
        Category.add(radioAll);

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
        getContentPane().add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 90, 80));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setViewportView(cardList);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 240, 320));

        radioAll.setText("All Card");
        getContentPane().add(radioAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, -1, -1));

        radioRare.setText("Rare Card");
        radioRare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioRareActionPerformed(evt);
            }
        });
        getContentPane().add(radioRare, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, -1, -1));

        radioLegend.setText("Legend Card");
        getContentPane().add(radioLegend, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, -1, -1));

        radioEpic.setText("Epic Card");
        getContentPane().add(radioEpic, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, -1, -1));

        radioSpell.setText("Spell Card");
        getContentPane().add(radioSpell, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, -1, -1));
        getContentPane().add(imgSpell, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 170, 250, 400));

        imgHero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/battle/of/hero/image/kartu/kartu blkg.png"))); // NOI18N
        getContentPane().add(imgHero, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 170, 250, 400));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/battle/of/hero/image/bg_heropedia.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

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

    private void radioRareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioRareActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioRareActionPerformed

    public JButton getBack() {
        return Back;
    }

    public ButtonGroup getCategory() {
        return Category;
    }

    public JList<String> getCardList() {
        return cardList;
    }

    public JLabel getImgHero() {
        return imgHero;
    }

    public JLabel getImgSpell() {
        return imgSpell;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public JRadioButton getRadioEpic() {
        return radioEpic;
    }

    public JRadioButton getRadioLegend() {
        return radioLegend;
    }

    public JRadioButton getRadioRare() {
        return radioRare;
    }

    public JRadioButton getRadioSpell() {
        return radioSpell;
    }

    public JRadioButton getRadioAll() {
        return radioAll;
    }
    
    public String getSelectedButtonText() {
        for (Enumeration<AbstractButton> buttons = Category.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }

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
            java.util.logging.Logger.getLogger(Heropedia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Heropedia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Heropedia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Heropedia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Heropedia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.ButtonGroup Category;
    private javax.swing.JList<String> cardList;
    private javax.swing.JLabel imgHero;
    private javax.swing.JLabel imgSpell;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton radioAll;
    private javax.swing.JRadioButton radioEpic;
    private javax.swing.JRadioButton radioLegend;
    private javax.swing.JRadioButton radioRare;
    private javax.swing.JRadioButton radioSpell;
    // End of variables declaration//GEN-END:variables
}
