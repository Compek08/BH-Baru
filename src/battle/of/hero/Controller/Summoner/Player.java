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

    public boolean isEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }
    private final cIcon icon;

    public boolean isDraw() {
        return draw;
    }

    public Player(PlayClassic vClassic, String user) throws SQLException {
        super(vClassic, user);
        icon = new cIcon();
//        ImageIcon iI= new ImageIcon();
        mCard mCard = new mCard();
        deck.addAll(mCard.getDeck());
//        System.out.println(deck.size());
        Collections.shuffle(deck);
//        System.out.println(vClassic.getC2().getWidth());
//        this.vClassic.getA6().setIcon(icon.rotateImageIcon((ImageIcon) vClassic.getC2().getIcon(), vClassic.getC2().getWidth(), vClassic.getC2().getHeight(), 90));
//        vClassic.getEnd().addActionListener(new End());
        
    }

    @Override
    public ArrayList<Card> getHand() {
        return hand;
    }

    @Override
    public void Summon(int urut) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void Draw(boolean act) {
        super.Draw(true);
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
