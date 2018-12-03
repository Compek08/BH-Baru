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
import javax.swing.DefaultListModel;
import java.util.*;

/**
 *
 * @author rakas
 */
public class mCard extends baseModel {

    private Connection koneksi;

    public mCard() throws SQLException {
        koneksi = new koneksi().getKoneksi();
    }

//    public DefaultListModel<String> getAll() {
//        DefaultListModel<String> list = new DefaultListModel();
//        String query = "SELECT `c`.`nama` FROM `card` `c` join `area` `a`\n"
//                + "on `c`.`area` = `a`.`id`";
//        try {
//            PreparedStatement st = koneksi.prepareStatement(query);
//            ResultSet rs = st.executeQuery();
//            while (rs.next()) {
//                list.addElement(rs.getString(1));
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
    public ArrayList<Card> getCatPedia(int cat) {
        ArrayList<Card> Card = new ArrayList<>();
        String query = "SELECT * FROM `card` WHERE grade = " + cat + "\nORDER BY `nama`";
        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Card.add(new Card(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getString(9))
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Card;
    }

    public String getImg(int id) {
        String url = "/battle/of/hero/image/kartu/kartu blkg.png";
        String query = "SELECT `pic` FROM `card` WHERE `id` = " + id;
        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                url = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return url;
    }

    public ArrayList<Card> getCard() {
        ArrayList<Card> Card = new ArrayList<>();
        String query = "SELECT * FROM `card` ORDER BY `nama`";
        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Card.add(new Card(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getString(9))
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Card;
    }

    public void drop(String tabel) throws SQLException {
        String query = "TRUNCATE `" + tabel + "`";
        PreparedStatement st = koneksi.prepareStatement(query);
        st.execute();
    }

    public ArrayList<Card> getCollection() {
        ArrayList<Card> Card = new ArrayList<>();
        String query = "SELECT `k`.`id_card`, `c`.`nama`, `c`.`pic` FROM `card` `c` join `koleksi` `k`\n"
                + "on `k`.`id_card` = `c`.`id` ORDER BY `c`.`nama`";
        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Card.add(new Card(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3)) {
                });
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Card;
    }

    public ArrayList<Card> getDeck() {
        ArrayList<Card> Card = new ArrayList<>();
        String query = "SELECT * FROM `card` c join `deck` `d`\n"
                + "on `d`.`id_card` = `c`.`id` ORDER BY `c`.`nama`";
        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Card.add(new Card(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getString(9))
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Card;
    }

    public void save(int id, String tabel) throws SQLException {
        String query = "INSERT INTO `" + tabel + "`(`id_card`) VALUES (" + id + ")";
        PreparedStatement st = koneksi.prepareStatement(query);
        st.execute();
    }
}
