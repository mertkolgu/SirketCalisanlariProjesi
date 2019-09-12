/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Database;

/**
 *
 * @author Mert
 */
public class GirisYap {

    ResultSet resultSet = null;
    PreparedStatement preparedStatement;

    public boolean girisYap(String kullaniciAdi, String parola) throws SQLException {
        Database db = new Database();
        db.baglan();
        String sorgu = "SELECT * FROM adminler WHERE username = ? AND password = ?";
        preparedStatement = db.con.prepareCall(sorgu);
        preparedStatement.setString(1, kullaniciAdi);
        preparedStatement.setString(2, parola);
        resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }
}
