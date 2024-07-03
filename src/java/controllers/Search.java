/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import dal.DAO;
import dal.Data;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import model.Film;
import model.User;

/**
 *
 * @author FPT
 */
public class Search extends HttpServlet {

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
            out.println("<title>Servlet Search</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Search at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("Search/search.jsp").forward(request, response);
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
        String input = request.getParameter("inputSearch");
        DAO dao = new DAO();
        ArrayList<Film> listFilmFind = new ArrayList<>();

        ArrayList<Film> listFilmByCountry = new ArrayList<>();
        listFilmByCountry = dao.getFilmByCountry(null, input.trim());

        ArrayList<Film> listFilmByCategory = new ArrayList<>();
        listFilmByCategory = dao.getFilmByCategory(null, input.trim());

        ArrayList<Film> listFilmByName = new ArrayList<>();
        listFilmByName = dao.getFilmByName(null, input.trim());

        
        listFilmFind.addAll(listFilmByCountry);
        listFilmFind.addAll(listFilmByCategory);
        listFilmFind.addAll(listFilmByName);
        Data data = new Data();
        data.removeDuplicates(listFilmFind);
        
        
        HttpSession session = request.getSession();
        User user = new User();
        user = (User) session.getAttribute("infoUser");
        request.setAttribute("idUser", user.getIdUser());
        request.setAttribute("idList", dao.getListIdByIdUser(user.getIdUser()));
        request.setAttribute("listFilmFind", listFilmFind);
        request.setAttribute("input", input);
        doGet(request, response);
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
