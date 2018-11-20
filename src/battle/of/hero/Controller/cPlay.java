/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battle.of.hero.Controller;

import BattleMain.*;
import battle.of.hero.Controller.*;
import battle.of.hero.Controller.Summoner.AIController;
import battle.of.hero.Model.*;
import battle.of.hero.View.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.*;
import battle.of.hero.Controller.Summoner.Player;
import battle.of.hero.Controller.Summoner.Enemy;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

/**
 *
 * @author rakas
 */
public class cPlay {

    private mCard mCard;
    private Play vPlay;
    private PlayClassic vClassic;
    private PlayArcade vArcade;
    private Semaphore semapor;
    private Player Player;
    private Enemy Enemy;
    private int turn;
    private AIController AI;
    private JOptionPane pane;
    private Object[] options;
    private JDialog dialog;
    private JPanel pan;
    private SwingWorker<Void, String> EnemyTurn;
//    ArrayList<Card> hand;
    Card[] A, B;
//    Arena Arena;

    public cPlay() throws SQLException {
        mCard = new mCard();
//        Arena = new Arena();
        vPlay = new Play();
        vPlay.setVisible(true);
        vPlay.getBtnArcade().addActionListener(new Arcade());
        vPlay.getBtnClassic().addActionListener(new Classic());
    }

    private class Start implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vClassic.getBtnStart().setVisible(false);
            vClassic.getEnd().setVisible(true);
            turn++;
            vClassic.getTurn().setText("Turn : " + turn);
            
            Player.DrawFirst(true);
        }
    }

    private class End implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (turn % 2 == 1) {
                Player.End();

                EnemyTurn = new SwingWorker<Void, String>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        TimeUnit.SECONDS.sleep(1);
                        //Draw musuh
                        if (turn == 2) {
                            Enemy.DrawFirst(turn % 2 == 1);
                        } else {
                            Enemy.Draw(turn % 2 == 1);
                        }
                        TimeUnit.SECONDS.sleep(1);

                        //Cek area
                        ArrayList<Integer> procs = AI.cek();

                        //Summon dkk musuh
                        procs.forEach((proc) -> {
                            switch (proc) {
                                case 2:
                                    Enemy.Summon(AI.getSummon());
                                    System.out.println("summon " + proc);
                            }
                        });
                        TimeUnit.SECONDS.sleep(1);

                        //End
                        Enemy.End();
                        turn++;
                        vClassic.getTurn().setText("Turn : " + turn);
                        System.out.println("Turn : " + turn);
                        System.out.println("Arena musuh = " + Enemy.getArena().size());
                        System.out.println("\n\n\n=====Player=====");

                        //Player draw
                        Player.Draw(true);
                        TimeUnit.SECONDS.sleep(1);
                        return null;
                    }
                };

                turn++;
                System.err.println("Turn : " + turn);
                vClassic.getTurn().setText("Turn : " + turn);
                System.out.println("\n\n\n=====Enemy=====");
                EnemyTurn.execute();
            }
        }
    }

//    public void Summon(Card card) {
//
//    }
//    private abstract class Summoner {
//
//        protected ArrayList<Card> hand;
//        protected Stack<Card> deck;
//
//        public Summoner() {
////            hand = new ArrayList<>();
//        }
//
//        public abstract ArrayList<Card> getHand();
//        public abstract void Draw();
//        public abstract void Summon();
//        public abstract Stack<Card> getDeck();
//
//    }
//    private static class Enemy extends Summoner {
//
//        public Enemy() {
//            hand = new ArrayList<>();
//        }
//
//        @Override
//        public ArrayList<Card> getHand() {
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        }
//
//        @Override
//        public Stack<Card> getDeck() {
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        }
//    }
//
//    private static class Player extends Summoner {
//
//        public Player() {
//            hand = new ArrayList<>();
//        }
//
//        @Override
//        public ArrayList<Card> getHand() {
//            return hand;
//        }
//
//        @Override
//        public Stack<Card> getDeck() {
//            return deck;
//        }
//    }
//    public class Arena {
//
//        public Arena() {
//            A = new Card[5];
//            B = new Card[5];
//        }
//
//    }
//    private class C1Action implements MouseListener {
//
//        @Override
//        public void mouseClicked(MouseEvent e) {
////            System.out.println(hand.get(0).getNama());
////            Summon(hand.get(0));
//        }
//
//        @Override
//        public void mousePressed(MouseEvent e) {
////            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        }
//
//        @Override
//        public void mouseReleased(MouseEvent e) {
////            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        }
//
//        @Override
//        public void mouseEntered(MouseEvent e) {
////            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        }
//
//        @Override
//        public void mouseExited(MouseEvent e) {
////            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        }
//    }
    private class Classic implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vClassic = new PlayClassic();
            vClassic.setVisible(true);
            vPlay.dispose();
            try {
                //            System.out.println("Compek");
                Playying play = new Playying();
            } catch (SQLException ex) {
                Logger.getLogger(cPlay.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private class Arcade implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vClassic = new PlayClassic();
            vClassic.setVisible(true);
            vPlay.dispose();
            try {
                //            System.out.println("Compek");
                Playying play = new Playying();
            } catch (SQLException ex) {
                Logger.getLogger(cPlay.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

        private class Playying {
            private Playying() throws SQLException{
//            semapor = new Semaphore(0);
            turn = 0;
//            boolean draw = false;
            boolean game = true;
            Player = new Player(vClassic, "Play");
            Enemy = new Enemy(vClassic, "Com");
            AI = new AIController(Player.getArena(), Enemy.getArena(), Enemy.getHand());
            invisibleAll();
            vClassic.getBtnStart().addActionListener(new Start());
            System.out.println("\n\n===== Player =====");
            tangan();
//            hand = new ArrayList<>();
//            Stack<Card> draw = new Stack<>();
//
//            draw.addAll(mCard.getDeck());
//
//            draw.forEach((drawi) -> {
//                System.out.println(drawi.getNama());
//            });
//
//            for (int i = 0; i < 6; i++) {
//                hand.add(draw.pop());
//            }
//
//            vClassic.getC1().setIcon(new javax.swing.ImageIcon(getClass().getResource(hand.get(0).getPic())));
//            vClassic.getC2().setIcon(new javax.swing.ImageIcon(getClass().getResource(hand.get(1).getPic())));
//            vClassic.getC3().setIcon(new javax.swing.ImageIcon(getClass().getResource(hand.get(2).getPic())));
//            vClassic.getC4().setIcon(new javax.swing.ImageIcon(getClass().getResource(hand.get(3).getPic())));
//            vClassic.getC5().setIcon(new javax.swing.ImageIcon(getClass().getResource(hand.get(4).getPic())));
//            vClassic.getC6().setIcon(new javax.swing.ImageIcon(getClass().getResource(hand.get(5).getPic())));
//
//            vClassic.getC1().addMouseListener(new C1Action());

            vClassic.getEnd().addActionListener(new End());
            vClassic.getTurn().setText("Turn : " + turn);

//            while (game) {
////            P1(Player, turn);
//            if (turn % 2 == 1) {
//                if (!Player.isDraw()) {
//                    if (turn == 1) {
//            Player.DrawFirst(turn % 2 == 1);
//                    } else {
//                        Player.Draw(turn % 2 == 1);
//                    }
//                    Player.setDraw(true);
//                }
//                vClassic.wait();
//                if (Player.isEnd()) {
//                    turn++;
//                    Player.setEnd(false);
//                }
//                System.out.println("Turn " + turn);
//                semapor.acquire();
//                System.out.println("Compek");
//            } else {
//                if (turn == 2) {
//                    Enemy.DrawFirst();
//                } else {
//                    Enemy.Draw();
//                }
//
//                turn++;
//            }
////                vClassic = Player.refresh();
//                System.out.println("turn" + turn);
//            }
//            }

//        private void P1(Player Player, int turn) throws InterruptedException {
////            if (turn % 2 == 1) {
//            if (!Player.isDraw()) {
//                if (turn == 1) {
//                    Player.DrawFirst();
//                } else {
//                    Player.Draw();
//                }
//                Player.setDraw(true);
//            }
////                    vClassic.wait();
//            if (Player.isEnd()) {
//                turn++;
//                Player.setEnd(false);
//            }
//            semapor.acquire();
//            System.out.println("Compek");
////                }
//            P2(Player, turn);
//        }
//
//        private void P2(Player Player, int turn) throws InterruptedException {
//            P1(Player, turn);
//        }
        }
        

        private void tangan() {
            vClassic.getC1().addActionListener(new C1());
            vClassic.getC2().addActionListener(new C2());
            vClassic.getC3().addActionListener(new C3());
            vClassic.getC4().addActionListener(new C4());
            vClassic.getC5().addActionListener(new C5());
            vClassic.getC6().addActionListener(new C6());
            vClassic.getC7().addActionListener(new C7());
        }

        private void invisibleAll() {
            //Tombol End
            vClassic.getEnd().setVisible(false);
            
            //Arena Player
            vClassic.getA1().setVisible(false);
            vClassic.getA2().setVisible(false);
            vClassic.getA3().setVisible(false);
            vClassic.getA4().setVisible(false);
            vClassic.getA5().setVisible(false);
            vClassic.getA6().setVisible(false);
            vClassic.getA7().setVisible(false);
            vClassic.getA8().setVisible(false);
            vClassic.getA9().setVisible(false);
            vClassic.getA10().setVisible(false);

            //Arena Musuh
            vClassic.getB1().setVisible(false);
            vClassic.getB2().setVisible(false);
            vClassic.getB3().setVisible(false);
            vClassic.getB4().setVisible(false);
            vClassic.getB5().setVisible(false);
            vClassic.getB6().setVisible(false);
            vClassic.getB7().setVisible(false);
            vClassic.getB8().setVisible(false);
            vClassic.getB9().setVisible(false);
            vClassic.getB10().setVisible(false);

            //Hand Player
            vClassic.getC1().setVisible(false);
            vClassic.getC2().setVisible(false);
            vClassic.getC3().setVisible(false);
            vClassic.getC4().setVisible(false);
            vClassic.getC5().setVisible(false);
            vClassic.getC6().setVisible(false);
            vClassic.getC7().setVisible(false);

            //Hand Musuh
            vClassic.getD1().setVisible(false);
            vClassic.getD2().setVisible(false);
            vClassic.getD3().setVisible(false);
            vClassic.getD4().setVisible(false);
            vClassic.getD5().setVisible(false);
            vClassic.getD6().setVisible(false);
            vClassic.getD7().setVisible(false);
        }
    }

    private class C1 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame pan = new JFrame();
//            pan.setLayout(new FlowLayout());
            pan.add(new JLabel(new javax.swing.ImageIcon(getClass().getResource(Player.getHand().get(0).getPic()))));
            pane = new JOptionPane("");
            options = new String[]{"Pasang", "Set", "Batal"};
            pane.setOptions(options);
            dialog = new JDialog();
            dialog = pane.createDialog(pan, "Aksi");
            dialog.setLayout(new BorderLayout());
//            dialog.add(pan, BorderLayout.NORTH);
//            dialog.add(pane, BorderLayout.SOUTH);
            dialog.add(new JLabel(new javax.swing.ImageIcon(getClass().getResource(Player.getHand().get(0).getPic()))), BorderLayout.SOUTH);
            dialog.setSize(300, 522);
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            dialog.setLocation(dim.width / 2 - dialog.getSize().width / 2, dim.height / 2 - dialog.getSize().height / 2);
            dialog.show();
            Object obj = pane.getValue();
//            if (obj.equals("Pasang")) {
//                Player.Summon(1);
//            } else if (obj.equals("Set")) {
//
//            } else if (obj.equals("Batal")) {
//
//            }
        }
    }

    private static class C2 implements ActionListener {

        public C2() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    private static class C3 implements ActionListener {

        public C3() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    private static class C4 implements ActionListener {

        public C4() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    private static class C5 implements ActionListener {

        public C5() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    private static class C6 implements ActionListener {

        public C6() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    private static class C7 implements ActionListener {

        public C7() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
