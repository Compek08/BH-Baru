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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class cHeroPedia {

    private Heropedia vHeropedia;
    private jListCon jList;
    private mCard mCard;

    DefaultListModel list;

    public cHeroPedia() throws SQLException {
        mCard = new mCard();
        vHeropedia = new Heropedia();
        jList = new jListCon();
        list = new DefaultListModel();
        vHeropedia.setVisible(true);
        vHeropedia.getCardList().addMouseListener(new cardPrev());
//        vHeropedia.getCardList().setModel(jList.addFromDatabase(vHeropedia.getCardList()));
//        jList.addFromDatabase();
        list = jList.addAll();
        vHeropedia.getCardList().setModel(list);
        vHeropedia.getRadioAll().addActionListener(new category());
        vHeropedia.getRadioEpic().addActionListener(new category());
        vHeropedia.getRadioLegend().addActionListener(new category());
        vHeropedia.getRadioRare().addActionListener(new category());
        vHeropedia.getRadioSpell().addActionListener(new category());
//        vHeropedia.getCategory().getSelection().addChangeListener(new category());
//        vHeropedia.getCategory().getSelection().addActionListener(new category());
//        vHeropedia.getCategory().getSelection().addItemListener(new category());

//        jList.addFromDatabase(vHeropedia.getCardList());
    }

//    private class category implements ChangeListener {
//
//        @Override
//        public void stateChanged(ChangeEvent e) {
//            String cat = vHeropedia.getSelectedButtonText();
//            switch (cat) {
//                case "Rare Card":
//                    try {
//                        list = jList.getCat(1);
//                    } catch (SQLException ex) {
//                        Logger.getLogger(cHeroPedia.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    vHeropedia.getCardList().setModel(list);
//                    break;
//                    
//                case "Epic Card":
//                    try {
//                        list = jList.getCat(2);
//                    } catch (SQLException ex) {
//                        Logger.getLogger(cHeroPedia.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    vHeropedia.getCardList().setModel(list);
//                    break;
//                    
//                case "Legend Card":
//                    try {
//                        list = jList.getCat(3);
//                    } catch (SQLException ex) {
//                        Logger.getLogger(cHeroPedia.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    vHeropedia.getCardList().setModel(list);
//                    break;
//                    
//                case "Spell Card":
//                    try {
//                        list = jList.getCat(4);
//                    } catch (SQLException ex) {
//                        Logger.getLogger(cHeroPedia.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    vHeropedia.getCardList().setModel(list);
//                    break;
//                    
//                case "All Card":
//                    try {
//                        list = jList.addAll();
//                    } catch (SQLException ex) {
//                        Logger.getLogger(cHeroPedia.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    vHeropedia.getCardList().setModel(list);
//                    break;
//                    
//            }
//        }
//    }
//    private class category implements ItemListener {
//
//        @Override
//        public void itemStateChanged(ItemEvent e) {
//            String cat = vHeropedia.getSelectedButtonText();
//            switch (cat) {
//                case "Rare Card":
//                    try {
//                        list = jList.getCat(1);
//                    } catch (SQLException ex) {
//                        Logger.getLogger(cHeroPedia.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    vHeropedia.getCardList().setModel(list);
//                    break;
//                    
//                case "Epic Card":
//                    try {
//                        list = jList.getCat(2);
//                    } catch (SQLException ex) {
//                        Logger.getLogger(cHeroPedia.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    vHeropedia.getCardList().setModel(list);
//                    break;
//                    
//                case "Legend Card":
//                    try {
//                        list = jList.getCat(3);
//                    } catch (SQLException ex) {
//                        Logger.getLogger(cHeroPedia.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    vHeropedia.getCardList().setModel(list);
//                    break;
//                    
//                case "Spell Card":
//                    try {
//                        list = jList.getCat(4);
//                    } catch (SQLException ex) {
//                        Logger.getLogger(cHeroPedia.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    vHeropedia.getCardList().setModel(list);
//                    break;
//                    
//                case "All Card":
//                    try {
//                        list = jList.addAll();
//                    } catch (SQLException ex) {
//                        Logger.getLogger(cHeroPedia.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    vHeropedia.getCardList().setModel(list);
//                    break;
//                    
//            }
//        }
//    }
    private class category implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String cat = vHeropedia.getSelectedButtonText();
            switch (cat) {
                case "Rare Card":
                    try {
                        list = jList.getCat(1);
                    } catch (SQLException ex) {
                        Logger.getLogger(cHeroPedia.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    vHeropedia.getCardList().setModel(list);
                    break;

                case "Epic Card":
                    try {
                        list = jList.getCat(2);
                    } catch (SQLException ex) {
                        Logger.getLogger(cHeroPedia.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    vHeropedia.getCardList().setModel(list);
                    break;

                case "Legend Card":
                    try {
                        list = jList.getCat(3);
                    } catch (SQLException ex) {
                        Logger.getLogger(cHeroPedia.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    vHeropedia.getCardList().setModel(list);
                    break;

                case "Spell Card":
                    try {
                        list = jList.getCat(4);
                    } catch (SQLException ex) {
                        Logger.getLogger(cHeroPedia.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    vHeropedia.getCardList().setModel(list);
                    break;

                case "All Card":
                    try {
                        list = jList.addAll();
                    } catch (SQLException ex) {
                        Logger.getLogger(cHeroPedia.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    vHeropedia.getCardList().setModel(list);
                    break;

            }
        }
    }

    private class cardPrev implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            String[] split = vHeropedia.getCardList().getSelectedValue().split(":");
            vHeropedia.getImgHero().setIcon(new javax.swing.ImageIcon(getClass().getResource(mCard.getImg(Integer.parseInt(split[1])))));
        }

        @Override
        public void mousePressed(MouseEvent e) {
            String[] split = vHeropedia.getCardList().getSelectedValue().split(":");
            vHeropedia.getImgHero().setIcon(new javax.swing.ImageIcon(getClass().getResource(mCard.getImg(Integer.parseInt(split[1])))));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            String[] split = vHeropedia.getCardList().getSelectedValue().split(":");
            vHeropedia.getImgHero().setIcon(new javax.swing.ImageIcon(getClass().getResource(mCard.getImg(Integer.parseInt(split[1])))));
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

}
