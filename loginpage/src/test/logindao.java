package test;
import java.sql.*;
public class logindao {
	public static boolean validate(String name,String pass) throws Exception
	{
		boolean status=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/logindata","root","");
			PreparedStatement ps=con.prepareStatement("select * from account where Username=? and Password=?");
			ps.setString(1,name);
			ps.setString(2,pass);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return status;
	}

}
