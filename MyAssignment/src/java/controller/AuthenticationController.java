/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DataDBContext;
import dal.DateHandle;
import dal.LectureDBContext;
import dal.SessionDBContext;
import dal.TimeSlotDBContext;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.Lecture;
import model.Session;
import model.TimeSlot;

/**
 *
 * @author Ngo Tung Son
 */
public class AuthenticationController extends HttpServlet {

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
        DataDBContext dbData = new DataDBContext();
        ArrayList<String> campuses = dbData.campus();
        //LectureDBContext dbLecture = new LectureDBContext();
        //ArrayList<Lecture> lectures = dbLecture.list();
        request.setAttribute("campus", campuses);
        String campus = request.getParameter("campus");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        request.getRequestDispatcher("view/authentication/login.jsp").forward(request, response);
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
        String campus = request.getParameter("campus");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Lecture lecture = new Lecture();
        lecture.setCampus(campus);
        lecture.setUsername(username);
        lecture.setPassword(password);
        LectureDBContext dbLecture = new LectureDBContext();
        if (dbLecture.get(lecture) != null) {
            //lecture
            request.setAttribute("lecture", lecture);
            //date
            DateHandle dbDate = new DateHandle();
            Date currentDate = new Date();
            ArrayList<Date> week = dbDate.getWeek(currentDate);
            ArrayList<String> weekdays = new ArrayList<>();
            for (Date date0 : week) {
                SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd");
                String strdate0 = format0.format(date0);
                weekdays.add(strdate0);
            }
            request.setAttribute("weekdays", weekdays);

            ArrayList<String> weekdays1 = new ArrayList<>();
            for (Date date1 : week) {
                SimpleDateFormat format1 = new SimpleDateFormat("E, dd MMM yyyy");
                String strdate0 = format1.format(date1);
                weekdays1.add(strdate0);
            }
            request.setAttribute("weekdays1", weekdays1);
            //slot
            TimeSlotDBContext dbSlot = new TimeSlotDBContext();
            ArrayList<TimeSlot> slots = dbSlot.list();
            request.setAttribute("slots", slots);
            //session
            SessionDBContext dbSession = new SessionDBContext();
            ArrayList<Session> sessions = dbSession.list(lecture);
            request.setAttribute("sessions", sessions);

            request.getRequestDispatcher("view/search/timetable.jsp").forward(request, response);
        } else {
            response.getWriter().println("failed");
        }

    }

}
