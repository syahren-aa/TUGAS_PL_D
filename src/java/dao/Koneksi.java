/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.SQLException;
import com.mysql.cj.jdbc.MysqlDataSource;

public class Koneksi {
    private static Connection conn;
    
    public static Connection Koneksi() {
        if(conn == null) {
            try {
                MysqlDataSource dataSource = new MysqlDataSource();

                dataSource.setServerName("localhost");
                dataSource.setPort(3306);
                dataSource.setDatabaseName("db_toko");
                dataSource.setUser("root");
                dataSource.setPassword("");
                
                conn = dataSource.getConnection();
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        
        return conn;
    }
}