/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelos.MySqlConection;

/**
 *
 * @author brannybk
 */
public class User {
    protected String id;
    protected String nombre;
    protected String email;
    protected int pasword;
    protected String rol;
    
    static final String GETALL = "SELECT nombre, email, rol FROM users";

    public User(String nombre, String email, String rol) {
        this.nombre = nombre;
        this.email = email;
        //this.pasword = pasword;
        this.rol = rol;
    }
    
    public User(String nombre, String email, String rol, String id) {
        this.nombre = nombre;
        this.email = email;
        this.id=id;
        this.rol = rol;
    }
    
    public boolean Remove(){
        boolean result = false;
        String DELETE = "DELETE FROM users WHERE nombre=? AND email=? AND rol=?";
        
        Connection conn = null;
        PreparedStatement stat = null;
        try{
            System.out.println("Connecting to a selected database...");
            conn = MySqlConection.connect();
            System.out.println("Connected database successfully...");

            //Execute a query
            System.out.println("Deleting record in the table...");
            stat = conn.prepareStatement(DELETE);
            stat.setString(1,this.nombre);
            stat.setString(2,this.email);
            stat.setString(3,this.rol);

                            
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
    
    public boolean Update(String id){
        boolean result = false;
        String UPDATE = "UPDATE users SET nombre=?, email=?, rol=? WHERE id=?";
        
        Connection conn = null;
        PreparedStatement stat = null;
        try{
            System.out.println("Connecting to a selected database...");
            conn = MySqlConection.connect();
            System.out.println("Connected database successfully...");

            //Execute a query
            System.out.println("Updating record in the table...");
            stat = conn.prepareStatement(UPDATE);
            stat.setString(1, this.nombre);
            stat.setString(2, this.email);
            //stat.setInt(3, pasword);
            stat.setString(3, this.rol);
            stat.setString(4, id);
                            
            //stmt.executeUpdate(sql);
            if (stat.executeUpdate() == 0){
                System.out.println("User not inserted...");
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
                System.out.println(this.nombre + "updated con éxito");
                result = true;
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
                System.out.println(this.nombre + "updated con éxito");
                result = true;
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        return result;
    }
    
    public boolean Save(){
        boolean result = false;
        String INSERT = "INSERT INTO users(nombre, email, rol) VALUES(?, ?, ?)";
        
        Connection conn = null;
        PreparedStatement stat = null;
        try{
            System.out.println("Connecting to a selected database...");
            conn = MySqlConection.connect();
            System.out.println("Connected database successfully...");

            //Execute a query
            System.out.println("Inserting records into the table...");
            stat = conn.prepareStatement(INSERT);
            stat.setString(1, this.nombre);
            stat.setString(2, this.email);
            //stat.setInt(3, pasword);
            stat.setString(3, this.rol);
                            
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
    
    public static List<User> all(){
        List<User> users = new ArrayList<User>();
        
        Connection conn = null;
        Statement stmt = null;
        try{
            System.out.println("Connecting to a selected database...");
            conn = MySqlConection.connect();
            System.out.println("Connected database successfully...");

            //Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(User.GETALL);
            //STEP 5: Extract data from result set
            while(rs.next()){
               //Retrieve by column name
               String nombre = rs.getString("nombre");
               String email = rs.getString("email");
               String rol = rs.getString("rol");

               //Create User Object
               User user = new User(nombre, email, rol);
               users.add(user);
            }
            rs.close();
            
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
                if(stmt!=null)
                    conn.close();
                //System.out.println(this.nombre + "insertado con éxito");
                
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
                //System.out.println(this.nombre + "insertado con éxito");
                
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        
        return users;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getRol() {
        return rol;
    }
    
    
}
