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
public class Browse extends HttpServlet {

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
            out.println("<title>Servlet Browse</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Browse at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        DAO dao = new DAO();
        Data data = new Data();

        ArrayList<Film> listSlide = new ArrayList<>();
        listSlide = data.listFilmSlide();

        ArrayList<Film> listTopByLike = new ArrayList<>();
        listTopByLike = dao.getTopFilmByLike(10);

        ArrayList<Film> listFilmByCountry = new ArrayList<>();
        listFilmByCountry = dao.getFilmByCountry("10", "Vietnam");

        ArrayList<Film> listTopByYear = new ArrayList<>();
        listTopByYear = dao.getFilmByCategory("10", "Drama");        
        
        ArrayList<Film>  listFilmAction = new ArrayList<>();
        listFilmAction = dao.getFilmByCategory("10", "Action");
        data.removeDuplicates(listFilmAction);
        
        ArrayList<Film>  listFilmCrime = new ArrayList<>();
        listFilmCrime = dao.getFilmByCategory("10", "Crime");
        data.removeDuplicates(listFilmCrime);
        
        ArrayList<Film> trendingMovie = new ArrayList<>();
        trendingMovie = dao.getTopFilmByLike(10);
        
        User user = new User();
        user = (User) session.getAttribute("infoUser");
        if(user.getRole() == 2){
            request.setAttribute("isAdmin", true);
        }
        request.setAttribute("idUser", user.getIdUser());
        request.setAttribute("idList", dao.getListIdByIdUser(user.getIdUser()));
        request.setAttribute("trendingMovie", trendingMovie);
        request.setAttribute("listFilmCrime", listFilmCrime);
        request.setAttribute("listFilmAction", listFilmAction);
        request.setAttribute("listTopByYear", listTopByYear);
        request.setAttribute("parallaxFilm", listTopByLike.get(0));
        request.setAttribute("listFilmByCountry", listFilmByCountry);
        request.setAttribute("listTopByLike", listTopByLike);
        request.setAttribute("listFilmSlide", listSlide);
        request.getRequestDispatcher("Views/browse.jsp").forward(request, response);
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
