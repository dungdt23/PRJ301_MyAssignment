/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.AttendanceDBContext;
import dal.SessionDBContext;
import dal.StudentDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Attendance;
import model.Session;
import model.Student;

/**
 *
 * @author Admin
 */
public class AttendanceController extends HttpServlet {

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
//        response.setContentType("text/html;charset=UTF-8");
//        try ( PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet AttendanceController</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet AttendanceController at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
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
        String sessionID = request.getParameter("sessionID");
        Session session = new Session();
        session.setSessionID(sessionID);
        StudentDBContext dbStudent = new StudentDBContext();
        ArrayList<Student> students = dbStudent.list(session);
        request.setAttribute("students", students);
        request.setAttribute("session", session);
        request.getRequestDispatcher("view/search/studentlist.jsp").forward(request, response);
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
        String sessionID = request.getParameter("sessionID");
        Session session = new Session();
        session.setSessionID(sessionID);
        StudentDBContext dbStudent = new StudentDBContext();
        ArrayList<Student> students = dbStudent.list(session);
        request.setAttribute("students", students);
        
        SessionDBContext dbSession = new SessionDBContext();
        
        AttendanceDBContext dbAttendance = new AttendanceDBContext();

        //check if this session is attended or not
        if (!dbSession.checkAttendance(session)) {
            for (Student s : students) {
                Attendance attendance = new Attendance();
                Student student0 = new Student();
                student0.setStudentID(request.getParameter(s.getStudentID()));
                Session session0 = new Session();
                session0.setSessionID(sessionID);
                String statusStr = request.getParameter("status" + s.getStudentID());
                boolean status = statusStr.equals("present");
                //boolean status = true;
                attendance.setStudent(student0);
                attendance.setSession(session);
                attendance.setAttendanceStatus(status);
                dbAttendance.insert(attendance);
            }
        } else {
            ArrayList<Attendance> existedAttendaces = dbAttendance.existedAttendances(session);
            for (Attendance ea : existedAttendaces) {
                for (Student s : students) {
                    if (ea.getStudent().getStudentID().equals(s.getStudentID())) {
                        String statusStr = request.getParameter("status" + s.getStudentID());
                        boolean status = statusStr.equals("present");
                        ea.setAttendanceStatus(status);
                        dbAttendance.update(ea);
                    }
                }
            }
        }
        
        dbSession.updateAttendace(session);
        
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
