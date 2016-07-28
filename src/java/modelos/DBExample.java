/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.*;
import java.util.List;
import modelos.User;
import modelos.MySqlConection;

/**
 *
 * @author brannybk
 */
public class DBExample {
    //final String INSERT = "INSERT INTO users(nombre, email, password, rol) VALUES(?, ?, ?, ?)";
    
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:8889/Adm_Proyects";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "root";
    
    //public void 

    public static void main(String[] args) {
//        User user = new User("Rodrigo Castro", "rcastro@example.com", "Disigner");
//        user.Save();ˆ
//        Proyecto proy = new Proyecto()

        List<Proyecto> proyectos = Proyecto.all();
        
    }//end main
}//end DBExample
