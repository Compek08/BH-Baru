package battle.of.hero.View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rakas
 */
public class PlayClassic extends javax.swing.JFrame {

    /**
     * Creates new form PlayClassic
     */
    public PlayClassic() {
        initComponents();
        Win.setVisible(false);

        btnDraw.setBorder(new RoundedBorder(10)); //10 is the radius
        btnDraw.setForeground(Color.BLUE);
        btnDraw.setBorder(new RoundedBorder(10));

        btnStandBy.setBorder(new RoundedBorder(10)); //10 is the radius
        btnStandBy.setForeground(Color.BLUE);
        btnStandBy.setBorder(new RoundedBorder(10));

        btnMain1.setBorder(new RoundedBorder(10)); //10 is the radius
        btnMain1.setForeground(Color.BLUE);
        btnMain1.setBorder(new RoundedBorder(10));

        btnEnd.setBorder(new RoundedBorder(10)); //10 is the radius
        btnEnd.setForeground(Color.BLUE);
        btnEnd.setBorder(new RoundedBorder(10));

        btnStart.setBorder(new RoundedBorder(10)); //10 is the radius
        btnStart.setForeground(Color.BLUE);
        btnStart.setBorder(new RoundedBorder(10));
    }

    public JButton getBtnDraw() {
        return btnDraw;
    }

    public JButton getBtnEnd() {
        return btnEnd;
    }

    public JButton getBtnMain1() {
        return btnMain1;
    }

    public JButton getBtnStandBy() {
        return btnStandBy;
    }

    public JButton getBtnStart() {
        return btnStart;
    }

    public JLabel getTurn() {
        return Turn;
    }

    public JLabel getMode() {
        return Mode;
    }

    public JLabel getWin() {
        return Win;
    }

    public JButton getA1() {
        return A1;
    }

    public JButton getA10() {
        return A10;
    }

    public JButton getA2() {
        return A2;
    }

    public JButton getA3() {
        return A3;
    }

    public JButton getA4() {
        return A4;
    }

    public JButton getA5() {
        return A5;
    }

    public JButton getA6() {
        return A6;
    }

    public JButton getA7() {
        return A7;
    }

    public JButton getA8() {
        return A8;
    }

    public JButton getA9() {
        return A9;
    }

    public JButton getB1() {
        return B1;
    }

    public JButton getB10() {
        return B10;
    }

    public JButton getB2() {
        return B2;
    }

    public JButton getB3() {
        return B3;
    }

    public JButton getB4() {
        return B4;
    }

    public JButton getB5() {
        return B5;
    }

    public JButton getB6() {
        return B6;
    }

    public JButton getB7() {
        return B7;
    }

    public JButton getB8() {
        return B8;
    }

    public JButton getB9() {
        return B9;
    }

    public JButton getC1() {
        return C1;
    }

    public JButton getC2() {
        return C2;
    }

    public JButton getC3() {
        return C3;
    }

    public JButton getC4() {
        return C4;
    }

    public JButton getC5() {
        return C5;
    }

    public JButton getC6() {
        return C6;
    }

    public JButton getC7() {
        return C7;
    }

    public JButton getD1() {
        return D1;
    }

    public JButton getD2() {
        return D2;
    }

    public JButton getD3() {
        return D3;
    }

    public JButton getD4() {
        return D4;
    }

    public JButton getD5() {
        return D5;
    }

    public JButton getD6() {
        return D6;
    }

    public JButton getD7() {
        return D7;
    }

    public JButton getESpell() {
        return ESpell;
    }

    public JButton getPSpell() {
        return PSpell;
    }

    public ButtonGroup getGrA1() {
        return GrA1;
    }

    public ButtonGroup getGrA2() {
        return GrA2;
    }

    public ButtonGroup getGrA3() {
        return GrA3;
    }

    public ButtonGroup getGrA4() {
        return GrA4;
    }

    public ButtonGroup getGrA5() {
        return GrA5;
    }

    public ButtonGroup getGrB1() {
        return GrB1;
    }

    public ButtonGroup getGrB2() {
        return GrB2;
    }

    public ButtonGroup getGrB3() {
        return GrB3;
    }

    public ButtonGroup getGrB4() {
        return GrB4;
    }

    public ButtonGroup getGrB5() {
        return GrB5;
    }

    public ButtonGroup geteHand() {
        return eHand;
    }

    public ButtonGroup getpHand() {
        return pHand;
    }

    public JLabel getEHP() {
        return EHP;
    }

    public JLabel getPHP() {
        return PHP;
    }

//    public JLabel getA1() {
//        return A1;
//    }
//
//    public JLabel getA2() {
//        return A2;
//    }
//
//    public JLabel getA3() {
//        return A3;
//    }
//
//    public JLabel getA4() {
//        return A4;
//    }
    public JLabel getOmbean1() {
        return Ombean1;
    }

    public JLabel getOmbean2() {
        return Ombean2;
    }

    public JButton getKuburanE() {
        return KuburanE;
    }

    public JButton getKuburanP() {
        return KuburanP;
    }

//    public JLabel getA5() {
//        return A5;
//    }
//
//    public JLabel getB1() {
//        return B1;
//    }
//
//    public JPanel getArea() {
//        return Area;
//    }
//
//    public JLabel getA1ATK() {
//        return A1ATK;
//    }
//
//    public JLabel getA1ATK1() {
//        return A1ATK1;
//    }
//
//    public JLabel getA1ATK2() {
//        return A1ATK2;
//    }
//
//    public JLabel getA1ATK3() {
//        return A1ATK3;
//    }
//
//    public JLabel getA1ATK4() {
//        return A1ATK4;
//    }
//
//    public JLabel getA1ATKLight() {
//        return A1ATKLight;
//    }
//
//    public JLabel getA1ATKLight1() {
//        return A1ATKLight1;
//    }
//
//    public JLabel getA1ATKLight2() {
//        return A1ATKLight2;
//    }
//
//    public JLabel getA1ATKLight3() {
//        return A1ATKLight3;
//    }
//
//    public JLabel getA1ATKLight4() {
//        return A1ATKLight4;
//    }
//
//    public JLabel getA1DEF() {
//        return A1DEF;
//    }
//
//    public JLabel getA1DEF1() {
//        return A1DEF1;
//    }
//
//    public JLabel getA1DEF2() {
//        return A1DEF2;
//    }
//
//    public JLabel getA1DEF3() {
//        return A1DEF3;
//    }
//
//    public JLabel getA1DEF4() {
//        return A1DEF4;
//    }
//
//    public JLabel getA1DEFLight() {
//        return A1DEFLight;
//    }
//
//    public JLabel getA1DEFLight1() {
//        return A1DEFLight1;
//    }
//
//    public JLabel getA1DEFLight2() {
//        return A1DEFLight2;
//    }
//
//    public JLabel getA1DEFLight3() {
//        return A1DEFLight3;
//    }
//
//    public JLabel getA1DEFLight4() {
//        return A1DEFLight4;
//    }
//
//    public JButton getBtnA1() {
//        return BtnA1;
//    }
//
//    public JButton getBtnA2() {
//        return BtnA2;
//    }
//
//    public JButton getBtnA3() {
//        return BtnA3;
//    }
//
//    public JButton getBtnA4() {
//        return BtnA4;
//    }
//
//    public JButton getBtnA5() {
//        return BtnA5;
//    }
//
//    public JPanel getjPanel2() {
//        return jPanel2;
//    }
//
//    public JPanel getjPanel3() {
//        return jPanel3;
//    }
//
//    public JPanel getjPanel4() {
//        return jPanel4;
//    }
//
//    public JPanel getjPanel5() {
//        return jPanel5;
//    }
//
//    public JPanel getjPanel6() {
//        return jPanel6;
//    }
//    public JLabel getB2() {
//        return B2;
//    }
//
//    public JLabel getB3() {
//        return B3;
//    }
//
//    public JLabel getB4() {
//        return B4;
//    }
//
//    public JLabel getB5() {
//        return B5;
//    }
//
//    public JLabel getC1() {
//        return C1;
//    }
//
//    public JLabel getC2() {
//        return C2;
//    }
//
//    public JLabel getC3() {
//        return C3;
//    }
//
//    public JLabel getC4() {
//        return C4;
//    }
//
//    public JLabel getC5() {
//        return C5;
//    }
//
//    public JLabel getC6() {
//        return C6;
//    }
//
//    public JLabel getC7() {
//        return C7;
//    }
//
//    public JLabel getD1() {
//        return D1;
//    }
//
//    public JLabel getD2() {
//        return D2;
//    }
//
//    public JLabel getD3() {
//        return D3;
//    }
//
//    public JLabel getD4() {
//        return D4;
//    }
//
//    public JLabel getD5() {
//        return D5;
//    }
//
//    public JLabel getD6() {
//        return D6;
//    }
//
//    public JLabel getD7() {
//        return D7;
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrA1 = new javax.swing.ButtonGroup();
        GrA2 = new javax.swing.ButtonGroup();
        GrA3 = new javax.swing.ButtonGroup();
        GrA4 = new javax.swing.ButtonGroup();
        GrA5 = new javax.swing.ButtonGroup();
        GrB1 = new javax.swing.ButtonGroup();
        GrB2 = new javax.swing.ButtonGroup();
        GrB3 = new javax.swing.ButtonGroup();
        GrB4 = new javax.swing.ButtonGroup();
        GrB5 = new javax.swing.ButtonGroup();
        pHand = new javax.swing.ButtonGroup();
        eHand = new javax.swing.ButtonGroup();
        Ombean1 = new javax.swing.JLabel();
        Ombean2 = new javax.swing.JLabel();
        A1 = new javax.swing.JButton();
        A2 = new javax.swing.JButton();
        A3 = new javax.swing.JButton();
        A4 = new javax.swing.JButton();
        A5 = new javax.swing.JButton();
        A6 = new javax.swing.JButton();
        A7 = new javax.swing.JButton();
        A8 = new javax.swing.JButton();
        A9 = new javax.swing.JButton();
        A10 = new javax.swing.JButton();
        B1 = new javax.swing.JButton();
        B3 = new javax.swing.JButton();
        B2 = new javax.swing.JButton();
        B5 = new javax.swing.JButton();
        B4 = new javax.swing.JButton();
        B7 = new javax.swing.JButton();
        B6 = new javax.swing.JButton();
        B9 = new javax.swing.JButton();
        B8 = new javax.swing.JButton();
        B10 = new javax.swing.JButton();
        C1 = new javax.swing.JButton();
        C2 = new javax.swing.JButton();
        C3 = new javax.swing.JButton();
        C4 = new javax.swing.JButton();
        C5 = new javax.swing.JButton();
        C6 = new javax.swing.JButton();
        C7 = new javax.swing.JButton();
        PSpell = new javax.swing.JButton();
        ESpell = new javax.swing.JButton();
        D1 = new javax.swing.JButton();
        D2 = new javax.swing.JButton();
        D3 = new javax.swing.JButton();
        D4 = new javax.swing.JButton();
        D5 = new javax.swing.JButton();
        D6 = new javax.swing.JButton();
        D7 = new javax.swing.JButton();
        Mode = new javax.swing.JLabel();
        Turn = new javax.swing.JLabel();
        Win = new javax.swing.JLabel();
        EHP = new javax.swing.JLabel();
        PHP = new javax.swing.JLabel();
        btnStart = new javax.swing.JButton();
        KuburanE = new javax.swing.JButton();
        KuburanP = new javax.swing.JButton();
        btnDraw = new javax.swing.JButton();
        btnStandBy = new javax.swing.JButton();
        btnMain1 = new javax.swing.JButton();
        btnEnd = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        GrA1.add(A1);
        GrA1.add(A6);

        GrA1.add(A2);
        GrA1.add(A7);

        GrA1.add(A3);
        GrA1.add(A8);

        GrA1.add(A4);
        GrA1.add(A9);

        GrA1.add(A5);
        GrA1.add(A10);

        GrA1.add(B1);
        GrA1.add(B2);

        GrA1.add(B3);
        GrA1.add(B4);

        GrA1.add(B5);
        GrA1.add(B6);

        GrA1.add(B7);
        GrA1.add(B8);

        GrA1.add(B9);
        GrA1.add(B10);

        pHand.add(C1);
        pHand.add(C2);
        pHand.add(C3);
        pHand.add(C4);
        pHand.add(C5);
        pHand.add(C6);
        pHand.add(C7);

        pHand.add(D1);
        pHand.add(D2);
        pHand.add(D3);
        pHand.add(D4);
        pHand.add(D5);
        pHand.add(D6);
        pHand.add(D7);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(Ombean1, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 600, 60, 90));
        getContentPane().add(Ombean2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, 60, 80));
        getContentPane().add(A1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 420, 63, 89));
        getContentPane().add(A2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 420, 63, 89));
        getContentPane().add(A3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 420, 63, 89));
        getContentPane().add(A4, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 420, 63, 89));
        getContentPane().add(A5, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 420, 63, 89));
        getContentPane().add(A6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 430, 89, 63));
        getContentPane().add(A7, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 430, 89, 63));
        getContentPane().add(A8, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 430, 89, 63));
        getContentPane().add(A9, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 430, 89, 63));
        getContentPane().add(A10, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 430, 89, 63));
        getContentPane().add(B1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 200, 63, 89));
        getContentPane().add(B3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 200, 63, 89));
        getContentPane().add(B2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 210, 89, 63));
        getContentPane().add(B5, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 200, 63, 89));
        getContentPane().add(B4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 210, 89, 63));
        getContentPane().add(B7, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 200, 63, 89));
        getContentPane().add(B6, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 210, 89, 63));
        getContentPane().add(B9, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 200, 63, 89));
        getContentPane().add(B8, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 210, 89, 63));
        getContentPane().add(B10, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 210, 89, 63));
        getContentPane().add(C1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 580, 63, 89));
        getContentPane().add(C2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 580, 63, 89));
        getContentPane().add(C3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 580, 63, 89));
        getContentPane().add(C4, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 580, 63, 89));
        getContentPane().add(C5, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 580, 63, 89));
        getContentPane().add(C6, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 580, 63, 89));
        getContentPane().add(C7, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 580, 63, 89));
        getContentPane().add(PSpell, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 490, 63, 89));
        getContentPane().add(ESpell, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 140, 63, 89));
        getContentPane().add(D1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, 63, 89));
        getContentPane().add(D2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, 63, 89));
        getContentPane().add(D3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, 63, 89));
        getContentPane().add(D4, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 50, 63, 89));
        getContentPane().add(D5, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 50, 63, 89));
        getContentPane().add(D6, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 50, 63, 89));
        getContentPane().add(D7, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 50, 63, 89));

        Mode.setFont(new java.awt.Font("Maiandra GD", 1, 30)); // NOI18N
        Mode.setText("Turn : 1");
        getContentPane().add(Mode, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 150, 50));

        Turn.setFont(new java.awt.Font("Maiandra GD", 1, 30)); // NOI18N
        Turn.setText("Turn : 1");
        getContentPane().add(Turn, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 150, 50));

        Win.setFont(new java.awt.Font("Maiandra GD", 1, 30)); // NOI18N
        Win.setText("Turn : 1");
        getContentPane().add(Win, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 150, 50));

        EHP.setText("100");
        getContentPane().add(EHP, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 50, -1, -1));

        PHP.setText("100");
        getContentPane().add(PHP, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 670, -1, -1));

        btnStart.setBackground(new java.awt.Color(255, 255, 51));
        btnStart.setFont(new java.awt.Font("SansSerif", 1, 70)); // NOI18N
        btnStart.setText("START");
        getContentPane().add(btnStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, 520, 160));

        KuburanE.setContentAreaFilled(false);
        getContentPane().add(KuburanE, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, 63, 89));

        KuburanP.setContentAreaFilled(false);
        getContentPane().add(KuburanP, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 390, 63, 89));

        btnDraw.setText("Draw");
        getContentPane().add(btnDraw, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 340, 60, 30));

        btnStandBy.setText("Tunggu");
        getContentPane().add(btnStandBy, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 340, 60, 30));

        btnMain1.setText("Main");
        getContentPane().add(btnMain1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 340, 60, 30));

        btnEnd.setText("End");
        getContentPane().add(btnEnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 340, 60, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/battle/of/hero/image/main.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/battle/of/hero/image/bg-main.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 4, 1280, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(PlayClassic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlayClassic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlayClassic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlayClassic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlayClassic().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton A1;
    private javax.swing.JButton A10;
    private javax.swing.JButton A2;
    private javax.swing.JButton A3;
    private javax.swing.JButton A4;
    private javax.swing.JButton A5;
    private javax.swing.JButton A6;
    private javax.swing.JButton A7;
    private javax.swing.JButton A8;
    private javax.swing.JButton A9;
    private javax.swing.JButton B1;
    private javax.swing.JButton B10;
    private javax.swing.JButton B2;
    private javax.swing.JButton B3;
    private javax.swing.JButton B4;
    private javax.swing.JButton B5;
    private javax.swing.JButton B6;
    private javax.swing.JButton B7;
    private javax.swing.JButton B8;
    private javax.swing.JButton B9;
    private javax.swing.JButton C1;
    private javax.swing.JButton C2;
    private javax.swing.JButton C3;
    private javax.swing.JButton C4;
    private javax.swing.JButton C5;
    private javax.swing.JButton C6;
    private javax.swing.JButton C7;
    private javax.swing.JButton D1;
    private javax.swing.JButton D2;
    private javax.swing.JButton D3;
    private javax.swing.JButton D4;
    private javax.swing.JButton D5;
    private javax.swing.JButton D6;
    private javax.swing.JButton D7;
    private javax.swing.JLabel EHP;
    private javax.swing.JButton ESpell;
    private javax.swing.ButtonGroup GrA1;
    private javax.swing.ButtonGroup GrA2;
    private javax.swing.ButtonGroup GrA3;
    private javax.swing.ButtonGroup GrA4;
    private javax.swing.ButtonGroup GrA5;
    private javax.swing.ButtonGroup GrB1;
    private javax.swing.ButtonGroup GrB2;
    private javax.swing.ButtonGroup GrB3;
    private javax.swing.ButtonGroup GrB4;
    private javax.swing.ButtonGroup GrB5;
    private javax.swing.JButton KuburanE;
    private javax.swing.JButton KuburanP;
    private javax.swing.JLabel Mode;
    private javax.swing.JLabel Ombean1;
    private javax.swing.JLabel Ombean2;
    private javax.swing.JLabel PHP;
    private javax.swing.JButton PSpell;
    private javax.swing.JLabel Turn;
    private javax.swing.JLabel Win;
    private javax.swing.JButton btnDraw;
    private javax.swing.JButton btnEnd;
    private javax.swing.JButton btnMain1;
    private javax.swing.JButton btnStandBy;
    private javax.swing.JButton btnStart;
    private javax.swing.ButtonGroup eHand;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.ButtonGroup pHand;
    // End of variables declaration//GEN-END:variables

    private class RoundedBorder implements Border {

        private int radius;

        public RoundedBorder(int i) {
            radius = i;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
        }

        @Override
        public boolean isBorderOpaque() {
            return true;
        }
    }
}
