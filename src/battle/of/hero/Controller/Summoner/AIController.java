/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battle.of.hero.Controller.Summoner;

import BattleMain.Card;
import java.util.ArrayList;

/**
 *
 * @author rakas 1. Cek area lawan 2. Jika tidak ada kartu atk : pasang kartu
 * penyerang dengan nilai atk tertinggi 3. Jika ada kartu atk : Cek posisi kartu
 * lawan (horizontal/vertikal/tertutup) 3a. Jika horizontal, cek nilai def dari
 * kartu yang posisi horizontal 3b. Jika vertikal, cek nilai atk dari kartu yang
 * posisi vertikal 3c. Jika kartu tertutup, pasang kartu dengan nilai atk tinggi
 * 3c. Jika terdapat dua atau lebih kartu dengan posisi berbeda : 3c1. Cek kartu
 * dengan posisi vertikal terlebih dulu, cek kartu atk yang dimiliki, jika kartu
 * yang dimiliki bernilai lebih besar dari atk kartu lawan, maka pasang kartu
 * tersebut dan serang kartu lawan, jika tidak memiliki kartu dengan nilai
 * lebih, maka lanjut dengan langkah 3c2. 3c2. Cek kartu lawan dengan posisi
 * horizontal, jika memiliki kartu dengan atk lebih besar dari nilai def lawan,
 * pasang kartu tersebut dan serang kartu yang dicek. 3c3. Pasang kartu dengan
 * nilai atk tinggi dan serang kartu lawan dengan posisi tertutup
 */
public class AIController {
    
    private ArrayList<Card> APlayer, AEnemy, hand;
    private int max=0, min=0,index;

    public AIController(ArrayList<Card> APlayer, ArrayList<Card> AEnemy, ArrayList<Card> hand) {
        this.APlayer = APlayer;
        this.AEnemy = AEnemy;
        this.hand = hand;
    }

    public ArrayList<Integer> cek() {
        ArrayList<Integer> act = new ArrayList<>();
        if (APlayer.isEmpty()) {
            act.add(2);
            hand.forEach((cek) -> {
                if (cek.getAtk() > max) {
                    max = cek.getAtk();
                    index = hand.indexOf(cek);
                }
            });
//            act.add(index);
        } else {
            APlayer.forEach((cek) -> {
                if (cek.getGrade() == 4) {

                } else {

                }
            });
        }
        return act;
    }

//    public AIController() {
//        
//    }

    public int getSummon() {
        return index;
    }
}
