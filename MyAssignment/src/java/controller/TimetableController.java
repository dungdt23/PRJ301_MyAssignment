/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DateHandle;
import dal.LectureDBContext;
import dal.SessionDBContext;
import dal.TimeSlotDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.Lecture;
import model.Session;
import model.TimeSlot;

/**
 *
 * @author Admin
 */
public class TimetableController extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TimetableController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TimetableController at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
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
        //processRequest(request, response);

        //set information for lecture
        String lectureUsername = request.getParameter("username");
        String lectureName = request.getParameter("lectureName");
        String lectureCampus = request.getParameter("campus");
        LectureDBContext dbLecture = new LectureDBContext();
        Lecture lecture = new Lecture();
        lecture.setUsername(lectureUsername);
        lecture = dbLecture.getLectureByUsername(lecture);
//        lecture.setLectureID(lectureID);
//        lecture.setCampus(lectureCampus);
//        lecture.setLectureName(lectureName);
        request.setAttribute("lecture", lecture);
        //get date 
        String dateStr = request.getParameter("date");
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        //date
        DateHandle dbDate = new DateHandle();
        ArrayList<Date> week = dbDate.getWeek(date);
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
        request.setAttribute("week", week);
        //slot
        TimeSlotDBContext dbSlot = new TimeSlotDBContext();
        ArrayList<TimeSlot> slots = dbSlot.list();
        request.setAttribute("slots", slots);
        //session
        SessionDBContext dbSession = new SessionDBContext();
        ArrayList<Session> sessions = dbSession.list(lecture);
        request.setAttribute("sessions", sessions);

        request.getRequestDispatcher("view/search/timetable.jsp").forward(request, response);
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
