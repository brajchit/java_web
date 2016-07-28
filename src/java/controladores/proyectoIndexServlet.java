/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Proyecto;

/**
 *
 * @author Edgar
 */
@WebServlet(name = "proyectoIndexServlet", urlPatterns = {"/proyectoIndexServlet"})
public class proyectoIndexServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                response.setContentType("application/json");
        Gson gson = new Gson();
        
        JsonObject object = new JsonObject();
        
        List<Proyecto> proyectos = Proyecto.all();
        int cont = 1;
        for (Proyecto proyecto : proyectos) {
            JsonObject object_proyecto = new JsonObject();
            String nombre = proyecto.getNombre();
            String descripcion = proyecto.getDescripcion();
            String usuarioResp = proyecto.getUsuarioResp();
            
            object_proyecto.addProperty("nombre", nombre);
            object_proyecto.addProperty("descripcion", descripcion);
            object_proyecto.addProperty("usuarioResp", usuarioResp);
            
            object.add(""+cont, object_proyecto);
            cont ++;
        }
        
        PrintWriter out =  response.getWriter();
        out.print(gson.toJson(object));
        out.flush();
    }
        

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}