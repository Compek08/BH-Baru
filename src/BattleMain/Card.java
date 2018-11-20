/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BattleMain;

/**
 *
 * @author rakas
 */
public class Card {

    int id, atk = 0, def = 0, area, grade;
    String skill, pic, nama, des;
//    private int att, def;
//    private final String asal, nama;
//    private boolean position, status;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDes() {
        return des;
    }

    public Card(int id, String nama, String pic) {
        this.id = id;
        this.pic = pic;
        this.nama = nama;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Card(int id, String nama, String des, int atk, int def, int area, int grade, String skill, String pic) {
        this.id = id;
        this.nama = nama;
        this.des = des;
        this.atk = atk;
        this.def = def;
        this.area = area;
        this.grade = grade;
        this.skill = skill;
        this.pic = pic;
    }

    public Card(int id, String nama, String des, int area, int grade, String skill, String pic) {
        this.id = id;
        this.nama = nama;
        this.des = des;
        this.area = area;
        this.grade = grade;
        this.skill = skill;
        this.pic = pic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

}
