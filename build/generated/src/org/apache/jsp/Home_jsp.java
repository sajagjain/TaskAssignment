package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.MongoClient;

public final class Home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");

    MongoClient client=new MongoClient();
    MongoDatabase db=client.getDatabase("grevesoft");
    MongoCollection coll=db.getCollection("users");
    MongoCollection coll2=db.getCollection("challenge");
    MongoCursor cur=coll.find(new Document("role","Coordinator")).iterator();
    MongoCursor cur2=coll2.find().iterator();
    MongoCursor cur3=coll.find(new Document("role","Member")).iterator();

      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n");
      out.write("\t<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("\t<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <style>\n");
      out.write("            .page-header{\n");
      out.write("                color:#006064;\n");
      out.write("            }\n");
      out.write("            .jumbotron{\n");
      out.write("                color: grey;\n");
      out.write("                background-color:rgba(255, 255, 255, 0.94);\n");
      out.write("            }\n");
      out.write("            .bodyji{\n");
      out.write("                background-image: url(2.jpg);\n");
      out.write("                background-repeat: no-repeat;\n");
      out.write("                background-attachment: fixed;\n");
      out.write("                background-size: cover;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        \n");
      out.write("        <title>Home</title>\n");
      out.write("    </head>\n");
      out.write("    <body class=\"bodyji\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("        <div class=\"\">\n");
      out.write("            <h1>Admin</h1>\n");
      out.write("            <a href=\"Logout\" class=\"btn btn-lg pull-right btn-primary\" style=\"margin-top:-50px\">LOGOUT</a>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"jumbotron\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("            <div class=\"col-lg-6 col-md-6 col-sm-6 col-xs-12\">\n");
      out.write("            <p style=\"font-size:30px\">\n");
      out.write("                Create A New Challenge.\n");
      out.write("            </p>\n");
      out.write("            <form action=\"Task\" method=\"get\">\n");
      out.write("                <div class=\"input-group input-group-md\"><span class=\"input-group-addon\">Task Name</span>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" name=\"taskname\">\n");
      out.write("                </div><br>\n");
      out.write("                <div class=\"input-group input-group-md\"><span class=\"input-group-addon\">Project Coordinator</span>\n");
      out.write("                <select class=\"form-control\" name=\"coordinator\">\n");
      out.write("                    ");
  Document doc;
                        while(cur.hasNext()){
                        doc=(Document)cur.next();
                        
                    
      out.write("\n");
      out.write("                    <option value=\"");
      out.print(doc.get("name"));
      out.write('"');
      out.write('>');
      out.print(doc.get("name"));
      out.write("</option>\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                </select>\n");
      out.write("                </div><br>\n");
      out.write("                <div class=\"input-group input-group-md\"><span class=\"input-group-addon\">Project Members</span>\n");
      out.write("                <select multiple class=\"form-control\" name=\"member\">\n");
      out.write("                    ");
  Document doc3;
                        while(cur3.hasNext()){
                        doc3=(Document)cur3.next();
                        
                    
      out.write("\n");
      out.write("                    <option value=\"");
      out.print(doc3.get("name"));
      out.write('"');
      out.write('>');
      out.print(doc3.get("name"));
      out.write("</option>\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                </select>\n");
      out.write("                </div><br>\n");
      out.write("                <div class=\"input-group input-group-md\">\n");
      out.write("                    <span class=\"input-group-addon\">Start Date</span>\n");
      out.write("                    <input type=\"date\" class=\"form-control\" name=\"startdate\">\n");
      out.write("                </div><br>\n");
      out.write("                <div class=\"input-group input-group-md\">\n");
      out.write("                    <span class=\"input-group-addon\">End Date</span>\n");
      out.write("                    <input type=\"date\" class=\"form-control\" name=\"enddate\">\n");
      out.write("                </div><br>\n");
      out.write("                <div class=\"input-group input-group-md\">\n");
      out.write("                    <span class=\"input-group-addon\">Description</span>\n");
      out.write("                    <textarea row=\"10\" class=\"form-control\" name=\"description\"></textarea>\n");
      out.write("                </div><br><br><br>\n");
      out.write("                <div class=\"input-group input-group-md\">\n");
      out.write("                    <input type=\"submit\" class=\"btn btn-md btn-primary\" value=\"Post\">\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-lg-6 col-md-6 col-sm-6 col-xs-12\">\n");
      out.write("                <p style=\"font-size:30px\">\n");
      out.write("                Task Assigned Before\n");
      out.write("                </p>\n");
      out.write("                ");
while(cur2.hasNext()){
                    Document doc2=(Document)cur2.next();
                
      out.write("    \n");
      out.write("                <div class=\"media\">\n");
      out.write("                <div class=\"media-left media-top\">\n");
      out.write("                <a href=\"#\">\n");
      out.write("                    <div class=\"media-object\" style=\"height: 100px;color: white;text-align:center;font-size:70px;background-color:rgba(54, 159, 173, 0.88);width:100px\">C</div>\n");
      out.write("                </a>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"media-body\">\n");
      out.write("                <h4 class=\"media-heading\">");
      out.print(doc2.get("taskname"));
      out.write("</h4>\n");
      out.write("                <h5 class=\"media-heading\">");
      out.print(doc2.get("coordinator"));
      out.write("</h5>\n");
      out.write("                <h5 class=\"media-heading\">");
      out.print(doc2.get("member"));
      out.write("\n");
      out.write("                <h5 class=\"media-heading\">");
      out.print(doc2.get("startdate"));
      out.write("---");
      out.print(doc2.get("enddate"));
      out.write("</h5>\n");
      out.write("                \n");
      out.write("                <p style=\"font-size:15px\">");
      out.print(doc2.get("description"));
      out.write("</p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <hr size=\"20\">\n");
      out.write("            ");
}
      out.write("\n");
      out.write("        </div>\n");
      out.write("</div>\n");
      out.write("</div>\n");
      out.write("</div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
