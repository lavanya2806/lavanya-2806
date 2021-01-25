package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginservlet2 extends HttpServlet {
	 
	 protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	  {
	   // TODO Auto-generated method stub 
	  
	  String uname=req.getParameter("Username");
	  String pwd=req.getParameter("Password");
	  String pwd2=req.getParameter("Password2");
	   String a=req.getParameter("Age");
	   String b=req.getParameter("Phoneno.");
	  int age=Integer.parseInt(a);
	  int pn=Integer.parseInt(b);
	  String fn=req.getParameter("Firstname");
	  String ln=req.getParameter("Lastname");
	  
	  try {
		  if(pwd.equals(pwd2))
		  {
		if(logindao.validate(uname,pwd))
		  {
			PrintWriter out=res.getWriter();
			   out.println("You already have an account");
			   RequestDispatcher rd=req.getRequestDispatcher("user.html");
			   rd.include(req,res);
			   
		  }
		  else
		  {
			  
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/logindata","root","");
					String sql = 
							  "insert into account values (?,?,?,?,?,?)";
							  PreparedStatement pst = con.prepareStatement(sql);
							  pst.setString(1, uname);
							  pst.setString(2, pwd);
							  pst.setInt(3,age);
							  pst.setInt(4, pn);
							  pst.setString(5, fn);
							  pst.setString(6, ln);
							 
							  int x = pst.executeUpdate();
							  Statement statemnt1 = con.createStatement();
							  ResultSet rs1 = statemnt1.executeQuery("Select * from account");
								PrintWriter out=res.getWriter();
								   out.println("Created");
							  while(rs1.next())
							  {
							      int c = rs1.getInt(1);
							      String d = rs1.getString(2);
							      int e = rs1.getInt(3);
							      int f = rs1.getInt(4);
							      String g = rs1.getString(5);
							      String h = rs1.getString(6);
							      out.println("Username:"+c + ",Password:" +d+ ",Age:" +e+ ",Phoneno.:" +f +",firstname:"+g +",lastname:" +h);
							  }
					
					
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				
	               
		  }
		  }else
		  {
			  PrintWriter out=res.getWriter();
			   out.println("password doesnot match");
			   RequestDispatcher rd=req.getRequestDispatcher("user.html");
			   rd.include(req,res);
		  }
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  }
	  
	 

	}
