/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battle.of.hero.Controller.Summoner;

import BattleMain.Card;
import battle.of.hero.Model.mCard;
import battle.of.hero.View.PlayClassic;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

/**
 *
 * @author rakas
 */
public class Enemy extends Summoner {

    public Enemy(PlayClassic vClassic, String user) throws SQLException {
        super(vClassic, user);
        mCard mCard = new mCard();
//        deck.addAll(mCard.getCard());
        mCard.getCard().forEach((Card1) -> {
            for (int i = 0; i < 3; i++) {
                deck.add(Card1);
//                System.out.println(deck.size());
            }
        });
//        System.out.println(deck.size());
        Collections.shuffle(deck);
//        System.out.println(deck.get(57).getNama());
        if (deck.size() > 80) {
            int selisih = deck.size() - 80;
//            System.out.println(selisih);
            for (int i = 0; i < selisih; i++) {
                deck.remove(i);
            }
            deck.trimToSize();
        }
        Collections.shuffle(deck);
//        if (deck.size() > 40) {
//            int selisih = deck.size() - 40;
////            System.out.println(selisih);
//            for (int i = 0; i < selisih; i++) {
//                deck.remove(i);
//            }
//            deck.trimToSize();
//        }

        super.setDeck();
    }

    @Override
    public ArrayList<Card> getHand() {
        return hand;
    }

    @Override
    public void Summon(int urut, Card spell) {
        super.Summon(urut, spell);
    }

    @Override
    public void End() {
        super.End();
    }

}
