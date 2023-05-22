package Student_Data;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FirstPerson")
public class FirstPerson extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int hallticketno = Integer.parseInt(request.getParameter("hallticketno"));
		String name = request.getParameter("name");
		int telugu = Integer.parseInt(request.getParameter("tel"));
		int hindi = Integer.parseInt(request.getParameter("hid"));
		int english = Integer.parseInt(request.getParameter("eng"));
		int maths = Integer.parseInt(request.getParameter("maths"));
		int science = Integer.parseInt(request.getParameter("science"));
		int social = Integer.parseInt(request.getParameter("social"));
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssc","root","root");
			Statement st = con.createStatement();
			String sql = "insert into sscmarks values("+hallticketno+",'"+name+"',"+telugu+","+hindi+","+english+","+maths+","+science+","+social+")";
			st.executeQuery(sql);
			
			
			PrintWriter pw = response.getWriter();
			pw.println("inserted data...");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
	
		
	}

}
