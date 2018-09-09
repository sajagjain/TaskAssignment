/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bson.Document;

/**
 *
 * @author sajag jain
 */
public class Task extends HttpServlet {

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
            String taskname=request.getParameter("taskname");
            String coordinator=request.getParameter("coordinator");
            String[] mem=request.getParameterValues("member");
            List<String> member=Arrays.asList(mem);
            String description=request.getParameter("description");
            String startdate=request.getParameter("startdate");
            String enddate=request.getParameter("enddate");
            out.print(taskname+coordinator+description+enddate+startdate+taskname+member);
            MongoClient client=new MongoClient();
            MongoDatabase db=client.getDatabase("grevesoft");
            MongoCollection coll=db.getCollection("challenge");
            if(taskname!=null&&coordinator!=null&&description!=null&&startdate!=null&&enddate!=null)
            {
                
            coll.insertOne(new Document("taskname",taskname).append("member",member).append("coordinator",coordinator).append("description",description).append("startdate",startdate).append("enddate",enddate));
            response.sendRedirect("Home.jsp");
            }else{
            response.sendError(0,"Error occoured try again");
            }
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
        processRequest(request, response);
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
