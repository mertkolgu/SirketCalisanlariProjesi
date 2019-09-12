/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.Database;

/**
 *
 * @author Mert
 */
public class Calisan {

    private Database db = new Database();
    ArrayList<Calisan> calisanList = new ArrayList<>();
    PreparedStatement preparedStatement;
    Statement statement;
    ResultSet resultSet;
    private int id;
    private String ad;
    private String soyad;
    private String departman;
    private int maas;
    private DefaultTableModel model;

    public Calisan() {
        //
    }

    public Calisan(int id, String ad, String soyad, String departman, int maas) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
        this.departman = departman;
        this.maas = maas;
    }

    public void calisanEkle(String ad, String soyad, String departman, int maas) {
        try {
            db.baglan();
            String sorgu = "INSERT INTO calisanlar (ad, soyad, departman, maas) values (?, ?, ?, ?)";
            preparedStatement = db.con.prepareStatement(sorgu);
            preparedStatement.setString(1, ad);
            preparedStatement.setString(2, soyad);
            preparedStatement.setString(3, departman);
            preparedStatement.setInt(4, maas);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void calisanGuncelle(int id, String ad, String soyad, String departman, int maas) {
        try {
            db.baglan();
            String sorgu = "UPDATE calisanlar SET ad = ?, soyad = ?, departman = ?, maas = ? WHERE id = ?";
            preparedStatement = db.con.prepareStatement(sorgu);

            preparedStatement.setString(1, ad);
            preparedStatement.setString(2, soyad);
            preparedStatement.setString(3, departman);
            preparedStatement.setInt(4, maas);
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void calisanSil(int id) {
        try {
            db.baglan();
            String sorgu = "DELETE FROM calisanlar WHERE id = ?";
            preparedStatement = db.con.prepareStatement(sorgu);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getDepartman() {
        return departman;
    }

    public void setDepartman(String departman) {
        this.departman = departman;
    }

    public int getMaas() {
        return maas;
    }

    public void setMaas(int maas) {
        this.maas = maas;
    }
}
