/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Mert
 */
public class Database {

    public Connection con;
    private final String USER_NAME = "root";
    private final String PASSWORD = "";
    private final String DB_NAME = "sirket";
    private final String HOST = "localhost";
    private final int PORT = 3306;
    // jdbc:mysql://localhost:3306/sirket?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
    private final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME
            + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public void baglan() {

        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            System.out.println("Veritabanı bağlantısı başarılı.");
        } catch (SQLException e) {
            System.out.println("Veritabanına bağlanılamadı! Bağlantıda hata var!\n" + e);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver bulunamadı.");
        }
    }
}
