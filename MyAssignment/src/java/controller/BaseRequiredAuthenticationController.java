/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Lecture;

/**
 *
 * @author Ngo Tung Son
 */
public abstract class BaseRequiredAuthenticationController extends HttpServlet {
   
    private boolean isAuthenticated(HttpServletRequest request) {
        //Account account = (Account) request.getSession().getAttribute("account");
        Lecture lecture = (Lecture) request.getSession().getAttribute("lecture");
        return lecture != null;
    }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        if(isAuthenticated(request))
        {
            processGet(request, response);
        }
        else
        {
            response.getWriter().println("access denied!");
        }
    } 
    protected abstract void processGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException;
    protected abstract void processPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException;
    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        if(isAuthenticated(request))
        {
            processPost(request, response);
        }
        else
        {
            response.getWriter().println("access denied!");
        }
    }

    


}
