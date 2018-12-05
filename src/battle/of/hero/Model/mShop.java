/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battle.of.hero.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import BattleMain.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.DefaultListModel;

public class mShop {

    private Connection koneksi;
    private final mCard mCard;

    public mShop() throws SQLException {
        koneksi = new koneksi().getKoneksi();
        mCard = new mCard();
    }

    public int getPoin() {
        int poin = 0;
        String query = "SELECT `pts` FROM `player`";
        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                poin = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return poin;
    }

//    public void saveKoleksi(int id) throws SQLException {
//        String query = "INSERT INTO `koleksi`(`id`, `id_card`) VALUES (," + id + ")";
//        try {
//            PreparedStatement st = koneksi.prepareStatement(query);
//            st.execute();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        mCard = new mCard();
//        mCard.save(id, "koleksi");
//    }
    public int bayar(int bayar) {
        int uang = getPoin();
        uang -= bayar;
        String query = "UPDATE `player` SET `pts`= " + uang;
        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return uang;
    }

    public int gacha(String tipe) throws SQLException {
        ArrayList<Card> Cards = mCard.getCard();
        Random R = new Random();
        int get = 0;
        ArrayList<Integer> gacha = new ArrayList<>();
        switch (tipe) {
            case "hero":
                Cards.clear();
                Cards.addAll(mCard.getCatPedia(1));
                Collections.shuffle(Cards);
                Cards.addAll(mCard.getCatPedia(2));
                Collections.shuffle(Cards);
                Cards.addAll(mCard.getCatPedia(3));
                Collections.shuffle(Cards);
                
                Collections.shuffle(Cards);
                gacha.clear();
                Cards.forEach((Card) -> {
                    if (Card.getGrade() == 1) {
                        for (int j = 0; j < 37; j++) {
                            gacha.add(Card.getId());
                        }
                    }
                    if (Card.getGrade() == 2) {
                        for (int j = 0; j < 12; j++) {
                            gacha.add(Card.getId());
                        }
                    }
                    if (Card.getGrade() == 3) {
                        for (int j = 0; j < 1; j++) {
                            gacha.add(Card.getId());
                        }
                    }
                });
                Collections.shuffle(Cards);
                get = R.nextInt(gacha.size());
                break;

            case "spell":
                Cards.clear();
                Cards.addAll(mCard.getCatPedia(4));
                Collections.shuffle(Cards);
                gacha.clear();
                Cards.forEach((Card) -> {
                    if (Card.getGrade() == 4) {
                        for (int j = 0; j < 30; j++) {
                            gacha.add(Card.getId());
                        }
                    }
                });
                Collections.shuffle(Cards);
                get = R.nextInt(gacha.size());
                break;
                
            case "all":
                Cards.clear();
                Cards.addAll(mCard.getCard());
                Collections.shuffle(Cards);
                gacha.clear();
                Cards.forEach((Card) -> {
                    if (Card.getGrade() == 1) {
                        for (int j = 0; j < 50; j++) {
                            gacha.add(Card.getId());
                        }
                    }
                    if (Card.getGrade() == 2) {
                        for (int j = 0; j < 10; j++) {
                            gacha.add(Card.getId());
                        }
                    }
                    if (Card.getGrade() == 3) {
                        for (int j = 0; j < 1; j++) {
                            gacha.add(Card.getId());
                        }
                    }
                    if (Card.getGrade() == 4) {
                        for (int j = 0; j < 3; j++) {
                            gacha.add(Card.getId());
                        }
                    }
                });
                Collections.shuffle(Cards);
                get = R.nextInt(gacha.size());
                break;
        }
        mCard.save(gacha.get(get), "koleksi");
        return gacha.get(get);
    }
}
