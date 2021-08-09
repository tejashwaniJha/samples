
package pack1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Login", urlPatterns = {"/Login.do"})
public class Login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           String email = request.getParameter("email");
           String pass = request.getParameter("password");
           
           try
           {
              Class.forName("com.mysql.jdbc.Driver");
              Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","");
              
              String sql = "select * from info WHERE email = ? and password = ?;";
              PreparedStatement pstmt = con.prepareStatement(sql);
              
              pstmt.setString(1, email);
              pstmt.setString(2, pass);
              
              ResultSet result = pstmt.executeQuery();
              
              if(result.next())
              {
                  
                  HttpSession hs = request.getSession();
                  hs.setAttribute("name",result.getString(1));
                  hs.setAttribute("mobile",result.getLong(2));
                  
                  
                  RequestDispatcher rd = request.getRequestDispatcher("Home.do");
                  rd.forward(request, response);
                  
              }
              else
              {
                  RequestDispatcher rd = request.getRequestDispatcher("error.html");
                  rd.forward(request, response);
              }
                      
              
              
           }
           catch(Exception e){}
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
