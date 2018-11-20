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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

public class cHeroPedia {

    private Heropedia vHeropedia;
    private jListCon jList;
    private mCard mCard;

    DefaultListModel list;

    public cHeroPedia() throws SQLException {
        vHeropedia = new Heropedia();
        jList = new jListCon();
        list = new DefaultListModel();
        vHeropedia.setVisible(true);
        vHeropedia.getCardList().addMouseListener(new cardPrev());
//        vHeropedia.getCardList().setModel(jList.addFromDatabase(vHeropedia.getCardList()));
//        jList.addFromDatabase();
        list = jList.addAll();
        vHeropedia.getCardList().setModel(list);

//        jList.addFromDatabase(vHeropedia.getCardList());
    }

    private class cardPrev implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                mCard = new mCard();
//                vHeropedia.getImgHero().setIcon(new javax.swing.ImageIcon(getClass().getResource(mCard.getImg(vHeropedia.getCardList().getSelectedValue()))));
            } catch (SQLException ex) {
                Logger.getLogger(cHeroPedia.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(vHeropedia.getCardList().getSelectedValue());
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

}
