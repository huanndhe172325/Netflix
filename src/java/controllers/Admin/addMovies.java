/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers.Admin;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import model.Country;
import model.Film;

/**
 *
 * @author FPT
 */
@MultipartConfig
public class addMovies extends HttpServlet {

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
            out.println("<title>Servlet addMovies</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addMovies at " + request.getContextPath() + "</h1>");
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
        ArrayList<Country> listCountry = new ArrayList<>();
        listCountry = dao.getAllCountry();
        request.setAttribute("listCountry", listCountry);
        request.getRequestDispatcher("Admin/addMovies.jsp").forward(request, response);
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
        DAO dao = new DAO();
        String name = request.getParameter("name");
        String detail = request.getParameter("Detail");
        String country_Raw = request.getParameter("country");
        String countryName = country_Raw.split(",")[1];
        String countryiD = country_Raw.split(",")[0];
        String formattedTime = "";
        int id = dao.maxIdFilm() + 1;
        String uploadDirectory = "E:\\NetflixWeb\\web\\uploadImgMovies";
        String imgFileName = name + "_" + id + "_image.jpg";
        String movieFileName = name + "_" + id + "_movie.mp4";
        String trailerFileName = name + "_" + id +"_trailer.mp4";

        String imgFilePath = uploadDirectory + "\\" + imgFileName;
        String movieFilePath = uploadDirectory + "\\" + movieFileName;
        String trailerFilePath = uploadDirectory + "\\" + trailerFileName;

        Part imgPart = request.getPart("imgPath");
        Part moviePart = request.getPart("moviePath");
        Part trailerPart = request.getPart("trailerPath");

        try {
            int time = Integer.parseInt(request.getParameter("time"));
            if (time >= 60) {
                int hours = time / 60;
                int minutes = time % 60;
                formattedTime = hours + "h " + minutes + "min";
            } else {
                formattedTime = time + "min";
            }
            int year = Integer.parseInt(request.getParameter("year"));
            int age = Integer.parseInt(request.getParameter("age"));
            int cId = Integer.parseInt(countryiD);
            Film addFilm = new Film();
            addFilm.setIDFilm(id);
            addFilm.setName(name);
            addFilm.setTime(formattedTime);
            addFilm.setYear(year);
            addFilm.setImgPath("uploadImgMovies" + "/" + imgFileName);
            addFilm.setMoviePath("uploadImgMovies" + "/" + movieFileName);
            addFilm.setAge(age);
            addFilm.setDetail(detail);

            Country cou = new Country(cId, countryName);
            addFilm.setCountry(cou);

            addFilm.setTrailerPath("uploadImgMovies" + "/" + trailerFileName);
            addFilm.setStatus(true);
            
            if (dao.addFilm(addFilm)) {
                imgPart.write(imgFilePath);
                moviePart.write(movieFilePath);
                trailerPart.write(trailerFilePath);
                request.setAttribute("success", "Add successfull");
            } else {
                request.setAttribute("success", "Exit ID!!");
            }
        } catch (Exception e) {
            request.setAttribute("success", "Error input");
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
