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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

public class cDeck {

    private Deck vDeck;
    private mCard mCard;
    private jListCon jList;
    private ArrayList<Card> koleksi;

    DefaultListModel listDeck, listCard;

    public cDeck() throws SQLException {
        mCard = new mCard();
//        koleksi = mCard.getCollection();
        vDeck = new Deck();
        jList = new jListCon();
        listDeck = new DefaultListModel();
        listCard = new DefaultListModel();

        vDeck.setVisible(true);
        vDeck.getBtnAdd().addActionListener(new addList());
        vDeck.getBtnRemove().addActionListener(new removeList());
        vDeck.getListCard().addMouseListener(new cardPrev(true));
        vDeck.getListDeck().addMouseListener(new cardPrev(false));
        vDeck.getBtnSave().addActionListener(new save());

        listCard = jList.getCol();
        listDeck = jList.getDek();
//        System.out.println(listCard.capacity());
//        System.out.println(listCard.getSize());
//        System.out.println(listCard.size());
//        System.out.println(listDeck.capacity());
//        System.out.println(listDeck.getSize());
//        System.out.println(listDeck.size());

        vDeck.getListDeck().setModel(listDeck);
        vDeck.getListCard().setModel(listCard);

//        jList.addFromDatabase(vHeropedia.getCardList());
    }

    private class save implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                mCard.drop("koleksi");
                mCard.drop("deck");
            } catch (SQLException ex) {
                Logger.getLogger(cDeck.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (int i = 0; i < listDeck.size(); i++) {
                String[] split = listDeck.get(i).toString().split(":");
                try {
                    mCard.save(Integer.parseInt(split[1]), "deck");
                } catch (SQLException ex) {
                    Logger.getLogger(cDeck.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            for (int i = 0; i < listCard.size(); i++) {
                String[] split = listCard.get(i).toString().split(":");
                try {
                    mCard.save(Integer.parseInt(split[1]), "koleksi");
                } catch (SQLException ex) {
                    Logger.getLogger(cDeck.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private class cardPrev implements MouseListener {

        private boolean list;

        public cardPrev(boolean list) {
            this.list = list;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
//            System.out.println(vDeck.getListCard().getSelectedValue());
            if (list) {
                vDeck.getListDeck().clearSelection();
                String[] split = vDeck.getListCard().getSelectedValue().split(":");
                vDeck.getCardPrev().setIcon(new javax.swing.ImageIcon(getClass().getResource(mCard.getImg(Integer.parseInt(split[1])))));
            } else {
                vDeck.getListCard().clearSelection();
                String[] split = vDeck.getListDeck().getSelectedValue().split(":");
                vDeck.getCardPrev().setIcon(new javax.swing.ImageIcon(getClass().getResource(mCard.getImg(Integer.parseInt(split[1])))));
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            if (list) {
                vDeck.getListDeck().clearSelection();
                String[] split = vDeck.getListCard().getSelectedValue().split(":");
                vDeck.getCardPrev().setIcon(new javax.swing.ImageIcon(getClass().getResource(mCard.getImg(Integer.parseInt(split[1])))));
            } else {
                vDeck.getListCard().clearSelection();
                String[] split = vDeck.getListDeck().getSelectedValue().split(":");
                vDeck.getCardPrev().setIcon(new javax.swing.ImageIcon(getClass().getResource(mCard.getImg(Integer.parseInt(split[1])))));
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (list) {
                vDeck.getListDeck().clearSelection();
                String[] split = vDeck.getListCard().getSelectedValue().split(":");
                vDeck.getCardPrev().setIcon(new javax.swing.ImageIcon(getClass().getResource(mCard.getImg(Integer.parseInt(split[1])))));
            } else {
                vDeck.getListCard().clearSelection();
                String[] split = vDeck.getListDeck().getSelectedValue().split(":");
                vDeck.getCardPrev().setIcon(new javax.swing.ImageIcon(getClass().getResource(mCard.getImg(Integer.parseInt(split[1])))));
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private class addList implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (vDeck.getListCard().getSelectedIndex() != -1) {
                jList.addItem(listDeck, vDeck.getListCard().getSelectedValue(), listCard, vDeck.getListCard().getSelectedIndex());
            }
//            vDeck.getListDeck().sort
//            System.out.println(listCard.size());
//            System.out.println(listDeck.size());
        }
    }

    private class removeList implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (vDeck.getListDeck().getSelectedIndex() != -1) {
                jList.removeItem(listDeck, vDeck.getListDeck().getSelectedIndex(), listCard, vDeck.getListDeck().getSelectedValue());
            }
        }
    }
}
