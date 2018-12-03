/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BattleMain;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import battle.of.hero.Model.mCard;
import java.util.ArrayList;

/**
 *
 * @author rakas
 */
public class jListCon {

    private DefaultListModel listModel;
    private mCard mCard;

//    public DefaultListModel<String> addFromDatabase() throws SQLException {
//        listModel = new DefaultListModel();
//        mCard = new mCard();
//        listModel = mCard.getAll();
//        return listModel;
//    }

//    public DefaultListModel<String> addAll() throws SQLException {
//        listModel = new DefaultListModel();
//        mCard = new mCard();
////        listModel = mCard.getAll();
//        ArrayList<Card> Cards = mCard.getCard();
//        for (Card Card1 : Cards) {
//            listModel.addElement(Card1.toString());
//        }
//        return listModel;
//    }

    private void removeItem(DefaultListModel list, int index) {
        list.remove(index);
    }

    private void addItem(DefaultListModel<String> list, String add) {
        list.addElement(add);
    }

    public void addItem(DefaultListModel listDeck, String selectedValue, DefaultListModel listDeck0, int selectedIndex) {
        addItem(listDeck, selectedValue);
        removeItem(listDeck0, selectedIndex);
    }

    public void removeItem(DefaultListModel listDeck, int selectedIndex, DefaultListModel listDeck0, String selectedValue) {
        removeItem(listDeck, selectedIndex);
        addItem(listDeck0, selectedValue);
    }

    public DefaultListModel<Card> addAll() throws SQLException {
        listModel = new DefaultListModel();
        mCard = new mCard();
        ArrayList<Card> Cards = mCard.getCard();
        Cards.forEach((Card1) -> {
//            System.out.println(Card1.getNama() + "\t\t\t\t\t" + Card1.getId());
            listModel.addElement(Card1.getNama() + "                                                                                                                                                  :" + Card1.getId());
        });
        return listModel;
    }

    public void saveDeck(DefaultListModel deck) {
//        deck.
    }

    private void removeItem(DefaultListModel list, Card index) {
        list.removeElement(index);
    }

    private void addItem(DefaultListModel<Card> list, Card add) {
        list.addElement(add);
    }

    public void addItem(DefaultListModel listDeck, Card add, DefaultListModel listDeck0, Card remove) {
        addItem(listDeck, add);
        removeItem(listDeck0, remove);
    }

    public void removeItem(DefaultListModel listDeck, Card remove, DefaultListModel listDeck0, Card add) {
        removeItem(listDeck, remove);
        addItem(listDeck0, add);
    }
    
    public DefaultListModel<Card> getCol() throws SQLException {
        listModel = new DefaultListModel();
        mCard = new mCard();
        ArrayList<Card> Cards = mCard.getCollection();
        Cards.forEach((Card1) -> {
            listModel.addElement(Card1.getNama() + "                                                                                                                                                  :" + Card1.getId());
        });
        return listModel;
    }
    
    public DefaultListModel<Card> getDek() throws SQLException {
        listModel = new DefaultListModel();
        mCard = new mCard();
        ArrayList<Card> Cards = mCard.getDeck();
        Cards.forEach((Card1) -> {
            listModel.addElement(Card1.getNama() + "                                                                                                                                                  :" + Card1.getId());
        });
        return listModel;
    }
    
    public DefaultListModel<Card> getCat(int cat) throws SQLException {
        listModel = new DefaultListModel();
        mCard = new mCard();
        ArrayList<Card> Cards = mCard.getCatPedia(cat);
        Cards.forEach((Card1) -> {
            listModel.addElement(Card1.getNama() + "                                                                                                                                                  :" + Card1.getId());
        });
        return listModel;
    }
}
