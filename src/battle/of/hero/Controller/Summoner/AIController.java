/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battle.of.hero.Controller.Summoner;

import BattleMain.Card;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author rakas 
 1. Cek area lawan 
 2. Jika tidak ada kartu atk : pasang kartu penyerang dengan nilai atk tertinggi 
 3. Jika ada kartu atk : Cek posisi kartu lawan (horizontal/vertikal/tertutup) 
      3a. Jika horizontal, cekSummon nilai def dari kartu yang posisi horizontal 
      3b. Jika vertikal, cekSummon nilai atk dari kartu yang posisi vertikal 
      3c. Jika kartu tertutup, pasang kartu dengan nilai atk tinggi
      3d. Jika terdapat dua atau lebih kartu dengan posisi berbeda : 
          3d1. Cek kartu dengan posisi vertikal terlebih dulu, cekSummon kartu atk yang dimiliki, jika kartu
               yang dimiliki bernilai lebih besar dari atk kartu lawan, maka pasang kartu
               tersebut dan serang kartu lawan, jika tidak memiliki kartu dengan nilai
                 lebih, maka lanjut dengan langkah 3c2. 
          3c2. Cek kartu lawan dengan posisi horizontal, jika memiliki kartu dengan atk lebih besar dari 
               nilai def lawan, pasang kartu tersebut dan serang kartu yang dicek. 3c3. Pasang kartu dengan
               nilai atk tinggi dan serang kartu lawan dengan posisi tertutup
 */
public class AIController {

    private ArrayList<Card> APlayer, AEnemy, hand;
    private int max, min, index, pmax;
    private ArrayList<Integer> act, slc;
    private boolean hero = true, atk = false;

    public void setAtk(boolean atk) {
        this.atk = atk;
    }

    public AIController(ArrayList<Card> APlayer, ArrayList<Card> AEnemy, ArrayList<Card> hand) {
        this.APlayer = APlayer;
        this.AEnemy = AEnemy;
        this.hand = hand;
        min = 0;
        max = 0;
    }

    public ArrayList<Integer> cekSummon() {
        act = new ArrayList<>();
        slc = new ArrayList<>();
        index = -1;
        max = 0;
        min = 0;
        if (APlayer.isEmpty()) {
            act.add(1);
            hand.forEach((cek) -> {
                System.out.println("Atk : " + cek.getAtk());
                if (cek.getAtk() > max && (cek.getGrade() != 4)) {
                    max = cek.getAtk();
                    index = hand.indexOf(cek);
//                    System.out.println("Index AI sumon : " + index);
                }
            });
//            act.add(index);
        } else {
            pmax = 0;
            APlayer.forEach((cek) -> {
                if (pmax < cek.getAtk()) {
                    pmax = cek.getAtk();
                }
            });
            
//            APlayer.forEach((cek) -> {
//                if (cek.getGrade() == 4) {
//                    hand.forEach((tangan) -> {
//                        if (tangan.getArea() == cek.getArea()) {
//                            APlayer.forEach((search) -> {
//                                if (search.getArea() == cek.getArea()) {
//                                    if (search.getAtk() > min && search.getGrade() != 4) {
//                                        min = search.getAtk();
//                                    }
//                                }
//                            });
//                            hand.forEach((search) -> {
//                                if (search.getArea() == cek.getArea()) {
//                                    if (search.getAtk() > max && search.getGrade() != 4) {
//                                        max = search.getAtk();
//                                        index = hand.indexOf(search);
//                                    }
//                                }
//                            });
//                            if (max > min) {
//                                act.add(2);
//                            } else {
//                                index = -1;
//                            }
//                        }
//                    });
//                } else {
            hand.forEach((tangan) -> {
                System.out.println("Atk : " + tangan.getAtk());
                if (pmax < tangan.getAtk() && tangan.getGrade() != 4) {
                    if (index == -1) {
                        act.add(1);
                        index = hand.indexOf(tangan);
                    } else {
                        if (tangan.getAtk() > hand.get(index).getAtk()) {
                            index = hand.indexOf(tangan);
                        }
                    }
                }
            });
            if (index == -1) {
                hand.forEach((cek) -> {
                    if (cek.getGrade() != 4) {
                        index = hand.indexOf(cek);
                    }
                });
                act.add(5);
                hand.forEach((tangan) -> {
                    if (tangan.getAtk() > hand.get(index).getAtk() && tangan.getGrade() != 4) {
                        index = hand.indexOf(tangan);
                    }
                });
            }
//                }
//            });
        }
//        int sumon = 0;
//        while (sumon != 1) {          
//            for (int i = 0; i < act.size(); i++) {
//                if (act.get(i) == 1 || act.get(i) == 2) {
//                    sumon++;
//                }
//            }
//            prioritize();
//        }
        System.out.println("Size of act" + act.size());
        System.out.println("Index AI sumon : " + index);
        return act;
    }
    
    public void setSpell(ArrayList<Integer> area) {
        index = -1;
        Collections.sort(area);
        int itung = 0, max = 0, index = 0;
        for (int i = 0; i < area.size(); i++) {
            if (i == 0) {
                itung++;
            } else {
                if (area.get(i) == area.get(i - 1)) {
                    itung++;
                } else {
                    if (itung > max) {
                        max = itung;
                        itung = 1;
                        index = i;
                    }
                }
                if (i == area.size()-1) {
                    if (itung > max) {
                        max = itung;
                        index = i;
                    }
                }
            }
        }
        getSpell(area.get(index));
    }

    private void getSpell(int area) {
        hand.forEach((cek) -> {
            if (cek.getGrade() == 4 && cek.getArea() == area) {
                index = hand.indexOf(cek);
            }
        });
    }

    public ArrayList<Integer> cekAttack() {
        act.clear();
        slc.clear();
        ArrayList<Integer> urut = new ArrayList<>();ArrayList<Integer> att = new ArrayList<>();
        index = -1;
        AEnemy.forEach((plus) -> {
            urut.add(plus.getAtk());
        });
//        System.out.println(urut.toString());
        Collections.sort(urut);
//        System.out.println(urut.toString());
        urut.forEach((ur) -> {
            index = -1;
            AEnemy.forEach((cek) -> {
                index++;
                if (cek.getAtk() == ur) {
                    if (!cek.getPic().contains("def")) {
                        if (att.isEmpty()) {
                            att.add(index);
                        } else {
                            if (!att.contains(index)) {
                                att.add(index);
                            }
                        }
                    }
                }
            });
        });
        System.out.println(urut.toString());
        if (APlayer.size() > 0) {
            System.out.println("if pertama");
            index = -1;
            urut.clear();
            APlayer.forEach((cek) -> {
                System.out.println("foreach aplayer");
                index++;
                att.forEach((pil) -> {
                    System.out.println("foreach att");
                    boolean nol = true;
                    if (!cek.getPic().contains("def")) {
                        System.out.println("if kedua");
                        System.out.println("cek : " + cek.getAtk());
                        System.out.println(pil);
                        int pill = AEnemy.get(pil).getAtk();
                        System.out.println("pil : " + AEnemy.get(pil).getAtk());
                        if (cek.getAtk() <= AEnemy.get(pil).getAtk()) {
                            System.out.println("if ketiga");
                            if (!urut.contains(index) && !slc.contains(pil)) {
                                System.out.println("if keempat");
                                if (act.isEmpty()) {
                                    System.out.println("if kelima");
                                    act.add(1);
                                }
                                nol = false;
                                act.add(pil);
                                act.add(index);
                                urut.add(index);
                                slc.add(pil);
                            }
                        }
                        System.out.println("act ngetek : " + act.toString());
                    } else {
                        System.out.println("ngedef");
                        if (cek.getDef()< AEnemy.get(pil).getAtk()) {
                            if (!urut.contains(index) && !slc.contains(pil)) {
                                if (act.isEmpty()) {
                                    act.add(1);
                                }
                                act.add(pil);
                                act.add(index);
                                urut.add(index);
                                slc.add(pil);
                            }
                        }
                    }
                    if (nol) {
                        if (act.isEmpty()) {
                            act.add(1);
                        }
                        act.add(pil);
                        act.add(-1);
                        slc.add(pil);
                    }
//                AEnemy.forEach((pil) -> {
//                    index++;
//                    if (hero) {
//                        
//                    }
                });
            });
        } else {
            act.add(0);
        }
        System.out.println("urut : " + urut.toString());
        System.out.println("slc : " + slc.toString());
        System.out.println("act : " + act.toString());
        // 1 = action
        // genap = musuh
        // ganjil = player
//        if (act.size() > 3) {
//            for (int i = 3; i < act.size(); i += 2) {
//                if (act.get(0) == 0) {
//                    break;
//                }
//                for (int j = i; j < act.size(); j += 2) {
//                    if (act.get(j) > 0) {
//                        act.set(j, (act.get(j) - 1));
//                    }
//                }
//            }
//        }
        return act;
    }

//    public AIController() {
//        
//    }
            
    public int getIndex() {
        return index;
    }

    private void prioritize() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
