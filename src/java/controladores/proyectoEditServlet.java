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
@WebServlet(name = "proyectoEditServlet", urlPatterns = {"/proyectoEditServlet"})
public class proyectoEditServlet extends HttpServlet {

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
        String id = request.getParameter("id");
        String proyecto = request.getParameter("inputNombre");
        String descripcion = request.getParameter("inputDescripcion");
        String usuarioResp = request.getParameter("inputUsuarioResp");

        response.setContentType("application/json");
        Gson gson = new Gson();
        JsonObject object = new JsonObject();

        // Register new user!
        Proyecto newProyecto = new Proyecto(proyecto, descripcion, usuarioResp);
        // Inserted new user into DB?
        //validacion de usuarioResp con la BBDD
        if ( newProyecto.Update(id) == true ){
            object.addProperty("error", Boolean.FALSE);
            object.addProperty("url", "proyectos.jsp");
            object.addProperty("msg", "Proyecto registrado con exito");
        } else {
            object.addProperty("error", Boolean.TRUE);
            object.addProperty("errormsg", "Error al registrar el Proyecto en la BDDD");
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