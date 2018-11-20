/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battle.of.hero.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import BattleMain.*;

/**
 *
 * @author rakas
 */
public abstract class baseModel {

    private Connection koneksi;
    private koneksi kon;

    public baseModel() throws SQLException {
        koneksi = new koneksi().getKoneksi();
        kon = new koneksi();
    }

//    abstract String login();

    protected boolean create(String query) throws SQLException {
        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            st.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean update(String query) throws SQLException {
        try {
//            PreparedStatement st = koneksi.prepareStatement(query);
//            st.executeQuery();
            kon.execute(query);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean delete(String query) throws SQLException {
        try {
            PreparedStatement st = koneksi.prepareStatement(query);
            st.executeQuery();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
