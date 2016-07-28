/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Edgar
 */
public class Proyecto {
    protected String nombre;
    protected String descripcion;
    protected String usuarioResp;
    
    static final String GETALL = "SELECT nombre, descripcion, usuarioResp FROM proyectos";

    public Proyecto(String nombre, String descripcion, String usuarioResp) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.usuarioResp = usuarioResp;
    }
    
    public boolean Update(String id){
        boolean result = false;
        String UPDATE = "UPDATE proyectos SET nombre=?, descripcion=?, usuarioResp=? WHERE id=?";
        
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
            stat.setString(2, this.descripcion);
            stat.setString(3, this.usuarioResp);
            stat.setString(4, id);
            
            //stmt.executeUpdate(sql);
            if (stat.executeUpdate() == 0){
                System.out.println("Project not inserted...");
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
        String INSERT = "INSERT INTO proyectos (nombre, descripcion, usuarioResp) VALUES(?, ?, ?)";
        
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
            stat.setString(2, this.descripcion);
            //stat.setInt(3, pasword);
            stat.setString(3, this.usuarioResp);
                            
            //stmt.executeUpdate(sql);
            if (stat.executeUpdate() == 0){
                System.out.println("Project not inserted...");
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
    
        public static List<Proyecto> all(){
        List<Proyecto> proyectos = new ArrayList<Proyecto>();
        
        Connection conn = null;
        Statement stmt = null;
        try{
            System.out.println("Connecting to a selected database...");
            conn = MySqlConection.connect();
            System.out.println("Connected database successfully...");

            //Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(Proyecto.GETALL);
            //STEP 5: Extract data from result set
            while(rs.next()){
               //Retrieve by column name
               String nombre = rs.getString("nombre");
               String descripcion = rs.getString("descripcion");
               String usuarioResp = rs.getString("usuarioResp");

               //Create User Object
               Proyecto proyecto = new Proyecto(nombre, descripcion, usuarioResp);
               proyectos.add(proyecto);
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
        
        return proyectos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getUsuarioResp() {
        return usuarioResp;
    }
}
