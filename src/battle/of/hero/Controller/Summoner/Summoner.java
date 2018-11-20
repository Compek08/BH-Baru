/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battle.of.hero.Controller.Summoner;

import java.util.*;
import BattleMain.*;
import battle.of.hero.Controller.cPlay;
import battle.of.hero.View.PlayClassic;
import java.util.concurrent.TimeUnit;
import javax.swing.SwingWorker;

/**
 *
 * @author rakas
 */
abstract class Summoner {

    protected ArrayList<Card> hand, arena;
    protected Stack<Card> deck;
    protected int HP = 100;
    protected PlayClassic vClassic = new PlayClassic();
    protected String user;

    public Summoner(PlayClassic vClassic, String user) {
        this.arena = new ArrayList<>();
        this.vClassic = vClassic;
        this.user = user;
        deck = new Stack<>();
        hand = new ArrayList<>();
    }

    public ArrayList<Card> getArena() {
        return arena;
    }

    public int getHP() {
        return HP;
    }

    public abstract ArrayList<Card> getHand();

    public void Draw(boolean act) {
        hand.add(deck.pop());
        System.out.println("draw");
        hand.trimToSize();
        System.out.println("tangan = " + hand.size());
        for (int i = 0; i < hand.size(); i++) {
            String[] url = hand.get(i).getPic().split("/");
            String urll = "";
            for (int j = 0; j < url.length; j++) {
                if (j == (url.length - 1)) {
                    urll += ("/kecil/" + url[j]);
                } else {
                    if (j == 0) {
                        urll += url[j];
                    } else {
                        urll += "/" + url[j];
                    }
                }
            }
            switch (i) {
                case 0:
                    if (act) {
                        vClassic.getC1().setVisible(true);
                        vClassic.getC1().setIcon(new javax.swing.ImageIcon(getClass().getResource(urll)));
                    } else {
                        vClassic.getD1().setVisible(true);
                        vClassic.getD1().setIcon(new javax.swing.ImageIcon(getClass().getResource("/battle/of/hero/image/kartu/kecil/kartu blkg.png")));
                    }
                    break;
                case 1:
                    if (act) {
                        vClassic.getC2().setVisible(true);
                        vClassic.getC2().setIcon(new javax.swing.ImageIcon(getClass().getResource(urll)));
                    } else {
                        vClassic.getD2().setVisible(true);
                        vClassic.getD2().setIcon(new javax.swing.ImageIcon(getClass().getResource("/battle/of/hero/image/kartu/kecil/kartu blkg.png")));
                    }
                    break;
                case 2:
                    if (act) {
                        vClassic.getC3().setVisible(true);
                        vClassic.getC3().setIcon(new javax.swing.ImageIcon(getClass().getResource(urll)));
                    } else {
                        vClassic.getD3().setVisible(true);
                        vClassic.getD3().setIcon(new javax.swing.ImageIcon(getClass().getResource("/battle/of/hero/image/kartu/kecil/kartu blkg.png")));
                    }
                    break;
                case 3:
                    if (act) {
                        vClassic.getC4().setVisible(true);
                        vClassic.getC4().setIcon(new javax.swing.ImageIcon(getClass().getResource(urll)));
                    } else {
                        vClassic.getD4().setVisible(true);
                        vClassic.getD4().setIcon(new javax.swing.ImageIcon(getClass().getResource("/battle/of/hero/image/kartu/kecil/kartu blkg.png")));
                    }
                    break;
                case 4:
                    if (act) {
                        vClassic.getC5().setVisible(true);
                        vClassic.getC5().setIcon(new javax.swing.ImageIcon(getClass().getResource(urll)));
                    } else {
                        vClassic.getD5().setVisible(true);
                        vClassic.getD5().setIcon(new javax.swing.ImageIcon(getClass().getResource("/battle/of/hero/image/kartu/kecil/kartu blkg.png")));
                    }
                    break;
                case 5:
                    if (act) {
                        vClassic.getC6().setVisible(true);
                        vClassic.getC6().setIcon(new javax.swing.ImageIcon(getClass().getResource(urll)));
                    } else {
                        vClassic.getD6().setVisible(true);
                        vClassic.getD6().setIcon(new javax.swing.ImageIcon(getClass().getResource("/battle/of/hero/image/kartu/kecil/kartu blkg.png")));
                    }
                    break;
                case 6:
                    if (act) {
                        vClassic.getC7().setVisible(true);
                        vClassic.getC7().setIcon(new javax.swing.ImageIcon(getClass().getResource(urll)));
                    } else {
                        vClassic.getD7().setVisible(true);
                        vClassic.getD7().setIcon(new javax.swing.ImageIcon(getClass().getResource("/battle/of/hero/image/kartu/kecil/kartu blkg.png")));
                    }
                    break;
            }
        }
    }

    public void DrawFirst(boolean act) {
        for (int i = 0; i < 6; i++) {
            hand.add(deck.pop());
            System.out.println("draw awal = " + hand.size());
            String[] url = hand.get(i).getPic().split("/");
            String urll = "";
            for (int j = 0; j < url.length; j++) {
                if (j == (url.length - 1)) {
                    urll += ("/kecil/" + url[j]);
                } else {
                    if (j == 0) {
                        urll += url[j];
                    } else {
                        urll += "/" + url[j];
                    }
                }
            }
            final int urut = i;
            final String link = urll;
//            System.out.println(urll);
            SwingWorker<Void, String> Draw = new SwingWorker<Void, String>() {
                @Override
                protected Void doInBackground() throws Exception {
                    switch (urut) {
                        case 0:
                            if (act) {
                                vClassic.getC1().setVisible(true);
                                vClassic.getC1().setIcon(new javax.swing.ImageIcon(getClass().getResource(link)));
                            } else {
                                vClassic.getD1().setVisible(true);
                                vClassic.getD1().setIcon(new javax.swing.ImageIcon(getClass().getResource("/battle/of/hero/image/kartu/kecil/kartu blkg.png")));
                            }
                    TimeUnit.SECONDS.sleep(1);
                            break;
                        case 1:
                            if (act) {
                                vClassic.getC2().setVisible(true);
                                vClassic.getC2().setIcon(new javax.swing.ImageIcon(getClass().getResource(link)));
                            } else {
                                vClassic.getD2().setVisible(true);
                                vClassic.getD2().setIcon(new javax.swing.ImageIcon(getClass().getResource("/battle/of/hero/image/kartu/kecil/kartu blkg.png")));
                            }
                    TimeUnit.SECONDS.sleep(1);
                            break;
                        case 2:
                            if (act) {
                                vClassic.getC3().setVisible(true);
                                vClassic.getC3().setIcon(new javax.swing.ImageIcon(getClass().getResource(link)));
                            } else {
                                vClassic.getD3().setVisible(true);
                                vClassic.getD3().setIcon(new javax.swing.ImageIcon(getClass().getResource("/battle/of/hero/image/kartu/kecil/kartu blkg.png")));
                            }
                    TimeUnit.SECONDS.sleep(1);
                            break;
                        case 3:
                            if (act) {
                                vClassic.getC4().setVisible(true);
                                vClassic.getC4().setIcon(new javax.swing.ImageIcon(getClass().getResource(link)));
                            } else {
                                vClassic.getD4().setVisible(true);
                                vClassic.getD4().setIcon(new javax.swing.ImageIcon(getClass().getResource("/battle/of/hero/image/kartu/kecil/kartu blkg.png")));
                            }
                    TimeUnit.SECONDS.sleep(1);
                            break;
                        case 4:
                            if (act) {
                                vClassic.getC5().setVisible(true);
                                vClassic.getC5().setIcon(new javax.swing.ImageIcon(getClass().getResource(link)));
                            } else {
                                vClassic.getD5().setVisible(true);
                                vClassic.getD5().setIcon(new javax.swing.ImageIcon(getClass().getResource("/battle/of/hero/image/kartu/kecil/kartu blkg.png")));
                            }
                    TimeUnit.SECONDS.sleep(1);
                            break;
                        case 5:
                            if (act) {
                                vClassic.getC6().setVisible(true);
                                vClassic.getC6().setIcon(new javax.swing.ImageIcon(getClass().getResource(link)));
                            } else {
                                vClassic.getD6().setVisible(true);
                                vClassic.getD6().setIcon(new javax.swing.ImageIcon(getClass().getResource("/battle/of/hero/image/kartu/kecil/kartu blkg.png")));
                            }
                    TimeUnit.SECONDS.sleep(1);
                            break;
                    }
                    return null;
                }
            };
            Draw.execute();
        }
    }

    public void Summon(int urut) {
        arena.add(hand.get(urut));
        hand.remove(urut);
        hand.trimToSize();
    }

    public int getDeck() {
        return deck.size();
    }

    public void End() {
        hand.trimToSize();
        arena.trimToSize();
        if (hand.size() == 7) {
            hand.remove(6);
            if (user.equals("Play")) {
                System.out.println("Player End");
//                vClassic.getC7().setVisible(false);
            } else {
                System.out.println("Enemy End");
//                vClassic.getD7().setVisible(false);
            }
        }
        if (getDeck() == 0) {
            System.out.println("Game Over");
            System.exit(1);
        }
        refresh();
    }

    public void refresh() {
        int sisa = hand.size();
        System.out.println("tangan = " + sisa);
        switch (sisa) {
            case 0:
                if (user.equals("Play")) {
                    vClassic.getC1().setVisible(false);
                    vClassic.getC1().setIcon(null);
                } else {
                    vClassic.getD1().setVisible(false);
                    vClassic.getD1().setIcon(null);
                }
            case 1:
                if (user.equals("Play")) {
                    vClassic.getC2().setVisible(false);
                    vClassic.getC2().setIcon(null);
                } else {
                    vClassic.getD2().setVisible(false);
                    vClassic.getD2().setIcon(null);
                }
            case 2:
                if (user.equals("Play")) {
                    vClassic.getC3().setVisible(false);
                    vClassic.getC3().setIcon(null);
                } else {
                    vClassic.getD3().setVisible(false);
                    vClassic.getD3().setIcon(null);
                }
            case 3:
                if (user.equals("Play")) {
                    vClassic.getC4().setVisible(false);
                    vClassic.getC4().setIcon(null);
                } else {
                    vClassic.getD4().setVisible(false);
                    vClassic.getD4().setIcon(null);
                }
            case 4:
                if (user.equals("Play")) {
                    vClassic.getC5().setVisible(false);
                    vClassic.getC5().setIcon(null);
                } else {
                    vClassic.getD5().setVisible(false);
                    vClassic.getD5().setIcon(null);
                }
            case 5:
                if (user.equals("Play")) {
                    vClassic.getC6().setVisible(false);
                    vClassic.getC6().setIcon(null);
                } else {
                    vClassic.getD6().setVisible(false);
                    vClassic.getD6().setIcon(null);
                }
            case 6:
                if (user.equals("Play")) {
                    vClassic.getC7().setVisible(false);
                    vClassic.getC7().setIcon(null);
                } else {
                    vClassic.getD7().setVisible(false);
                    vClassic.getD7().setIcon(null);
                }
        }
    }

    public String getUser() {
        return user;
    }
}
