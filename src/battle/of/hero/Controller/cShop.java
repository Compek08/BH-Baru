/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battle.of.hero.Controller;

import battle.of.hero.View.*;
import battle.of.hero.Controller.*;
import battle.of.hero.Model.*;
import BattleMain.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class cShop {

    private Shop vShop = new Shop();
    public mShop mShop;

    public cShop() throws SQLException {
        mShop = new mShop();
        vShop.setVisible(true);
        vShop.getPoin().setText("" + mShop.getPoin());
        vShop.getgHero().addActionListener(new gachaHero());
        vShop.getgSpell().addActionListener(new gachaSpell());
//        vShop.getgHero().addActionListener(gachaHero());
//        vShop.getgSpell().addActionListener(gachaSpell());
    }
//
//    public void gacha(String tipe) throws SQLException {
//        ArrayList<Card> Cards = mCard.getCard();
//        Random R = new Random();
//        int get;
//        ArrayList<Integer> gacha = new ArrayList<>();
//        if (tipe.equalsIgnoreCase("hero")) {
////            for (int i = 0; i < 3; i++) {
//            Cards.forEach((Card) -> {
//                if (Card.getGrade() == 1) {
//                    for (int j = 0; j < 37; j++) {
//                        gacha.add(Card.getId());
//                    }
//                }
//                if (Card.getGrade() == 2) {
//                    for (int j = 0; j < 12; j++) {
//                        gacha.add(Card.getId());
//                    }
//                }
//                if (Card.getGrade() == 3) {
//                    for (int j = 0; j < 1; j++) {
//                        gacha.add(Card.getId());
//                    }
//                }
//            });
////            }
////System.out.println(gacha.size());
//            get = R.nextInt(gacha.size());
//        } else {
//            Cards.forEach((Card) -> {
//                System.out.println(Card.getGrade());
//                if (Card.getGrade() == 4) {
//                    for (int j = 0; j < 30; j++) {
//                        gacha.add(Card.getId());
//                    }
//                }
//            });
//            System.out.println(gacha.size());
//            get = R.nextInt(gacha.size());
//        }
//        mCard.save(Cards.get(gacha.get(get)).getId(), "koleksi");
//    }
    
    public void get(String url){
        vShop.getDapat().setIcon(new javax.swing.ImageIcon(getClass().getResource(url)));
    }
    
    private class gachaHero implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (mShop.getPoin() >= 5000) {
                try {
                    vShop.getPoin().setText("" + mShop.bayar(5000));
                    mShop.gacha("hero");
                } catch (SQLException ex) {
                    Logger.getLogger(cShop.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Poin Tidak Mencukupi");
            }
        }
    }

    private class gachaSpell implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (mShop.getPoin() >= 3000) {
                try {
                    vShop.getPoin().setText("" + mShop.bayar(3000));
                    mShop.gacha("spell");
                } catch (SQLException ex) {
                    Logger.getLogger(cShop.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Poin Tidak Mencukupi");
            }
        }
    }

//    private ActionListener gachaHero() {
//        if (mShop.getPoin() >= 5000) {
//            try {
//                vShop.getPoin().setText("" + mShop.bayar(5000));
//                mShop.gacha("hero");
//            } catch (SQLException ex) {
//                Logger.getLogger(cShop.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } else {
//            JOptionPane.showMessageDialog(null, "Poin Tidak Mencukupi");
//        }
//        throw null;
//    }
//
//    private ActionListener gachaSpell() {
//        if (mShop.getPoin() >= 3000) {
//            try {
//                vShop.getPoin().setText("" + mShop.bayar(3000));
//                mShop.gacha("spell");
//            } catch (SQLException ex) {
//                Logger.getLogger(cShop.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } else {
//            JOptionPane.showMessageDialog(null, "Poin Tidak Mencukupi");
//        }
//        throw null;
//    }
}
