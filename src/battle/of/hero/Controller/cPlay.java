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
import javax.swing.WindowConstants;

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
    private int turn, win;
    private AIController AI;
    private JOptionPane pane;
    private Object[] options;
    private JDialog dialog;
    private JPanel pan;
    private SwingWorker<Void, Void> EnemyTurn;
    private boolean over;
    private String mode;
    private Card spell;
    private Refresh refresh;
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

    private class Refresh {

        public void Spell() {
            if (spell != null) {
                vClassic.getPSpell().setVisible(true);
                vClassic.getESpell().setVisible(true);
                vClassic.getPSpell().setIcon(new javax.swing.ImageIcon(getClass().getResource(spell.getPic())));
                vClassic.getESpell().setIcon(new javax.swing.ImageIcon(getClass().getResource(spell.getPic())));
            } else {
                vClassic.getPSpell().setVisible(false);
                vClassic.getESpell().setVisible(false);
            }
        }
    }

    private class Start implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!over) {
                vClassic.getBtnStart().setVisible(false);
                vClassic.getEnd().setVisible(true);
                turn++;
                vClassic.getTurn().setText("Turn : " + turn);

                Player.DrawFirst(true);
            } else {
                MainMenu main = new MainMenu();
                main.setVisible(true);
                vClassic.dispose();
            }
        }
    }

    private class End implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (Player.getDeck() > 0) {
                if (turn % 2 == 1) {
                    Player.End();
                    if (turn == 1) {
                        Player.setFirstTurn(true);
                    }

                    EnemyTurn = new SwingWorker<Void, Void>() {
                        @Override
                        protected Void doInBackground() throws Exception {
                            indexAtk.clear();
                            sumon = false;
                            TimeUnit.MILLISECONDS.sleep(300);
                            //Draw musuh
                            if (turn == 2) {
                                Enemy.DrawFirst(turn % 2 == 1);
                            } else {
                                Enemy.Draw(turn % 2 == 1);
                            }
                            TimeUnit.MILLISECONDS.sleep(300);

                            //Cek area
                            ArrayList<Integer> procs = AI.cekSummon();

                            //Summon sumonan musuh
                            if (Enemy.getArena().size() != 5) {
                                System.out.println("Proccess Running");
                                for (int i = 0; i < procs.size(); i++) {
                                    int proc = procs.get(i);
//                                procs.forEach((proc) -> {
                                    System.out.println("Proccess = " + proc);
                                    switch (proc) {
                                        case 1:
//                                        vClassic.getHistory().
                                            Enemy.Summon(AI.getIndex());
//                                        System.out.println("summon " + proc);
                                            break;
                                        case 2:
                                            if (AI.getIndex() != -1) {
                                                Enemy.Summon(AI.getIndex());
                                            }
                                        case 5:
                                            System.out.println("Index : " + AI.getIndex());
                                            Enemy.Summon(AI.getIndex());
                                            break;
                                    }
                                }
//                                });
                            }
                            // 1 = action
                            // genap = musuh
                            // ganjil = player
                            boolean nol = false;
                            if (turn != 1) {
                                procs = AI.cekAttack();
                                switch (procs.get(0)) {
                                    case 0:
                                        nol = true;
                                        Enemy.getArena().forEach((att) -> {
                                            if (!att.getPic().contains("def")) {
                                                Player.setHP(att.getAtk());
                                            }
                                        });
                                        break;
                                    case 1:
                                        System.out.println("procs : " + procs.toString());
                                        procs.remove(0);
                                        procs.trimToSize();
                                        for (int i = 0; i < procs.size(); i += 2) {
                                            System.out.println("procs : " + procs.toString());
                                            System.out.println(procs.get(i + 1) + " -1 " + procs.get(i + 1).equals(-1));
                                            if (procs.get(i + 1).equals(-1)) {
//                                            System.out.println(procs.get(i + 1));
                                                Player.setHP(Enemy.getArena().get(procs.get(i)).getAtk());
                                            } else {
                                                Enemy.Attack(Player, Enemy, procs.get(i), procs.get(i + 1));
                                            }
                                            for (int j = i + 1; j < procs.size(); j += 2) {
                                                System.out.println(procs.get(j) + " -1 " + procs.get(j).equals(-1));
                                                if ((procs.get(i + 1) > procs.get(j)) && (!procs.get(j).equals(-1))) {
                                                    procs.set(j, procs.get(j) - 1);
                                                }
                                            }
                                        }
                                }
                            }
//                            //Spell
//                            ArrayList<Integer> area = new ArrayList<>();
//                            Enemy.getArena().forEach((arena) -> {
//                                area.add(arena.getArea());
//                            });
//                            AI.setSpell(area);
//                            if (AI.getIndex() != -1) {
//                                spell = Enemy.getHand().get(AI.getIndex());
//                                Enemy.getHand().remove(AI.getIndex());
//                                Enemy.getHand().trimToSize();
//                                Enemy.refresh();
//                                refresh.Spell();
//                            }

                            TimeUnit.MILLISECONDS.sleep(300);

                            //End
                            Enemy.End();
                            if (turn == 2) {
                                Enemy.setFirstTurn(true);
                            }
                            turn++;
                            vClassic.getTurn().setText("Turn : " + turn);
//                            System.out.println("Turn : " + turn);
//                            System.out.println("Arena musuh = " + Enemy.getArena().size());
//                            System.out.println("\n\n\n=====Player=====");
                            TimeUnit.MILLISECONDS.sleep(300);

                            //Player draw
                            Player.Draw(true);
                            TimeUnit.MILLISECONDS.sleep(300);
                            return null;
                        }
                    };

                    turn++;
//                    System.err.println("Turn : " + turn);
//                    vClassic.getTurn().setText("Turn : " + turn);
//                    System.out.println("\n\n\n=====Enemy=====");
                    EnemyTurn.execute();
                }
            } else {
                vClassic.getBtnStart().setText("Game Over");
                invisibleAll();
                vClassic.getBtnStart().setVisible(true);
                over = true;
            }
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

            //Spell
            vClassic.getESpell().setVisible(false);
            vClassic.getPSpell().setVisible(false);

            //Ombean
            vClassic.getOmbean1().setVisible(false);
            vClassic.getOmbean2().setVisible(false);

            //Kuburan
            vClassic.getKuburanE().setVisible(false);
            vClassic.getKuburanP().setVisible(false);
        }
    }

    public void Summon(Card card) {
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
    }

    private class Classic implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vClassic = new PlayClassic();
            vClassic.setVisible(true);
            vPlay.dispose();
            mode = "Classic";
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
            mode = "Arcade";
            try {
                //            System.out.println("Compek");
                Playying play = new Playying();
            } catch (SQLException ex) {
                Logger.getLogger(cPlay.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class Playying {

        private Playying() throws SQLException {
//            semapor = new Semaphore(0);
            over = false;
            refresh = new Refresh();
            turn = 0;
//            boolean draw = false;
            boolean game = true;
            Player = new Player(vClassic, "Play");
            Enemy = new Enemy(vClassic, "Com");
            AI = new AIController(Player.getArena(), Enemy.getArena(), Enemy.getHand());
            invisibleAll();
            vClassic.getBtnStart().addActionListener(new Start());
//            System.out.println("\n\n===== Player =====");
            tangan();
            lapangan();
            lawan();
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
            vClassic.getKuburanE().addActionListener(new Kuburan(false));
            vClassic.getKuburanP().addActionListener(new Kuburan(true));
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

        //Tombolan tangan
        private void tangan() {
            vClassic.getC1().addActionListener(new hand(1));
            vClassic.getC2().addActionListener(new hand(2));
            vClassic.getC3().addActionListener(new hand(3));
            vClassic.getC4().addActionListener(new hand(4));
            vClassic.getC5().addActionListener(new hand(5));
            vClassic.getC6().addActionListener(new hand(6));
            vClassic.getC7().addActionListener(new hand(7));
        }

        //Tombol lapangan
        private void lapangan() {
            vClassic.getA1().addActionListener(new lapangan(1));
            vClassic.getA2().addActionListener(new lapangan(2));
            vClassic.getA3().addActionListener(new lapangan(3));
            vClassic.getA4().addActionListener(new lapangan(4));
            vClassic.getA5().addActionListener(new lapangan(5));
            vClassic.getA6().addActionListener(new lapangan(1));
            vClassic.getA7().addActionListener(new lapangan(2));
            vClassic.getA8().addActionListener(new lapangan(3));
            vClassic.getA9().addActionListener(new lapangan(4));
            vClassic.getA10().addActionListener(new lapangan(5));
        }

        //Tombol lawan
        private void lawan() {
            vClassic.getB1().addActionListener(new lawan(1));
            vClassic.getB2().addActionListener(new lawan(1));
            vClassic.getB3().addActionListener(new lawan(2));
            vClassic.getB4().addActionListener(new lawan(2));
            vClassic.getB5().addActionListener(new lawan(3));
            vClassic.getB6().addActionListener(new lawan(3));
            vClassic.getB7().addActionListener(new lawan(4));
            vClassic.getB8().addActionListener(new lawan(4));
            vClassic.getB9().addActionListener(new lawan(5));
            vClassic.getB10().addActionListener(new lawan(5));
        }

        private void invisibleAll() {
            //Tombol End
            vClassic.getEnd().setVisible(false);

            //Spell
            vClassic.getESpell().setVisible(false);
            vClassic.getPSpell().setVisible(false);

            //Histori
            vClassic.getHistory().setVisible(false);

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

    //Act pitetan tangan
    boolean sumon = false;

    private Object handAct(int urut) {
//        JFrame pan = new JFrame();
//            pan.setLayout(new FlowLayout());
//            pan.add(new JLabel(new javax.swing.ImageIcon(getClass().getResource(Player.getHand().get(urut).getPic()))));
        pane = new JOptionPane("");
        if ((turn % 2 == 1 && Player.getArena().size() != 5) && (!sumon || Player.getHand().get(urut).getGrade() == 4)) {
            options = new String[]{"Pasang", "Batal"};
        } else {
            options = new String[]{"Ok"};
        }
        pane.setOptions(options);
        dialog = new JDialog();
        dialog = pane.createDialog(new JFrame(), "Aksi");
        dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        dialog.setLayout(new BorderLayout());
//            pane.set
//            dialog.add(pan, BorderLayout.NORTH);
//            dialog.add(pane, BorderLayout.SOUTH);
        dialog.add(new JLabel(new javax.swing.ImageIcon(getClass().getResource(Player.getHand().get(urut).getPic().replace("/kecil", "")))), BorderLayout.SOUTH);
        dialog.setSize(300, 522);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        dialog.setLocation(dim.width / 2 - dialog.getSize().width / 2, dim.height / 2 - dialog.getSize().height / 2);
        dialog.show();
        Object obj = pane.getValue();
        return obj;
    }

    private class hand implements ActionListener {

        int i;

        public hand(int i) {
            this.i = i;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Object obj = handAct(i - 1);

            if (obj.equals("Pasang")) {
                if (Player.getHand().get(i - 1).getGrade() != 4) {
                    Player.Summon(i - 1);
                    sumon = true;
                } else {
                    spell = Player.getHand().get(i - 1);
                    Player.getHand().remove(i - 1);
                    Player.getHand().trimToSize();
                    Player.refresh();
                    refresh.Spell();
                }
//                System.out.println(Player.getArena().get(i-1).getNama() + " atk = " + Player.getArena().get(i-1).getAtk());
            }
        }
    }

    //Act pitetan lapangan
    ArrayList<Integer> indexAtk = new ArrayList<>();

    private Object arenaAct(int urut) {
        JFrame pan = new JFrame();
//            pan.setLayout(new FlowLayout());
//            pan.add(new JLabel(new javax.swing.ImageIcon(getClass().getResource(Player.getHand().get(urut).getPic()))));
        pane = new JOptionPane("");
        if (turn % 2 == 1 && Player.isFirstTurn() && !indexAtk.contains(urut)) {
            options = new String[]{"Serang", "Set", "Batal"};
        } else {
            options = new String[]{"Ok"};
        }
        pane.setOptions(options);
        dialog = new JDialog();
        dialog = pane.createDialog(pan, "Aksi");
        dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        dialog.setLayout(new BorderLayout());
//            pane.set
//            dialog.add(pan, BorderLayout.NORTH);
//            dialog.add(pane, BorderLayout.SOUTH);
        dialog.add(new JLabel(new javax.swing.ImageIcon(getClass().getResource(Player.getArena().get(urut).getPic().replace("/kecil", "")))), BorderLayout.SOUTH);
        dialog.setSize(300, 522);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        dialog.setLocation(dim.width / 2 - dialog.getSize().width / 2, dim.height / 2 - dialog.getSize().height / 2);
        dialog.show();
        Object obj = pane.getValue();
        return obj;
    }

    int pilih, target;

    private class lapangan implements ActionListener {

        private int i;

        public lapangan(int ii) {
            i = ii;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Object obj = arenaAct(i - 1);

            if (obj.equals("Serang")) {
                if (Enemy.getArena().size() > 0) {
                    Player.setAttack(true);
                    pilih = i - 1;
                } else {
                    Enemy.setHP(Player.getArena().get(i - 1).getAtk());
                }
            } else if (obj.equals("Set")) {
                Player.setDef(i - 1);
            }
        }
    }

    //Act pitetan lawan
    private Object lawanAct(int urut) {
        JFrame pan = new JFrame();
//            pan.setLayout(new FlowLayout());
//            pan.add(new JLabel(new javax.swing.ImageIcon(getClass().getResource(Player.getHand().get(urut).getPic()))));
        pane = new JOptionPane("");
        if (turn % 2 == 1 && Player.isAttack()) {
            options = new String[]{"Serang", "Batal"};
        } else {
            options = new String[]{"Ok"};
        }
        pane.setOptions(options);
        dialog = new JDialog();
        dialog = pane.createDialog(pan, "Aksi");
        dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        dialog.setLayout(new BorderLayout());
//            pane.set
//            dialog.add(pan, BorderLayout.NORTH);
//            dialog.add(pane, BorderLayout.SOUTH);
        dialog.add(new JLabel(new javax.swing.ImageIcon(getClass().getResource(Enemy.getArena().get(urut).getPic().replace("/kecil", "")))), BorderLayout.SOUTH);
        dialog.setSize(300, 522);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        dialog.setLocation(dim.width / 2 - dialog.getSize().width / 2, dim.height / 2 - dialog.getSize().height / 2);
        dialog.show();
        Object obj = pane.getValue();
        return obj;
    }

    private class lawan implements ActionListener {

        private int i, damage;

        public lawan(int ii) {
            i = ii;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Object obj = lawanAct(i - 1);

            if (obj.equals("Serang")) {
                target = i - 1;
                System.out.println("==Attack==");
                System.out.println(Player.getArena().get(pilih).getNama() + " atk = " + Player.getArena().get(pilih).getAtk());
                System.out.println("====VS====");
                System.out.println(Enemy.getArena().get(target).getNama() + " atk = " + Enemy.getArena().get(target).getAtk());
//                damage = Player.Attack(Player.getArena().get(pilih).getAtk(), Enemy.getArena().get(target).getAtk());
//                calculate();
                indexAtk.add(pilih);
                Player.Attack(Enemy, Player, pilih, target);
            }
        }
    }
    //Act pitetan kuburan

    private Object kuburanAct(boolean act) {
        JFrame pan = new JFrame();
//            pan.setLayout(new FlowLayout());
//            pan.add(new JLabel(new javax.swing.ImageIcon(getClass().getResource(Player.getHand().get(urut).getPic()))));
        pane = new JOptionPane("");
        options = new String[]{"Ok"};
        pane.setOptions(options);
        dialog = new JDialog();
        dialog = pane.createDialog(pan, "Korban Jiwa ;(");
        dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        dialog.setLayout(new BorderLayout());
//            pane.set
//            dialog.add(pan, BorderLayout.NORTH);
//            dialog.add(pane, BorderLayout.SOUTH);
        if (act) {
            dialog.add(new JLabel(new javax.swing.ImageIcon(getClass().getResource(Player.getKuburan().peek().getPic().replace("/kecil", "")))), BorderLayout.SOUTH);
        } else {
            dialog.add(new JLabel(new javax.swing.ImageIcon(getClass().getResource(Enemy.getKuburan().peek().getPic().replace("/kecil", "")))), BorderLayout.SOUTH);
        }
        dialog.setSize(300, 522);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        dialog.setLocation(dim.width / 2 - dialog.getSize().width / 2, dim.height / 2 - dialog.getSize().height / 2);
        dialog.show();
        Object obj = pane.getValue();
        return obj;
    }

    private class Kuburan implements ActionListener {

        private boolean act;

        public Kuburan(boolean act) {
            this.act = act;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Object obj = kuburanAct(act);
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
