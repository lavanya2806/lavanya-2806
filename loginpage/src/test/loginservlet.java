package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class loginservlet extends HttpServlet {
 
 protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
  {
   // TODO Auto-generated method stub 
  
  String uname=req.getParameter("Username");
  String pwd=req.getParameter("Password");
  
  try {
	if(logindao.validate(uname,pwd))
	  {
		   RequestDispatcher rd=req.getRequestDispatcher("correct");
		   rd.forward(req,res);
	  }
	  else
	  {
		 
               PrintWriter out=res.getWriter();
			   RequestDispatcher rd=req.getRequestDispatcher("how.html");
			  out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>");
	            out.println("<script>$(document).ready(function(){$('.abcd').text('Username or Password invalid !');});</script>");
	            rd.include(req,res);
	  }
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
  
  }
  
 

}
