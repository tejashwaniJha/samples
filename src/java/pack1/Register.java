package pack1;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Register", urlPatterns = {"/Register.do"})
public class Register extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           String name = request.getParameter("name");            
            Long mobile = new Long(request.getParameter("mobile").trim());
            String parentname = request.getParameter("parentname");
            Long parentnum = new Long(request.getParameter("parentnum").trim());
            String permanentadd = request.getParameter("permanentadd");
            String currrentadd = request.getParameter("currrentadd");
            String email= request.getParameter("email");
            String dob = request.getParameter("dob"); 
            String gender = request.getParameter("gender"); 
            String nationality = request.getParameter("nationality"); 
            String course = request.getParameter("course"); 
            String profile = request.getParameter("profile"); 
            String clgname = request.getParameter("clgname");   
            String highestedu = request.getParameter("highestedu"); 
            String stream = request.getParameter("stream"); 
            String tenth = request.getParameter("tenth"); 
            String twelth = request.getParameter("twelth"); 
            String graduation = request.getParameter("graduation");         
    
            
            try{ 
                System.out.println(name);
                System.out.println(mobile);
                System.out.println(parentname);
                System.out.println(parentnum);
                System.out.println(permanentadd);
                System.out.println(currrentadd);
                System.out.println(email);
                System.out.println(dob);
                System.out.println(gender);
                System.out.println(nationality);
                System.out.println(course);
                System.out.println(profile);
                System.out.println(clgname);
                System.out.println(highestedu);
                System.out.println(stream);
                System.out.println(tenth);
                System.out.println(twelth);
                System.out.println(graduation);
                
                
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","");
            String q1 = "insert into info values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); ";
            PreparedStatement pstmt = con.prepareStatement(q1);
            pstmt.setString(1,name);
            pstmt.setLong(2, mobile);
            pstmt.setString(3, parentname);
            pstmt.setLong(4, parentnum);
            pstmt.setString(5, permanentadd);
            pstmt.setString(6, currrentadd);
            pstmt.setString(7, email);
            pstmt.setString(8, dob);
            pstmt.setString(9, gender);
            pstmt.setString(10, nationality);
            pstmt.setString(11, course);
            pstmt.setString(12, profile);
            pstmt.setString(13, clgname);
            pstmt.setString(14, highestedu);
            pstmt.setString(15, stream);
            pstmt.setString(16, tenth);
            pstmt.setString(17, twelth);
            pstmt.setString(18, graduation);
                   
            
            pstmt.executeUpdate();
            
            out.println("Data Inserted");
            
           RequestDispatcher rd = request.getRequestDispatcher("index.html");
           rd.include(request, response);
             
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
