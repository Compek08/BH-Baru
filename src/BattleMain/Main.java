package BattleMain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import BattleMain.*;
import battle.of.hero.Controller.*;
import battle.of.hero.Model.*;
import battle.of.hero.View.*;
import javax.swing.UIManager;
import java.util.Random;
import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;

/** *
 * @author rakas

 */
public class Main {

    private MainMenu vMain;
    private ABOUT vAbout;
    private Deck vDeck;
    private Help vHelp;
    private Heropedia vHeropedia;
    private MainMenu vMainMenu;
    private Setting vSetting;
    private Connection konek;
    /**
     * @param args the command line arguments
     */
    public void main(String[] args) throws SQLException {
        konek = new koneksi().getKoneksi();
        System.out.println(konek);
        vMain = new MainMenu();
        vMain.setVisible(true);
    }
    
}
