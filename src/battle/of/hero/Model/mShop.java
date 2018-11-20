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

    public void gacha(String tipe) throws SQLException {
        ArrayList<Card> Cards = mCard.getCard();
        Random R = new Random();
        int get;
        ArrayList<Integer> gacha = new ArrayList<>();
        if (tipe.equalsIgnoreCase("hero")) {
//            for (int i = 0; i < 3; i++) {
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
//            }
//System.out.println(gacha.size());
            get = R.nextInt(gacha.size());
        } else {
            Cards.forEach((Card) -> {
                System.out.println(Card.getGrade());
                if (Card.getGrade() == 4) {
                    for (int j = 0; j < 30; j++) {
                        gacha.add(Card.getId());
                    }
                }
            });
            System.out.println(gacha.size());
            get = R.nextInt(gacha.size());
            
        }
        mCard.save(Cards.get(gacha.get(get)).getId(), "koleksi");
    }
}
