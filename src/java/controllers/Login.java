/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

/**
 *
 * @author FPT
 */
public class Login extends HttpServlet {

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
            out.println("<title>Servlet Login</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Login at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("Views/login.jsp").forward(request, response);
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
        String userName = request.getParameter("username");
        String passWord = request.getParameter("password");
        if (userName == null || passWord == null) {
            request.setAttribute("error", "Please input user name and password!!");
            doGet(request, response);
        }

        DAO dao = new DAO();
        HttpSession session = request.getSession();
        if (dao.checkLogin(userName, passWord)) {
            User user = dao.getUserByEmail(userName);
            if (user.isStatus()) {
                if (user.getRole() == 2) {
                    session.setAttribute("isAdmin", true);
                }
                int currentPlan = dao.getPricingIdByIdUser(user.getIdUser());
                if (currentPlan != 0) {
                    session.setAttribute("isPremium", true);
                }
                session.setAttribute("infoUser", user);
                session.setAttribute("loginSuccess", true);
                if (session.getAttribute("requestURL") != null) {
                    String redirectURL = (String) session.getAttribute("requestURL");
                    response.sendRedirect(redirectURL);
                    session.removeAttribute("requestURL");
                } else {
                    response.sendRedirect("browse");
                }
            } else {
                request.setAttribute("error", "The account has been disabled!!");
                doGet(request, response);
            }
        } else {
            request.setAttribute("userName", userName);
            request.setAttribute("error", "User name or password incorrect!!");
            doGet(request, response);
        }
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
