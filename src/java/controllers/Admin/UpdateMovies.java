/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers.Admin;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.util.ArrayList;
import model.Country;
import model.Film;
import model.User;

/**
 *
 * @author FPT
 */
public class UpdateMovies extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateMovies</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateMovies at " + request.getAttribute("idUpdate") + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        DAO dao = new DAO();
        Film film = new Film();
        String idFilm_raw = request.getParameter("idUpdate");
        if (idFilm_raw == null) {
            response.sendRedirect("manageMovies");
        }
        ArrayList<Country> listCountry = new ArrayList<>();
        listCountry = dao.getAllCountry();
        request.setAttribute("listCountry", listCountry);
        HttpSession session = request.getSession(false);
        try {
            int idFilm = Integer.parseInt(idFilm_raw);
            Film filmUpdate = dao.getFilmByIdAllStatus(idFilm);
            if (filmUpdate == null) {
                response.sendRedirect("manageMovies");
            }
            String[] parts = filmUpdate.getTime().split("h |min");
            int hours = Integer.parseInt(parts[0]);
            int minutes = Integer.parseInt(parts[1]);
            int totalMinutes = hours * 60 + minutes;
            
            request.setAttribute("time", totalMinutes);
            request.setAttribute("film", filmUpdate);
        } catch (Exception e) {
            response.sendRedirect("manageMovies");
        }
        request.getRequestDispatcher("Admin/updateMovies.jsp").forward(request, response);
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
