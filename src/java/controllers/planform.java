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
import java.util.ArrayList;
import model.Pricing;
import model.User;

/**
 *
 * @author FPT
 */
public class planform extends HttpServlet {

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
            out.println("<title>Servlet lan</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet planform at " + request.getContextPath() + "</h1>");
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
        ArrayList<Pricing> listPricing = new ArrayList<>();
        listPricing = dao.getAllPricing();

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("infoUser");
        int idCurrenPricing = dao.getPricingIdByIdUser(user.getIdUser());

        Pricing currenPri = dao.getPricingById(idCurrenPricing);
        request.setAttribute("currenPri", currenPri);
        request.setAttribute("listPricing", listPricing);
        request.getRequestDispatcher("Views/planform.jsp").forward(request, response);
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
        String selectedPricingID = request.getParameter("selectedPricingID");
        int id;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("infoUser");

        DAO dao = new DAO();
        try {
            id = Integer.parseInt(selectedPricingID);
            Pricing pri = dao.getPricingById(id);
            if (pri.getPrice() <= 200) {
                dao.orderPricing(user.getIdUser(), id);
                int currentPlan = dao.getPricingIdByIdUser(user.getIdUser());
                session.setAttribute("isPremium", true);
                session.setAttribute("currentPlan", currentPlan);
                request.setAttribute("noti", "Successfull");
                if (session.getAttribute("requestURL") != null) {
                    String redirectURL = (String) session.getAttribute("requestURL");
                    session.removeAttribute("requestURL");
                    response.sendRedirect(redirectURL);
                } else {
                    doGet(request, response);
                }
            } else {
                request.setAttribute("noti", "Insufficient balance");
                doGet(request, response);
            }
        } catch (NumberFormatException e) {
            request.setAttribute("noti", "Error");
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
