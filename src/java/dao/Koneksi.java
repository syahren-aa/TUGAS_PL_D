/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {

    private static Koneksi instance = new Koneksi();
    private static Connection conn;
    static String namakoneksi = "jdbc:mysql://localhost/db_tugasPL";
    static String username = "root";
    static String password = "";

    public static Koneksi getInstance() {
        return instance;
    }

    public static Connection getConnection() {
        return conn;
    }

    private Koneksi() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    namakoneksi, username, password);
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
    }
   
}
