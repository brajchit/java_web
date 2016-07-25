/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.*;

/**
 *
 * @author brannybk
 */
public class MySqlConection {

    //  Database credentials
    static final String DATABASE = "Adm_Proyects";
    static final String PORT     = "8889";
    static final String USER     = "root";
    static final String PASS     = "root";
    
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:"+8889+"/"+DATABASE;
    
    public static Connection connect() {
        Connection conn = null;

        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Database connection established");

        } catch (Exception e) {

            System.err.println("Cannot connect to database server");
            e.printStackTrace();

        }
        return conn;
    }
    
}
