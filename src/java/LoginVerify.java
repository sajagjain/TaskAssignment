/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bson.Document;

/**
 *
 * @author sajag jain
 */
public class LoginVerify extends HttpServlet {

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
            String name=(String)request.getParameter("name");
            String password=(String)request.getParameter("password");
            String save=(String)request.getParameter("save");
            out.println(name+"   "+password);
            MongoClient client=new MongoClient();
            MongoDatabase db=client.getDatabase("grevesoft");
            MongoCollection coll=db.getCollection("users");
            FindIterable fi=coll.find(new Document("name",name).append("password",password));
            MongoCursor cur=fi.iterator();
            
            if(cur.hasNext())
            {
                
                if(save!=null)
                {
                    Cookie ck1=new Cookie("name",name);
                    Cookie ck2=new Cookie("password",password);
                    ck1.setMaxAge(60*60);
                    ck2.setMaxAge(60*60);
                    response.addCookie(ck1);
                    response.addCookie(ck2);
                }
                if(coll.find(new Document("role","Coordinator").append("name",name)).iterator().hasNext())
                {
                    out.print(name);
                    response.sendRedirect("CoordinatorHome.jsp?name="+request.getParameter("name"));
                }else if(coll.find(new Document("role","Admin").append("name",name)).iterator().hasNext()){
                    
                    response.sendRedirect("Home.jsp");
                }else{
                        
                    response.sendRedirect("MemberHome.jsp?name="+request.getParameter("name"));
                    
                    
                }
            }
        }catch(Exception ex){
        PrintWriter out=response.getWriter();
        out.println("error");
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
