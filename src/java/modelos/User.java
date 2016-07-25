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
public class User {
    protected String nombre;
    protected String email;
    protected int pasword;
    protected String rol;

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    //static final String DB_URL = "jdbc:mysql://localhost:8889/Adm_Proyects";
    static final String DB_URL = "jdbc:mysql://localhost:8889/Adm_Proyects";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "root";

    public User(String nombre, String email, int pasword, String rol) {
        this.nombre = nombre;
        this.email = email;
        this.pasword = pasword;
        this.rol = rol;
    }

    public boolean Save(){
        boolean result = false;
        String INSERT = "INSERT INTO users(nombre, email, password, rol) VALUES(?, ?, ?, ?)";
        
        Connection conn = null;
        //Statement stmt = null;
        PreparedStatement stat = null;
        try{
            //Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(this.DB_URL, this.USER, this.PASS);
            System.out.println("Connected database successfully...");

            //Execute a query
            System.out.println("Inserting records into the table...");
            //stmt = conn.createStatement();
            stat = conn.prepareStatement(INSERT);
            stat.setString(1, this.nombre);
            stat.setString(2, this.email);
            stat.setInt(3, pasword);
            stat.setString(4, this.rol);
                            
            //stmt.executeUpdate(sql);
            if (stat.executeUpdate() == 0){
                System.out.println("User no iserted...");
            } else {
                System.out.println("Inserted records into the table...");
            }
            
        }catch(SQLException se){
            //Handle errors for JDBC
            System.out.println("Error con el JDBC...");
            se.printStackTrace();            
        }catch(Exception e){
            //Handle errors for Class.forName
            System.out.println("Error en el forName...");
            e.printStackTrace();
        }finally{
              //finally block used to close resources
            try{
                if(stat!=null)
                    conn.close();
                System.out.println(this.nombre + "insertado con éxito");
                result = true;
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
                System.out.println(this.nombre + "insertado con éxito");
                result = true;
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        return result;
    }
}
