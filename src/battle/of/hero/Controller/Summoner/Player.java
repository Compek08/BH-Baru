/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battle.of.hero.Controller.Summoner;

import BattleMain.Card;
import battle.of.hero.Controller.cIcon;
import battle.of.hero.Controller.cPlay;
import battle.of.hero.Model.mCard;
import battle.of.hero.View.PlayClassic;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import javax.swing.ImageIcon;

/**
 *
 * @author rakas
 */
public class Player extends Summoner{
    
    private boolean draw = false;
    private boolean end = false;
    private boolean attack;
    private ArrayList<Integer> attIndex;

    public boolean isAttack() {
        return attack;
    }

    public void setAttack(boolean attack) {
        this.attack = attack;
    }
    
    public boolean isEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }

    public boolean isDraw() {
        return draw;
    }

    public ArrayList<Integer> getAttIndex() {
        return attIndex;
    }

    public Player(PlayClassic vClassic, String user) throws SQLException {
        super(vClassic, user);
        attIndex = new ArrayList<>();
        attack = false;
//        ImageIcon iI= new ImageIcon();
        mCard mCard = new mCard();
        deck.addAll(mCard.getDeck());
//        System.out.println(deck.size());
        Collections.shuffle(deck);
//        System.out.println(vClassic.getC2().getWidth());
//        this.vClassic.getA6().setIcon(icon.rotateImageIcon((ImageIcon) vClassic.getC2().getIcon(), vClassic.getC2().getWidth(), vClassic.getC2().getHeight(), 90));
//        vClassic.getEnd().addActionListener(new End());
        super.setDeck();
//        for (int i = 0; i < 5; i++) {
//            System.out.println("Player = "+deck.get(i).getPic());
//        }
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
    public void Draw(boolean act, Card spell) {
        super.Draw(true, spell);
//        draw = true;
    }

    public void setDraw(boolean draw) {
        this.draw = draw;
    }
    
    @Override
    public void End() {
        super.End();
//        draw = false;
    }

//    private class End implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            End();
////            System.out.println(draw);
//        }
//    }
    
    
    
}
