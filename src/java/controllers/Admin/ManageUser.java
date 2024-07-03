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
import java.util.ArrayList;
import model.User;

/**
 *
 * @author FPT
 */
public class ManageUser extends HttpServlet {

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
            out.println("<title>Servlet ManageUser</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ManageUser at " + request.getContextPath() + "</h1>");
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
        ArrayList<User> listUser = new ArrayList<>();

        String input = request.getParameter("inputSearch");

        if (input == null || input.isEmpty()) {
            listUser = dao.getListUser(100);
        } else {
            listUser = dao.getListUserByName(input);
        }
        request.setAttribute("listUser", listUser);
        request.getRequestDispatcher("Admin/manageUser.jsp").forward(request, response);
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
        String userId = request.getParameter("userId");
        DAO dao = new DAO();
        HttpSession session = request.getSession(false);
        User userLogin = (User) session.getAttribute("infoUser");
        try {
            int id = Integer.parseInt(userId);
            if (userLogin.getIdUser() == id || dao.totalAdmin() < 2) {
                request.setAttribute("noti", "Change Fail");
            } else {
                User userChange = dao.getUserByIdUser(id);
                if (userChange == null) {
                    request.setAttribute("noti", "Change Fail");
                } else {
                    if (userChange.isStatus()) {
                        dao.changeStatusUser(0, userChange.getIdUser());
                    } else {
                        dao.changeStatusUser(1, userChange.getIdUser());
                    }
                    request.setAttribute("noti", "Change success");
                }
            }
        } catch (Exception e) {
            request.setAttribute("noti", "Change Fail");
            System.out.println(e);
        }
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
