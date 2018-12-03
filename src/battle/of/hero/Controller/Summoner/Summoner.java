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
    protected Stack<Card> kuburan;
    protected int HP = 100;
    protected PlayClassic vClassic = new PlayClassic();
    protected String user;
    protected boolean summon, firstTurn;
//    private Card spell;

    public Summoner(PlayClassic vClassic, String user) {
        this.arena = new ArrayList<>();
        this.vClassic = vClassic;
        this.user = user;
        kuburan = new Stack<>();
        deck = new Stack<>();
        hand = new ArrayList<>();
        firstTurn = false;
    }

    public boolean isFirstTurn() {
        return firstTurn;
    }

    public void setFirstTurn(boolean firstTurn) {
        this.firstTurn = firstTurn;
    }

    public ArrayList<Card> getArena() {
        return arena;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP -= HP;
        refresh();
    }

    public Stack<Card> getKuburan() {
        return kuburan;
    }

    public abstract ArrayList<Card> getHand();

    public void Draw(boolean act) {
        hand.add(deck.pop());
//        System.out.println("draw");
        hand.trimToSize();
//        System.out.println("tangan = " + hand.size());
        refresh();
    }

    public void DrawFirst(boolean act) {
        for (int i = 0; i < 6; i++) {
            hand.add(deck.pop());
//            System.out.println("draw awal = " + hand.size());
            String urll = hand.get(i).getPic();
            final int urut = i;
            final String link = urll;
//            System.out.println(urll);
        }
        refresh();
    }

    public void Summon(int urut) {
//        System.out.println("==Summon kartu==");
//        if (hand.get(urut).getGrade() == 4) {
//            spell = hand.get(urut);
//        } else {
//            if (spell != null) {
//                if (hand.get(urut).getArea() == spell.getArea()) {
//                    
//                }
//            }
        arena.add(hand.get(urut));
//        }
        System.out.println("Nama = " + hand.get(urut).getNama());
//        System.out.println("pic = " + hand.get(urut).getPic());
        hand.remove(urut);
        hand.trimToSize();
        refresh();
    }

    public void Attack(Summoner E, Summoner P, int pil, int tar) {
        Card pilih = P.getArena().get(pil);
        Card target = E.getArena().get(tar);
        int serang, diserang;

//        if (pilih.getArea() == spell.getArea()) {
//            serang = pilih.getAtk() + spell.getAtk();
//        }
//        if (spell == null) {
        if (target.getPic().contains("def")) {
            if (pilih.getAtk() > target.getDef()) {
                E.destroy(tar);
            } else {
                P.destroy(pil);
            }
        } else {
            int damage = pilih.getAtk() - target.getAtk();
            int signum = Integer.signum(damage);
            switch (signum) {
                case -1:
                    P.destroy(pil);
                    P.setHP(-damage);
                    break;
                case 0:
                    E.destroy(tar);
                    P.destroy(pil);
                    break;
                case 1:
                    E.destroy(tar);
                    E.setHP(damage);
                    break;
            }

//                if (pilih.getAtk() > target.getAtk()) {
//                    E.destroy(tar);
//                    E.setHP(pilih.getAtk() - target.getAtk());
//                } else if (pilih.getAtk() < target.getAtk()) {
//
//                }
        }
//        }
    }

    public int Attack(int pilih, int target) {
        return (pilih - target);
    }

    public int getDeck() {
        return deck.size();
    }

    public boolean cekHP() {
        if (HP <= 0) {
            return false;
        } else {
            return true;
        }
    }

    public void End() {
        hand.trimToSize();
        arena.trimToSize();
//        System.out.println(hand.size());
        if (hand.size() == 7) {
            hand.remove(6);
            if (user.equals("Play")) {
//                System.out.println("Player End");
//                vClassic.getC7().setVisible(false);
            } else {
//                System.out.println("Enemy End");
//                vClassic.getD7().setVisible(false);
            }
        }
        if (getDeck() == 0) {
            System.out.println("Game Over");
            System.exit(1);
        }
        refresh();
    }

    public void destroy(int index) {
        if (kuburan.isEmpty()) {
            if (user.equals("Play")) {
                vClassic.getKuburanP().setVisible(true);
            } else {
                vClassic.getKuburanE().setVisible(true);
            }
        }
        kuburan.push(arena.get(index));
        arena.remove(index);
        arena.trimToSize();
        refresh();
    }

    public void refresh() {
        int sisa = hand.size();
//        System.out.println("tangan = " + sisa);

        //=============== TANGAN ===============
        //Benerno Tangan
        for (int i = 0; i < sisa; i++) {
            String urll = hand.get(i).getPic();
            switch (i) {
                case 0:
                    if (user.equals("Play")) {
                        vClassic.getC1().setVisible(true);
                        vClassic.getC1().setIcon(new javax.swing.ImageIcon(getClass().getResource(urll)));
                    } else {
                        vClassic.getD1().setVisible(true);
                        vClassic.getD1().setIcon(new javax.swing.ImageIcon(getClass().getResource("/battle/of/hero/image/kartu/kecil/kartu blkg.png")));
                    }
                    break;
                case 1:
                    if (user.equals("Play")) {
                        vClassic.getC2().setVisible(true);
                        vClassic.getC2().setIcon(new javax.swing.ImageIcon(getClass().getResource(urll)));
                    } else {
                        vClassic.getD2().setVisible(true);
                        vClassic.getD2().setIcon(new javax.swing.ImageIcon(getClass().getResource("/battle/of/hero/image/kartu/kecil/kartu blkg.png")));
                    }
                    break;
                case 2:
                    if (user.equals("Play")) {
                        vClassic.getC3().setVisible(true);
                        vClassic.getC3().setIcon(new javax.swing.ImageIcon(getClass().getResource(urll)));
                    } else {
                        vClassic.getD3().setVisible(true);
                        vClassic.getD3().setIcon(new javax.swing.ImageIcon(getClass().getResource("/battle/of/hero/image/kartu/kecil/kartu blkg.png")));
                    }
                    break;
                case 3:
                    if (user.equals("Play")) {
                        vClassic.getC4().setVisible(true);
                        vClassic.getC4().setIcon(new javax.swing.ImageIcon(getClass().getResource(urll)));
                    } else {
                        vClassic.getD4().setVisible(true);
                        vClassic.getD4().setIcon(new javax.swing.ImageIcon(getClass().getResource("/battle/of/hero/image/kartu/kecil/kartu blkg.png")));
                    }
                    break;
                case 4:
                    if (user.equals("Play")) {
                        vClassic.getC5().setVisible(true);
                        vClassic.getC5().setIcon(new javax.swing.ImageIcon(getClass().getResource(urll)));
                    } else {
                        vClassic.getD5().setVisible(true);
                        vClassic.getD5().setIcon(new javax.swing.ImageIcon(getClass().getResource("/battle/of/hero/image/kartu/kecil/kartu blkg.png")));
                    }
                    break;
                case 5:
                    if (user.equals("Play")) {
                        vClassic.getC6().setVisible(true);
                        vClassic.getC6().setIcon(new javax.swing.ImageIcon(getClass().getResource(urll)));
                    } else {
                        vClassic.getD6().setVisible(true);
                        vClassic.getD6().setIcon(new javax.swing.ImageIcon(getClass().getResource("/battle/of/hero/image/kartu/kecil/kartu blkg.png")));
                    }
                    break;
                case 6:
                    if (user.equals("Play")) {
                        vClassic.getC7().setVisible(true);
                        vClassic.getC7().setIcon(new javax.swing.ImageIcon(getClass().getResource(urll)));
                    } else {
                        vClassic.getD7().setVisible(true);
                        vClassic.getD7().setIcon(new javax.swing.ImageIcon(getClass().getResource("/battle/of/hero/image/kartu/kecil/kartu blkg.png")));
                    }
                    break;
            }
//            System.out.println(hand.get(i).getNama() + " atk = " + hand.get(i).getAtk());
        }

        //Ngilangno Tangan
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

        //=============== ARENA ===============
        sisa = arena.size();
        //Benerno Arena
        for (int i = 0; i < sisa; i++) {
            String urll = arena.get(i).getPic();
            switch (i) {
                case 0:
                    if (user.equals("Play")) {
                        if (urll.contains("def")) {
                            vClassic.getA6().setVisible(true);
                            vClassic.getA6().setIcon(new javax.swing.ImageIcon(getClass().getResource(urll)));
                        } else {
                            vClassic.getA1().setVisible(true);
                            vClassic.getA1().setIcon(new javax.swing.ImageIcon(getClass().getResource(urll)));
                        }
                    } else {
                        if (urll.contains("def")) {
                            vClassic.getB2().setVisible(true);
                            vClassic.getB2().setIcon(new javax.swing.ImageIcon(getClass().getResource(urll)));
                        } else {
                            vClassic.getB1().setVisible(true);
                            vClassic.getB1().setIcon(new javax.swing.ImageIcon(getClass().getResource(urll)));
                        }
                    }
                    break;
                case 1:
                    if (user.equals("Play")) {
                        if (urll.contains("def")) {
                            vClassic.getA7().setVisible(true);
                            vClassic.getA7().setIcon(new javax.swing.ImageIcon(getClass().getResource(urll)));
                        } else {
                            vClassic.getA2().setVisible(true);
                            vClassic.getA2().setIcon(new javax.swing.ImageIcon(getClass().getResource(urll)));
                        }
                    } else {
                        if (urll.contains("def")) {
                            vClassic.getB4().setVisible(true);
                            vClassic.getB4().setIcon(new javax.swing.ImageIcon(getClass().getResource(urll)));
                        } else {
                            vClassic.getB3().setVisible(true);
                            vClassic.getB3().setIcon(new javax.swing.ImageIcon(getClass().getResource(urll)));
                        }
                    }
                    break;
                case 2:
                    if (user.equals("Play")) {
                        if (urll.contains("def")) {
                            vClassic.getA8().setVisible(true);
                            vClassic.getA8().setIcon(new javax.swing.ImageIcon(getClass().getResource(urll)));
                        } else {
                            vClassic.getA3().setVisible(true);
                            vClassic.getA3().setIcon(new javax.swing.ImageIcon(getClass().getResource(urll)));
                        }
                    } else {
                        if (urll.contains("def")) {
                            vClassic.getB6().setVisible(true);
                            vClassic.getB6().setIcon(new javax.swing.ImageIcon(getClass().getResource(urll)));
                        } else {
                            vClassic.getB5().setVisible(true);
                            vClassic.getB5().setIcon(new javax.swing.ImageIcon(getClass().getResource(urll)));
                        }
                    }
                    break;
                case 3:
                    if (user.equals("Play")) {
                        if (urll.contains("def")) {
                            vClassic.getA9().setVisible(true);
                            vClassic.getA9().setIcon(new javax.swing.ImageIcon(getClass().getResource(urll)));
                        } else {
                            vClassic.getA4().setVisible(true);
                            vClassic.getA4().setIcon(new javax.swing.ImageIcon(getClass().getResource(urll)));
                        }
                    } else {
                        if (urll.contains("def")) {
                            vClassic.getB8().setVisible(true);
                            vClassic.getB8().setIcon(new javax.swing.ImageIcon(getClass().getResource(urll)));
                        } else {
                            vClassic.getB7().setVisible(true);
                            vClassic.getB7().setIcon(new javax.swing.ImageIcon(getClass().getResource(urll)));
                        }
                    }
                    break;
                case 4:
                    if (user.equals("Play")) {
                        if (urll.contains("def")) {
                            vClassic.getA10().setVisible(true);
                            vClassic.getA10().setIcon(new javax.swing.ImageIcon(getClass().getResource(urll)));
                        } else {
                            vClassic.getA5().setVisible(true);
                            vClassic.getA5().setIcon(new javax.swing.ImageIcon(getClass().getResource(urll)));
                        }
                    } else {
                        if (urll.contains("def")) {
                            vClassic.getB10().setVisible(true);
                            vClassic.getB10().setIcon(new javax.swing.ImageIcon(getClass().getResource(urll)));
                        } else {
                            vClassic.getB9().setVisible(true);
                            vClassic.getB9().setIcon(new javax.swing.ImageIcon(getClass().getResource(urll)));
                        }
                    }
                    break;
            }
        }

        //Ngilangno Arena
        switch (sisa) {
            case 0:
                if (user.equals("Play")) {
                    vClassic.getA1().setVisible(false);
                    vClassic.getA1().setIcon(null);
                    vClassic.getA6().setVisible(false);
                    vClassic.getA6().setIcon(null);
                } else {
                    vClassic.getB1().setVisible(false);
                    vClassic.getB1().setIcon(null);
                    vClassic.getB2().setVisible(false);
                    vClassic.getB2().setIcon(null);
                }
            case 1:
                if (user.equals("Play")) {
                    vClassic.getA2().setVisible(false);
                    vClassic.getA2().setIcon(null);
                    vClassic.getA7().setVisible(false);
                    vClassic.getA7().setIcon(null);
                } else {
                    vClassic.getB3().setVisible(false);
                    vClassic.getB3().setIcon(null);
                    vClassic.getB4().setVisible(false);
                    vClassic.getB4().setIcon(null);
                }
            case 2:
                if (user.equals("Play")) {
                    vClassic.getA3().setVisible(false);
                    vClassic.getA3().setIcon(null);
                    vClassic.getA8().setVisible(false);
                    vClassic.getA8().setIcon(null);
                } else {
                    vClassic.getB5().setVisible(false);
                    vClassic.getB5().setIcon(null);
                    vClassic.getB6().setVisible(false);
                    vClassic.getB6().setIcon(null);
                }
            case 3:
                if (user.equals("Play")) {
                    vClassic.getA4().setVisible(false);
                    vClassic.getA4().setIcon(null);
                    vClassic.getA9().setVisible(false);
                    vClassic.getA9().setIcon(null);
                } else {
                    vClassic.getB7().setVisible(false);
                    vClassic.getB7().setIcon(null);
                    vClassic.getB8().setVisible(false);
                    vClassic.getB8().setIcon(null);
                }
            case 4:
                if (user.equals("Play")) {
                    vClassic.getA5().setVisible(false);
                    vClassic.getA5().setIcon(null);
                    vClassic.getA10().setVisible(false);
                    vClassic.getA10().setIcon(null);
                } else {
                    vClassic.getB9().setVisible(false);
                    vClassic.getB9().setIcon(null);
                    vClassic.getB10().setVisible(false);
                    vClassic.getB10().setIcon(null);
                }
        }

        //Spell
//        if (spell == null) {
//            vClassic.getESpell().setVisible(false);
//            vClassic.getPSpell().setVisible(false);
//        } else {
//            vClassic.getESpell().setVisible(true);
//            vClassic.getPSpell().setVisible(true);
//
//            vClassic.getESpell().setIcon(new javax.swing.ImageIcon(getClass().getResource(spell.getPic())));
//            vClassic.getPSpell().setIcon(new javax.swing.ImageIcon(getClass().getResource(spell.getPic())));
//        }
        //Lain - Laine
        //Ombean
        if (user.equals("Play")) {
            if (deck.size() > 0) {
                vClassic.getOmbean1().setVisible(true);
                vClassic.getOmbean1().setIcon(new javax.swing.ImageIcon(getClass().getResource("/battle/of/hero/image/kartu/kecil/kartu blkg.png")));
            } else {
                vClassic.getOmbean1().setVisible(false);
            }
        } else {
            if (deck.size() > 0) {
                vClassic.getOmbean2().setVisible(true);
                vClassic.getOmbean2().setIcon(new javax.swing.ImageIcon(getClass().getResource("/battle/of/hero/image/kartu/kecil/kartu blkg.png")));
            } else {
                vClassic.getOmbean2().setVisible(false);
            }
        }

        //Kuburan
        if (!kuburan.empty()) {
            if (kuburan.peek().getPic().contains("def")) {
                kuburan.peek().setPic(kuburan.peek().getPic().replace("def", "kecil"));
            }
            if (user.equals("Play")) {
                vClassic.getKuburanP().setIcon(new javax.swing.ImageIcon(getClass().getResource(kuburan.peek().getPic())));
            } else {
                vClassic.getKuburanE().setIcon(new javax.swing.ImageIcon(getClass().getResource(kuburan.peek().getPic())));
            }
        }

        //HP
        if (user.equals("Play")) {
            vClassic.getPHP().setText("" + HP);
        } else {
            vClassic.getEHP().setText("" + HP);
        }

    }

    public String getUser() {
        return user;
    }

    public boolean isSummon() {
        return summon;
    }

    public void setSummon(boolean summon) {
        this.summon = summon;
    }

    public void setDef(int idx) {
        if (arena.get(idx).getPic().contains("def")) {
            String pic = arena.get(idx).getPic();
            pic = pic.replace("def", "kecil");
            arena.get(idx).setPic(pic);
        } else {
            String pic = arena.get(idx).getPic();
            pic = pic.replace("kecil", "def");
            arena.get(idx).setPic(pic);
        }
    }

//    public Card getSpell() {
//        return spell;
//    }
    public void setKecil(Card target) {
        String[] url = target.getPic().split("/");
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
        target.setPic(urll);
    }

    public void activate(Summoner P, Summoner E, Spell Spell) {
        P.getArena().forEach((set) -> {
            if (set.getArea() == Spell.getArea()) {
                set.setAtk(set.getAtk() + Spell.getAtk());
                set.setDef(set.getDef() + Spell.getDef());
            }
        });

        E.getArena().forEach((set) -> {
            if (set.getArea() == Spell.getArea()) {
                set.setAtk(set.getAtk() + Spell.getAtk());
                set.setDef(set.getDef() + Spell.getDef());
            }
        });
    }

    public void deactivate(Summoner P, Summoner E, Spell Spell) {
        P.getArena().forEach((set) -> {
            if (set.getArea() == Spell.getArea()) {
                set.setAtk(set.getAtk() - Spell.getAtk());
                set.setDef(set.getDef() - Spell.getDef());
            }
        });

        E.getArena().forEach((set) -> {
            if (set.getArea() == Spell.getArea()) {
                set.setAtk(set.getAtk() - Spell.getAtk());
                set.setDef(set.getDef() - Spell.getDef());
            }
        });
    }

    public void setDeck() {
//        System.out.println(deck.size());
        deck.forEach((card) -> {
            if (!card.getPic().contains("/kecil")) {
                setKecil(card);
            }
        });
    }
}
