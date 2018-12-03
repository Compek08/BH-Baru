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
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
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
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class cShop {

    private Shop vShop = new Shop();
    public mShop mShop;
    public mCard mCard;

    public cShop() throws SQLException {
        mShop = new mShop();
        mCard = new mCard();
        vShop.setVisible(true);
        vShop.getPoin().setText("" + mShop.getPoin());
        vShop.getgHero().addActionListener(new gacha("hero"));
        vShop.getgSpell().addActionListener(new gacha("spell"));
//        vShop.getgHero().addActionListener(new gachaHero());
//        vShop.getgSpell().addActionListener(new gachaSpell());
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

    public void get(String url) {
        vShop.getDapat().setIcon(new javax.swing.ImageIcon(getClass().getResource(url)));
    }

    private class gacha implements ActionListener {

        String type;
        int price;
        private JOptionPane pane;
        private String[] options;
        private JDialog dialog;

        public gacha(String type) {
            this.type = type;
            switch (type) {
                case "hero":
                    price = 5000;
                    break;
                case "spell":
                    price = 3000;
                    break;
            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (type) {
                case "hero":
                    if (mShop.getPoin() >= price) {
                        try {
                            vShop.getPoin().setText("" + mShop.bayar(price));
                            int id = mShop.gacha(type);
                            show(id);
                        } catch (SQLException ex) {
                            Logger.getLogger(cShop.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Poin Tidak Mencukupi");
                    }
                    break;
                case "spell":
                    if (mShop.getPoin() >= price) {
                        try {
                            vShop.getPoin().setText("" + mShop.bayar(price));
                            int id = mShop.gacha(type);
                            show(id);
                        } catch (SQLException ex) {
                            Logger.getLogger(cShop.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Poin Tidak Mencukupi");
                    }
                    break;
            }
        }

        private void show(int id) {
            pane = new JOptionPane("");
            options = new String[]{"Ok"};
            pane.setOptions(options);
            dialog = new JDialog();
            dialog = pane.createDialog(new JFrame(), "Selamat");
            dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
            dialog.setLayout(new BorderLayout());
            dialog.add(new JLabel(new javax.swing.ImageIcon(getClass().getResource(mCard.getImg(id)))), BorderLayout.SOUTH);
            dialog.setSize(300, 522);
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            dialog.setLocation(dim.width / 2 - dialog.getSize().width / 2, dim.height / 2 - dialog.getSize().height / 2);
            dialog.show();
            Object obj = pane.getValue();
        }
    }

    private class gachaHero implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (mShop.getPoin() >= 5000) {
                try {
                    vShop.getPoin().setText("" + mShop.bayar(5000));
                    int id = mShop.gacha("hero");
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
                    int id = mShop.gacha("spell");
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
