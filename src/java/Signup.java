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
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bson.Document;

/**
 *
 * @author sajag jain
 */
public class Signup extends HttpServlet {

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
            String name=request.getParameter("fullname");
            String email=request.getParameter("email");
            String password=request.getParameter("password");
            String gender=request.getParameter("gender");
            String terms=request.getParameter("terms");
            String age=request.getParameter("age");
            String role=request.getParameter("role");
            out.print(role);
            ServletContext context=getServletContext();
            MongoClient client=new MongoClient();
            MongoDatabase db=client.getDatabase("grevesoft");
            MongoCollection coll=db.getCollection("users");
            coll.insertOne(new Document("name",name).append("role",role).append("age",age).append("gender",gender).append("password",password).append("email",email));
            if(coll.find(new Document("role","Coordinator").append("name",name)).iterator().hasNext())
                {
                    out.print(name);
                    response.sendRedirect("CoordinatorHome.jsp?name="+request.getParameter("name"));
                }else if(coll.find(new Document("role","Admin").append("name",name)).iterator().hasNext()){
                    
                    response.sendRedirect("Home.jsp");
                }else{            
                    response.sendRedirect("MemberHome.jsp");        
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
