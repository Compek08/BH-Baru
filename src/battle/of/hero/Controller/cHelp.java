/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battle.of.hero.Controller;

import battle.of.hero.View.Help;
import battle.of.hero.View.MainMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author rakas
 */
public class cHelp {

    Help vHelp;
    int isi;

    public cHelp() {
        vHelp = new Help();
        vHelp.setVisible(true);
        isi = 0;

//        vHelp.getBack().addActionListener(new Home());
        vHelp.getNext().addActionListener(new Nav(true));
        vHelp.getPrev().addActionListener(new Nav(false));
    }

    private class Nav implements ActionListener {

        private boolean nav;

        public Nav(boolean b) {
            nav = b;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (nav) {
                isi++;
            } else {
                isi--;
            }
            vHelp.getIsi().setIcon(new javax.swing.ImageIcon(getClass().getResource("/battle/of/hero/image/bantuan/" + Math.abs(isi % 6) + ".png")));
        }
    }

//    private class Home implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            MainMenu main = new MainMenu();
//            main.setVisible(true);
//            vHelp.dispose();
//        }
//    }

}
